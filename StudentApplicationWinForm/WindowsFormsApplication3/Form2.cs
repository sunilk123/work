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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string StudentID = comboBox1.Text;
            string sql = "select CourseNum from CoursesTaken where StudentID="+StudentID;
            DataTable dt = DBFunctions.GetDataTable(sql);
            dataGridView1.DataSource = dt;
        }

      
        private void Form2_Load(object sender, EventArgs e)
        {
            string sql = "select distinct StudentID from CoursesTaken ";
            DataTable dt = DBFunctions.GetDataTable(sql);
            for (int i = 0; i < dt.Rows.Count; i++)
                comboBox1.Items.Add(dt.Rows[i]["StudentID"].ToString());

        }
    }
}
