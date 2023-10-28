import java.sql.*;
import java.util.Random;

public class Parts {

    Connection database = null;

    public Parts(Connection database){
        this.database = database;
    }

    public void add(String name, String date, String man_name) throws Exception {
        try {
            Statement state = database.createStatement();
            state.execute("insert into parts (name, date_made, man_name) values(\"" + name + "\", \"" + date + "\", \"" + man_name + "\");");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void massAdd(int numRecords) throws Exception {
        Statement state = database.createStatement();
        Random rand = new Random();
        String date;
        int supplierIndex, nameIndex;

        for(int i = 0; i < numRecords; i++){
           
            supplierIndex = rand.nextInt(11);
            nameIndex = rand.nextInt(9);
            
            date = Record.randomDate();

            //System.out.println(names[nameIndex] + " " + date + " " + suppliers[supplierIndex]);

            state.addBatch("insert into parts (name, date_made, man_name) values(\"" 
            + Record.partNames[nameIndex] + "\", \"" + date + "\", \"" + Record.suppliers[supplierIndex] + "\");");
        }
        int updates[] = state.executeBatch();
        System.out.println(updates.length);
    }
}
