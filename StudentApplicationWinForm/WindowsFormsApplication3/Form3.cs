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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
            string sql = "select distinct CourseNum from Enrollment ";
            DataTable dt = DBFunctions.GetDataTable(sql);
            for (int i = 0; i < dt.Rows.Count; i++)
                comboBox1.Items.Add(dt.Rows[i]["CourseNum"].ToString());
        }

        private void comboBox1_SelectionChangeCommitted(object sender, EventArgs e)
        {
            string CourseNum = comboBox1.Text;
            string sql = "select * from Enrollment where CourseNum= '" + CourseNum+"'";
            DataTable dt = DBFunctions.GetDataTable(sql);
            dataGridView1.DataSource = dt;
            dataGridView1.AutoResizeColumns();
        }
    }
}
