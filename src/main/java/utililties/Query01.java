package utililties;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1)Driver tanımla
       Class.forName("org.postgresql.Driver");


        //2) Database'e Bağlan
        Connection con =  DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");

        //3) Statement
        Statement st =  con.createStatement();
        //4)ResultSet
        ResultSet veri = st.executeQuery(" select * from ogrenciler ");
        //5)Dataları Al
        while(veri.next()){
            System.out.println(veri.getInt(1)+
                    veri.getString(2)+
                    veri.getString(3)+
                    veri.getString(4));
        }
        //6)Bağlantıları kapatma
        con.close();
        st.close();
        veri.close();

    }
}
