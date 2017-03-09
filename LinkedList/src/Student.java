
import java.util.ArrayList;

public class Student {
	private String FirstName;
	private String LastName;
	private String Major;
	private double Gpa;
	private int IdNo;
	private int Length1;
	public Student next;
	private double credit;
	public Student previous;
	private LinkedList course ;
	private Course firstLink;
	private Course lastLink;
	
	public void removeCourse(String element){
		course.remove(element);
		Length1--;
		Gpa=Gpa();
		setCredit(Totalcredit());
	}

	public void setCourse(LinkedList course) {
		this.course = course;
	}
	public LinkedList getCourse() {
		return course;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMajor() {
		return Major;
	}
	public Student(String lastName, String firstName, int idNo) {
		course = new LinkedList();
		FirstName = firstName;
		LastName = lastName;
		Gpa = Gpa();
		credit=Totalcredit();
		
		IdNo = idNo;
		
	}
	/*
	public void insertInlast(String courseNumber, double credit, String Grade){
		Course newCourse = new Course(courseNumber, credit, Grade);
		if(isEmpty()){
			firstLink = newCourse;
			
		}
		else
		{
		newCourse.previous = lastLink;
		lastLink.next = newCourse;
		}
		lastLink = newCourse;
	}
	
	public boolean isEmpty(){
		return (firstLink == null);
	}
	
	public Course get(int index)
    {
        Course current = firstLink;
        int count = 0; 
        while (current != null)
        {
            if (count == index)
                return current;
            count++;
            current = current.next;
        }
		return current;
 
        
    }
	*/
	public void setCourse(String courseNumber, double credit, String grade){
		
		
		course.insertInlast(courseNumber, credit, grade);
		/*
		course.get1(Length1).setCourseNumber(courseNumber);
		course.get1(Length1).setCredit(credit);
		course.get1(Length1).setGrade(grade);
		*/
		Length1++;
		Gpa=Gpa();
		setCredit(Totalcredit());
		
	}
	public Student() {

	}
	public void setMajor(String major) {
		Major = major;
	}
	public double getGpa() {
		return Gpa;
	}
	public void setGpa(double gpa) {
		Gpa = gpa;
	}
	public int getIdNO() {
		return IdNo;
	}
	public void setIdNO(int idNO) {
		IdNo = idNO;
	}
	public double getcredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	
	public String toString()
	   {
	      String s;
	      
	      s = LastName+","+FirstName+","+IdNo+"\n";
	      for(int i = 0; i<Length1;i++){
	    	  s+= course.get1(i).toString();
	      }
	      s+= credit+","+Gpa;
	     
	      return s;
	   }
	public boolean Compare(String Lastname){
		boolean temp = false;
		if(Lastname.compareTo(LastName)==0){
			temp=true;
		}
		return temp;
		
	}
	public boolean equality(String IdNo){
		boolean temp = false;
		if(IdNo.equals(IdNo)){
			temp = true;
		}
		return temp;
		
		
	}
	public String toFile()
	   {
	      String s;
	      
	      s = LastName+","+FirstName+","+IdNo+"\n";
	      for(int i = 0; i<Length1;i++){
	    	  s+= course.get(i).toString();
	      }
	      s+="-999"+"\n"+ credit+","+Gpa;
	      return s;
	   }
	public double Totalcredit(){
		double tc=0.0 ;
		for(int i =0; i<Length1;i++){
			tc+=course.get1(i).getCredit();
		}
		return tc;
		}
	public double Grade(String grade){
		double gpa=0.0;
		switch(grade){
		case "A": gpa =4.0;break;
		case "A-": gpa = 3.7;break;
		case "B+": gpa = 3.3;break;
		case "B": gpa =3.0;break;
		case "B-": gpa = 2.7;break;
		case "C+":  gpa = 2.3;break;
		case "C": gpa = 2.0;break;
		case "C-": gpa = 1.7;break;
		case "D+": gpa = 1.3;break;
		case "D": gpa = 1.0;break;
		}
		return gpa;
	}
	public double Gpa(){
		double credit = Totalcredit();
		double gpa = 0.0;
		for(int i = 0; i<Length1; i++){
			gpa+= Grade(course.get1(i).getGrade())*course.get1(i).getCredit();
		}
		gpa= gpa/credit;
		return gpa;

	}

	
}


