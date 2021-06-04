import java.util.Scanner;

public class EmployeeSalarySlipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Employee:");
        String emp_name = sc.nextLine();
        System.out.println("Enter the Basic Salary of the employee: ");
        double bs = Double.parseDouble(sc.nextLine()); 
        sc.close();
        
        Employee ram = new Employee(emp_name, bs);
        ram.printSalarySlip();
        

	}

}
