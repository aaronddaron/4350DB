import java.util.Arrays;
import java.util.Scanner;
import com.jcraft.jsch.Session;
import java.io.Console;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
         Session session = null;

        try {

            Console console = System.console();
            Scanner scan = new Scanner(System.in);
            System.out.print("Cell username: ");
            String user = scan.nextLine();
            System.out.print("Cell password: ");
            char[] pass = console.readPassword();

            session = Connect.ssh(user, new String(pass));
            Arrays.fill(pass, ' ');
            

            System.out.print("mySQL username: ");
            user = scan.nextLine();
            System.out.print("mySQL password: ");
            pass = console.readPassword();

            Connection con = Connect.mySQL(session, user, new String(pass));
            Arrays.fill(pass, ' ');

            Vehicles vehicles = new Vehicles(con);
            vehicles.massAdd(1);
            
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
