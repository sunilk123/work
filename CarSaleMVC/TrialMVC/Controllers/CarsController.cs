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
using System.IO;

namespace TrialMVC.Controllers
{
    public class CarsController : Controller
    {
        private AutoLotEntities db = new AutoLotEntities();

        // GET: Cars
        public async Task<ActionResult> Index()
        {
                var cars = db.Cars.Include(c => c.LoginTable);
                return View(await db.Cars.ToListAsync());

                
        }

        // GET: Cars/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Car car = await db.Cars.FindAsync(id);
            if (car == null)
            {
                return HttpNotFound();
            }
            return View(car);
        }

        // GET: Cars/Create
        public ActionResult Create()
        {
            ViewBag.CustomerId = new SelectList(db.LoginTables, "CustomerId", "CustomerPwd");
            return View();
        }

        // POST: Cars/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "CarId,CarMake,CarName,Mileage,Color,CarModel,Cost,img")] Car car)
        {
            
            if (ModelState.IsValid)
            {
                using (BinaryReader br = new BinaryReader(car.img.InputStream))
                {
                    car.Photo = new byte[car.img.ContentLength];
                    car.Photo = br.ReadBytes(car.img.ContentLength);
                }
                car.CustomerId = (int)Session["LOGGEDIN"];
                db.Cars.Add(car);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            return View(car);
        }

        // GET: Cars/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Car car = await db.Cars.FindAsync(id);
            if (car == null)
            {
                return HttpNotFound();
            }
            return View(car);
        }

        // POST: Cars/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "CarId,CarMake,CarName,Mileage,Color,CarModel,Cost,img")] Car car)
        {
            if (ModelState.IsValid)
            {
                using (BinaryReader br = new BinaryReader(car.img.InputStream))
                {
                    car.Photo = new byte[car.img.ContentLength];
                    car.Photo = br.ReadBytes(car.img.ContentLength);
                }
                car.CustomerId = (int)Session["LOGGEDIN"];

                db.Entry(car).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewBag.CustomerId = new SelectList(db.LoginTables, "CustomerId", "CustomerPwd", car.CustomerId);
            return View(car);
        }

        // GET: Cars/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Car car = await db.Cars.FindAsync(id);
            if (car == null)
            {
                return HttpNotFound();
            }
            return View(car);
        }

        // POST: Cars/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            Car car = await db.Cars.FindAsync(id);
            db.Cars.Remove(car);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }
        public ActionResult Mycars()
        {
            CarRepo obj = new CarRepo();
            if (Session["LOGGEDIN"] != null)
            {
                var cars = obj.UserCars((int)Session["LOGGEDIN"]);
                return View(cars);
            }
            else
                return RedirectToAction("Login", "LoginTables");


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
