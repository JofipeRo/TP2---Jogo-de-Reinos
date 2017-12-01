
public class Game {
	private boolean gameOn=false;
	private int numberReinos;
	private int numberCastles;
	private int counterCastles;
	private int counterReinos;
	private int xMap;
	private int yMap;
	private int currentPlayer;
	private int currentCastle;
	private int currentReino;
	public Reinos[] r1;
	public Castelos[] c1;
	public boolean isGameOn() {
		return gameOn;
	}
	public Game(int x, int y, int nReinos, int nCastles, Castelos[] c1, Reinos[] r1) {
		xMap=x;
		yMap=y;
		numberReinos=nReinos;
		numberCastles=nCastles;
		r1= new Reinos[numberReinos];
		c1= new Castelos[numberCastles];
		counterCastles = 0;
		counterReinos = 0;
	}
	public int getNReino() {
		return numberReinos;
	}
	public int getNCastles() {
		return numberCastles;
	}
	public void addCastles(Castelos c2, String name, int treasure, int x, int y) {
		c2 = new Castelos(name, treasure, x, y);
		c1[counterCastles++]=c2;
		currentCastle++;
	}
	public int getCounterCastles() {
		return counterCastles;
	}
	public int getCounterReinos() {
		return counterReinos;
	}
	// Duvida sobre o remove castles: se e possivel que o jogo nao inicialize devido a falta de castelos inicializados,
	// talvez o while do main tenha de funcionar de forma diferente para que que seja feito apenas nCastles vezes mesmo dando erro
	// perguntar ao stor segunda (mesma duvida para os reinos)
	public void removeCastles() {
		counterCastles--;
	}
	public boolean hasNextCastles() {
		return currentCastle < numberCastles;
	}
	public void addReinos (Reinos r2, String name, String castle, int treasure) {
		if(choseCastle(castle, c1)!=-1) {
			treasure=c1[choseCastle(castle,c1)].getTreasure();
		}
		r2 = new Reinos(name, treasure);
		r1[counterReinos++] = r2;
		c1[choseCastle(castle,c1)].changeOwner(r1[counterReinos-1]);
		currentReino++;
	}
	public void removerReinos() {
		counterReinos--;
	}
	public boolean hasNextReinos() {
		return currentReino < numberReinos;
	}
	public String getTeamName() {
		return r1[currentPlayer].getReinoName();
	}
	
	public int choseCastle(String name, Castelos[] c1) {
		int i=-1;
		int j = 0;
		boolean found = false;
		while(!found && j<counterCastles) {
			if(name.equals(c1[j].getName())){
				i=j;
				found=true;
			}
			else {
				j++;
			}
		}
		return i;
	}
	
	public void inicializeInteratiorPlayer() {
		currentPlayer=0;
	}
	public boolean hasNextPlayer() {
		return currentPlayer+1 <= counterReinos;
	}
	public void nextPlayer() {
		if(hasNextPlayer())
			currentPlayer++;
		else {
			currentPlayer=0;
		}
	}
	public int getPlayer() {
		return currentPlayer;
	}
	
	
	
	
	public int getXMap() {
		return xMap;
	}
	public int getYMap() {
		return yMap;
	}
	public void startGame() {
		gameOn=true;
	}
	public void closeGame() {
		gameOn=false;
	}
}
