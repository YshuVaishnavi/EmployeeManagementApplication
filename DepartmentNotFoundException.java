package exception;

public class DepartmentNotFoundException extends Exception {
	public DepartmentNotFoundException()
	{
		super("DEP Not Found");
	}

	public DepartmentNotFoundException(String message) //--exception
	{
		super(message);
	}
 
}
