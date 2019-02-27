import java.util.Scanner;

/**
 * Lab 03 - 20 Questions
 *
 * This is a program that asks yes or no questions to guess the user's animal.
 *
 * @author Varun Ramakrishnan, L09
 *
 * @version January 31st, 2018
 */

public class Questions
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String  ans;
        String yes = "yes";
        String no = "no";

        System.out.print("Does it have fur? ");
        ans = input.nextLine();

        if(ans.equalsIgnoreCase(yes))
        {
            System.out.print("\nDoes it live in trees? ");
            ans = input.nextLine();

            if(ans.equalsIgnoreCase(yes))
            {
                System.out.print("\nDoes it eat leaves? ");
                ans = input.nextLine();

                if(ans.equalsIgnoreCase(yes))
                {
                    System.out.print("\nIs it's poop green? ");
                    ans = input.nextLine();

                    if(ans.equalsIgnoreCase(yes)) System.out.print("\nIt is a Koala");

                        else if(ans.equalsIgnoreCase(no)) System.out.print("\nIt is a Panda");
                }

                    else if(ans.equalsIgnoreCase(no))
                    {
                        System.out.print("\nIs is a big cat? ");
                        ans = input.nextLine();

                        if(ans.equalsIgnoreCase(yes)) System.out.print("\nIt is a Jaguar");
                            else if(ans.equalsIgnoreCase(no)) System.out.print("\nIt is a Monkey");
                    }
            }

                else if(ans.equalsIgnoreCase(no))
                {
                    System.out.print("\nDoes it live underground? ");
                    ans = input.nextLine();

                    if(ans.equalsIgnoreCase(yes)) System.out.print("\nIt is a Groundhog");
                        else if(ans.equalsIgnoreCase(no)) System.out.print("\nIt is a Rat");
                }
        }

            else if(ans.equalsIgnoreCase(no))
            {
                System.out.print("\nDoes it have scales? ");
                ans = input.nextLine();

                if(ans.equalsIgnoreCase(yes))
                {
                    System.out.print("\nDoes it live in water? ");
                    ans = input.nextLine();

                    if(ans.equalsIgnoreCase(yes)) System.out.print("\nIt is a Fish");
                        else if(ans.equalsIgnoreCase(no)) System.out.print("\nIt is a Lizard");
                }

                    else if(ans.equalsIgnoreCase(no))
                    {
                        System.out.print("\nIs is an amphibian? ");
                        ans = input.nextLine();

                        if(ans.equalsIgnoreCase(yes)) System.out.print("\nIt is a Newt");
                        else if(ans.equalsIgnoreCase(no))
                        {
                            System.out.print("\nCan it fly? ");
                            ans = input.nextLine();

                            if(ans.equalsIgnoreCase(yes)) System.out.print("\nIt is a Hawk");
                                else if(ans.equalsIgnoreCase(no)) System.out.print("\nIt is a Penguin");
                        }
                    }
            }
    }
}
