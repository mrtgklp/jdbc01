import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1)Driver tanımla
        Class.forName("org.postgresql.Driver");


        //2) Database'e Bağlan
        Connection con =  DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "mrtgklp89");

        //3) Statement
        Statement st =  con.createStatement();
        //"workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.
        String sql01 = "Create table workers(worker_id varchar(5),worker_name varchar(20),worker_salary int)";
        st.execute(sql01);
        //Table'a worker_address sütunu ekleyin.
        /*String sql02 = "Alter Table workers add worker_address varchar(50)";
        st.executeQuery(sql02);*/
        // workers table'ını silin.
        //String sql03= "Drop Table workers";
        //st.execute(sql03);

        //execute() -> create, drop, alter table (DDl) için kullanılır

    }
}
