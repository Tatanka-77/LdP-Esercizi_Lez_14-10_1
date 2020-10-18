import java.util.*;
public class Esercizio8 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println ("Inserisci la frase a cui vuoi togliere le vocali: ");	
		System.out.println("La frase senza vocali è: " + Esercizi.rimuoviVocali(input.nextLine()));
	}
}


