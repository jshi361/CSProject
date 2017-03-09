package Regis;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class SortedArray {
	private Student [] StudentArray;
	private Course [] CourseArray;
	private int arraysize;
	private int front=0;
	private int front1=0;
	private int rear1=0;
	private int nStudent=0;
	private int nCourse=0;
	private int rear=0;
	private int index=0;
	private int index1=0;
	private BufferedWriter bw;
	public static void main (String []args ){
		/*
		SortedArray Array= new SortedArray();
		
		Array.priorityInsert("zhi","zhouxin",234242);
		Array.priorityInsert("shi","zhouxin",133244);
	
		System.out.println(Array.search("sy",Array.getfront(),Array.getrear()));
		Array.display();
	*/
		
		
	}
	public int getfront(){
		return front;
	}
	public int getrear(){
		return rear;
		
	}
	
	public SortedArray(){
		arraysize = 50;
		StudentArray = new Student[50];
		CourseArray = new Course[50];
	}
	
	
	public void insertStudent(String lastName, String firstName, int idNO){
		Student newStudent = new Student(lastName, firstName, idNO);
		if(nStudent+1<=arraysize){
			StudentArray[rear] = newStudent;
			nStudent++;
			
		}else {
			System.out.println("the array is full");
		}
	}
	public void priorityInsert(String lastName, String firstName, int idNO){
		int i;
		if(nStudent==0){
			insertStudent(lastName,firstName,idNO);
			
		}else{
			for (i = nStudent-1; i>= 0; i--){
				if(lastName.compareToIgnoreCase(StudentArray[i].getLastName())<0){
					StudentArray[i+1]= StudentArray[i];
				}else break;
				
			}
			Student newStudent = new Student(lastName, firstName, idNO);
			StudentArray[i+1]= newStudent;
			rear++;
			nStudent++;
		}
		
		
			
		}
	public void remove(String last, String first){
		
		boolean remove = false;
		if(nStudent == 0){
			System.out.println("Empty array");
		}
		else{
			for(int i = 0; i<= nStudent-1; i++){
				if(last.equalsIgnoreCase(StudentArray[i].getLastName())&& first.equalsIgnoreCase(StudentArray[i].getFirstName())){
					index = i;
					remove = true;
					break;
				}
			}
			
			}
		if(remove==true){
		for(int j = index; j<nStudent-1;j++){
			StudentArray[j]=StudentArray[j+1];
		}
		nStudent--;
		rear--;
		}
		}
	
		
		public Student get(int i){
			return StudentArray[i];
		}
		public Course get1(int i){
			return CourseArray[i];
		}
		
		public void insertCourse(String courseNumber, double credit, String Grade){
			Course newCourse = new Course (courseNumber, credit, Grade);
			if(nCourse+1<=arraysize){
				CourseArray[rear1] = newCourse;
				nCourse++;
				
			}else {
				System.out.println("the array is full");
			}
		}
		public void priorityInsert(String courseNumber, double credit, String Grade){
			int i;
			if(nCourse==0){
				insertCourse(courseNumber,credit,Grade);
				
			}else{
				for (i = nCourse-1; i>= 0; i--){
					if((Integer.parseInt(courseNumber))<(Integer.parseInt(CourseArray[i].getCourseNumber()))){
						CourseArray[i+1]= CourseArray[i];
					}else break;
					
				}
				Course newCourse = new Course(courseNumber, credit, Grade);
				CourseArray[i+1]= newCourse;
				rear1++;
				nCourse++;
			}
			
			
				
			}
		
	public Student search(String last, int front, int rear ){
		if(front > rear){ return null;
		
		}
		int mid = (front + rear)/2;
		if(last.equalsIgnoreCase(StudentArray[mid].getLastName())) 
			return StudentArray[mid];
		if(last.compareToIgnoreCase(StudentArray[mid].getLastName())<0){
			return search(last, front, mid-1);
		}
		else return search(last,mid+1,rear);
		
		
	}
	
	public void write(String actions){
		try{
		if(actions.equals("addCourse")){
			bw = new BufferedWriter(new FileWriter("addCourse.txt"));
		}
		if(actions.equals("deleteCourse")){
			bw = new BufferedWriter(new FileWriter("deleteCourse.txt"));
		}
		if(actions.equals("addStudent")){
			bw = new BufferedWriter(new FileWriter("addStudent.txt"));
		}
		if(actions.equals("deleteStudent")){
			bw = new BufferedWriter(new FileWriter("deleteStudent.txt"));
		}
		for(int i =0; i<=nStudent-1;i++){
			bw.write(StudentArray[i].toString());
			bw.newLine();
		}
		bw.flush();
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
	
	
	public Course find(String courseNumber, int front1, int rear1 ){
		if(front1 > rear1) return null;
		int mid = (front1 + rear1)/2;
		if(courseNumber.equals(CourseArray[mid].getCourseNumber())) return CourseArray[mid];
		if(Integer.parseInt(courseNumber) < Integer.parseInt(CourseArray[mid].getCourseNumber()))
			return find(courseNumber, front1, mid-1);
		else return find(courseNumber,mid+1,rear1);
		
		
	}
	
public boolean remove(String element){
		
		boolean remove = false;
		if(nCourse == 0){
			System.out.println("Error");
		}
		else{
			for(int i = 0; i<= nCourse-1; i++){
				if(element.equals(CourseArray[i].getCourseNumber())){
					index1 = i;
					remove = true;
					break;
				}
			}
			
			}
		if(remove==true){
		for(int j = index1; j<nCourse-1;j++){
			CourseArray[j]=CourseArray[j+1];
		}
		nCourse--;
		rear1--;
		}
		return remove;
		} 
	public void display(){
		for(int i = 0;i<=nStudent-1; i++){
			System.out.println(StudentArray[i]);
		}
	}
	
}
