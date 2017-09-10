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
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text != "0" && textBox2.Text != "0" && textBox3.Text != "0" && textBox4.Text != "0")
            {
                Boolean found=false;
                string StudentID = textBox2.Text;
                string CourseNum = textBox1.Text;
                string sql2 = "select DISTINCT CourseNum from Coursesoffered where CourseNum='"+CourseNum+"'";
                string sql1 = "select StudentID from Students where StudentID="+StudentID;
                string sql3 = "select StudentID from Enrollment where StudentID="+StudentID+"and CourseNum='"+CourseNum+"'";
                string sql4 = "select Prereq_Cnum from Prerequisites where CourseNum='"+CourseNum+"'";
                string sql5 = "select CourseNum from Enrollment where StudentID="+StudentID;
                string sql6 = "select CourseNum from CoursesTaken where StudentID="+StudentID;
                string sql7 = "insert into Enrollment(CourseNum,StudentID,SectionNum,CNum) values('"+CourseNum+"',"+StudentID+","+ textBox3.Text+","+ textBox4.Text+")";
                string sql8= "select (NumRegistered-Capacity) from CoursesOffered where CourseNum='" + CourseNum + "'";
                string sql9 = "update CoursesOffered set NumRegistered+=1 where CourseNum='" + CourseNum + "'";
                

                DataTable dt1 = DBFunctions.GetDataTable(sql4);
                DataTable dt2 = DBFunctions.GetDataTable(sql5);
                DataTable dt3 = DBFunctions.GetDataTable(sql6);
                
                
                if (StudentID != Convert.ToString(DBFunctions.GetScalar(sql1)))
                    MessageBox.Show("No such student exist");
                
                else if (CourseNum != Convert.ToString(DBFunctions.GetScalar(sql2)))
                    MessageBox.Show("No such course offered");
                
                else if (Convert.ToString(DBFunctions.GetScalar(sql3))==StudentID)
                    MessageBox.Show("Already registered");
                else if(Convert.ToString(DBFunctions.GetScalar(sql8))=="0")
                    MessageBox.Show("Capacity full");
                else
                {
                    //
                    //checking prerequisites with enrolled courses
                    //
                    for (int i = 0; i < dt1.Rows.Count; i++)
                    {
                        found = false;
                        for (int j = 0; j < dt2.Rows.Count; j++)
                        {
                            if (dt1.Rows[i]["Prereq_Cnum"].ToString() == dt2.Rows[j]["CourseNum"].ToString())
                                found = true;
                        }
                        //
                        //checking prerequisites with previous completed courses
                        //
                        for (int j = 0; j < dt3.Rows.Count; j++)
                        {
                            if (dt1.Rows[i]["Prereq_Cnum"].ToString() == dt3.Rows[j]["CourseNum"].ToString())
                                found = true;
                        }
                        if (!found)
                        {
                            MessageBox.Show(" prerequisite " + dt1.Rows[i]["Prereq_Cnum"] + " needed");
                            break;
                        }
                    }
                    if (found)
                    {
                        Object obj = new object();
                        obj=DBFunctions.GetNonQuery(sql7);
                        MessageBox.Show(Convert.ToString(obj)+" row inserted");
                        //
                        //UPDATE CAPACITY
                        //
                        Object obj1 = new object();
                        obj1 = DBFunctions.GetNonQuery(sql9);
                        MessageBox.Show(Convert.ToString(obj1) + " row updated");

                    }

                }
                
            }
            else
                MessageBox.Show("All fiels are required");
        }

        private void Form4_Load(object sender, EventArgs e)
        {

        }
    }
}
