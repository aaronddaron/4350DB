import java.util.Arrays;
import java.util.Scanner;
import com.jcraft.jsch.Session;
import java.io.Console;
import java.sql.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

         JFrame f = new JFrame("Dealership Database");
         
         JLogin login = new JLogin(f);

         f.setSize(1000, 500);
         f.setLayout(null);
         f.setLocationRelativeTo(null);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setVisible(true);
        
         login.close();

         //CmdLine.setUp();
    }
}
