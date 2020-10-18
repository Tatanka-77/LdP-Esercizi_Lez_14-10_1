import java.util.* ;
/** Classe che implementa i metodi richiesti dagli esercizi della lezione del 14-10-20 parte 1 */
public class Esercizi {
	/**Questo metodo acquisisce nome e cognome e restituisce le iniziali in maiuscolo separate da &
	 * @return String iniziale del nome e iniziale del cognome in maiuscolo separate da & */ 
	static public String esercizio1 () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il nome e premi invio poi il cognome e premi invio");
		return scanner.nextLine().substring(0,1).toUpperCase() + "&" + scanner.nextLine().substring(0,1).toUpperCase();
	}
	/**Questo metodo acquisisce una stringa e la restituisce rovesciata
	 * @return String stringa acquisita rovesciata */
	static public String esercizio2 () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci la stringa che vuoi rovesciare");
		String stringa = scanner.nextLine();
		char arrayDiCaratteriRovesciato[] = new char[stringa.length()];
		for (int i=(stringa.length() - 1); i>=0; i--) arrayDiCaratteriRovesciato[i] = stringa.charAt(stringa.length() -1 - i);
		return (stringa = new String(arrayDiCaratteriRovesciato));
	}


	/**Metodo privato per passare il valore del contatore durante la ricerca del pattern 
	 * @param stringa String - Testo in cui effettuare la ricerca
	 * @param pattern String - Pattern da ricercare
	 * @param contatore int - Occorrenze già trovate 
	 * @return int Contatore aggiornato */
	static private int esercizio3 (String stringa, final String pattern,int contatore) {
		int i=stringa.indexOf(pattern); 
		if (i>=0) {
			if (stringa.length() >= pattern.length()) return esercizio3 (stringa.substring(i+1,stringa.length()), pattern, ++contatore);
			}
		return contatore;
	}

	/**Metodo per cercare un pattern in un testo
	 * @param stringa String - Testo in cui effettuare la ricerca
	 * @param pattern String - Pattern da ricercare
	 * @return int - Numero delle occorrenze trovate */
	static public int esercizio3 (String stringa, final String pattern) {
		return esercizio3(stringa, pattern, 0);
	}

	/**Metodo per verificare la correttezza formale di un indirizzo email senza utlizzo di espressioni regolari
	 * @param stringa String - Stringa da validare
	 * @return boolean ritorna vero se la stringa ricevuta rappresenta un indirizzo email formalmente corretto */
	static public boolean isValidEmail (String stringa) {
		boolean valido=false;
		String stringaDivisa[] = stringa.split("@");
		String tld[] = {".com",".it",".edu", ".gov", ".fr", ".de", ".net"};
		if ((stringaDivisa.length == 2) && (stringaDivisa[0].length() > 0) && (stringa.charAt(stringa.indexOf("@")+1) != '.')) {
			String s[] = stringaDivisa[1].split("\\.");
			if ((s.length > 1) && (!s[1].startsWith("\\.")));
				for (String suffisso : tld) {
					if (s[s.length - 1].length() >= (suffisso.length()-1)) {
						if (!valido) valido = stringaDivisa[1].endsWith(suffisso)?true:false;
						else break;
					}
				}
		}
		return valido;
	}

	/**Metodo per verificare la correttezza formale di un indirizzo email con l'utlizzo di espressioni regolari
	* @param stringa String - Stringa da validare
	* @return boolean ritorna vero se la stringa ricevuta rappresenta un indirizzo email formalmente corretto */
	static public boolean isValidEmailRegex (String stringa) {
		return stringa.matches("[\\w\\!#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^_\\`\\{\\|\\}\\~]([\\.\\w\\!#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^_\\`\\{\\|\\}~]?[\\w!#$\\%\\&\\'\\*\\+\\-\\/\\=?\\^_`\\{\\|\\}~]+)*@[\\w\\!#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^_\\`\\{\\|\\}\\~]([\\.\\w\\!#\\$\\%\\&\\'\\*\\+\\-\\/\\=\\?\\^_\\`\\{\\|\\}~]?[\\w!#$\\%\\&\\'\\*\\+\\-\\/\\=?\\^_`\\{\\|\\}~]+)*.(com|it|edu|gov|fr|de|net)");
	}

	/**Metodo che preso in input un intero restituisce la somma delle sue cifre 
	 * @param numero int - numero di cui saranno sommate le singole cifre
	 * @return int - somma delle cifre */
	static public int sommaCifre(int numero) {
		String stringa = String.valueOf(numero);
		int somma=0;
		for (int i=0;i<stringa.length();i++) somma+=Integer.parseInt(stringa.substring(i,i+1));
		return somma;
	}

	/** Metodo che controlla se una stringa e l'anagramma di un'altra
	 * @param stringa1 String Prima stringa da valutare
	 * @param stringa2 String Seconda stringa da validare
	 * @return boolean vero se string2 è anagramma di string1 altrimenri falso */
	static public boolean isAnagram(String stringa1, String stringa2) {
		if (stringa1.length() == stringa2.length()) {
			ArrayList<Character> caratteriStringa1 = new ArrayList<Character>();
			for (char carattere : stringa1.toCharArray()) caratteriStringa1.add(carattere);
			for (char carattere2 : stringa2.toCharArray()) caratteriStringa1.remove(Character.valueOf(carattere2));
			return caratteriStringa1.size()>0?false:true;
		}
		return false;
	}

	/**Metodo che riconosce una vocale 
	 * @param carattere char - carattere da esaminare
	 * @return boolean True se è una vocale False altrimenti */
	private static boolean isVocale(char carattere) {
		switch (carattere) {
			case 'a':
			case 'A':
			case 'e':
			case 'E':
			case 'i':
			case 'I':
			case 'o':
			case 'O':
			case 'u':
			case 'U':
				return true;
			default: 
				return false;
		}
	}

	/** Metodo che rimuove le vocali in una frase
	 * @param stringa String - stringa da modificare
	 * @return String - stringa modificata */
	static public String rimuoviVocali(String stringa) {
		ArrayList<Character> caratteri = new ArrayList<Character>();
		for (int i=0;i<stringa.length();i++)if (!Esercizi.isVocale(stringa.charAt(i))) caratteri.add(stringa.charAt(i));
		return caratteri.toString().replace("[","").replace("]","").replace(", ","");
	}

	/**Metodo che restituisce la rappresentazione unaria di un numero fornito in ingresso
	 * @param numero int - numero da convertire
	 * @return string - rappresentazione unaria del numero convertito */
	static public String rappresentazioneUnaria (int numero) {
		StringBuilder rapUnaria = new StringBuilder();
		for (int i=0; i<numero; i++) rapUnaria.append("0");
		return rapUnaria.toString();
	}

	/**Metodo che trasforma in maiuscolo l'iniziale di ogni parola di una stringa fornita in ingresso
	 * @param stringa String stringa da convertire
	 * @return String stringa modificata */
	public static String inizialeMaiuscolo (String stringa) {
		StringBuilder stringasb = new StringBuilder();
		String[] parole=stringa.split(" ");
		for (String parola : parole) stringasb.append(parola.substring(0,1).toUpperCase() + parola.substring(1)+" ");
		return stringasb.toString().trim();
	}	
	
	/**Metodo che genera le parola n-esima di Fibonacci con n fornito in input
	 * @param n int indice della serie
	 * @return String n-esimo termine della serie richiesto */
	private static ArrayList<String> pdf = new ArrayList<String>();
	public static String parolaDiFibonacci (int n) {
		if (pdf.size() > 0 && pdf.get(n-1).length() > 0) return pdf.get(n-1);
		else {
			StringBuilder sb = new StringBuilder();
			switch (n) {
				case 1: 
					pdf.add("B");
					return ("B");
				case 2: 
					pdf.add("B");
					pdf.add("A");
					return ("A");
				default: 
					pdf.add(sb.append(parolaDiFibonacci(n-1)).append(parolaDiFibonacci(n-2)).toString());
					return pdf.get(n-1);
			}
		}
	}

	/**Metodo che dati in input due interi a ed n restituisce una stringa casuale di n elementi presi da un alfabeto di cardinalità a
	 * @param a int Cardinalità dell'alfabeto
	 * @param n int Lunghezza della stringa generata
	 * @return String stringa richiesta */
	public static String stringaCasuale(int a, int n) {
		char[] alfabeto = new char[a];
		System.out.print("L'alfabeto di cardinalità "+ a + " dal quale sarà scelta la parola di lunghezza " + n + " è: ");  
		for (int i=0; i<a; i++) {
			alfabeto[i]=(char)(int)(21 + Math.random()*100);
			System.out.print (alfabeto[i] + " " );
		}
		System.out.println("");
		StringBuilder parola = new StringBuilder();
		for (int i=0; i<n; i++) parola.append(Character.toString(alfabeto[(int)(Math.random()*n)]));
		return(parola.toString());
	}
}
