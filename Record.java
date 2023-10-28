import java.util.Random;
import java.util.HashMap;

public class Record {

    public static Random rand = new Random();
    public static String partNames[] = {"Engine", "Transmission", "Bumper", "Catalytic Converter", "Fuel Tank", "Side View Mirror", "Brake Disc",
    "Shock", "Strut", "Headlights"};

    public static String suppliers[] = {"Honda", "Ford", "Toyota", "GM", "Chrysler", "Land Rover", "Mercedes-Benz", "Getrag", "Goodyear", "Bosch",
    "AC Delco Parts", "Motorcraft"}; 

    public static String cities[] = {"Frisco", "Plano", "Allen", "McKinney", "Dallas", "Richardson", "Lewisville", "Carrolton"};
    public static String streetNames[] = {"Twinleaf Ln", "Sandgem St", "Celestic Dr", "Eterna Cr", "Hearthome Dr", "Jubilife St",
    "Oreburgh Dr", "Canalave Cr", "Floaroma Ln", "Pastoria Dr", "Sunyshore Dr", "Snowpoint Ln", "Pallet Dr", "Cerulian Ln", 
    "Pewter St", "Celadon Dr", "Vermillion Cr", "Viridian St", "Lavender Dr", "Fuchsia Ln", "Petalburg Cr", "Goldenrod Dr", 
    "Blackthorn St", "Cianwood Cr", "Olivine St", "New Bark Ln", "Mahogany Cr", "Violet St", "Azalea Ln", "Cherrygrove Dr",
    "Goldenrod Cr", "Mount Silver Ln"};

    public static String maleNames[] = {"Aaron", "Ben", "Winston", "Dan", "Ed", "Rick", "Eric", "Nate", "John", 
    "George", "Will", "Tyler", "Luka", "Seth", "Grant", "Josh", "Derek", "Maxi", "Dwight", "Kyrie", "Tim", "Jaden", 
    "Dirk", "Michael"};
    public static String femaleNames[] = {"Jan", "Caroline", "Jane", "Margot", "Susan", "Karen", "Ruth", "Rachel", "Mary", 
    "Laura", "Abigail", "Sabrina", "Candace", "Sue", "Doris", "Elise", "Amy", "Lauren", "Britney", "Elaine", "Kelly", "Pam", 
    "Angela"};
    public static String lastNames[] = {"Smith", "Johnson", "Doe", "Geist", "Adams", "Swift", "Doncic", "Curry", "Williams",
    "Green", "Lively", "Jones", "Kleber", "Powell", "Irving", "Hardaway", "Hardy", "Nowitzki", "James", "Jordan", "Bird", "Parker"};

    public static String colors[] = {"Black", "White", "Grey", "Red", "Blue", "Green", "Tan", "Silver", "Cyan", "Fuschia"};
    public static String bodyStyles[] = {"Convertable", "Four Door", "Sedan", "Crossover", "Hatchback", "SUV", "Coupe"};
    public static String brands[] = {"Honda", "Toyota", "Cheverolet", "Acura", "Ford", "Dodge", "Land Rover", "Chrysler",
    "Ram", "Jeep", "Mercedes-Benz"};

    public static HashMap <String, String[]> models;

    static String randomDate(){

        int int_year = rand.nextInt(2023 - 2006 + 1) + 2006;
        int int_month = rand.nextInt(12) + 1;
        int int_day = rand.nextInt(31) + 1;
        
        String day = "", month = "";

        if (int_day < 10){
            day = "0" + int_day;
        } else { day = Integer.toString(int_day); }

        if (int_month < 10){
            month = "0" + int_month;
        } else { month = Integer.toString(int_month); }

        return int_year + "-" + month + "-" + day;
    }

    static String randomAddr(){
        int int_houseNum = rand.nextInt(99999 - 11111 + 1) + 11111;
        
        int streetIndex = rand.nextInt(32);
        int cityIndex = rand.nextInt(8);

        return int_houseNum + " " + streetNames[streetIndex] + " " + cities[cityIndex] + " " + "TX";
    }

    static String randomName(char gender){
        int firstNameIndex;
        int lastNameIndex = rand.nextInt(22);

        if (gender == 'm'){
            firstNameIndex = rand.nextInt(24);
            return maleNames[firstNameIndex] + " " + lastNames[lastNameIndex];
        } else {
            firstNameIndex = rand.nextInt(23);
            return femaleNames[firstNameIndex] + " " + lastNames[lastNameIndex];
        }
    }

    static String randomPhoneNum(){
        int first = rand.nextInt(999 - 111 + 1) + 111;
        int second = rand.nextInt(999 - 111 + 1) + 111;
        int third = rand.nextInt(9999 - 1111 + 1) + 1111;

        return first + "-" + second + "-" + third;
    }

    static String randomVIN(){
        char newChar;
        String vin = "";

        for(int i = 0; i<17; i++)
        {    
            int numOrChar = rand.nextInt(2);
            
            if (numOrChar == 0) { //Num
                newChar = (char)(rand.nextInt(57 - 48 + 1) + 48);
            } else { //Char
                newChar = (char)(rand.nextInt(90 - 65 + 1) + 65);
            }
            vin = vin + newChar;
        }
        
        return vin;
    }

    static String randomModel(String brand){
        String modelNames[] = models.get(brand);
        int modelIndex = rand.nextInt(modelNames.length);
        return modelNames[modelIndex];
    }

    static String getManufacturer(String brand){
        if (brand == "Acura")
            return "Honda";
        else if (brand == "Toyota" || brand == "Honda" || brand == "Ford" || brand == "Chrysler"
        || brand == "Land Rover" || brand == "Mercedes-Benz")
            return brand;
        else if (brand == "Dodge" || brand == "Ram" || brand == "Jeep")
            return "Chrysler";
        else if (brand == "Cheverolet")
            return "GM";
        else 
            return "";
    }

    static void initMap(){
        models = new HashMap<String, String[]>();
        models.put("Honda", new String[] {"Civic", "Odyssey", "CR-V", "Accord", "Pilot", "Passport"});
        models.put("Toyota", new String[] {"Camry", "Highlander", "Prius", "Corolla", "RAV4", "Tacoma"});
        models.put("Cheverolet", new String[] {"Trax", "Equinox", "Camaro", "Malibu", "Tahoe"});
        models.put("Acura", new String[] {"MDX", "Integra", "RDX", "TLX"});
        models.put("Ford", new String[] {"F-150", "Mustang", "Edge", "Explorer", "Bronco", "Escape"});
        models.put("Dodge", new String[] {"Challenger", "Charger", "Durango"});
        models.put("Land Rover", new String[] {"Range Rover", "Defender", "Evoque", "Discovery"});
        models.put("Chrysler", new String[] {"300", "Pacifica"});
        models.put("Ram", new String[] {"1500", "2500"});
        models.put("Jeep", new String[] {"Wrangler", "Cherokee", "Wagoneer"});
        models.put("Mercedes-Benz", new String[] {"G-Class", "E-Class", "GT-Class", "A-Class", "S-Class", "C-Class"});

    }

}
