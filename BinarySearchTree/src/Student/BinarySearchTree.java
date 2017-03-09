package Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class BinarySearchTree {
	private Student Studentroot;
	private Course Courseroot;
	private BufferedWriter bw;
	private int Studentcounter;
	private int Coursecounter;
	private String s;
	public static void main(String[] args){
		/*
		SortedArray a = new SortedArray();
		a.addStudent("shi", "zhouxin", 2342424);
 		a.addStudent("zhi", "joseph", 123421412);
		a.find("zhouxin", "shi").setCourse("234242", 8.0, "A");
		a.find("zhouxin", "shi").setCourse("134242", 8.0, "A");
		a.find("zhouxin", "shi").removeCourse("234242");
	    a.remove("zhouxin", "shi");
		a.display();
       */
	}
	public void addCourse(String courseNumber, double credit, String Grade){
		Course newCourse = new Course(courseNumber, credit, Grade);
		if(Courseroot==null){
			Courseroot= newCourse;
			return;
		}
		
		Course focusCourse = Courseroot;
		Course parent;
		while(true){
			parent = focusCourse;
			if(Integer.parseInt(courseNumber) < Integer.parseInt(focusCourse.getCourseNumber())){
				focusCourse = focusCourse.leftChild;
			if(focusCourse==null){
				parent.leftChild = newCourse;
				return;
			}
			}
			else{
				focusCourse = focusCourse.rightChild;
				if(focusCourse == null){
					parent.rightChild = newCourse;
					return;
				}
			}
		  }
		}
	
	
	public void addStudent(String lastName, String firstName, int idNO){
		Student newStudent = new Student(lastName, firstName, idNO);
		if(Studentroot==null){
			Studentroot= newStudent;
			
		}
		else
		{
		Student focusStudent = Studentroot;
		Student parent;
		while(true){
			parent = focusStudent;
			if(lastName.compareToIgnoreCase(focusStudent.getLastName())<0){
				focusStudent = focusStudent.leftChild;
			if(focusStudent==null){
				parent.leftChild = newStudent;
				return;
			}
			}
			else{
				focusStudent = focusStudent.rightChild;
				if(focusStudent == null){
					parent.rightChild = newStudent;
					return;
				}
			}
		  }
		}
	}
	public void display(){
		inOrder(Studentroot);
	}
	
	public void inOrder(Student focusStudent){
		if(focusStudent != null){
			inOrder(focusStudent.leftChild);
			System.out.println(focusStudent);
			inOrder(focusStudent.rightChild);

		}
	}
	
	public void inOrder(Course focusCourse){
		
		if(focusCourse != null){
			inOrder(focusCourse.leftChild);
			System.out.print(focusCourse);
			inOrder(focusCourse.rightChild);
			
		}
	}
	
	public String writeIn(){
		s = null;
		return inOrderWrite(Studentroot);
		
		
	}
	public String inOrderWrite(Student focusStudent){
		
		if(focusStudent != null){
			inOrderWrite(focusStudent.leftChild);
			if (s== null)
		     s="";
			s = s+ focusStudent.toString()+ "\n";
			
			inOrderWrite(focusStudent.rightChild);

		}
		return s;
	}
	
	public Student get(int index){
		Studentcounter = -1;
	   return inOrderTraverseTree(Studentroot, index);
	       
	   }
	   
public Student inOrderTraverseTree(Student root,int index){
		   
		   		
	 if  (root == null) return null;
	    Student smallest = null;
	    smallest = inOrderTraverseTree(root.leftChild,index);
	       if(smallest == null){
	    	   Studentcounter ++;
	    	   if(Studentcounter == index)
	    	   {
	    		   smallest = root;
	    	   }
	       }

	       
	       if (smallest == null) 
	       {
	           smallest = inOrderTraverseTree(root.rightChild,index);
	       } 
	       
	      return smallest;
		   
		}   
		
		   public Course get1(int index){
			   Coursecounter = -1;
			   return inOrderTraverse(Courseroot, index);
		   }
		   public Course inOrderTraverse(Course root,int index){
			   
			   if  (root == null) return null;
			    Course smallest = null;
			    smallest = inOrderTraverse(root.leftChild,index);
			       if(smallest == null){
			    	   Coursecounter ++;
			    	   if(Coursecounter == index)
			    	   {
			    		   smallest = root;
			    	   }
			    	   
			       }

			       
			       if (smallest == null) 
			       {
			           smallest = inOrderTraverse(root.rightChild,index);
			       } 
			       
			      return smallest;
			       
			       
			   
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
				
					bw.write(writeIn());
					bw.newLine();
				
				bw.flush();
				}
				catch(Exception e){
					System.out.println("Error");
				}
			}
		   
		   
	

	public boolean remove(String first, String last)
    {
		Student focusStudent = Studentroot;
        Student parent = Studentroot;
        boolean IsAleftChild = true;
        while(!(focusStudent.getFirstName().equalsIgnoreCase(first) && focusStudent.getLastName().equalsIgnoreCase(last))){
        	parent = focusStudent;
        	if(last.compareTo(focusStudent.getLastName())<0){
        		IsAleftChild = true;
        		focusStudent = focusStudent.leftChild;
        	}
        	else{
        		IsAleftChild = false;
        		focusStudent = focusStudent.rightChild;
        		
        	}
        	if(focusStudent == null)
        		return false;
        }
        if(focusStudent.leftChild == null && focusStudent.rightChild== null){
        	if(focusStudent == null)
        		Courseroot =null;
        	else if (IsAleftChild)
        		parent.leftChild = null;
        		else parent.rightChild = null;
        }
        else if (focusStudent.rightChild == null){
        	if(focusStudent == Studentroot)
        		Studentroot = focusStudent.leftChild;
        	else if (IsAleftChild)
        		parent.leftChild = focusStudent.leftChild;
        		else parent.rightChild = focusStudent.leftChild;
        	}
        else if (focusStudent.leftChild == null){
        	if(focusStudent == Studentroot)
        		Studentroot = focusStudent.rightChild;
        		else if(IsAleftChild)
        		parent.leftChild = focusStudent.rightChild;
        		else parent.rightChild = focusStudent.rightChild;
        	}
        else { 
        	Student replacement = getReplace(focusStudent);
        	if(focusStudent == Studentroot)
        		Studentroot = replacement;
        	else if (IsAleftChild)
        		parent.leftChild = replacement;
        	else parent.rightChild = replacement;
        	replacement.leftChild = focusStudent.leftChild;
        }
        return true; 
    }
	public Student getReplace(Student replace){
		Student replaceParent = replace;
		Student replacement = replace;
		Student focusCourse = replace.rightChild;
		while(focusCourse != null){
			replaceParent = replacement;
			replacement = focusCourse;
			focusCourse = focusCourse.leftChild;
		}
		if(replacement != replace.rightChild){
			replaceParent.leftChild= replacement.rightChild;
			replacement.rightChild = replace.rightChild;
		}
		return replacement;
		
	}
	
	
	public boolean remove(String element)
    {
        Course focusCourse = Courseroot;
        Course parent = Courseroot;
        boolean IsAleftChild = true;
        while(!focusCourse.getCourseNumber().equals(element)){
        	parent = focusCourse;
        	if(element.compareTo(focusCourse.getCourseNumber())<0){
        		IsAleftChild = true;
        		focusCourse = focusCourse.leftChild;
        	}
        	else{
        		IsAleftChild = false;
        		focusCourse = focusCourse.rightChild;
        		
        	}
        	if(focusCourse == null)
        		return false;
        }
        if(focusCourse.leftChild == null && focusCourse.rightChild== null){
        	if(focusCourse == null)
        		Courseroot =null;
        	else if (IsAleftChild)
        		parent.leftChild = null;
        		else parent.rightChild = null;
        }
        else if (focusCourse.rightChild == null){
        	if(focusCourse == Courseroot)
        		Courseroot = focusCourse.leftChild;
        	else if (IsAleftChild)
        		parent.leftChild = focusCourse.leftChild;
        		else parent.rightChild = focusCourse.leftChild;
        	}
        else if (focusCourse.leftChild == null){
        	if(focusCourse == Courseroot)
        		Courseroot = focusCourse.rightChild;
        		else if(IsAleftChild)
        		parent.leftChild = focusCourse.rightChild;
        		else parent.rightChild = focusCourse.rightChild;
        	}
        else { 
        	Course replacement = getReplace(focusCourse);
        	if(focusCourse == Courseroot)
        		Courseroot = replacement;
        	else if (IsAleftChild)
        		parent.leftChild = replacement;
        	else parent.rightChild = replacement;
        	replacement.leftChild = focusCourse.leftChild;
        }
        return true;
    }
	
	
	public Course getReplace(Course replace){
		Course replaceParent = replace;
		Course replacement = replace;
		Course focusCourse = replace.rightChild;
		while(focusCourse != null){
			replaceParent = replacement;
			replacement = focusCourse;
			focusCourse = focusCourse.leftChild;
		}
		if(replacement != replace.rightChild){
			replaceParent.leftChild= replacement.rightChild;
			replacement.rightChild = replace.rightChild;
		}
		return replacement;
		
	}
	public Student find(String first, String last){
		Student focusStudent = Studentroot;
		while(!((first.equalsIgnoreCase(focusStudent.getFirstName()))&&last.equalsIgnoreCase(focusStudent.getLastName()))){
			if(last.compareToIgnoreCase(focusStudent.getLastName())<0){
				focusStudent = focusStudent.leftChild;
			}
			else {
				focusStudent = focusStudent.rightChild;
			}
			if(focusStudent == null)
				return null;
		}
		return focusStudent;
		
	}
	
}
