
import javax.swing.*;

/*
 CS 18000 - Lab 1
 
 This is a simple program that prompts the user to enter some 
 input by showing a message box
 
 @author Varun Ramakrishnan, ramakri7@purdue.edu, Lab 09
 
 @version 10/1/18
*/
  
public class CopyCat
{
  public static void main(String[] args)
  {
    String s=JOptionPane.showInputDialog("Trigger the copycat: ");
    JOptionPane.showMessageDialog(null, s);
  }
}