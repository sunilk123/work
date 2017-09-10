using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WindowsFormsApplication3
{
    class DBFunctions
    {
        public static string CONNSTR = "server=SUNIL-PC\\SQLEXPRESS;integrated security=true;database=StDb2SQL";
        public static object GetScalar(string sql)
        {
            object obj = null;
            SqlConnection conn = new SqlConnection(CONNSTR);
            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand(sql, conn);
                obj = cmd.ExecuteScalar();
            }
            catch (Exception ex) { throw ex; }
            finally
            {
                conn.Close();
            }
            return obj;
        }

        public static object GetNonQuery(string sql)
        {
            object obj = null;
            SqlConnection conn = new SqlConnection(CONNSTR);
            try
            {
                conn.Open();
                SqlCommand cmd = new SqlCommand(sql, conn);
                obj = cmd.ExecuteNonQuery();
            }
            catch (Exception ex) { throw ex; }
            finally
            {
                conn.Close();
            }
            return obj;
        }

        public static DataTable GetDataTable(string sql)
        {
            DataTable dt = new DataTable();
            SqlConnection conn = new SqlConnection(CONNSTR);
            try
            {
                conn.Open();
                SqlDataAdapter da = new SqlDataAdapter(sql, conn);
                da.Fill(dt);
            }
            catch (Exception ex) { throw ex; }
            finally
            {
                conn.Close();
            }
            return dt;
        }
    }

}

