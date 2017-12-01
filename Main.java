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
	private static final String ERRO_FATAL = "Erro fatal, jogo nao inicializado.";
	
	public static void main(String[] args) {
		Scanner s1= new Scanner(System.in);
		String command = readCommand(s1);
		printMenu();
		Game g1 = null;
		Castelos[] c1 = null;
		Reinos[] r1 = null;
		Condicoes cond= new Condicoes();
		g1.inicializeInteratiorPlayer();
		while (!command.equals(SAI)) {
			if (!g1.isGameOn() || g1==null) {
				System.out.print("> ");
			} else {
				System.out.print(g1.getTeamName() + " > ");
				}
			command = readCommand(s1);
			executeCommand(command,s1, g1, cond, c1, r1);
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
	private static void executeCommand(String command, Scanner s1, Game g1, Condicoes cond, Castelos[] c1, Reinos[] r1) {
		switch(command) {
		case AJUDA:
			if(!g1.isGameOn())
			System.out.println("novo - Novo jogo");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai - Termina a execucao do programa");
			break;
		case NOVO_JOGO:
			createGame(command, s1, g1, cond);
			break;
		case MAPA:
			if(!g1.isGameOn())
				System.out.println("Comando inactivo.");
			else {
				System.out.println(g1.getXMap() + " " + g1.getYMap());
				System.out.println((g1.getCounterCastles()+1) + " castelos:");
				for(int i=0; i<g1.getCounterCastles(); i++) {
					System.out.println(c1[i].getName() + " (" + c1[i].getOwner() + ")");
				}
				System.out.println((g1.getCounterReinos()+1) + " reinos:");
				for(int i=0; i<g1.getCounterCastles(); i++) {
					System.out.print(r1[i].getReinoName());
					if(i+1 < g1.getCounterReinos())
						System.out.print("; ");
				}
				s1.nextLine();
			}
			break;
		case CASTELOS:
			System.out.println(r1[g1.getPlayer()].getNCastles() + " castelos:");
			for(int i=0;i<r1[g1.getPlayer()].getNCastles();i++) {
				
			}
		}
			
	}
	
	
	
	
	
	
	private static void createGame(String command, Scanner s1, Game g1, Condicoes cond) {
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
		 if(!cond.mapSize(g1)) {
			 System.out.println("Mapa pequeno demais para o jogo.");
			 System.out.println(ERRO_FATAL);}
		 if(cond.mapSize(g1) && !cond.numberReinos(g1)) {
			 System.out.println("Numero de reinos invalido.");
			 System.out.println(ERRO_FATAL);}
		 if(cond.mapSize(g1) && cond.numberReinos(g1) && !cond.numberCastles(g1)) {
			 System.out.println("Numero de castelos invalido.");
			 System.out.println(ERRO_FATAL);}
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
			else { if(!cond.goodCastlesTreasure(g1, c1)) {
				System.out.println("Castelo com riqueza invalida.");
				g1.removeCastles();
				}
			else { if(cond.lookForCastleName(c1, g1, CastleName)) {
				System.out.println("Os castelos nao podem ter nomes duplicados.");
				g1.removeCastles();
				}	
			}
			}
		 }
		 if(g1.getCounterCastles()+1<g1.getNReino()) {
			 System.out.println("Numero insuficiente de castelos criados.");
			 System.out.println(ERRO_FATAL);}
		 else {
		 while(g1.hasNextReinos()) {
			 reinoName=s1.next();
			 castle=s1.nextLine();
			 g1.addReinos(r2, reinoName, castle, totalTreasure);
			 if(cond.lookForReinoName(r1, g1, reinoName)) {
				g1.removerReinos();
				System.out.println("Os reinos nao podem ter nomes duplicados.");
			 }
			 else { 
				 if(cond.castlesAlreadyTaken(r1, c1, g1, castle)==-1) {
					 g1.removerReinos();
					 System.out.println("Castelo nao existe.");
			 }
				 if(cond.castlesAlreadyTaken(r1, c1, g1, castle)==-2) {
					 g1.removerReinos();
					 System.out.println("Castelo ja ocupado.");
				 }
			 }
		 }
		 if(g1.getCounterReinos()+1<2) {
			 System.out.println("Numero insuficiente de reinos criados.");
			 System.out.println(ERRO_FATAL);}
		 else {
			 g1.startGame();
			 System.out.println("Jogo iniciado, comeca o reino " + g1.getTeamName());
		 }
		 }
		 }
	}
		
}
