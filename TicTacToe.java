import java.util.Scanner;

/**
 *
 * @author Mansur Ismailov 
 *
 */

public class TicTacToe {
	
	private char[][] field;
	private char player;
	
	/**
		Erstellen des Tic-Tac-Toe Spieles mit
		einem Char-Array der Groesse 5x5.
	*/
	
	public TicTacToe() {
		field = new char[5][5];
		player = 'X';
		createField();
	}
	
	/**
		Methode die "leere" Felder fuer
		das Spielfeld erzeugt.
	*/
	
	public void createField() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				field[i][j] = ' ';
			}
		}
	}
	
	/** 
		Methode die das Spielfeld erzeugt mit den Abgrenzungen.
	*/
	public void printField() {
		System.out.println("-----------");
		for (int i = 0; i < 5; i++) {
			System.out.print("|");
			for (int j = 0; j < 5; j++) {
				System.out.print(field[i][j] + "|");
			}
			
			System.out.println();
			System.out.println("-----------");
		}
	}
	
	/**
		Methode die ueberprueft ob das Feld voll ist.
		@return Feld ist voll
	*/	
	public boolean fieldFull() {
		boolean full = true;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (field[i][j] == ' ') {
					full = false;
				}
			}
		}
		return full;
	}
	
	/** 
		Methode die jeweils den Spielerzug wechselt.
	*/
	public void playerTurn() {
		if (player == 'X') {
			System.out.println("Spieler O ist am Zug:");
			player = 'O';
		} else {
			player = 'X';
			System.out.println("Spieler X ist am Zug:");
		}
	}
	
	/**
		Methode die eine Markierung auf das Feld setzt.
		@param i fuer Zeile
		@param j fuer Spalte
		@return Spieler X bzw. Spieler O
	*/
	public boolean placePlayer(int i, int j) {
		if ((i >= 0) && (i < 5)) {
			if ((j >= 0) && (j < 5)) {
				if (field[i][j] == ' ') {
					field[i][j] = player;
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TicTacToe t = new TicTacToe();
		t.createField();
		System.out.println("Spieler X beginnt:");
		do {
			t.printField();
			int i;
			int j;
			do {
				System.out.println("Bitte die Koordinate (Reihe und Spalte, jeweils 0-4 mit Leerzeichen) eingeben:");
				i = input.nextInt();
				j = input.nextInt();
			}
			while (!t.placePlayer(i, j));
			t.playerTurn();
		}
		while (!t.fieldFull());
	}
}