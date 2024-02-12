import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

final class AutoMobile {

    private static String make;
    private static String model;
    private static String color;
    private static int year;
    private static int mileage;
    private static int index;
    private static int index =300;


    }


    public void AutoMobile(String make, String model, String color, int year,
                           int mileage, int index) {
        super();
        AutoMobile.make = make;
        AutoMobile.model = model;
        AutoMobile.color = color;
        AutoMobile.year = year;
        AutoMobile.mileage = mileage;
        AutoMobile.index = index;
    }



    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public static int getIndex() {
        return index;
    }

}

class Vehicle {
    static ArrayList<AutoMobile> vehicleList = new ArrayList<>();
    public static final String FILENAME = " Programming 1\\Week 8\\AutoMobile.txt";
    //Prints to location with proper header, but returns package and no vehicles

    public static  void addVehicle() {
        Scanner s = new Scanner(in);
        out.println("------Add Vehicle-------");
        out.print("Enter Vehicle make: ");
        String make = s.nextLine();
        out.print("Enter Vehicle new model: ");
        String model = s.nextLine();
        out.print("Enter Vehicle color: ");
        String color = s.nextLine();
        out.print("Enter Vehicle year: ");
        int year = s.nextInt();
        out.print("Enter Vehicle mileage: ");
        int mileage = s.nextInt();
        out.print("Enter the Vehicle Index Number: ");
        int index = s.nextInt();
        AutoMobile a = new AutoMobile(make, model, color, year, mileage, index);
        vehicleList.add(a);
        out.println("Vehicle Added Successfully");
        out.println("------------------------");

    }

    public static void removeVehicle() {
        Scanner s = new Scanner(in);
        out.println("Remove Vehicle");
        out.print("Enter Vehicle make: ");
        s.nextLine();
        out.print("Enter Vehicle new model: ");
        s.nextLine();
        out.print("Enter the Vehicle Index Number: ");
        s.nextInt();
        out.println("No such Vehicle Exist");
        out.println("------------------------");

    }

    public static void updateVehicle() {
        Scanner s = new Scanner(in);
        out.println("------Update Vehicle-------");
        out.print("Enter the make of Automobile: ");
        s.nextLine();
        out.print("Enter the model of Automobile: ");
        s.nextLine();
        out.print("Enter the Vehicle Index Number: ");
        s.nextInt();
        for (AutoMobile ignored : vehicleList) {
        }
        out.println("No such Vehicle Exist");
        out.println("------------------------");
    }

    public static void printfile() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            String content = "ID Make Model Color Year Mileage\n";
            bw.write(content);
            for (AutoMobile autoMobile : vehicleList) {
                bw.write(autoMobile.toString() + "\n");
            }
            out.println("Done printing");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        do {

            out
                    .println("============================VEHICLE OPTIONS============================");
            out.println("1. Add Vehicle");
            out.println("2. Remove Vehicle");
            out.println("3. Update Vehicle");
            out.println("4. Print Vehicle List");
            out.println("5. Exit");
            out
                    .println(MessageFormat.format("{0}=====================================================", getString()));
            out.println();
            Scanner s = new Scanner(in);
            out.print("Enter the choice: ");
            int i = s.nextInt();
            s.nextLine();
            switch (i) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    updateVehicle();
                    break;
                case 4:
                    printfile();
                    break;
                case 5:
                    out.println("Good Bye!!!!!");
                    break;
                default:
                    out.println("You  entered the wrong choice!!!!");
                    out.println();
            }
            if(i==4)
                break;
            out.println();
        } while (true);
        PrintWriter pw = new PrintWriter("VehicleInventory");
        StringBuilder text = new StringBuilder("Index,Make,Model,Color,Year,Mileage\n");
        for(AutoMobile a : vehicleList){
            text.append(AutoMobile.getIndex()).append(",").append(a.getMake()).append(",").append(a.getModel()).append(",").append(a.getColor()).append(",").append(a.getYear()).append(",").append(a.getMileage()).append("\n");
        }
        pw.write(text.toString());
        pw.flush();
        pw.close();
        out.println("VehicleInventory file created successfully");
        out.println();
        out.println(text);


    }

    private static String getString ( ) {
        return "==================";
    }

}

