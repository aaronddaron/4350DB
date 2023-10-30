import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import com.jcraft.jsch.Session;

public class JLogin {
    JFrame f;
    JTextField userField;
    JPasswordField passField;
    JButton button;
    JLabel l1, l2, l3;
    Session session = null;
    Connection connection = null;

    public JLogin(JFrame frame){
        f = frame;
        userField = new JTextField();
        passField = new JPasswordField();
        button = new JButton("Login");
        l1 = new JLabel("Username: ");
        l2 = new JLabel("Password: ");
        l3 = new JLabel("SSH");

        l3.setBounds(50, 75, 80, 30);
        userField.setBounds(130, 100, 200, 30);
        passField.setBounds(130, 135, 200, 30);
        button.setBounds(130, 170, 90, 30);
        l1.setBounds(50, 100, 80, 30);
        l2.setBounds(50, 135, 80, 30);

        f.add(l3); f.add(l1); f.add(userField); f.add(l2); f.add(passField); f.add(button); 

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    sshLogin();
                    l3.setText("mySQL");
                    button.removeActionListener(this);
                    passField.setText(null);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                mySQL_Login();
                                l3.setText("Connected");
                            } catch (Exception ex) {
                                // TODO: handle exception
                            }
                        }
                    });
                } catch(Exception ex) {}
            }
        } );
    }

    private void sshLogin() throws Exception {
        
        String username = userField.getText();
        String password = new String(passField.getPassword());
        session = Connect.ssh(username, password);
    }

    private void mySQL_Login() throws Exception {
        
        String username = userField.getText();
        String password = new String(passField.getPassword());
        connection = Connect.mySQL(session, username, password);
    
    }

    public void remove(){
        f.remove(l1); f.remove(userField); f.remove(l2); f.remove(passField); f.remove(button);
    }

    public void close(){
        try{
            connection.close();
            session.disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
