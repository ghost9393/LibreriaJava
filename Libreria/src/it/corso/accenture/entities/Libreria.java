package it.corso.accenture.entities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;


public class Libreria {

	static HashSet<Libro> libreria = new HashSet<Libro>();
	static String filepath = "C:\\Users\\ignaa\\Desktop\\libreria.txt";
	static ObjectOutputStream objectOutput;
	static ObjectInputStream objectInput;

	//Inserisco libri in libreria
	public boolean inserisciLibro(String titoloLibro, String autoreLibro, double prezzoLibro, String dataUscita) {
		Libro libro = new Libro(titoloLibro, autoreLibro, prezzoLibro, dataUscita);
		libreria.add(libro);
		return true;
	}

	//Stampo a video l'elenco dei libri
	public void stampaLibri() {
		for (Libro libro : libreria) {
			System.out.println(libro.toString());
		}
	}


	//Elimino libro dalla libreria
	public void eliminaLibro(String titoloString) {
		for (Libro libro : libreria) {
			if(libro.getTitoloString() == titoloString) {
				libreria.remove(libro);
				System.out.println(titoloString + " è stato eliminato!");
				break; //DANNATO
			}
		}
	}


	//Stampa a video i libri con l'anno inserito dall'utente
	public void libroAnno(int anno) throws ParseException {
		String data = "";
		for (Libro libro : libreria) {
			data = libro.getData();
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			if(calendar.get(Calendar.YEAR) == anno) {
				System.out.println(libro.toString());
			}
		}

	}


	//Stampa a video la differenza di anni tra 2 libri
	@SuppressWarnings("deprecation")
	public void differenzaAnno(String titolo1, String titolo2) throws ParseException {
		String sDate1 = "";  
		String sDate2= "";

		for (Libro libro : libreria) {
			if(libro.getTitoloString() == titolo1) {
				sDate1 = libro.getData();
			}
		}
		for (Libro libro : libreria) {
			if(libro.getTitoloString() == titolo2) {
				sDate2 = libro.getData();
			}
		}

		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
		Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);  
		System.out.println(date1.getYear()-date2.getYear()); 
	}


	//Metodo che mi permette di scrivere gli oggetti su file
	public static void writeToFile() throws IOException {
		objectOutput = new ObjectOutputStream(new FileOutputStream(filepath));
		objectOutput.writeObject(libreria);
		objectOutput.close();
	}

	
	//Metodo che mi permettere di leggere i dati da file
	public static void readFile() throws IOException, ClassNotFoundException {

		try {
			objectInput = new ObjectInputStream(new FileInputStream(filepath));
		} catch (Exception e) {
			System.out.println("Nessun contatto ancora memorizzato");
		}

		if(objectInput != null) {
			@SuppressWarnings("unchecked")
			HashSet<Libro> inputList = (HashSet<Libro>) objectInput.readObject();
			System.out.println("\nELENCO LIBRI");
			
			for (Libro book : inputList) {
				Libro libro = (Libro) book;
				System.out.println(libro.toString());
			}
			objectInput.close();
		}

	}
	
	
	
}
