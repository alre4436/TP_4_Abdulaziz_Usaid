import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import java.util.Scanner;
public class TestCases {

	@Test
	public void addAStudentTest(){
	
		ArrayList<Student> students = new ArrayList<>();
		
		Student student = new Student();
		student.setFirstName("Yasir");
		student.setLastName("Alanazi");
		student.setStudentId("109");
		
		students.add(student);
		assertEquals(student.getFirstName(), "Yasir");
	
	}
	
	@Test
	public void addABookTest(){
		
		ArrayList<Copies> books = new ArrayList<>();
		
		Copies book = new Copies();
		book.setAuthor("Eric");
		book.setAvaliblity(true);
		book.setBookId("515");
		book.setCourseNo("111");
		book.setNoOfCopyAvalible(15);
		book.setTitle("Data Analysis");
		
		books.add(book);
		assertEquals (book.getTitle(), "Data Analysis");
		
	}
	
	@Test
	public void searchBookTest(){
		
		Copies book = new Copies();
		book.setBookId("999");
		book.setAvaliblity(true);
		book.setAuthor("Yasir");
		book.setCourseNo("111");
		book.setTitle("How to get an A in Software Analysis");
		
		
		Controller controller = new Controller();
	//	controller.addABook();
		controller.searchBook("999");
		
		assertEquals (book.getTitle(), "How to get an A in Software Analysis");
		
	}
	@Test
	public void BooksListTest(){

	     ArrayList<Copies> books = new ArrayList<>();
	     books.add(new Copies("001","1", "Calculus 1", "CAL",  "Eric Level", 201.10 ));
         books.add(new Copies("002","2", "Data Base", "DAT", "Jeffery KADE",122.98 ));
         books.add(new Copies("001","3", "Java", "XYZ",  "Eric", 338.18));
         books.add(new Copies("005","4", "Software analysis and design", "Me",  "Babahani",145.32 ));
         books.add(new Copies("007","5", "Chemestry", "ABC",  "Chi Lai", 521.30));
         books.add(new Copies("008","6", "Security and Networking", "NAZ", "Saultan",781.20 ));
         books.add(new Copies("10","7", "Statistics ", "CDS",  "Aziz", 451.40));
         books.add(new Copies("07","8", "Java 2", "ABC", "Usaid", 472.40 ));
         books.add(new Copies("03","9", "Java 2", "ABC", "Eric Level", 422.10 ));

	     ArrayList<Copies> books1 = new ArrayList<>();
			
	     Controller controller = new Controller();
		
		controller.BookList();
        books1=controller.returnBooks();
        
       Copies cp=books.get(0);
        Copies cp1=books1.get(0);
        
        assertNotEquals (books, books1);
		
        assertEquals (cp.getAuthor(), cp1.getAuthor());
        System.out.println(cp.getduedate()+" "+ cp1.getduedate());
        assertNotEquals (cp.getduedate(), cp1.getduedate());
        assertEquals (cp.getBookId(), cp1.getBookId());
        assertEquals (cp.getCourseNo(), cp1.getCourseNo());
        
		
		/*controller.StudentList();
		controller.BookList();
		
		controller.checkIn();
		controller.howManyCopiesISAvalibleInLibrary();
		*/
		
	}
	@Test
	public void StudentListTest()
	{
		

	     ArrayList<Student> students = new ArrayList<>();
	     students.add(new Student("01", "Abdulaziz", "Alreshidi"));
         students.add(new Student("02", "Tim", "Karen"));
         students.add(new Student("03", "Susan", "Kim"));
         students.add(new Student("04", "Usaid", "ALibrahem"));
         students.add(new Student("04", "Muhammeed", "M"));
         students.add(new Student("05", "Khaled", "Abdullah"));
         students.add(new Student("04", "Musaaed", "Saad"));
         
        Controller controller = new Controller();
		controller.StudentList();

	     ArrayList<Student> students1 = new ArrayList<>();
	     students1=  controller.returnStudents();
	   // System.out.println(students1.size()+"  "+students.size());
	    Student std=students1.get(0);
	    Student std1=students.get(0);
	//    System.out.println(std.getFirstName()+" "+std.getLastName()+" "+std.getStudentId()+" "+std.getNoOfBooks());
//	    System.out.println(std1.getFirstName()+" "+std1.getLastName()+" "+std1.getStudentId()+" "+std1.getNoOfBooks());
	    
	    
	     assertEquals(std.getFirstName(),std1.getFirstName());
	     assertEquals(std.getLastName(),std1.getLastName());
	     assertEquals(std.getStudentId(),std1.getStudentId());
	     
	      std1=students.get(1);
	     assertNotEquals(std,std1);
	     
	     
	     
	     
	}
	@Test
	public void SearchBookTest()
	{
		
	     Controller controller = new Controller();
		
		controller.BookList();

	     ArrayList<Copies> books1 = new ArrayList<>();
			
	     books1=controller.returnBooks();
		
		Copies Book=books1.get(0);
	     assertEquals(Book.getCourseNo(),"001");
	     assertEquals(Book.getBookId(),"1");
	Copies Book1=new Copies("001","123", "Calculus 1", "CAL",  "Eric Level", 201.10 );
	  assertNotEquals(Book1,Book);     
	
	}
	@Test
	public void AvailableCopiesTest()
	{

	     ArrayList<Copies> books1 = new ArrayList<>();
	     Controller controller = new Controller();
		
		controller.BookList();
		books1=controller.returnBooks();
		Copies b=books1.get(0);
		int num=controller.returnNoofCopies(b.getBookId());
		//System.out.println(num+" "+b.getNoOfCopyAvalible());
		 assertEquals(8,num);
		 
		 assertEquals(b.getNoOfCopyAvalible(),num);
		Copies book=new Copies("001","123", "Calculus 1", "CAL",  "Eric Level", 201.10 );
		book.setNoOfCopyAvalible(5);
		 assertNotEquals(book.getNoOfCopyAvalible(),num);
			
		
	}
	@Test
	public void CheckInTest()
	{
		System.out.println("*** Test For Check In ***");
		Scanner sc=new Scanner (System.in);
		 Controller controller = new Controller();
		 controller.BookList();
			controller.StudentList();
			controller.checkIn();
ArrayList<Student> std=new ArrayList<Student>();
std=controller.returnStudents();

for (int i=0;i<std.size();i++)
{
	Student s=std.get(i);
	ArrayList<Copies> cp=new ArrayList<Copies>();
	cp=s.getBooks();
	if (cp.size()>0)
	{
		Copies c=cp.get(0);
		System.out.println("Enter The Book ID You have entered Before to Check in ");
		String x = sc.nextLine().trim();
		assertEquals(x,c.getBookId());
		assertNotEquals(x,c.getCourseNo());
		Copies copy=new Copies (c.getCourseNo(),c.getBookId(),c.getTitle(),c.getPublisher(),c.getAuthor(),c.getPrice());
		
		assertNotEquals(copy.getNoOfCopyAvalible(),c.getNoOfCopyAvalible());
		assertNotEquals(copy,c); // because no of copies are not equal
		
		break;
	}
}

	}
	@Test
	public void CheckOutTest()
	{
		System.out.println("*** Test For Check In ***");
		Scanner sc=new Scanner (System.in);
		 Controller controller = new Controller();
		 controller.BookList();
			controller.StudentList();
			controller.checkIn();
ArrayList<Student> std=new ArrayList<Student>();
std=controller.returnStudents();

for (int i=0;i<std.size();i++)
{
	Student s=std.get(i);
	ArrayList<Copies> cp=new ArrayList<Copies>();
	cp=s.getBooks();
	if (cp.size()>0)
	{
		Copies c=cp.get(0);
		System.out.println("Enter The Book ID You have entered Before to Check in ");
		String x = sc.nextLine().trim();
		assertEquals(x,c.getBookId());
		assertNotEquals(x,c.getCourseNo());
		Copies copy=new Copies (c.getCourseNo(),c.getBookId(),c.getTitle(),c.getPublisher(),c.getAuthor(),c.getPrice());
		
		assertNotEquals(copy.getNoOfCopyAvalible(),c.getNoOfCopyAvalible());
		assertNotEquals(copy,c); // because no of copies are not equal
		System.out.println("***Enter The same Student Id which You have entered in Check in ***");
		std=controller.returnStudents();
		s=std.get(i);
		
		assertNotEquals(copy.getNoOfCopyAvalible(),c.getNoOfCopyAvalible());
		
		controller.checkOut();
		
		cp=s.getBooks();
		
		System.out.println(cp.size());
		if (cp.size()==0)
		c=null;
		assertEquals(c,null);
		
		break;
	}
}


		
	}
	public static void main (String args[])
	
	{
		TestCases t= new TestCases();
		//t.BooksListTest();
	}
}




