package javapractice;

public class CustomException extends Exception{
	private String message= "Shanmu";
	
	public CustomException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
