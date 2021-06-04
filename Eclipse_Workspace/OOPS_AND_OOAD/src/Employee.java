import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class Employee {
	String name;
	String companyName;
	double basicSalary;
	double hra;
	double da;
	double ta;
	double ma;
	double pf;
	double gs;
	double tax;
	double ns;
	
	Employee()
	{
		this.companyName = "DG Tech";
	}
	

	Employee(String name, double basicSalary)
	{
		this();
		this.name = name;
		properCase();
		this.basicSalary = basicSalary;
		calculate_Gross();
		calculate_Tax();
		calculate_NetSalary();
		
	}
	
	public void printSalarySlip()
	{
		
		
		Locale locale = new Locale("hi", "IN");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		Date date = new Date();
		DateFormat df = DateFormat.getInstance();
		
		
		System.out.println("__________________________________________________________________________________________");
        System.out.println("                                       SALARY  SLIP                                       ");        
        System.out.println("__________________________________________________________________________________________");
        System.out.println();
        System.out.println("Company Name: "+ companyName);
        System.out.println("Employee Name: "+ name);
        System.out.println();
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Earnings                        Amount");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Basic Pay                       "+ nf.format(basicSalary));
        System.out.println("House Rent Allowance            "+ nf.format(hra));
        System.out.println("Dearness Allowance              "+ nf.format(da));
        System.out.println("Transport Allowance             "+ nf.format(ta));
        System.out.println("Medical Allowance               "+ nf.format(ma));
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Deductions                      Amount");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Provident Fund                  "+ nf.format(pf));
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Gross Salary: " + nf.format(gs));
        System.out.println("Tax: "+ nf.format(tax));
        System.out.println("Net Salary: "+ nf.format(ns) + "                              Date: " + df.format(date));						
	}
	
	private void calculate_NetSalary() {
		// TODO Auto-generated method stub
		ns = gs - tax;
	}


	private void calculate_Tax() {
		// TODO Auto-generated method stub
		
		if(gs>=900000)
		{
			tax = gs*0.3;
		}
		else if(gs<900000 && gs>=700000)
		{
			tax = gs*0.2;
		}
		else if(gs<700000 && gs>=500000)
		{
			tax = gs*0.1;
		}
		else
		{
			tax = 0;
		}
	}


	private void calculate_Gross() {
		// TODO Auto-generated method stub
		 double bs = this.basicSalary;
         hra = 0.3 * bs; // hra - house rent allowance
         da = 0.1 * bs;  // da - dearness allowance
         ta = 0.2 * bs;  // ta - transport allowance
         ma = 0.15 * bs; // ma - medical allowance
         pf = 0.1 * bs;  // pf - provident fund
         gs = bs + hra + da + ta + ma - pf;  // gs - gross salary
	}


	private void properCase() {
		String[] str_arr = this.name.split("\\s");
		
		for(int i=0; i<str_arr.length; i++)
		{
			str_arr[i] = str_arr[i].substring(0, 1).toUpperCase() + str_arr[i].substring(1).toLowerCase(); 
		}
		
		this.name = String.join(" ", str_arr);
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	
}
