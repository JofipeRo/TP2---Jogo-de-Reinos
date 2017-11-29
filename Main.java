/** 
 * @author 53349 52794
 */
import java.util.Scanner;
public class Main {
	private static final String NOVO_JOGO = "novo";
	private static final String AJUDA = "ajuda";
	private static final String SAI = "sai";
	private static final String MAPA = "mapa";
	private static final String CASTELOS = "castelos";
	private static final String EXERCITO = "exercito";
	private static final String REINOS = "reinos";
	private static final String RECRUTA = "recruta";
	private static final String SOLDADO = "soldado";
	
	public static void main(String[] args) {
		Scanner s1= new Scanner(System.in);
		String command = readCommand(s1);
		printMenu();
		Game g1 = null;
		int i = 0;
		while (!command.equals(SAI)) {
			if (!g1.isGameOn()) {
				System.out.print("> ");
			} else {
				System.out.print(g1.getTeamName(i) + " > ");
				i++;
				if(!g1.hasNextPlayer(i))
					i=0;
				}
			command = readCommand(s1);
			executeCommand(command,s1);
		}
		s1.close();
		System.out.println("Obrigado por jogar. Ate a proxima.");
		
	}
	private static String readCommand(Scanner s1) {
		String command = s1.next();
		return command = command.toLowerCase();
	}
	private static void printMenu() {
		System.out.println("novo - Novo jogo");
		System.out.println("ajuda - Mostra a ajuda");
		System.out.println("sai - Termina a execucao do programa");
	}
	private static void executeCommand(String command, Scanner s1) {
		switch(command) {
		case AJUDA:
			System.out.println("novo - Novo jogo");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai - Termina a execucao do programa");
		}
	}
	
		
}
