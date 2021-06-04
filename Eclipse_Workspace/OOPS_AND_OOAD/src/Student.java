

public class Student {
	String name;
	int age;
	String phone;
	double marks[];

		
	
	Student(String name, int age, String phone)
	{
		this.name = name;
		properCase();
		this.age = age;
		this.phone = phone;		
	}
	
	Student(String name, int age, String phone, double marks[])
	{
		this(name, age, phone);
		this.marks = marks;
	}
	

	public double total_marks()
	{
		double sum = 0;
		for(int i=0;i<marks.length;i++)
		{
			sum += marks[i];
		}
		return sum;
	}
	
	public double percentage()
	{
		double total_marks = total_marks();
		double percentage = (total_marks/300) * 100;
		return percentage;
	}
	
	public char grade()
	{
		double percentage = percentage();
		char grade;
		if(percentage>=90)
		{
			grade = 'A';
		}
		else if(percentage<90 && percentage>=70)
		{
			grade = 'B';
		}
		else if(percentage<70 && percentage>=60)
		{
			grade = 'C';
		}
		else
		{
			grade = 'D';
		}
		return grade;
	}
	
	
	private void properCase() {
		String[] str_arr = this.name.split("\\s");
		
		for(int i=0; i<str_arr.length; i++)
		{
			str_arr[i] = str_arr[i].substring(0, 1).toUpperCase() + str_arr[i].substring(1).toLowerCase(); 
		}
		
		this.name = String.join(" ", str_arr);
	}
	

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public double[] getMarks() {
		return marks;
	}

	public void setMarks(double[] marks) {
		this.marks = marks;
	}
}
