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
                int manufacturersIndex = rand.nextInt(12);

                String brand = Record.brands[brandsIndex];
                String vin = Record.randomVIN();
                String date = Record.randomDate();
                String year = date.substring(0,4);
                String manufacturer = Record.suppliers[manufacturersIndex];
                System.out.println(year);

                state.addBatch("insert into vehicles (VIN, color, body_style, brand, model, date_made, man_name) values(\"" 
                + vin + "\", \"" + Record.colors[colorIndex] + "\", \"" + Record.bodyStyles[body_styleIndex] + 
                "\", \"" + brand + "\", \"" + Record.randomModel(brand) + "\", \"" + date + "\", \"" 
                + Record.getManufacturer(brand) + "\");");

                state.addBatch("insert into parts (name, vehicle, date_made, man_name) values(\"Engine\", \"" + vin
                 + "\", \"" + Record.randomDate(Integer.parseInt(year)) +"\", \"" + manufacturer + "\");");

                state.addBatch("insert into parts (name, vehicle, date_made, man_name) values(\"Transmission\", \"" + vin
                 + "\", \"" + Record.randomDate(Integer.parseInt(year)) +"\", \"" + manufacturer + "\");");

            }
            int updates[] = state.executeBatch();
            System.out.println(updates.length);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    
}
