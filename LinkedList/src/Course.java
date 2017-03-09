
public class Course {
	private String CourseNumber;
	private double Credit;
	private String Grade;
	public Course next;
	public Course previous;
	
	public String getCourseNumber() {
		return CourseNumber;
	}
	public Course(String courseNumber, double credit, String grade) {
		
		CourseNumber = courseNumber;
		Credit = credit;
		Grade = grade;
	}
	public Course() {
		
	}
	public void setCourseNumber(String i) {
		CourseNumber = i;
	}
	public double getCredit() {
		return Credit;
	}
	public void setCredit(double credit) {
		Credit = credit;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		String s;
		s= CourseNumber + "," + Credit + "," + Grade+"\n";
		return s;
	}
	
	
}
