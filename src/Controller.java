import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    static Scanner readData = new Scanner(System.in);
    static ArrayList<Copies> books = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
 
    /** Load Books to the Book list **/
    public static void BookList() {
        // book is , Title , publisher , price , author , course no
    	 books.add(new Copies("001","1", "Calculus 1", "CAL",  "Eric Level", 201.10 ));
         books.add(new Copies("002","2", "Data Base", "DAT", "Jeffery KADE",122.98 ));
         books.add(new Copies("001","3", "Java", "XYZ",  "Eric", 338.18));
         books.add(new Copies("005","4", "Software analysis and design", "Me",  "Babahani",145.32 ));
         books.add(new Copies("007","5", "Chemestry", "ABC",  "Chi Lai", 521.30));
         books.add(new Copies("008","6", "Security and Networking", "NAZ", "Saultan",781.20 ));
         books.add(new Copies("10","7", "Statistics ", "CDS",  "Aziz", 451.40));
         books.add(new Copies("07","8", "Java 2", "ABC", "Usaid", 472.40 ));
         books.add(new Copies("03","9", "Java 2", "ABC", "Eric Level", 422.10 ));

    }

    /** Load Students to the Student list **/
    public static void StudentList() {
        //  student is , first name ,last name 
    	   students.add(new Student("01", "Abdulaziz", "Alreshidi"));
           students.add(new Student("02", "Tim", "Karen"));
           students.add(new Student("03", "Susan", "Kim"));
           students.add(new Student("04", "Usaid", "ALibrahem"));
           students.add(new Student("04", "Muhammeed", "M"));
           students.add(new Student("05", "Khaled", "Abdullah"));
           students.add(new Student("04", "Musaaed", "Saad"));
    }
/*** return Student List ***/
public static  ArrayList<Student>  returnStudents()
{
	return students;
}
    /** Display all books in the library **/
    public static void displayAllBooks() {
        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
        System.out.printf("|%15s |%-25s|%15s|%20s|%8s|%11s|\n", "CourseNo", "Book ID", "Title", "Publisher", "Author", "Number of copies");
        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
        for (Copies b : books) {
            b.print();
            System.out.println();
        }
       
        System.out.printf("|------------------------------------------------------------------------------------------ ---------|\n");
    }

    /** Display Books that relate to a certain course **/
    public static void displayBooklistForCoursList(String coursNumber) {
        System.out.printf("|---------------------------------------------------------------------------------------- -----------|\n");
        System.out.printf("|%15s |%-25s|%15s|%20s|%8s|%11s|\n", "CourseNo", "Book ID", "Title", "Publisher", "Author", "Number of copies");
        System.out.printf("|----------------------------------------------------------------------------------------- ----------|\n");
        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
        for (Copies b : books) {
            if (b.getCourseNo().equals(coursNumber)) {
                b.print();
               // System.out.println();
            }
        }
        System.out.printf("|------------------------------------------------------------------------------------------ ---------|\n");
    }

    /** looking  for a book **/
    public static Copies searchBook(String byTitleOrID) {

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(byTitleOrID) || books.get(i).getTitle().equals(byTitleOrID)) {
                return books.get(i);
            }
        }
        return null;
    }

    /** Looking for a student **/
    public static Student searchStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                return students.get(i);
                 
               
            }
           
        }
       
        return null;
        
        
    }
   
    /** Adding  new Students to the library database (ArrayList) **/
    public static void addAStudent() {
        System.out.print("Please enter the student id : ");
        String id = readData.nextLine();
        System.out.print("Please enter the student's first name : ");
        String firstName = readData.nextLine();
        System.out.print("Please enter the student's last name : ");
        String lastName = readData.nextLine();

        students.add(new Student(id, firstName, lastName));
        System.out.print("Student with  id " + id + " added  ");

    }
    
    /**  Adding new Students to the library database (ArrayList) **/
    

    
    
    
    
    private static void addAStudent(Student stu) {
        students.add(stu);
        System.out.print("Student with  " + stu.getFirstName() + " done Student added  to the student's list");
    }
    
    
    /** Display All Students in the list we have 
     * @param newParam TODO**/
    static void displayAllStudents(Object newParam) {
        System.out.printf("|---------------------------------|\n");
        System.out.printf("|%10s|%10s|%10s|\n", "Student ID", "First Name", "Last Name");
        System.out.printf("|--------------------------------|\n");
        for (Student s : students) {
            s.print();
            System.out.println();
        }
        System.out.printf("|--------------------------------|\n");
    }
    /** ReturnNoofCopies of Bookid placed in parameter **/
    static int returnNoofCopies(String id)
    {
    	Copies b=null;
    	b=searchBook(id);
    	return b.getNoOfCopyAvalible();
    }
    /** Check for books availability **/
    static void howManyCopiesISAvalibleInLibrary() {
        System.out.print("Please enter the book's title or you can enter book's id : ");
        String bTitleorId = readData.nextLine().trim();
        Copies b = searchBook(bTitleorId);
        if (b != null) {
            System.out.print("Book  Found...no of copies left are :  " + b.getNoOfCopyAvalible());
        } else {
            System.out.print("Book \"" + bTitleorId + "\" NOT Found ");
        }

    }

    /** To add new books to the library **/
    public static void addABook() {
        System.out.print("Please enter the book id : ");
        String id = readData.nextLine();
        System.out.print("Please enter the course number : ");
        String courseID = readData.nextLine();
        System.out.print("Please enter the book price : ");
        double p = Double.parseDouble(readData.nextLine() );
        System.out.print("Please enter the book title : ");
        String title = readData.nextLine();
        System.out.print("Please enter the book publisher : ");
        String publisher = readData.nextLine();
        System.out.print("Please enter the book author : ");
        String auther = readData.nextLine();
 
        books.add(new Copies(courseID,id, title, publisher,  auther, p ));
        System.out.print("Book with this id : " + id + " has been entered  ");

    }
    
    public static void addingABook(Copies b) {
        books.add(b);
        System.out.print("Book: " + b.getTitle() + " checked in.  ");
    }
    
    /** Check out books **/
    public static void checkOut() {
    	int money=0;
    	System.out.print("Enter the student ID : ");
    	String id="";
    	   	id=readData.nextLine().trim();
    	Student s = searchStudent(id);
        if (s!=null){
        System.out.println("List of books with student " + s.getStudentId());
        trackStudentForBooks(s);
        
       System.out.println();
      
       if (s.getBooks().size() > 0) {
           // System.out.print("Enter the book's title or book's id (to check out from student): ");
           // String bTitleorId = readData.nextLine().trim();
    	
    	   ArrayList<Copies> books1 = new ArrayList<>();
    	   books1=s.getBooks();
           for (int i=0;i< s.getNoOfBooks();i++){
        	  
            Copies b = books1.get(i);
            if (b != null) {
            	System.out.println("");
            //if (b.getduedate() );
            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            	Calendar c = Calendar.getInstance();
            	c.setTime(new Date()); // Now use today date.

            if (b.getduedate().compareTo(c.getTime())<0)
            {
            	System.out.println(" You have already Issued a Book And its Due Date is Passed ");
            	System.out.println("Checking Out..... ");
            	s.checkOut(b);
            	b.setNoOfCopyAvalible(b.getNoOfCopyAvalible() + 1);
            	System.out.println(" You have To Pay Fine of 5 Dollars");
            	System.out.println("Enter Money ");
            	 money=Integer.parseInt(readData.nextLine().trim());
            	if (money>=5)
            	{
            		

            		System.out.println("You remaining Change is "+(money-5));
                		
                		}
                		
               
            	else if (money<5)
            	{
            		System.out.println("Money less than 5.. Enter Money Again ");
                	 money=Integer.parseInt(readData.nextLine().trim());
                		if (money>5)
                    	{
                    		System.out.println("You remaining Change is "+(money-5));
	
                    	}
                    	
            	}
            	
            	System.out.println("book checked out from the student. ");
            }
            else
            {
            System.out.println("Do You Want  "+b.getTitle()+" to Check Out?");
            System.out.println("Press y for Yes Else Press n ");
            String ans=readData.nextLine().trim();
            if (ans.equals("y"))
            {
            	
            	s.checkOut(b);
            	b.setNoOfCopyAvalible(b.getNoOfCopyAvalible() + 1);	
            }
            }
            }
                
             else {
              //  System.out.print("please check the book id");
            }
           
        
        
    }
       }
        }
        }/*
    	Scanner readData = new Scanner(System.in);
        System.out.print("Enter the course number : ");
        String cno = readData.nextLine().trim();
        System.out.println("List of books avaliable for this course id :");
        displayBooklistForCoursList(cno);
        System.out.println();
        System.out.print("Enter the student ID ( to issuse) : ");
        String id = readData.nextLine().trim();

        Student s = searchStudent(id);
        if (s.getNoOfBooks() < 5) {
            System.out.print("Enter the book's title or book's id ( to issuse) : ");
            String bTitleorId = readData.nextLine().trim();
            Copies b = searchBook(bTitleorId);
            if (b.isAvaliblity()) {
                if (s.checkIn(b)) {
                    System.out.println("The selected book has been issused to the student id " + s.getStudentId());
                    b.setNoOfCopyAvalible(b.getNoOfCopyAvalible() - 1);
                }
            } else {
                System.out.print("The selected book is not avaliable.");
            }
        } else {
            System.out.print("Each student can have only 5 books to the max.");
        }
*/
    /** return books **/
    static ArrayList<Copies>  returnBooks()
    {
    	return books;
    }
    
    /** Check in books **/
    static void checkIn() {
    	System.out.print("Enter the student ID : ");
    	String id="";
    	   	id=readData.nextLine().trim();
    	Student s = searchStudent(id);
        if (s!=null){
        System.out.println("List of books with student " + s.getStudentId());
        trackStudentForBooks(s);
        
       System.out.println();
      
       if (s.getBooks().size() > 0) {
           // System.out.print("Enter the book's title or book's id (to check out from student): ");
           // String bTitleorId = readData.nextLine().trim();
    	
    	   ArrayList<Copies> books1 = new ArrayList<>();
    	   books1=s.getBooks();
           for (int i=0;i< s.getNoOfBooks();i++){
        	  
            Copies b = books1.get(i);
            if (b != null) {
            	System.out.println("");
            //if (b.getduedate() );
            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            	Calendar c = Calendar.getInstance();
            	c.setTime(new Date()); // Now use today date.

            if (b.getduedate().compareTo(c.getTime())<0)
            {
            	System.out.println(" You have already Issued a Book And its Due Date is Passed ");
            	System.out.println("Checking Out..... ");
            	s.checkOut(b);
            	b.setNoOfCopyAvalible(b.getNoOfCopyAvalible() + 1);
            	System.out.println(" You have To Pay Fine of 5 Dollars");
            	System.out.println("Enter Money ");
            	int money=Integer.parseInt(readData.nextLine().trim());
            	if (money>=5)
            	{
            		System.out.println("You remaining Change is "+(money-5));
                	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                	Calendar c1 = Calendar.getInstance();
                	c1.setTime(new Date()); // Now use today date.
                	
                	String bookorid;
                	System.out.println("Enter Book Title or Book ID ");
                	bookorid=readData.nextLine().trim();
                	for (int i1=0;i1<books.size();i1++)
                	{
                		Copies cp = books.get(i1);
                	System.out.println(cp.getBookId());
                		if (cp.getBookId().equals(bookorid)|| cp.getTitle().equals(bookorid) ){
                		//System.out.println("yes");
                			if (cp.isAvaliblity() )
                		{
                				System.out.println(" Enter the No of Days You want To Issue this Book");
                	        	int num=Integer.parseInt(readData.nextLine().trim());
                	        	c1.add(Calendar.DATE, num);
                	        	//Date datenow= new Date();
                	        
                			
                		     	cp.setduedate(c1.getTime());
                		     	cp.setavailablecopy();
                		     	s.checkIn(cp);
                		books.remove(i1);
                		books.add(i1, cp);
                		for (int k=0;k<students.size();k++)
                		{
                			Student std=students.get(k);
                			if (std.getStudentId().equals(id))
                			{
                				students.remove(k);
                				students.add(k, s);

                	        	String output = sdf1.format(c1.getTime());
                		System.out.println("Youe Book is Issue , Return Date of You Book is "+output);
                		System.out.println("if Book is not returned on Time Then 5 Dollars are charged as a Fine");
                		
                		break;
                			}
                		}
                		//System.out.println("book Issued ");
                		     	break;     	
                		
                		}
                		else
                		{
                			System.out.println("book is not available any more ");
                			break;
                		}
                	}
                }	
            	}
            	else if (money<5)
            	{
            		System.out.println("Money less than 5.. Enter Money Again ");
                	 money=Integer.parseInt(readData.nextLine().trim());
                		if (money>5)
                    	{
                    		System.out.println("You remaining Change is "+(money-5));
                        	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        	Calendar c1 = Calendar.getInstance();
                        	c1.setTime(new Date()); // Now use today date.
                        	
                        	String bookorid;
                        	System.out.println("Enter Book Title or Book ID ");
                        	bookorid=readData.nextLine();
                        	for (int i1=0;i1<books.size();i1++)
                        	{
                        		Copies cp = books.get(i1);
                        	System.out.println(cp.getBookId());
                        		if (cp.getBookId().equals(bookorid)|| cp.getTitle().equals(bookorid) ){
                        		//System.out.println("yes");
                        			if (cp.isAvaliblity() )
                        		{
                        				System.out.println(" Enter the No of Days You want To Issue this Book");
                        	        	int num=Integer.parseInt(readData.nextLine().trim());
                        	        	c1.add(Calendar.DATE, num);
                        	        	//Date datenow= new Date();
                        	        
                        			
                        		     	cp.setduedate(c1.getTime());
                        		     	cp.setavailablecopy();
                        		     	s.checkIn(cp);
                        		books.remove(i1);
                        		books.add(i1, cp);
                        		for (int k=0;k<students.size();k++)
                        		{
                        			Student std=students.get(k);
                        			if (std.getStudentId().equals(id))
                        			{
                        				students.remove(k);
                        				students.add(k, s);

                        	        	String output = sdf1.format(c1.getTime());
                        		System.out.println("Youe Book is Issue , Return Date of You Book is "+output);
                        		System.out.println("if Book is not returned on Time Then 5 Dollars are charged as a Fine");
                        		
                        		break;
                        			}
                        		}
                        		//System.out.println("book Issued ");
                        		     	break;     	
                        		
                        		}
                        		else
                        		{
                        			System.out.println("book is not available any more ");
                        			break;
                        		}
                        	}
                        }	
                    	}
                    	
            	}
            	
            	System.out.println("book checked out from the student. ");
                     
            }
                
            } else {
                System.out.print("please check the book id");
            }
           }
        }
        else
        {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	Calendar c = Calendar.getInstance();
        	c.setTime(new Date()); // Now use today date.
        	boolean check=false;
            
        	while(!check){    	
        	String bookorid;
        	System.out.println("Enter Book Title or Book ID ");
        	bookorid=readData.nextLine();
    
        	for (int i=0;i<books.size();i++)
        	{
        		Copies cp = books.get(i);
        	//System.out.println(cp.getBookId());
        		if (cp.getBookId().equals(bookorid)|| cp.getTitle().equals(bookorid) ){
        		//System.out.println("yes");
        			if (cp.isAvaliblity() )
        		{
        				System.out.println(" Enter the No of Days You want To Issue this Book");
        	        	int num=Integer.parseInt(readData.nextLine().trim());
        	        	c.add(Calendar.DATE, num);
        	        	//Date datenow= new Date();
        	        
        			
        		     	cp.setduedate(c.getTime());
        		     	cp.setavailablecopy();
        		     	s.checkIn(cp);
        		books.remove(i);
        		books.add(i, cp);
        		for (int k=0;k<students.size();k++)
        		{
        			Student std=students.get(k);
        			if (std.getStudentId().equals(id))
        			{
        				students.remove(k);
        				students.add(k, s);

        	        	String output = sdf.format(c.getTime());
        		System.out.println("Youe Book is Issue , Return Date of You Book is "+output);
        		System.out.println("if Book is not returned on Time Then 5 Dollars are charged as a Fine");
        		check=true;
        		break;
        			}
        		}
        		//System.out.println("book Issued ");
        		check=true;
        		break;     	
        	
        		}
        		else
        		{
        			System.out.println("book is not available any more ");
        			break;
        		}
        	}
        }

        	if (check==false)
        	{

    			System.out.println("book Not Found ");
        	}
}
        }
        }
        else
        {
        	System.out.println("Student Does Not Exists ");
        }
        
    }
    
    /** return trackofstudent **/
    static ArrayList<Copies> trackstudent(Student s)
    {
    	return s.getBooks();
    }
    /** Track Student record and find out which book he has **/
    static void trackStudentForBooks(Student s) {
        if (s.getBooks().size() > 0) {
            System.out.printf("|---------------------------------------------------------------------------------------------------|\n");
            System.out.printf("|%15s |%-25s|%15s|%20s|%8s|\n", "CourseNo", "Book ID", "Title", "Publisher", "Author", "Number of copies");
            System.out.printf("|---------------------------------------------------------------------------------------------------|\n");
            for (Copies b : s.getBooks()) {
                b.printStudentView();
                System.out.println();
            }
            System.out.printf("|---------------------------------------------------------------------------------------------------|\n");
        } else {
            System.out.print("No book is issused to this student id. ");
        }

    }
    
    public static void exit() {
        System.exit(1);
    }
public static void functialityNotAvailable(){
    	
    	System.out.println("\n"+"Functionality is Not Available yet!");
    	
    }
    
    /** Display the main menu **/
    public static void displayMenu() {
        System.out.println(" Press#1: To add new Student");
        System.out.println(" Press#2: To add new book");
        System.out.println(" Press#3: To display all Students");
        System.out.println(" Press#4: To display all books");
        System.out.println(" Press#5:To track student who has which book");
        System.out.println(" Press#6: How many copies are available");
        System.out.println(" Press#7: To Check out book");
        System.out.println(" Press#8: To Check in book");
        System.out.println(" Press#9: To Search book");
        System.out.println(" Press#10: Search Student");
        System.out.println(" Press#11: Exit");
        System.out.print("\n"+"Please enter your option :   ");
    }
    
    
} 