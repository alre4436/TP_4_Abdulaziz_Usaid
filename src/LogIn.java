
import java.util.InputMismatchException;
import java.util.Scanner; // I use scanner because it's command line.

public class LogIn {
	
	Scanner input = new Scanner(System.in);
	String user;
	int passIt;
	
public void run()  {
	System.out.println("you can Only have 4 tries to enter the system \n");
	for( int i =0; i<=3;++i){
    	Scanner input = new Scanner(System.in);
    	String user;
    	int put;
    	try{
    	System.out.println("Enter your user name");
    	user = input.nextLine();
    	System.out.println("Enter your user password");
    	put = input.nextInt();
    	if(user.equals("aziz")&& (put == 12345)){
    		System.out.println("Welcome to textbook rental library App  \n");
    		break;
    	}
    	
    	System.out.println("Wrong password or user name/n");
    	if (i==2){
        System.out.println(" Sorry, you have exceed the number of tries");
         System.exit(0);
    	
    	}
    	}
    	catch (InputMismatchException e){
    		System.out.println("Please enter integer value for the password");
    	}
    	}
    
}
} 