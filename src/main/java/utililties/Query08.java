package utililties;

import static Utilities.DatabaseUtilty.*;

public class Query08 {
    public static void main(String[] args) {
        DatabaseUtilty.createConnection();

        String sql01 = "select * from ogrenciler";
        System.out.println("Sutun isimleri : " + DatabaseUtilty.getColumnNames(sql01));
        System.out.println("Okul No: " + DatabaseUtilty.getColumnData(sql01,"okul_no"));
        System.out.println("Ogrenci İsmi: " + DatabaseUtilty.getColumnData(sql01,"ogrenci_ismi"));
        System.out.println("Sınıf : " + DatabaseUtilty.getColumnData(sql01,"sinif"));


    }
}
