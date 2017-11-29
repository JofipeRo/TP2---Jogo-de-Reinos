
public class Game {
	private boolean gameOn=false;
	private int numberReinos;
	private int numberCastles;
	private int counterCastles;
	private int counterReinos;
	private int xMap;
	private int yMap;
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
	public void addCastles(Castelos c2, String name, int treasure, int x, int y) {
		c2 = new Castelos(name, treasure, x, y);
		c1[counterCastles++]=c2;
	}
	public boolean hasNextCastles() {
		return counterCastles < numberCastles;
	}
	// Fazer metodo para econtrar o nome do castelo, e devolver a posicao, para depois definir o owner e tesouro
	public void addReinos (Reinos r2, String name, String castle, int treasure) {
		r2 = new Reinos(name, treasure);
		r1[counterReinos++] = r2;
		
	}
	public boolean hasNextReinos() {
		return counterCastles < numberCastles;
	}
	public String getTeamName(int i) {
		return r1[i].getReinoName();
	}
	
	
	
	
	public boolean hasNextPlayer(int i) {
		return i < counterReinos;
	}
	
	
	
	
	
	public int getXMap() {
		return xMap;
	}
	public int getYMap() {
		return yMap;
	}
}
