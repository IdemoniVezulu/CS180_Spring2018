import java.util.Scanner;
import java.util.Random;

public class Caeser
{
    public static void encrypt()
    {
        Scanner input = new Scanner(System.in);

        Random  r = new Random();

        final int   alphSz = 26;
        String      normMes;
        String      tmpMes = "";
        String      encMes = "";

        int         key;
        int         mesLen;

                    System.out.println("\nEnter a message you would like to encrypt:");
                    normMes = input.nextLine();

                    mesLen = normMes.length();

                    key = r.nextInt(25);

                    normMes = normMes.toLowerCase();

                    for(int i = 0; i < mesLen; i++)
                    {
                        if(normMes.charAt(i) >= 'a' && normMes.charAt(i) <= 'z')
                            tmpMes = tmpMes + (char) (normMes.charAt(i) + key);
                            else if(normMes.charAt(i) == ' ') tmpMes = tmpMes + " ";
                                else tmpMes = tmpMes + normMes.charAt(i);

                        if((int)tmpMes.charAt(i) > 122 && tmpMes.charAt(i) != ' ')
                            encMes = encMes + (char)((int)tmpMes.charAt(i) - 26);
                            else if((int)tmpMes.charAt(i) < 97 && tmpMes.charAt(i) != ' ')
                                encMes = encMes + (char)((int)tmpMes.charAt(i) + 26);
                                else encMes = encMes + tmpMes.charAt(i);
                    }

                    System.out.println("\nEncrypted message is: " + encMes);
    }

    public static void decrypt()
    {
        Scanner input = new Scanner(System.in);

        int     key;
        String  encMes;
        String  tmpMes = "";
        String  decMes = "";
        int     mesLen;
        boolean isTru = true;

                System.out.println("\nEnetr a message you would like to decrypt: ");
                encMes = input.nextLine();

                System.out.println("Please enter your guess for a key: ");
                key = input.nextInt();

                if(key < 0 || key > 26)
                while(true)
                {

                    System.out.println("That's not a valid key!\n Please enter a new gues between 1 and 25 (inclusive):");
                    key = input.nextInt();

                }

                mesLen = encMes.length();

                encMes = encMes.toLowerCase();

                for(int i = 0; i < mesLen; i++)
                {
                    if(encMes.charAt(i) >= 'a' && encMes.charAt(i) <= 'z')
                        tmpMes = tmpMes + (char) (encMes.charAt(i) - key);
                    else if(encMes.charAt(i) == ' ') encMes = tmpMes + " ";
                        else tmpMes = tmpMes + encMes.charAt(i);

                    if((int)tmpMes.charAt(i) > 122 && tmpMes.charAt(i) != ' ')
                        decMes = decMes + (char)((int)tmpMes.charAt(i) - 26);
                    else if((int)tmpMes.charAt(i) < 97 && tmpMes.charAt(i) != ' ')
                        decMes = decMes + (char)((int)tmpMes.charAt(i) + 26);
                        else decMes = decMes + tmpMes.charAt(i);
                }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int     useOpt;
        boolean isTru = true;

                System.out.println("\nWelcome to Caeser cipher encryption/decryption services.");

                do
                {
                    System.out.println("Select what service you would like below");

                    System.out.println("1 - Encrypt a message \n2 - Decrypt a message \n3 - Exit");
                    useOpt = input.nextInt();

                    switch(useOpt)
                    {
                        case 1: encrypt();
                                break;

                        case 2: decrypt();
                                break;

                        case 3: isTru = false;
                                break;
                    }
                } while(isTru);
    }
}
