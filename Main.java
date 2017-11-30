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
		Condicoes cond= new Condicoes();
		g1.inicializeInteratiorPlayer();
		while (!command.equals(SAI)) {
			if (!g1.isGameOn() || g1==null) {
				System.out.print("> ");
			} else {
				System.out.print(g1.getTeamName() + " > ");
				g1.nextPlayer();
				}
			command = readCommand(s1);
			executeCommand(command,s1, g1, cond);
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
	private static void executeCommand(String command, Scanner s1, Game g1, Condicoes cond) {
		switch(command) {
		case AJUDA:
			System.out.println("novo - Novo jogo");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai - Termina a execucao do programa");
		case NOVO_JOGO:
			g1.closeGame();
			int x = s1.nextInt();
			int y = s1.nextInt();
			int nReinos = s1.nextInt();
			int nCastles = s1.nextInt();
			s1.nextLine();
			Castelos c2=null;
			Reinos r2=null;
			String CastleName;
			int castleTreasure;
			int xC;
			int yC;
			String reinoName;
			String castle;
			int totalTreasure=0;
			Castelos[] c1=null;
			Reinos[] r1=null;
			 g1 = new Game(x, y, nReinos, nCastles, c1, r1);
			 if(!cond.mapSize(g1))
				 System.out.println("Mapa pequeno demais para o jogo.");
			 if(cond.mapSize(g1) && !cond.numberReinos(g1))
				 System.out.println("Numero de reinos invalido.");
			 if(cond.mapSize(g1) && cond.numberReinos(g1) && !cond.numberCastles(g1))
				 System.out.println("Numero de castelos invalido.");
			 if(cond.mapSize(g1) && cond.numberReinos(g1) && cond.numberCastles(g1)) {
			 while(g1.hasNextCastles()) {
				xC = s1.nextInt();
				yC = s1.nextInt();
				castleTreasure = s1.nextInt();
				CastleName=s1.nextLine();
				g1.addCastles(c2, CastleName, castleTreasure, xC, yC);
				if(!cond.goodCastlesCordinates(g1, c1)) {
					System.out.println("Castelo em posicao invalida.");
					g1.removeCastles();
				}
				if(cond.goodCastlesCordinates(g1, c1) && !cond.goodCastlesTreasure(g1, c1)) {
					System.out.println("Castelo com riqueza invalida.");
					g1.removeCastles();
				}
			 }
			 while(g1.hasNextReinos()) {
				 reinoName=s1.next();
				 castle=s1.nextLine();
				 g1.addReinos(r2, reinoName, castle, totalTreasure);
			 }
			 }
			 g1.startGame();
		}
	}
	
		
}
