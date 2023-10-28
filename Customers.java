import java.sql.*;
import java.util.Random;

public class Customers {
    Connection database = null;

    public Customers(Connection database){
        this.database = database;
    }

    public void massAdd(int numRecords) throws Exception {
        try {
            Statement state = database.createStatement();
            Random rand = new Random();
            char genders[] = {'m', 'f'};

            for (int i = 0; i < numRecords; i++){
                int salary = rand.nextInt(200000 - 60000 + 1) + 60000;
                int genderIndex = rand.nextInt(2);
                char gender = genders[genderIndex];


                state.addBatch("insert into customers (name, address, phone, gender, salary) values(\"" 
                + Record.randomName(gender) + "\", \"" + Record.randomAddr() + "\", \"" + Record.randomPhoneNum() +
                "\", \'" + gender + "\', " + salary +");");
            }
            int updates[] = state.executeBatch();
            System.out.println(updates.length);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
