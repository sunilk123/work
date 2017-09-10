using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        private void ComboBox1_SelectedIndexChanged_1(object sender, EventArgs e)
        {
            switch (ComboBox1.Text)
            {
                case "Courses Taken":
                    {
                        Form2 f2 = new Form2();
                        f2.Show();
                        break;
                    }
                case "Enrollments":
                    {
                        Form3 f3 = new Form3();
                        f3.Show();
                        break;
                    }
                case "Register for Course":
                    {
                        Form4 f4 = new Form4();
                        f4.Show();
                        break;
                    }
                case "Unregister For course":
                    {
                        Form5 f5 = new Form5();
                        f5.Show();
                        break;
                    }
            }
        }
    }
}
