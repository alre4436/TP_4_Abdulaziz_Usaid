
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String studentId;
    private String firstName;
    private String lastName;
    private int noOfBooks;
    static ArrayList<Copies> books;
    
    public Student() {

    }

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = new ArrayList<>();
    }

    /** Getters and Setters **/
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void print() {
        System.out.printf("|%10s|%10s|%10s|", studentId, firstName, lastName);
    }

    public boolean checkIn(Copies b) {
        
        if (!exists(b)) {
            books.add(b);
            return true;
        }else{
            System.out.println("A copy of this book exists with the student id. ");
        }
        return false;
    }

    private boolean exists(Copies b) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(b.getBookId()) || books.get(i).getTitle().equals(b.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public int getNoOfBooks() {
        return books.size();
    }
    

    public static void displayAllBooksForACourse(String cno) {
        System.out.printf("|---------------------------------------------------------------------------------------- -----------|\n");
        System.out.printf("|%15s |%-25s|%15s|%20s|%8s|%11s|\n", "Book ID", "Title", "Publisher", "Author", "CourseNo", "# of copies");
        System.out.printf("|----------------------------------------------------------------------------------------- ----------|\n");
        for (Copies b : books) {
            if (b.getCourseNo().equals(cno)) {
                b.print();
               // System.out.println();
            }
        }
        System.out.printf("|------------------------------------------------------------------------------------------ ---------|\n");
    }

    public void checkOut(Copies b) {
        for (int i = 0; i < books.size(); i++) {
            
        	if (books.get(i).getBookId().equals(b.getBookId()) || books.get(i).getTitle().equals(b.getTitle())) {
                books.remove(b);
            
                break;
            }
        }
        //--------------------------
        /*if (status == false) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle() == b.getTitle()) {
                    books.remove(b);
                    break;
                }
            }
        }*/
        //----------------------------------------------------
        noOfBooks--;
    }    
    
    public static Copies searchBook(String bTitleorId) {

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(bTitleorId) || books.get(i).getTitle().equals(bTitleorId)) {
                return books.get(i);
            }
        }
        return null;
    }

    public static Student searchStudent(String studentId) {
    	   ArrayList<Copies> books = new ArrayList<>();
    	   ArrayList<Student> students = new ArrayList<>();
    	   
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                return students.get(i);
            }
        }
        return null;
    }

    public ArrayList<Copies> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Copies> books) {
        this.books = books;
    }

}
