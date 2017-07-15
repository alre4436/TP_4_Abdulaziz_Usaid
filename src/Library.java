
import java.util.ArrayList;
import java.util.Scanner;

public class Library {


    public static void main(String[] args) {

    	LogIn log = new LogIn();
    	log.run();
    	/** Load a list of students and books **/
    	
        Controller.BookList();
        Controller.StudentList();
        System.out.println("***** Welcome to TRL *****" + "\n");
        Controller.displayMenu();

        int choice = 0;

     	 Scanner readData = new Scanner(System.in);
        while (true) {

        	System.out.println();
        	choice=0;
       
          String x =readData.nextLine().trim();
choice=Integer.parseInt(x);

            switch (choice) {
                case 1:
                	Controller.addAStudent();
                    break;
                case 2:
                	Controller.addABook();
                    break;
                case 3:
                	Controller.displayAllStudents();
                    break;
                case 4:
                	Controller.displayAllBooks();
                    break;
                case 5:
                	 System.out.print("Enter the student id : ");
                     String studentId = readData.nextLine().trim();
                     Student s = Controller.searchStudent(studentId);
                     if (s != null) {
                         Controller.trackStudentForBooks(s);
                     } else {
                         System.out.print("please check the student id. ");
                     }
                     break;
                case 6:
                	Controller.howManyCopiesISAvalibleInLibrary();
                    break;
                case 7:
                    // checkOut();
                	Controller.checkOut();
                    break;
                case 8:
                    // checkIn();
                	Controller.checkIn();
                    break;
                case 9:
                    System.out.print("Enter the book's title or book's id : ");
                    String bTitleorId = readData.nextLine().trim();
                    Copies b = Controller.searchBook(bTitleorId);
                    if (b != null) {
                        System.out.print("Book  Found...details as shown below: \n");
                        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
                        System.out.printf("|%15s |%-25s|%15s|%20s|%8s|%11s|\n", "CourseNo", "Book ID", "Title", "Publisher", "Author", "Number of copies");
                        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
                        b.print();
                        System.out.println();
                        System.out.printf("|--------------------------------------------------------------------------------------------- ------|\n");
                    } else {
                        System.out.print("Book \"" + bTitleorId + "\" NOT Found ");
                    }
                    break;
                case 10:
                	  System.out.print("Enter the student id : ");
                      studentId = readData.nextLine().trim();
                      s = Controller.searchStudent(studentId);
                      if (s != null) {
                          System.out.print("Student  Found...details as shown below: \n");
                          System.out.printf("|--------------------------------|\n");
                          System.out.printf("|%10s|%10s|%10s|\n", "Student ID", "First Name", "Last Name");
                          System.out.printf("|--------------------------------|\n");
                          s.print();
                          System.out.println();
                          System.out.printf("|--------------------------------|\n");
                      } else {
                          System.out.print("Student NOT Found!! \n  ");
                          System.out.print("Do you want add this ID? :   \n ");
                          String question = readData.nextLine().trim();
                          if (question == "yes"){
                        	  System.out.print("Enter ID, First name, Last name :  \n ");
                        	  Controller.addAStudent();
                        	 
   
                         } 
                          Controller.addAStudent();
                          
                      }
                    break;
                
                
                
                
                
                
                
                
                
                case 11:
                	  readData.close();
                	Controller.exit();
                    break;
                default:
            }
            System.out.println();
            System.out.println();
            //readData.next();
            
       /* System.out.println("press Y to conitnue and N for Exit ");
        String ch=readData.nextLine();
        if (ch=="N")
        	break;
         */   Controller.displayMenu();
          
        }     
       
    }
    
}
