import java.util.Scanner;


public class SalarySlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Employee:");
        String emp_name = sc.nextLine();
        System.out.println("Enter the Employee ID:");
        String emp_id = sc.nextLine();
        System.out.println("Enter the Basic Salary of the employee: ");
        float bs = Float.parseFloat(sc.nextLine());  // bs - basic salary
        float hra = 0.3f * bs; // hra - house rent allowance
        float da = 0.1f * bs;  // da - dearness allowance
        float ta = 0.2f * bs;  // ta - transport allowance
        float ma = 0.15f * bs; // ma - medical allowance
        float pf = 0.1f * bs;  // pf - provident fund
        float gs = bs + hra + da + ta + ma - pf;  // gs - gross salary
        float tax;
        float annual_gs = gs * 12;

        if(annual_gs<=500000.0)
        {
            tax = 0.1f * gs;
        }
        else if(annual_gs>500000.0 && annual_gs<= 700000.0)
        {
            tax = 0.2f * gs;
        }
        else
        {
            tax = 0.3f * gs;
        }

        float ns = gs - tax; 
        sc.close();

        System.out.println("__________________________________________________________________________________________");
        System.out.println("                                       SALARY  SLIP                                       ");        
        System.out.println("__________________________________________________________________________________________");
        System.out.println();
        System.out.println("Employee Name: "+ emp_name);
        System.out.println("Employee ID: "+ emp_id);
        System.out.println();
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Earnings                        Amount");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Basic Pay                       "+ bs);
        System.out.println("House Rent Allowance            "+ hra);
        System.out.println("Dearness Allowance              "+ da);
        System.out.println("Transport Allowance             "+ ta);
        System.out.println("Medical Allowance               "+ ma);
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Deductions                      Amount");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Provident Fund                  "+ pf);
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Gross Salary: " + gs);
        System.out.println("Tax: "+ tax);
        System.out.println("Net Salary: "+ ns);
    
    }
}

