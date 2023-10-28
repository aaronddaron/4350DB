import java.util.Scanner;
import com.jcraft.jsch.Session;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
         Session session = null;
        try {

            Scanner scan = new Scanner(System.in);
            System.out.print("Cell username: ");
            String user = scan.nextLine();
            System.out.print("Cell password: ");
            String pass = scan.nextLine();

            session = Connect.ssh(user, pass);

            System.out.print("mySQL username: ");
            user = scan.nextLine();
            System.out.print("mySQL password: ");
            pass = scan.nextLine();

            Connection con = Connect.mySQL(session, user, pass);
            
            con.close();
            scan.close();
        } finally {
            // TODO Auto-generated catch block
            if (session != null){
                session.disconnect();
            }
        }
        
    }
}
