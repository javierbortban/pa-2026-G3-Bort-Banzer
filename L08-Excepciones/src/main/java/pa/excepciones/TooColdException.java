package pa.excepciones;

public class TooColdException extends Exception{
	public TooColdException(){
		super();
	}
	public TooColdException(String message) {
		super(message);
	}

}
