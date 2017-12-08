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
	private static final int DEFAULT_SIZE = 100;
	public static void main(String[] args) {
		Game g1= new Game();
		printMenu();
		System.out.print("> ");
		Scanner s1= new Scanner(System.in);
		String command = readCommand(s1);
		while (!command.equals(SAI)) {
			executeCommand(command,s1, g1);
			writePrompt(g1);
			command = readCommand(s1);
		}
		s1.close();
		System.out.println("Obrigado por jogar. Ate a proxima.");
		
	}
	private static String readCommand(Scanner s1) {
		String command = s1.next();
		return command = command.toLowerCase();
	}
	
	private static void writePrompt(Game g1) {
			if(g1.isGameOn())
			System.out.print(g1.getTeamName() + " > ");
			else {
				System.out.print("> ");
			}
	}
	
	private static void printMenu() {
		System.out.println("novo - Novo jogo");
		System.out.println("ajuda - Mostra a ajuda");
		System.out.println("sai - Termina a execucao do programa");
	}
	private static void executeCommand(String command, Scanner s1,Game g1) {
		switch(command) {
		case AJUDA:
			printAjuda(g1);
			break;
		case NOVO_JOGO:
			createGame(command, s1,g1);
			break;
		case MAPA:
			printMap(s1, g1);
			break;
		case CASTELOS:
			printCastelos(g1);
			break;
		case EXERCITO:
			printExercito(g1);
			break;
		case REINOS:
			printReinos(g1);
			break;
		default:
			System.out.println("Opcao inexistente.");
			s1.nextLine();
			break;
		}
			
		}

	
	private static void printCastelos(Game g1) {
		if(!g1.isGameOn()) {
			System.out.println("Comando inactivo.");
		}
		else {
			System.out.println(g1.getNCastlesByReino(g1.getPlayer()) + " castelos:");
			for(int i=0; i<g1.getNCastlesByReino(g1.getPlayer()); i++) {
				System.out.println(g1.getCastelosNameByReino(i) + " com riqueza " + g1.getCastelosTreasureByReino(i)
				+ " na posicao " + g1.getCastelosPositionByReino(i));
			}
		}
	}
	
	private static void printMap(Scanner s1, Game g1) {
		if(!g1.isGameOn())
			System.out.println("Comando inactivo.");
		else {
			System.out.println(g1.getXMap() + " " + g1.getYMap());
			System.out.println((g1.getCounterCastelos()) + " castelos:");
			for(int i=0; i<g1.getCounterCastelos(); i++) {
				System.out.println(g1.getCastleName(i) + " (" + g1.findOwner(g1.getCastleName(i)) + ")");
			}
			System.out.println((g1.getCounterReinos()) + " reinos:");
			for(int i=0; i<g1.getCounterReinos(); i++) {
				System.out.print(g1.getReinosName(i));
				if(i+1 < g1.getCounterReinos())
					System.out.print("; ");
				else {
					System.out.println();
				}
			}
			s1.nextLine();
		}
	}
	
	private static void printAjuda(Game g1) {
		if(!g1.isGameOn())
			printMenu();
		else {
			System.out.println("novo - Novo jogo");
			System.out.println("soldado - Move o soldado");
			System.out.println("recruta - Recruta um soldado num castelo");
			System.out.println("mapa - Lista todos os castelos do mapa, incluindo os abandonados, pela ordem de criacao no jogo"
					+ " e todos os reinos ainda em jogo, pela ordem de jogada");
			System.out.println("castelos - Lista os castelos do jogador activo, pela ordem pela qual foram conquistados");
			System.out.println("exercito - Lista os soldados vivos do jogador activo, pela ordem de recrutamento");
			System.out.println("reinos - Lista os varios reinos ainda em jogo, ordenados por nome do reino");
			System.out.println("ajuda - Mostra a ajuda");
			System.out.println("sai - Termina a execucao do programa");
		}
	}
	
	private static void printExercito(Game g1) {
		if(!g1.isGameOn())
			System.out.println("Comando inactivo.");
		else {
			if(g1.getNSoldados(g1.getPlayer())==0)
				System.out.println("Sem exercito.");
		}
	}
	
	private static void printReinos(Game g1) {
		if(!g1.isGameOn())
			System.out.println("Comando inactivo.");
		else {
			System.out.println(g1.getCounterReinos() + " reinos:");
			for(int i=0; i<g1.getCounterReinos();i++) {
				System.out.println(g1.getReinoInfo(i));
			}
		}
	}
	private static void createGame(String command, Scanner s1, Game g1) {
		g1.closeGame(g1);
		Castelo c2=null;
		Reino r2=null;
		String CastleName;
		int castleTreasure;
		int xC;
		int yC;
		String reinoName;
		String castle;
		int x = s1.nextInt();
		int y = s1.nextInt();
		int nReinos = s1.nextInt();
		int nCastles = s1.nextInt();
		s1.nextLine();
		g1.createGame(x, y, nReinos, nCastles);
		if(!g1.mapSize()) {
			System.out.println("Mapa pequeno demais para o jogo.");
			System.out.println(ERRO_FATAL);
		}
		else {
			if(nReinos<2 || nReinos>8) {
				System.out.println("Numero de reinos invalido.");
				System.out.println(ERRO_FATAL);
			}
			else {
				if(nCastles<nReinos || nCastles> (x*y)) {
					System.out.println("Numero de castelos invalido.");
					System.out.println(ERRO_FATAL);
				}
				else {
					System.out.println(nCastles + " castelos:");
					for(int i=0; i<nCastles; i++) {
						xC = s1.nextInt();
						yC = s1.nextInt();
						castleTreasure = s1.nextInt();
						CastleName=s1.nextLine().trim();
						if(xC>0 && xC<=x && yC>0 && yC<=y) {
							if(castleTreasure>0) {
								c2 = new Castelo(CastleName, castleTreasure, xC, yC);
								g1.addCastles(c2);
							}
							else {
								System.out.println("Castelo com riqueza invalida.");
							}
							}
						else {
							System.out.println("Castelo em posicao invalida.");
						}
						}
					if(g1.getCounterCastelos()<nReinos) {
						System.out.println("Numero insuficiente de castelos criados.");
						System.out.println(ERRO_FATAL);
					}
					else {
						System.out.println(nReinos + " reinos:");
						for(int j=0;j<nReinos;j++ ) {
							reinoName=s1.next();
							castle=s1.nextLine().trim();
							if(g1.reinoNameFound(reinoName)) {
								System.out.println("Os reinos nao podem ter nomes duplicados.");
							}
							else {
								if(!g1.castleNameFound(castle)) {
									System.out.println("Castelo nao existe.");
								}
								else {
									if(!g1.findOwner(castle).equals("sem dono")) {
										System.out.println("Castelo ja ocupado.");
									}
									else {
										r2 = new Reino(reinoName, nCastles);
										g1.addReinos(r2, reinoName, castle, c2);
									}
							}
						}
						}
						if(g1.getCounterReinos()<2) {
							System.out.println("Numero insuficiente de reinos criados.");
							System.out.println(ERRO_FATAL);
						}
						else {				
							g1.inicializeInteratiorPlayer();
							g1.startGame();
							System.out.println("Jogo iniciado, comeca o reino " + g1.getTeamName() + ".");
						}
	}
	}
	}
	}
	}
 }
		

