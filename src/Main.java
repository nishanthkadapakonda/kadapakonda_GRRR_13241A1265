
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		SimpleDateFormat formatter2=new SimpleDateFormat("YYYY-MM-dd");
		System.out.println("enter no of students");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		StudentGroup sg = new StudentGroup(length);
		Student []students = new Student[length]; 
		for(int i=0 ; i<length ;i++){
			System.out.println("enter id:");
			
			int id =sc.nextInt();
			System.out.println("enter fname");
			String fullName = sc.nextLine();
			System.out.println("enter date of birth(yyyy-MM-dd");
			String dob = sc.nextLine();
			Date d = new Date();
			
			Date date2=null;
			try {
				date2 = formatter2.parse(dob);
			} catch (ParseException e) {
				e.printStackTrace();
			}  
			double avgMarks = sc.nextDouble();
			Student s = new Student(id, fullName, date2, avgMarks);
			students[i] =s; 
		}
		System.out.println("select option");
		int option = sc.nextInt();
		switch(option){
		case 1:   Student[] s = sg.getStudents();
		          break;
		case 2 :  
		         
			      Student s1 = new Student(9 , "Ramu Ramu" ,formatter2.parse("1996-10-15") , 45 );
			      sg.setStudent(s1, 3);
			      break;
		case 3:
			     sg.getStudent(1);
			     break;
		case 4: 
			    sg.setStudents(students);
			    break;
		case 5:
			    Student s2 = new Student(19 , "Ramu Ramu" ,formatter2.parse("1996-10-15") , 45 );
			    sg.add(s2, 4);
			    break;
		case 6 :
			     Student s3 = new Student(20 , "Ramu Ramu" ,formatter2.parse("1996-10-15") , 45 );
			     sg.addFirst(s3);
			     break;
		case 7: 
			    Student s4 = new Student(21 , "Ramu Ramu" ,formatter2.parse("1996-10-15") , 45 );
			      sg.addLast(s4);
			      break;
		case 8: 
			   sg.remove(1);
			   break;
		case 9: 
			   sg.bubbleSort();
			   break;
		case 10: 
			     Student s5 = new Student(21 , "Ramu Ramu" ,formatter2.parse("1996-10-15") , 45 );
			     sg.remove(s5);
			     break;
		case 11:
			     Student s6 = new Student(21 , "Ramu Ramu" ,formatter2.parse("1996-10-15") , 45 );
			     sg.removeFromElement(s6);
			     break;
		case 12:    
			   sg.removeFromIndex(2);
			   break;
		case 13: sg.removeToIndex(3);
		         break;
		case 14:
			     sg.getStudentsWithMaxAvgMark();
			     break;
			     
		}
		
		
		
	}

}
