public class Esercizio7 {
	public static void main(String args[]) {
		System.out.print("La stringa: " + args[0] + " e la stringa: " + args[1] + " ");
		System.out.print(Esercizi.isAnagram(args[0], args[1])?"sono":"non sono");
		System.out.println(" anagrammi");
	}
}


