class Person
{
	String name;
	int age;
	
//	Person()
//	{
//		
//	}
	
	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
}

class ITEmployee extends Person
{
	int emp_id;
	String company_name;
	double salary;
	
	
//	Employee()
//	{
//		
//	}
	
	ITEmployee(String name, int age, int emp_id, double salary)
	{
		super(name, age);
		this.emp_id = emp_id;
		this.salary = salary;
		this.company_name = "DG Tech";
	}
	
	void location()
	{
		System.out.println("Assigned Location");
	}
	
	void printEmployee()
	{
		System.out.println("Company Name: "+ company_name);
		System.out.println("Employee Name: "+name+" Employee ID: "+ emp_id +" Employee Salary:" + salary);
	}
}

class FullTimeEmployee extends ITEmployee
{
	double pf;
	double bonus;
	
	FullTimeEmployee(String name, int age, int emp_id, double salary)
	{
		super(name, age, emp_id, salary);
	}
	
	void computePF()
	{
		this.pf = salary *0.1;
		System.out.println("PF: " + pf);
	}
	
	void computeBonus()
	{
		this.bonus = salary * 0.5;
		System.out.println("Bonus: " + bonus);
	}
	
	@Override
	void printEmployee()
	{
		super.printEmployee();
		computePF();
		computeBonus();
	}
	
	@Override
	void location()
	{
		System.out.println("Bangalore Office");
	}
}

class PartTimeEmployee extends ITEmployee
{
	int noOfHours;
	
	PartTimeEmployee(String name, int age, int id, double salary,int noOfHours)
	{
		super(name, age, id, salary);
		this.noOfHours = noOfHours;
	}
	
	@Override
	void printEmployee()
	{
		super.printEmployee();
		System.out.println("No of Hours: "+noOfHours);
	}
	
	@Override
	void location()
	{
		System.out.println("Work From Home For PartTimers");
	}
	
	void computeAtt()
	{
		System.out.println("Hourly Basis");
	}
	
	
}

class Freelancer extends ITEmployee
{
	String project;
	int duration;
	
	Freelancer(String name, int age, int id, double salary, String project, int duration)
	{
		super(name, age, id, salary);
		this.project = project;
		this.duration = duration;
	}
	
	@Override
	void printEmployee()
	{
		super.printEmployee();
		System.out.println("Project: " + project);
		System.out.println("Duration: "+ duration);
	}
	
	@Override
	void location()
	{
		System.out.println("Freelancer Location");
	}
	
	void rating()
	{
		System.out.println("A");
	}
}

class Customer extends Person
{
	String order;
	
	Customer(String name, int age, String order)
	{
		super(name, age);
		this.order = order;
	}
	
}


// Caller Class :- This class is made to follow the DRY principle in the program.

class Caller{
	void callEmployee(ITEmployee employee) // Upcasting
	{
		employee.printEmployee();
		employee.location();
		if(employee instanceof FullTimeEmployee)
		{
			FullTimeEmployee fte = (FullTimeEmployee) employee; // downcasting
			fte.computeBonus();
			fte.computePF();
		}
		if(employee instanceof PartTimeEmployee)
		{
			((PartTimeEmployee)employee).computeAtt(); // downcasting
		}
		
		if(employee instanceof Freelancer)
		{
			((Freelancer)employee).rating(); // downcasting
		}
		
		System.out.println("***********************************************************");
	}
}





public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Caller caller = new Caller();
		
		caller.callEmployee(new Freelancer("Ramu", 24, 301, 50000,"Web Development", 30));
		
		caller.callEmployee(new FullTimeEmployee("Sham", 25, 201, 30000));
		
		caller.callEmployee(new PartTimeEmployee("Mohan", 21, 101, 15000, 20));
		
		

	}

}
