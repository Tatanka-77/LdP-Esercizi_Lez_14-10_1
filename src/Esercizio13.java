public class Esercizio13 {
	public static void main(String args[]) {
		int[] numeri = new int[args.length];
		for (int i=0; i < args.length; i++) numeri[i] = Integer.parseInt(args[i]);
		Esercizi.stampaArray(numeri);
	}
}
