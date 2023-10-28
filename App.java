import java.util.Scanner;
import com.jcraft.jsch.Session;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
         Session session = null;
        try {

            /*Scanner scan = new Scanner(System.in);
            System.out.print("Cell username: ");
            String user = scan.nextLine();
            System.out.print("Cell password: ");
            String pass = scan.nextLine();*/

            session = Connect.ssh("agg0162", "Bteaclmju2@");

            /*System.out.print("mySQL username: ");
            user = scan.nextLine();
            System.out.print("mySQL password: ");
            pass = scan.nextLine();*/

            Connection con = Connect.mySQL(session, "agg0162", "11519913");
            Customers customers = new Customers(con);
            Parts parts = new Parts(con);
            Vehicles vehicles = new Vehicles(con);
            vehicles.massAdd(1);
            con.close();
            //scan.close();
        } finally {
            // TODO Auto-generated catch block
            if (session != null){
                session.disconnect();
            }
        }
        
    }
}
