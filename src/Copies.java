import java.util.Date;

public class Copies {

	/** Each student has maximum number of books **/
	final private int NO_OF_COPIES = 8;

	private String bookId;
	private String title;
	private String publisher;
	private double price;
	private int noOfCopyAvalible;
	private String author;
	private boolean avaliblity;
	private String courseNo;
    private Date duedate; 
	Copies(String courseNo,String bookId, String title, String publisher, String author,double price ) {
		this.courseNo = courseNo;
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.avaliblity = true;
		noOfCopyAvalible = NO_OF_COPIES;
		duedate=null;
	}
	public void setduedate(Date d)
	{
		duedate=d;
	}
	public Date getduedate()
	{
		return duedate;
	}
	
	public void removeduedate()
	{
		duedate=null;
	}
	public String getCourseNo() {
		return courseNo;
	}

	public void setavailablecopy()
	{
		noOfCopyAvalible =noOfCopyAvalible - 1;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	

	public Copies() {

	}

	/** Getters and Setters **/
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getNoOfCopyAvalible() {
		return noOfCopyAvalible;
	}

	public void setNoOfCopyAvalible(int noOfCopyAvalible) {
		this.noOfCopyAvalible = noOfCopyAvalible;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isAvaliblity() {
		return noOfCopyAvalible > 0 & noOfCopyAvalible <= 8;
	}

	public void setAvaliblity(boolean avaliblity) {
		this.avaliblity = avaliblity;
	}

	

	/** Display Book information **/
	public void print() {
		System.out.printf("|%15s |%-25s|%15s|%20s|%8s|%11d|",courseNo, bookId, title, publisher, author, 
				noOfCopyAvalible);
	}

	public void printStudentView() {
		System.out.printf("|%15s |%-25s|%15s|%20s|%8s|",bookId, title, publisher, author, courseNo);
	}
}
