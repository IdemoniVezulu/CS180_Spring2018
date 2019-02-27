import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class DataInput {
    public static Star[] stars;
    public void read(String filename){
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(new File(filename)));
            ArrayList<Star> stars = new ArrayList<Star>();

            bfr.readLine();
            while(true) {
                String s = bfr.readLine();
                if (s==null){
                    break;
                }
                stars.add(parse(s));
            }
            this.stars = stars.toArray(new Star[1]);
            bfr.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    public Star parse(String input){
        String [] initial = input.split(",");
        boolean planets = false;
        if (initial[3].equals("Yes")){
            planets = true;
        }
        return new Star(initial[0],Double.parseDouble(initial[1]),Double.parseDouble(initial[2]),planets);
    }

    public void printInfo(StellarGrouping sg, Month month)
    {
        //Print the requested information
        String  info;

        String isVisible = sg.isVisible(month) ? "Yes" : "No";

                info = String.format("Grouping name: %s\n" +
                                    "The brightest star in this grouping is %s\n" +
                                    "%s is %f trillion miles from earth.\n" +
                                    "The furthest star from earth in this grouping is %f trillion miles from earth.\n" +
                                    "Currently visible to naked eye: %s\n" +
                                    "Planets orbiting one or more stars in the grouping: %s", sg.getName(), sg.brightestStar().getName(), sg.brightestStar().getName(), sg.distanceFromEarth(sg.brightestStar()), sg.furthestStar(), isVisible, sg.planetsOrbiting());
        //Tip: The numbers printed will only be tested for up to the first three decimal places

                System.out.println(info);
    }

    public static void main(String[] args)
    {
        //TODO: Parse command line arguments (the first should be the CSV name, the second should be the month)

        //Tip: You can use <Enum_Name>.valueOf(<String>) to get an enum constant of the same name as the String (case sensitive)

        //TODO: Create an instance of DataInput and pass the filename to .read

        //TODO: Create a StellarGrouping instance and print the info for that grouping and the month given above
        DataInput   data = new DataInput();

                    data.read(args[0]);

        StellarGrouping constellation = new SouthernSummerConstellation("Canis Major", stars);

                        data.printInfo(constellation, Month.valueOf(args[1]));

    }

}
