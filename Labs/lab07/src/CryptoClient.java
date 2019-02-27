import java.util.*;
import java.lang.*;

public class CryptoClient
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //DO NOT EDIT CODE BELOW THIS-----------------------------------------------------------------------------------
        CryptoCurrency s1, s2, s3;
        CryptoClient c = new CryptoClient();
        Scanner s = new Scanner(System.in);
        boolean investAgain = true;
        Demand JVarnDemand = c.Genrandom();
        Demand VictoryDemand = c.Genrandom();
        Demand XerosDemand = c.Genrandom();
        do {
            System.out.printf("Welcome to CryptoCo, the leading exchange for semi-legitimate currency!\n" +
                    "Our cheapest package involves allows you to invest in Three CryptoCurrencies\n" +
                    "Here are your options:\n\t1.JVarnCoin\n\t2.VictoryCoin\n\t3.XerosCoin\n" +
                    "Please enter what your first investment.\n");
            String choice1 = s.nextLine();
            System.out.printf("How many coins will you start with?\n");
            int invest1 = s.nextInt();
            System.out.printf("Great! Now what is the second crypto currency you would like to invest in?\n");
            s.nextLine();
            String choice2 = s.nextLine();
            System.out.printf("How many coins will you start with?\n");
            int invest2 = s.nextInt();
            System.out.printf("Great! Now what is the third crypto currency you would like to invest in?\n");
            s.nextLine();
            String choice3 = s.nextLine();
            System.out.printf("How many coins will you start with?\n");
            int invest3 = s.nextInt();
            System.out.println("Calculating... ");
            //DO NOT EDIT THE CODE ABOVE THIS---------------------------------------------------------------------------

            //TODO: Assign coins to s1, s2, and s3 based on the user's selections

            System.out.println("great!");

            if(choice1.equals("1")) s1 = new JVarnCoin(JVarnDemand, invest1);
                else if(choice1.equals("2")) s1 = new VictoryCoin(VictoryDemand, invest1);
                    else s1 = new XerosCoin(XerosDemand, invest1);

            if(choice2.equals("1")) s2 = new JVarnCoin(JVarnDemand, invest2);
                else if(choice2.equals("2")) s2 = new VictoryCoin(VictoryDemand, invest2);
                    else s2 = new XerosCoin(XerosDemand, invest2);

            if(choice3.equals("1")) s3 = new JVarnCoin(JVarnDemand, invest3);
                else if(choice3.equals("2")) s3 = new VictoryCoin(VictoryDemand, invest3);
                    else s3 = new XerosCoin(XerosDemand, invest3);
            
            //TODO: Implement the menu for each of the user's three selections.

    int     useOpt;
    int     attempts;
    int     coins;

            System.out.println("How would you like to acquire capital for the coin 1? \n\t1.Mine it\n\t2. Purchase some with profit\n\t3. Do not alter");
            useOpt = s.nextInt();

            if(useOpt == 1)
            {
                System.out.println("How many attempts would you like to make?");
                attempts = s.nextInt();

                s1.mine(attempts);
            }
            else if(useOpt == 2)
            {
                System.out.println("How many would you like to purchase?");
                coins = s.nextInt();

                s1.purchase(coins);
            }

            System.out.println("How would you like to acquire capital for the coin 2? \n\t1.Mine it\n\t2. Purchase some with profit\n\t3. Do not alter");
            useOpt = s.nextInt();

            if(useOpt == 1)
            {
                System.out.println("How many attempts would you like to make?");
                attempts = s.nextInt();

                s2.mine(attempts);
            }
            else if(useOpt == 2)
            {
                System.out.println("How many would you like to purchase?");
                coins = s.nextInt();

                s2.purchase(coins);
            }

            System.out.println("How would you like to acquire capital for the coin 3? \n\t1.Mine it\n\t2. Purchase some with profit\n\t3. Do not alter");
            useOpt = s.nextInt();

            if(useOpt == 1)
            {
                System.out.println("How many attempts would you like to make?");
                attempts = s.nextInt();

                s3.mine(attempts);
            }
            else if(useOpt == 2)
            {
                System.out.println("How many would you like to purchase?");
                coins = s.nextInt();

                s3.purchase(coins);
            }

            System.out.println("Calculating profit:\n1");
            //TODO: Calculate profit for s1
            s1.assessProfit();
            System.out.println("Done.\n2");
            //TODO: Calculate profit for s2
            s2.assessProfit();
            System.out.println("Done\n3");
            //TODO: Calculate profit for s3
            s3.assessProfit();
            System.out.println("Done");

            //TODO: Compare results
            if(s1.getProfit() > s2.getProfit() && s1.getProfit() > s3.getProfit())
                System.out.println("The best option with the higest profit was option " + choice1 + " with a profit of $" + s1.getProfit());
            else if(s2.getProfit() > s3.getProfit())
                System.out.println("The best option with the higest profit was option " + choice2 + " with a profit of $" + s2.getProfit());
            else System.out.println("The best option with the higest profit was option " + choice3 + " with a profit of $" + s3.getProfit());
            String choice = s.nextLine();

            System.out.println("Would you like to invest again? (y/n)");
            choice = s.nextLine();
            if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"))
            {
                investAgain = true;
            }
            else
            {
                investAgain = false;
            }

        } while (investAgain);
    }
    //NOTE: THIS LINE SHOULD NOT BE BELOW LINE 175

    public Demand Genrandom() {
        Random r = new Random();
        int chance = r.nextInt(5);
        switch (chance) {
            case 0:
                return Demand.HIGH;
            case 1:
                return Demand.ABOVE_AVERAGE;
            case 2:
                return Demand.AVERAGE;
            case 3:
                return Demand.BELOW_AVERAGE;
            case 4:
                return Demand.LOW;
        }
        return Demand.AVERAGE;
    }
}