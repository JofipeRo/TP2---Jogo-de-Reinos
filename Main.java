/** 
 * @author 53349 52794
 */
import java.util.Scanner;
public class Main {
	private static final String OPCAO_INEXISTENTE = "Opcao inexistente.";
	private static final String CAVALEIRO = "cavaleiro";
	private static final String LANCEIRO = "lanceiro";
	private static final String ESPADACHIM = "espadachim";
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
		case RECRUTA:
			recrutar(g1, s1);
			break;
		case SOLDADO:
			moverSoldado(g1,s1);
			break;
		default:
			System.out.println(OPCAO_INEXISTENTE);
			s1.nextLine();
			break;
		}
			
		}
	
	private static void moverSoldado(Game g1, Scanner s1) {
		int compare=-1;
		int xPos=s1.nextInt();
		int yPos=s1.nextInt();
		String move=null;
		int soldado=g1.saveWhichSoldado(xPos, yPos);
		if(soldado==-1) {
			System.out.println("Nao existe nenhum soldado ilustre da casa de " + g1.getTeamName() + " na posicao ("
					+ xPos  + "," + yPos + ").");
		}
		else {
			String type=g1.getReinoSoldadoType(xPos, yPos);
			if(type.equals(ESPADACHIM)||type.equals(LANCEIRO)) {
				move=s1.next();
				if(!g1.mapLimits(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), move)) {
					System.out.println("O " + type + " da ilustre casa de " + g1.getTeamName() + " e um cobardolas.");
				}
				else {
					if(g1.reinoSoldadoColision(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), soldado, move)) {
						System.out.println("O " + type + " da ilustre casa de " + g1.getTeamName() + 
								" devia tentar ir para outro sitio.");
					}
					else {
					g1.moveReinoSoldado(soldado, move);
					if(g1.enemyColision(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado))!=-1) {
						compare=g1.fightCompare(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado));
						System.out.println(g1.getMessageFromFight(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado)));
						g1.killSoldadoFrom(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), soldado);
					}
					if (compare==1) {
						System.out.println(g1.getTeamName() + " " + type + " morto");
					}
					else {
						if(g1.soldadoInCastelo(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), soldado)){
							int castelo=g1.getCastleInPos(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado));
							String owner=g1.findOwner(g1.getCastleName(castelo));
							if(!owner.equals(g1.getTeamName())) {
								System.out.println("O " + type + " da ilustre casa de " + g1.getTeamName() 
									+ " adquiriu um novo castelo " + g1.getCastleName(castelo) + " para o seu reino.");
								if(!owner.equals("sem dono")) {
									g1.removeCasteloFromReino(g1.getCastleName(castelo), owner);
								}
								Castelo c2=g1.getCasteloInIndex(castelo);
								g1.addCasteloToReino(c2);
							}
						}
					}
				}
			}
				if(compare!=1) {
					System.out.println(g1.getTeamName() + " " + type + " (" + g1.getReinoSoldadoXPos(soldado)+ ","
							+ g1.getReinoSoldadosYPos(soldado) + ")");
				}
				if(g1.isReinoDead()!=-1)
					g1.removeReino(g1.isReinoDead());
				if(g1.lastReino()) {
					System.out.println("Sou um heroi " + g1.getTeamName() + "! Vitoria gloriosa!");
					g1.closeGame();
				}
		}
			if(type.equals(CAVALEIRO)) {
				for(int movesLeft=3; movesLeft>0; movesLeft--) {
					compare=-1;
					move=s1.next();
					if(!g1.mapLimits(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), move)) {
						System.out.println("O cavaleiro da ilustre casa de " + g1.getTeamName() + " e um cobardolas.");
					}
					else {
						if(g1.reinoSoldadoColision(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), soldado, move)) {
							System.out.println("O cavaleiro da ilustre casa de " + g1.getTeamName() + 
									" devia tentar ir para outro sitio.");
						}
						else {
							g1.moveReinoSoldado(soldado, move);
							if(g1.enemyColision(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado))!=-1) {
								compare=g1.fightCompare(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado));
								if(g1.fightCompare(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado))==1)
									movesLeft-=3;
								System.out.println(g1.getMessageFromFight(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado)));
								g1.killSoldadoFrom(type, g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), soldado);
							}
							if (compare==1) {
								System.out.println(g1.getTeamName() + " " + type + " morto");
							}
							if(g1.soldadoInCastelo(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado), soldado)){
								int castelo=g1.getCastleInPos(g1.getReinoSoldadoXPos(soldado), g1.getReinoSoldadosYPos(soldado));
								String owner=g1.findOwner(g1.getCastleName(castelo));
								if(!owner.equals(g1.getTeamName())) {
								System.out.println("O " + type + " da ilustre casa de " + g1.getTeamName() 
									+ " adquiriu um novo castelo " + g1.getCastleName(castelo) + " para o seu reino.");
								if(!owner.equals("sem dono")) {
									g1.removeCasteloFromReino(g1.getCastleName(castelo), owner);
								}
								Castelo c2=g1.getCasteloInIndex(castelo);
								g1.addCasteloToReino(c2);
								}
							}
						}
					}
					if(compare!=1) {
						System.out.println(g1.getTeamName() + " " + type + " (" + g1.getReinoSoldadoXPos(soldado)+ ","
								+ g1.getReinoSoldadosYPos(soldado) + ")");
					}
					if(g1.isReinoDead()!=-1) {
						g1.removeReino(g1.isReinoDead());
					}
					if(g1.lastReino()) {
						System.out.println("Sou um heroi " + g1.getTeamName() + "! Vitoria gloriosa!");
						g1.closeGame();
						movesLeft-=3;
					}
					}
			}
			}
		s1.nextLine();
		g1.nextPlayer();
	}

	
	private static void recrutar(Game g1, Scanner s1) {
		if(!g1.isGameOn()) {
			System.out.println("Comando inactivo.");
			s1.nextLine();
		}
		else {
			String type = s1.next();
			type.toLowerCase();
			String castle = s1.nextLine().trim();
			if(!type.equals(ESPADACHIM) && !type.equals(LANCEIRO) && !type.equals(CAVALEIRO))
				System.out.println("Tipo de soldado inexistente.");
			else {
				if(!g1.reinoHasCastle(castle))
					System.out.println("Castelo invadido ilegalmente.");
				else {
					if(g1.isReinoCasteloOcupado(castle))
						System.out.println("Castelo nao livre.");
					else {
					switch(type) {
					case ESPADACHIM:
						if(g1.hasCastleEnoughMoney(castle, 2)) {
							g1.addSoldadoToReino(ESPADACHIM, castle);
							System.out.println(ESPADACHIM + " recrutado no " + castle + " do reino " + g1.getTeamName()
							   + " por 2 moedas.");
							}
						else {
							System.out.println("Riqueza insuficiente para recrutamento.");
						}
						break;
					case LANCEIRO:
						if(g1.hasCastleEnoughMoney(castle, 2)) {
							g1.addSoldadoToReino(LANCEIRO, castle);
							System.out.println(LANCEIRO + " recrutado no " + castle + " do reino " + g1.getTeamName()
							   + " por 2 moedas.");
						}
						else {
							System.out.println("Riqueza insuficiente para recrutamento.");
						}
						break;
					case CAVALEIRO:
						if(g1.hasCastleEnoughMoney(castle, 4)) {
							g1.addSoldadoToReino(CAVALEIRO, castle);
							System.out.println(CAVALEIRO + " recrutado no " + castle + " do reino " + g1.getTeamName()
							   + " por 4 moedas.");
						}
						else {
							System.out.println("Riqueza insuficiente para recrutamento.");
						}
						break;
					}
					}
			
			}
		}
		g1.nextPlayer();
	}
	}
	
	private static void printCastelos(Game g1) {
		if(!g1.isGameOn()) {
			System.out.println("Comando inactivo.");
		}
		else {
			if(g1.getNCastlesByReino(g1.getPlayer())==0) {
				System.out.println("Sem castelos.");
			}
			else {
			System.out.println(g1.getNCastlesByReino(g1.getPlayer()) + " castelos:");
			for(int i=0; i<g1.getNCastlesByReino(g1.getPlayer()); i++) {
				System.out.println(g1.getCastelosNameByReino(i) + " com riqueza " + g1.getCastelosTreasureByReino(i)
				+ " na posicao " + g1.getCastelosPositionByReino(i));}
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
			else {
				System.out.println(g1.getNSoldados(g1.getPlayer()) + " soldados:");
				for(int i=0;i<g1.getNSoldados(g1.getPlayer());i++) {
					System.out.println(g1.printReinoSoldadoInfo(i, g1.getPlayer()));
				}
			}
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
		g1.closeGame();
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
							if(g1.castleInSamePos(xC, yC))
								System.out.println("Castelo em posicao invalida.");
							else {
								if(g1.castleNameFound(CastleName))
									System.out.println("Os castelos nao podem ter nomes duplicados.");
								else {
									if(castleTreasure>0) {
										c2 = new Castelo(CastleName, castleTreasure, xC, yC);
										g1.addCastles(c2);
									}
									else {
										System.out.println("Castelo com riqueza invalida.");
								}
							}
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