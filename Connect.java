import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.sql.*;

public class Connect {
    static Connection mySQL(Session session, String user, String password) throws Exception {
        Connection con = null;
        try {
            System.out.println(session.isConnected());
            int forwardedPort = session.setPortForwardingL(0, "localhost", 3306);
            String url = "jdbc:mysql://localhost:" + forwardedPort + "/csce4350_team2_proj";

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    static Session ssh(String user, String password) throws Exception {
        Session session = null;        
        try {

            session = new JSch().getSession(user, "celldb-cse.eng.unt.edu", 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
