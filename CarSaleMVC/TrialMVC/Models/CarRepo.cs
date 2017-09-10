using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TrialMVC.Models
{
    public class CarRepo
    {
        AutoLotEntities context = new AutoLotEntities();

        public List<Car> UserCars(int customerId)
        {
            List<Car> myList=new List<Car>();
            foreach(Car c in context.Cars)
            {
                if (c.CustomerId == customerId)
                    myList.Add(c);
            }
            return myList;

        }
    }
}