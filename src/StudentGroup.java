import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		this.students = students;
		try{
		  if(this.students == null){
			 throw new IllegalArgumentException();
		  }
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here //students[index] == null 
		try{
			if(index < 0 || index > students.length)
				throw new IllegalArgumentException();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException{
		// Add your implementation here
		if(index <0 || index > students.length || student == null){
			throw new IllegalArgumentException();
		}
		else{
	      this.students[index] = student;
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		
		try{
			if(student == null)
			  throw new IllegalArgumentException();
			else{
				int k=0;
				Student students1[] = new  Student[students.length +1];
				students1[k] = student;
				for(int i = 0 ; i<students.length ; i++){
					k++;
					students1[k] = students[i]; 
					
				}
				students = new Student[students1.length];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{
					students[j] = students1[i];
					j++;
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		try{
			if(student == null)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length +1];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				k= students.length;
				students1[k] = student;
				
				students = new Student[students1.length];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{
					students[j] = students1[i];
					j++;
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		try{
			if(student == null || index <0 || index > students.length)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length +1];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				Student temp = students1[index];
				students1[index] = student;
				for( int i = index+1 ; i < students1.length ; i++){
					
					Student temp1 = students1[i];
					
					students1[i] = temp;
					temp = temp1;	
				}
				
				students = new Student[students1.length];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{
					students[j] = students1[i];
					j++;
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		try{
			if(index <0 || index > students.length)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				students1[index] = null;
				students = new Student[students1.length - 1];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{  if(students1[i] != null){
					 students[j] = students1[i];
					 j++;
				  }
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		// Add your implementation here
		try{
			if(student == null)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				for(int i=0; i<students1.length ; i++){
					if(students1[i].getId()==student.getId()){
						students1[i] = null;
						break;
						
					}
					else{
						throw new IllegalArgumentException("Student not exist");
					}
				}
				students = new Student[students1.length - 1];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{  if(students1[i] != null){
					 students[j] = students1[i];
					 j++;
				  }
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		try{
			if(index <0 || index > students.length)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				for(int i=index+1 ; i< students1.length ; i++){
					students1[i] = null;
				}
				students = new Student[index+1];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{  if(students1[i] != null){
					 students[j] = students1[i];
					 j++;
				  }
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int index =0;
		int flag =0;
		try{
			if(student == null)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				for(int i=0; i<students1.length ; i++){
					
						if(students1[i].getId()==student.getId()){
							index =i;
							break;
						}
					else{
						students1[i] = null;
					}
					
					
				}
				students = new Student[index +1];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{  if(students1[i] != null){
					 students[j] = students1[i];
					 j++;
				  }
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		try{
			if(index < 0 || index > students.length)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				for(int i=0; i<students1.length ; i++){
					if(i < index){
						students1[i] = null;
					}
					else
						break;

				}
				students = new Student[students1.length - index];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{  if(students1[i] != null){
					 students[j] = students1[i];
					 j++;
				  }
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int index =0;
		try{
			if(student == null)
			  throw new IllegalArgumentException();
			else{
				Student students1[] = new  Student[students.length];
				int k=0;
				for(int i = 0 ; i<students.length ; i++){
					students1[k] = students[i]; 
					k++;
				}
				for(int i=0; i<students1.length ; i++){
					
						if(students1[i].getId()==student.getId()){
							index = i;
							break;
						}
						else{
							students1[i] = null;
						}
					
				}
				students = new Student[students1.length - index];
				int j=0;
				for(int i=0; i<students1.length ; i++)
				{  if(students1[i] != null){
					 students[j] = students1[i];
					 j++;
				  }
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0 ; i< students.length ; i++){
			for(int j=i ; j< students.length ; j++){
				if(students[j].getId() > students[j+1].getId()){
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		Student[] students2 = null;
		try{
			students2= new Student[students.length];
			int k=0;
			for(int i =0 ; i<students.length ; i++){
				int match = students[i].getBirthDate().compareTo(date);
				if(match == 0){
					students2[k] = students[i];
					k++;
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		return students2;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student[] students2 = null;
		int j=0;
		try{
			if(firstDate == null || lastDate == null)
				 throw new IllegalArgumentException();
			else{
				students2= new Student[students.length];
				for(int i =0 ; i< students.length ; i++){
					int firstDate1 = students[i].getBirthDate().compareTo(firstDate);
					int lastDate1 = students[i].getBirthDate().compareTo(lastDate);
					if(firstDate1 >= 0 && lastDate1 <= 0){
					  	students2[j] = students[i];
					  	j++;
					}
				}
			}
		
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		return students2;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		/*Student[] students2 = null;
		int j=0;
		try{
			students2= new Student[students.length];
			for(int i=0; i<students.length ; i++){
				long diff = date.getTime() - students[i].getBirthDate().getTime();
				long days1 = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			
				if(java.lang.Math.abs(days1) <= days){
				  students2[j] = students[i];
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		return students2;*/
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Student students2[] = new Student[students.length];
		int k = 0;
		try{
			double maxMarks = 0;
			for(int i=0 ; i< students.length ; i++){
				maxMarks = maxMarks + students[i].getAvgMark();	
			}
			double avgMaxMarks = maxMarks/students.length;
			for(int j = 0; j < students.length ; j++){
				if(students[j].getAvgMark() == avgMaxMarks){
					students2[k] = students[j];
					k++;
				}
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		return students2;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		int index =0;
		try{
			if(student == null){
				throw new IllegalArgumentException();
			}
			else{
				for(int i=0; i<students.length ; i++){
					if(students[i].getId() == student.getId()){
						index =i;
					}
				}
				
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		return students[index+1];
	}
}
