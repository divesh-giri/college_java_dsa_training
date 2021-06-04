import java.util.Scanner;
public class TestStudentReport {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the Student:");
		String name = sc.nextLine();
		System.out.println("Enter the age of the Student:");
		int age = sc.nextInt();
		System.out.println("Enter the phone no of the Student:");
		sc.nextLine();
		String phone = sc.nextLine();
		System.out.println("Enter marks in Maths: ");
		double[] marks = new double[3];
		marks[0] = sc.nextDouble();
		System.out.println("Enter marks in Science:");
		marks[1] = sc.nextDouble();
		System.out.println("Enter marks in English:");
		marks[2] = sc.nextDouble();
		sc.close();
		Student std = new Student(name, age, phone, marks);
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getPhone());
		System.out.println(std.total_marks());
		System.out.println(std.percentage());
		System.out.println(std.grade());
		
		
		
		

	}

}
