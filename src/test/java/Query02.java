import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws SQLException {
        //1)Driver tanımla
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        //2) Database'e Bağlan
        Connection con =  DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");

        //3) Statement
        Statement st =  con.createStatement();
        //Region id'si  1 olan "country_name "

        //Soru 1 : Region id'si 1 olan "country name" degerlerini cagirin
        String sql01 = "select country_name from countries where region_id = 1";
        ResultSet veri = st.executeQuery(sql01);

        while(veri.next()){
            System.out.println(veri.getString(1));
        }

        String sql02 = "select country_name ,country_id from countries where region_id>2";
        ResultSet veri02 = st.executeQuery(sql02);

        while (veri02.next()){
            System.out.println(veri02.getString("country_id") + veri02.getString("country_name"));

        }
        con.close();
        st.close();
        veri02.close();
        veri.close();
    }
}
