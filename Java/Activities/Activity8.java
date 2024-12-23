package javapractice;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Activity8.exceptionTest("Will print to console");
			Activity8.exceptionTest("shanmu");
			Activity8.exceptionTest("Won't execute");
		} catch (CustomException e) {
			// TODO: handle exception
			System.out.println("Inside Catch block:" +e.getMessage());
		}
	}	
	static void exceptionTest(String text) throws CustomException{
		if(text==null) {
			throw new CustomException("String is null");
		}
		else {
			System.out.println(text);
		}
	}
}

