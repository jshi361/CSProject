
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class LinkedList {
	private Student firstLink;
	private Student lastLink;
	private Course head;
	private Course tail;
	private BufferedWriter bw;
	public static void main(String[] args){
		
		
	}
	public void insertInlast(String courseNumber, double credit, String Grade){
		Course newCourse = new Course(courseNumber, credit, Grade);
		if(head==null){
			head = newCourse;
			
		}
		else
		{
		newCourse.previous = tail;
		tail.next = newCourse;
		}
		tail = newCourse;
	}
	
	public Course get1(int index)
    {
        Course current = head;
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
	public void insertInfirst(String lastName, String firstName, int idNO){
		Student newStudent = new Student(lastName, firstName, idNO);
		if(isEmpty()){
			lastLink = newStudent;
			
		}
		else{
			firstLink.previous = newStudent;
		}
		newStudent.next = firstLink;
		firstLink = newStudent;
		
	
		
	}
	
	public boolean isEmpty(){
		return (firstLink == null);
	}
	public void insertInlast(String lastName, String firstName, int idNO){
		Student newStudent = new Student(lastName, firstName, idNO);
		if(isEmpty()){
			firstLink = newStudent;
		}
		else
		{
		newStudent.previous = lastLink;
		lastLink.next = newStudent;
		}
		lastLink = newStudent;
	}
	public void display(){
		Student theLink = firstLink;
		while(theLink!= null){
			System.out.println(theLink);
			
			theLink = theLink.next;
		}
	}
	public void write(){
		try{
		bw = new BufferedWriter(new FileWriter("update.txt"));
		Student theLink = firstLink;
		while(theLink!= null){
			bw.write(theLink.toString());
			bw.newLine();
			theLink = theLink.next;
		}
		bw.flush();
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
    	
	
	public Student get(int index)
    {
        Student current = firstLink;
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
	
	
	public void removefirst(){
		Student current = firstLink;
		if(!isEmpty()){
			firstLink = firstLink.next;
		}
		else 
		System.out.println("empty");
	
	return;
	
}
	public boolean remove(String first, String last)
    {
       if (isEmpty()) 
           return false;      
      
       if (first.equals(firstLink.getFirstName())&& last.equals(firstLink.getLastName()))
       {
          // Removal of first item in the list
          firstLink = firstLink.next;
          if (firstLink == null)
              lastLink = null;       
          return true;
       }
      
      // Find the predecessor of the element to remove
      Student pred = firstLink;
      while (pred.next != null && 
             !pred.next.getFirstName().equals(first) && !pred.next.getLastName().equals(last))
      {
          pred = pred.next;
      }

      // pred.next == null OR pred.next.value is element
      if (pred.next == null)
          return false;
      
      // pred.next.value  is element
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null)
          lastLink = pred;
      
      return true;       
    }
	
	public boolean remove(String element)
    {
       if (head == null) 
           return false;      
      
       if (element.equals(head.getCourseNumber()))
       {
          // Removal of first item in the list
          head = head.next;
          if (head == null)
              tail = null;       
          return true;
       }
      
      // Find the predecessor of the element to remove
      Course pred = head;
      while (pred.next != null && 
             !pred.next.getCourseNumber().equals(element))
      {
          pred = pred.next;
      }

      // pred.next == null OR pred.next.value is element
      if (pred.next == null)
          return false;
      
      // pred.next.value  is element
      pred.next = pred.next.next;    
      
      // Check if pred is now last
      if (pred.next == null)
          tail = pred;
      
      return true;       
    }
	public void find(String first, String last){
		Student theLink = firstLink;
		if(!isEmpty()){
		while(!(first.equals(theLink.getFirstName())) || !(last.equals(theLink.getLastName()))){
		if(theLink.next == null){
		return;
		} else{
		   theLink = theLink.next;
		}
		}
		}
		else{
			System.out.println("Empty LinkedList");
		}
		System.out.println(theLink);
	}
	public Student search(String first, String last){
		Student theLink = firstLink;
		if(!isEmpty()){
		while(!(first.equals(theLink.getFirstName())) || !(last.equals(theLink.getLastName()))){
		if(theLink.next == null){
		return null;
		} else{
		   theLink = theLink.next;
		}
		}
		}
		else{
			System.out.println("Empty LinkedList");
		}
	
		return theLink;
	}
}
