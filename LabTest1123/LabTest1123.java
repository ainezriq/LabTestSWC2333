/**
 * Program description : To calculate annual salaries for the company's employee
 * Programmer: AinIzriq
 * Date: 13 March 2024
 */
//import the respective packages
import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
//Driver class
public class LabTest1123
{
    public static void main(String[]args)
    {
        //Instantiate the object of DecimalFormat
        DecimalFormat dF = new DecimalFormat("0.00");
        //try block
        try
        {
            //Set the input/output file
            //input file
            BufferedReader inputFile = new BufferedReader(
                    new FileReader("employeeSalaries.txt"));
            //2 output files
            PrintWriter topPerforming = new PrintWriter(
                    new FileWriter("topPerforming.txt"));
            PrintWriter leastyearService = new PrintWriter(
                    new FileWriter("leastyearService.txt"));
            //Declare the variables
            String inputData = null;
            String employeeName;
            double salary, totalannualSalaries;
            char yearOfServ;
            //Write the employee name and total salaries for top performance
            topPerforming.println("List of top performing employee");
            topPerforming.println("\nEmployee Name\t\tTotal Salaries\t\tYear of Service");
            topPerforming.println("--------------------------------------");
            //Write the employee name and total salaries for least year of service
            leastyearService.println("List of employee with the least years of service");
            leastyearService.println("\nEmployee Name\t\tTotal Salaries\t\tYear of Service");
            leastyearService.println("--------------------------------------");
            while((inputData = inputFile.readLine()) != null)
            {
                //Instantiate the object reference of the StringTokenizer class
                //to read the string line (input data) & to set the delimeter
                StringTokenizer sT = new StringTokenizer(inputData,";");
                //to pass the string line &delimeter
                //Break into tokens and assign to the appropriate variables
                employeeName = sT.nextToken();
                totalannualSalaries =Double.parseDouble(sT.nextToken());

                //to calculate the total annual salaries
                totalannualSalaries = totalannualSalaries * 1.05;
                if (totalannualSalaries > 60000)
                    yearOfServ = '6';
                else if (totalannualSalaries >= 390000 && totalannualSalaries <= 50000)
                    yearOfServ = '4';
                else if (totalannualSalaries >= 19000 && totalannualSalaries <= 30000)
                    yearOfServ = '2';
                else
                    yearOfServ = '1';
                //end of if
                //To determine the salaries and write the data to the appropriate output file
                if (yearOfServ == '6')
                    topPerforming.println(employeeName + "\t\t\t" + totalannualSalaries + "\t\t\t" + yearOfServ);
                else if (yearOfServ == '1')
                    leastyearService.println(employeeName + "\t\t\t" + totalannualSalaries + "\t\t\t" + yearOfServ);
            }//end of while
            //close all the input/output files
            //Close the input/output file
            inputFile.close();
            topPerforming.close();
            leastyearService.close();
        }//end of try block

        catch(FileNotFoundException e) 
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e) 
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e) 
        {
            System.out.println("Problem :" +e.getMessage());
        }
    }//end of the main method
}//end of the driver class