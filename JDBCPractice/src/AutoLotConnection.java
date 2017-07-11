import java.sql.*;

/**
 * Created by SUNIL PC on 10-07-2017.
 */
public class AutoLotConnection {
    private static Connection con;
    private static String sqlquery="Select CarId from Cars ";
    public static void main (String[] args) throws Exception{
        DriverManager.registerDriver((Driver)Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance());
        con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=AutoLot;integratedSecurity=true;");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sqlquery);
        while(rs.next()){
            System.out.println(rs.getString("CarId"));


        }
        st.close();
        con.close();


    }
}
