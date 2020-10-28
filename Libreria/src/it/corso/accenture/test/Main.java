package it.corso.accenture.test;

import java.io.IOException;
import java.text.ParseException;

import it.corso.accenture.entities.Libreria;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
		Libreria libreria = new Libreria();
		
		
		//Anno di uscita in questo formato -> dd/MM/yyyy
		libreria.inserisciLibro("I promessi sposi", "Manzoni", 5.99, "12/05/2002");
		libreria.inserisciLibro("Il Decamerone", "Boccaccio", 8.99, "02/05/1997");
		libreria.inserisciLibro("La coscienza di Zeno", "Svevo", 10.99, "01/10/1993");
		libreria.inserisciLibro("La divina Commedia", "Dante Alighieri", 4.99, "08/09/1997");
		
		
		libreria.writeToFile();	
		libreria.readFile();
		
		System.out.println("\nLa differenza di anno tra i 2 libri: ");
		libreria.differenzaAnno("I promessi sposi", "La coscienza di Zeno");
		
		System.out.println("\nI libri usciti nel seguente anno: ");
		libreria.libroAnno(1997);
		
		System.out.println("\n--------------------");
		libreria.eliminaLibro("La divina Commedia");
		libreria.writeToFile();	
		libreria.readFile();
		

	}

}
