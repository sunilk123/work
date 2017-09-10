using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using TrialMVC.Models;
using TrialMVC.Content;
using System.Data.Common;

namespace TrialMVC.Controllers
{
    public class LoginTablesController : Controller
    {
        private AutoLotEntities db = new AutoLotEntities();
        private LoginRepo objRepo = new LoginRepo();
       
        public ActionResult Login()
        {
            if (Session["LOGGEDIN"] != null)
                return RedirectToAction("Index", "Cars");

                return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Login([Bind(Include = "CustomerId,CustomerPwd")] LoginTable loginTable)
        {
            
            if (objRepo.Authenticate(loginTable.CustomerId, loginTable.CustomerPwd))
                {
                    Session["LOGGEDIN"] = loginTable.CustomerId;
                    return RedirectToAction("MyCars", "Cars");
                }
            ViewBag.Message = "Login failed";
            return View(loginTable);
       

        }
        // GET: LoginTables/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: LoginTables/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        [HandleError(ExceptionType =typeof(DbException),View = "Error")]
        public async Task<ActionResult> Create([Bind(Include = "CustomerId,CustomerPwd,Role")] LoginTable loginTable)
        {
            if (ModelState.IsValid)
            {
                db.LoginTables.Add(loginTable);
                await db.SaveChangesAsync();
                return RedirectToAction("Login","LoginTables");
            }

            return View(loginTable);
        }

        // GET: LoginTables/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LoginTable loginTable = await db.LoginTables.FindAsync(id);
            if (loginTable == null)
            {
                return HttpNotFound();
            }
            return View(loginTable);
        }

        // POST: LoginTables/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "CustomerId,CustomerPwd,Role")] LoginTable loginTable)
        {
            if (ModelState.IsValid)
            {
                db.Entry(loginTable).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            return View(loginTable);
        }

        // GET: LoginTables/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            LoginTable loginTable = await db.LoginTables.FindAsync(id);
            if (loginTable == null)
            {
                return HttpNotFound();
            }
            return View(loginTable);
        }

        // POST: LoginTables/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            LoginTable loginTable = await db.LoginTables.FindAsync(id);
            db.LoginTables.Remove(loginTable);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }
        public ActionResult LogOut()
        {
            Session.Abandon();
            return RedirectToAction("Index","Home");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
