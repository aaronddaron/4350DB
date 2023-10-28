import java.sql.*;
import java.util.Random;

public class Vehicles {
    Connection database = null;

    public Vehicles(Connection database){
        this.database = database;
        Record.initMap();
    }

    public void massAdd(int numRecords){
        try {
            
            Statement state = database.createStatement();
            Random rand = new Random();
            
            for (int i = 0; i < numRecords; i++){
                int colorIndex = rand.nextInt(10);
                int body_styleIndex = rand.nextInt(7);

                int brandsIndex = rand.nextInt(11);
                String brand = Record.brands[brandsIndex];

                state.addBatch("insert into vehicles (VIN, color, body_style, brand, model, date_made, man_name) values(\"" 
                + Record.randomVIN() + "\", \"" + Record.colors[colorIndex] + "\", \"" + Record.bodyStyles[body_styleIndex] + 
                "\", \"" + brand + "\", \"" + Record.randomModel(brand) + "\", \"" + Record.randomDate() + "\", \"" 
                + Record.getManufacturer(brand) + "\");");

            }
            int updates[] = state.executeBatch();
            System.out.println(updates.length);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    
}
