package utililties;

import pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query09 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");
        Statement st = con.createStatement();

        //Doctor tablosu olusturun
        //String sql01 = "create table doctor(id int,isim varchar(20),bolum varchar(20),ucret int)";
        //st.execute(sql01);

        //POJO class kullanarak tablo veri ekleyelim
        List<Doctor> kayıtlar= new ArrayList<>();
        kayıtlar.add(new Doctor(20,"Ali can","Cildiye",500));
        kayıtlar.add(new Doctor(21,"Veli han","Cocuk",800));
        kayıtlar.add(new Doctor(22,"Ahmet can","Psikoloji",700));
        kayıtlar.add(new Doctor(23,"Ali can","Cildiye",100));
        kayıtlar.add(new Doctor(24,"Ali can","KBB",300));
        kayıtlar.add(new Doctor(25,"Ali can","Cildiye",400));
        kayıtlar.add(new Doctor(26,"Ali can","Cildiye",200));
        kayıtlar.add(new Doctor(27,"Ali can","Dahiliye",550));
        kayıtlar.add(new Doctor(28,"Ali can","Cildiye",500));
        PreparedStatement data = con.prepareStatement("insert into doctor values(?,?,?,?)");

        for(Doctor w: kayıtlar){
            data.setInt(1,w.getId());
            data.setString(2,w.getIsim());
            data.setString(3,w.getBolum());
            data.setDouble(4,w.getUcret());
            data.addBatch();//dataları bir araya getiri
        }
        data.executeBatch();
        con.close();
        st.close();
        data.close();


    }
}
