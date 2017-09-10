
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using TrialMVC.Models;

namespace TrialMVC.Content
{
    public class LoginRepo
    {
        AutoLotEntities context = new AutoLotEntities();
        public Boolean Authenticate(int userName, string pwd)
        { 
                LoginTable obj = context.LoginTables.Find(userName);
            if (obj != null)
            {
                string s = obj.CustomerPwd.Substring(0,5);
                if (!String.Equals(s, pwd))
                    return false;
                else
                    return true;
            }
            else
                return false;

           
        }
    }
}