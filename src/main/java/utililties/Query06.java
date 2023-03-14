package utililties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");
        //Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values (800, 'Ali Can', 11, 'E')");

        //Aynı SQL kodlarını kullacaksak statement değil preparedstatement kullanırız.
        //Statament kullandığımızda her seferin kodu database iletir
        //PraperedStatement kullandığımızda örneği saklar sadece dataları  iletir

        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?, ?, ?, ?)");
        ps.setInt(1, 872);
        ps.setString(2, "Ali Can");
        ps.setInt(3, 11);
        ps.setString(4, "E");
        ps.executeUpdate();

        ps.close();
        con.close();
    }
}
