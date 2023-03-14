package utililties;

import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");
        Statement st = con.createStatement();

        // SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
        //st.execute("create table urunler (id int , isim varchar(20),fiyat real)");
        //Çok miktarda kayıt eklemek için PreparedStatement methodu kullanılır.
        //Bunun haricinde POJo class kullanarakta bunu yapabiliriz.

        List<Urun> kayıtlar = new ArrayList<>();
        kayıtlar.add(new Urun(101,"Laptop",35000));
        kayıtlar.add(new Urun(102,"Mouse",750));
        kayıtlar.add(new Urun(103,"MacBook Pro",95000));
        kayıtlar.add(new Urun(104,"Ana Kart",5000));
        kayıtlar.add(new Urun(105,"Klavye",15000));
        kayıtlar.add(new Urun(106,"IPad",45000));
        PreparedStatement tablo = con.prepareStatement("insert into urunler values(?,?,?)");

        for (Urun w: kayıtlar){
            tablo.setInt(1,w.getId());
            tablo.setString(2,w.getIsim());
            tablo.setDouble(3,w.getFiyat());

            tablo.addBatch();
        }
        tablo.executeBatch();

        con.close();
        st.close();
        tablo.close();

    }
}
