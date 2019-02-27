/**
 * Created by Sarah Rodenbeck on 3/20/2018.
 */

import java.io.*;
import java.util.ArrayList;

public class DataCleaner
{
    private ArrayList<InternalRepresentation> rows = new ArrayList<InternalRepresentation>();

    public InternalRepresentation parseAndClean(String s)
    {
        String[]    lineSplit;

                    lineSplit = s.split(",");

        //TODO get rid of the last 3 data points (latitude,longitude, last modified)
        for(int i = lineSplit.length - 3; i < lineSplit.length; i++)
            lineSplit[i] = null;

        //TODO get rid of empty element (borough) and omit row if any other data missing
        for(int i = 0; i < lineSplit.length; i++)
        {
            lineSplit[3] = null;

            if(lineSplit[i] != null && lineSplit[i].isEmpty()) return null;
        }

        //TODO convert types and store in InternalRepresentation object
        InternalRepresentation  obj = new InternalRepresentation(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]), lineSplit[2], lineSplit[4], Integer.parseInt(lineSplit[5]), Double.parseDouble(lineSplit[6]), Integer.parseInt(lineSplit[7]), Double.parseDouble(lineSplit[8]), Double.parseDouble(lineSplit[9]), Double.parseDouble(lineSplit[10]));

        //obj.PrintRowFormatted();

        return obj;
    }

    public void openAndRead()
    {
        //TODO open file and create BufferedReader
        try
        {
            FileReader file = new FileReader("airbnb_christchurch_2016.csv");

            BufferedReader  in = new BufferedReader(file);

            in.readLine();

            //TODO read in each line from the file; parse/clean input and add result to ArrayList
            String  fileLine = " ";
            InternalRepresentation i;

                    while(true)
                    {
                        fileLine = in.readLine();

                        if(fileLine == null) break;

                        if((i = parseAndClean(fileLine)) != null) rows.add(parseAndClean(fileLine));
                    }

                    in.close();
                    file.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException caught");
        }

    }

    public void writeCleanData()
    {
        //TODO create files and PrintWriters
        File    allData = new File("/homes/ramakri7/CS 180/lab10/src/Cleaned_Airbnb_Christchurch.csv");
        File    cleanData = new File("/homes/ramakri7/CS 180/lab10/src/GoodPrivate_Airbnb_Christchurch.csv");
        try
        {
            FileOutputStream newStream = new FileOutputStream(allData);

            PrintWriter all = new PrintWriter(newStream);
            PrintWriter clean = new PrintWriter(cleanData);

            boolean     allCreated = allData.createNewFile();
            boolean     cleanCreated = cleanData.createNewFile();

                        //TODO write to files based on conditions specified in handout
                        for(int i = 0; i < rows.size(); i++)
                        {
                            if(rows.get(i) != null) all.println(rows.get(i).PrintRowCSV());

                            if(rows.get(i) != null && rows.get(i).getOverall_satisfaction() >= 4.0 && rows.get(i).getReviews() >= 10 && !rows.get(i).getRoomType().equals("Shared room"))
                                clean.println(rows.get(i).PrintRowCSV());
                        }

                        all.close();
                        clean.close();
                        newStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }
        catch (IOException e)
        {
            System.out.println("IOException Found");
        }
    }


    public static void main(String[] args) throws IOException
    {
        DataCleaner d = new DataCleaner();
        d.openAndRead();
        d.writeCleanData();
    }
}
