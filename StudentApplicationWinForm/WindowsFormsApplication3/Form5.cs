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
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text != "0" && textBox2.Text != "0")
            {
                string CourseNum = textBox1.Text;
                string StudentID = textBox2.Text;
                string sql1 = "update CoursesOffered set NumRegistered+=1 where CourseNum='" + CourseNum + "'";
                string sql2= "delete from Enrollment where StudentID=" + StudentID + "and CourseNum='" + CourseNum + "'";

                Object obj = new object();
                obj = DBFunctions.GetNonQuery(sql2);
                MessageBox.Show(Convert.ToString(obj) + " row deleted");
                //
                //UPDATE CAPACITY
                //
                Object obj1 = new object();
                obj1 = DBFunctions.GetNonQuery(sql1);
                MessageBox.Show(Convert.ToString(obj1) + " row updated");

            }
            else
                MessageBox.Show("All fields required");
        }
    }
}
