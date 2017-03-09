
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Driver {
	public static StringTokenizer token;
	private Scanner k;
	private int Length;
	private String x1;
	private String x2;
	private static LinkedList student = new LinkedList();;
	public Driver(){
		x1="";
		Length = 0;
		 
	}
	public static void main(String[] args) {
	 
		Driver dr = new Driver();
	
		dr.read();
		/*
		dr.push("Shi", "Joseph", 232691);
		dr.Display();
	*/
		dr.menu();
		
	}
	public void menu() {        
		  System.out.println("                                            ");
		  System.out.println("       Welcome to Student Registration 	      ");
		  System.out.println("-------------------------------------------");
		  System.out.println("        1:Add a student");
		  System.out.println("        2:Delete a student");
		  System.out.println("        3:Search a student");
		  System.out.println("        4:Display the current Registration"); 
		  System.out.print("Yout option:");
		    
		   Scanner k = new Scanner(System.in);
		  x1 = k.nextLine(); 
		  choice();
		 }
	 
		 public void choice() {
		    if(x1.equals("1")){   
		    Scanner k1 = new Scanner(System.in);
		    System.out.println("Enter Student's last Name");
		    String s1 =new String( k1.nextLine());
		    System.out.println("Enter Student's first Name");
		    String s2 = new String(k1.nextLine());
		    System.out.println("Enter You IDNO");
		    int s3 = Integer.parseInt(k1.nextLine());
		    student.insertInlast(s1,s2,s3);    
		    student.write();
		     menu();
		    }
		    if(x1.equals("2")){ 
		     Scanner k1 = new Scanner(System.in);
		     System.out.println("Enter student first Name"); 
		      String d1 =new String( k1.nextLine());
		      System.out.println("Enter student last Name");
		      String d2 =new String( k1.nextLine());
		      student.remove(d1, d2);
		      student.write();
		      menu();
		    }
		    if(x1.equals("3")){   
		    	System.out.println("Enter student first Name");
			      Scanner k1 = new Scanner(System.in);
			      String d1 =new String( k1.nextLine());
			      System.out.println("Enter student last Name");
			      String d2 =new String( k1.nextLine());
			      System.out.println("Choose one of option");
			      System.out.println("1: display");
			      System.out.println("2: add course and grade");
			      System.out.println("3: delete a course and grade");
			      
			      x2 = k1.nextLine();
			      if(x2.equals("1")){
			      student.find(d1, d2);
			      }
			      if(x2.equals("2")){
			    	  System.out.println("Enter you course Number");
			    	  Scanner k2 = new Scanner(System.in);
			    	  String c1 = k2.nextLine();
			    	  System.out.println("Enter you credit");
			    	  double c2 = Double.parseDouble(k2.nextLine());
			    	  System.out.println("Enter you grade");
			    	  String c3 = k2.nextLine();
			    	  student.search(d1, d2).setCourse(c1, c2, c3);
			    	  student.write();
			      }
			      if(x2.equals("3")){
			    	  System.out.println("Enter the course Number you want to delete");
			    	  Scanner k3 = new Scanner(System.in);
			    	  String e1 = k3.nextLine();
			    	  student.search(d1, d2).removeCourse(e1);
			    	  student.write();
			      }
		     menu();
		    }
		    if(x1.equals("4")){  
		    	student.display();
		    	menu();
		    }
		    else{    
		     menu();
		    }
		 }
	
		public void openFile(){
			try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("123.txt"));
			bw.newLine();
			Length++;
			bw.write(student.get(Length).toFile());
			bw.flush();
			}
			catch(Exception e){
				System.out.println("Error");
			}
		}
	    	
		public void push(String last, String first, int IdNo){
			
			student.insertInlast(last,first,IdNo);
			openFile();
		}
		
		public void read(){
			try{	
				 k = new Scanner(new File("WarmUp.txt"));
				}
				catch(Exception e){
					System.out.println("error");
				}
		 String line = k.nextLine();
		 
		 while(k.hasNextLine()){
			 token = new StringTokenizer(line,",");
			while(token.hasMoreTokens()){
				
				

				student.insertInlast(token.nextToken(), token.nextToken(), Integer.parseInt(token.nextToken()));
				
				line = k.nextLine();
				 token = new StringTokenizer(line,",");

			 while(line.compareTo("-999")!= 0){

				 String courseNumber=token.nextToken();
				 double credit = Double.parseDouble(token.nextToken());
				 String grade = token.nextToken();
				 student.get(Length).setCourse(courseNumber,credit , grade);
				 line =  k.nextLine();
				 token = new StringTokenizer(line,",");


			 }
			 line = k.nextLine();
			 double TotalCredit, GPA;
			 GPA = student.get(Length).Gpa();
			 TotalCredit = student.get(Length).Totalcredit();
			 student.get(Length).setCredit(TotalCredit);
			 student.get(Length).setGpa(GPA);
			 
			 if(k.hasNextLine()){
				Length++;
			 line = k.nextLine();
			 
			 }
			 break;
			}
			
				
		 }
		 
			
		}
		public void Display(){
			for(int i = 0; i<=Length;i++){
				System.out.println(student.get(i));
			}
		}


	}


	

