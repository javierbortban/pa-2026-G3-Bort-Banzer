package pa;
/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
public class Book {
    private String author;
    private String title;
    private int numPag;
    private String codRef;
    private int numPrestado;
    
    public Book(String bookAuthor, String bookTitle,int numPag) {
        author = bookAuthor;
        title = bookTitle;
        this.numPag=numPag;
        this.codRef="";
        this.numPrestado =0;
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCodRef() {
		return codRef;
	}

	public void setRefNumber(String ref) {
		if(ref.length() >= 3) {
			ref=codRef;
		}
		else {
			System.out.println("ERROR: El número de referencia del libro "+ title +" debe contener al menos tres caracteres");
			
		}
	}

	public int getNumPrestado() {
		return numPrestado;
	}

	public void prestar() {
		numPrestado++;
	}
	
    public void mostrarVecesPrestado() {
    	if (numPrestado==1) {
    		System.out.println("El libro "+ title + " se ha prestado 1 vez");
    	}
    	else if (numPrestado>1){
    		System.out.println("El libro "+ title + " se ha prestado " + numPrestado +" veces" );
    	}
    	else {
    		System.out.println("El libro "+ title + " no se ha prestado ninguna vez");
    	}
    }
    
	public void printDetails() {
		System.out.println("Detalles de "+ title);
		System.out.println("\t-- Author: "+ author);
		System.out.println("\t-- Título: "+ title);
		System.out.println("\t-- Nº páginas: "+ numPag);
		System.out.println("\t-- Nº referencia: "+ (codRef.length() == 0 ? "ZZZ": codRef));
		System.out.println("\t-- Nº préstamos: "+ numPrestado);
	}
    
}
