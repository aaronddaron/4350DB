import java.io.Console;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;

import com.jcraft.jsch.Session;

public class CmdLine {
    
    static void setUp() throws Exception{

        Console console = System.console();
        Connection con = null;
        Session session = null;
            
        Scanner scan = new Scanner(System.in);
        System.out.print("Cell username: ");
        String user = scan.nextLine();
        System.out.print("Cell password: ");
        char[] pass = console.readPassword();

        try {
            session = Connect.ssh(user, new String(pass));
            Arrays.fill(pass, ' ');
        

            System.out.print("mySQL username: ");
            user = scan.nextLine();
            System.out.print("mySQL password: ");
            pass = console.readPassword();

            con = Connect.mySQL(session, user, new String(pass));
            Arrays.fill(pass, ' ');
            scan.close();


            //Vehicles vehicles = new Vehicles(con);
            //vehicles.massAdd(1);
            con.close();
        } finally {
            session.disconnect();
        }

        
        
    }

}
