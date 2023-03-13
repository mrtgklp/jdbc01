import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con =  DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");

        Statement st =  con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Sutun sayısı : " + rsmd.getColumnCount());
        System.out.println("1.Sutun sayısı:"+rsmd.getColumnName(1));
        System.out.println("2.Sutun sayısı:" +rsmd.getColumnName(2));
        System.out.println("3.Sutun sayısı:" + rsmd.getColumnName(3));
        System.out.println("4.Sutun sayısı:" + rsmd.getColumnName(4));
        System.out.println("Tablo ismi : " + rsmd.getTableName(4));

        System.out.println("Degerleri: " + rsmd.getColumnTypeName(1));
        System.out.println("Degerleri: " + rsmd.getColumnTypeName(2));


    }
}
