package utililties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");
        Statement st = con.createStatement();


        //Soru:Ögrenciler Tablosuna yeni bir kayıt ekleyin(300,'Sena Can',12,'K')
       // int s1 = st.executeUpdate("insert into ogrenciler values(301,'Sena Can',12,'K')");
       // System.out.println(s1 + "satır database eklendi");
        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
// (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
        String [] veri = {"insert into ogrenciler values(501,'Sena Can',12,'K')",
                "insert into ogrenciler values(502,'Sena Can',12,'K')",
                "insert into ogrenciler values(504,'Sena Can',12,'K')"};
       //1.YOL
      /* int count=0;
        for (String w:veri
             ) {
           count = count + st.executeUpdate(w);
        }
        System.out.println(count +"satır eklendi ");*/
        //2.Yol
        for (String w:veri){
            st.addBatch(w); //Yukarıdaki dataların hepsini birleştiriyor

        }
       // st.executeBatch(); //Dataları tek seferde gönderiyor

        con.close();
        st.close();
        veri.clone();


    }
}
