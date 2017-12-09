
public class Game {
	private boolean gameOn=false;
	private int xMap;
	private int yMap;
	private int currentPlayer;
	private CasteloColection castelos;
	private ReinoColection reinos;
	public boolean isGameOn() {
		return gameOn;
	}
	public Game() {
	}
	
	public void createGame(int x, int y, int nReinos, int nCastles) {
		xMap=x;
		yMap=y;
		castelos=new CasteloColection(nCastles);
		reinos =new ReinoColection(nReinos);
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
	public void closeGame(Game g1) {
		gameOn=false;
	}
	
	//   **** CASTELOS ****
	public void addCastles(Castelo c2) {
		castelos.addCastelo(c2);
	}
	public String getCastleName(int i) {
		return castelos.getName(i);
	}
	public int getTreasure(int i) {
		return castelos.getTreasure(i);
	}
	public int getXPosCastle(int i) {
		return castelos.getXPos(i);
	}
	public int getYPosCastle(int i) {
		return castelos.getYPos(i);
	}
	public int getCounterCastelos() {
		return castelos.getCounter();
	}
	public String findOwner(String castle) {
		String owner="sem dono";
		int i=reinos.searchForCastle(castle);
		if(i!=-1)
			owner=reinos.getName(i);
		return owner;
	}	
	public void addMoneyToCastelos() {
		for(int i=0;i<castelos.getCounter();i++) 
			castelos.addMoney(i);
	}
	//   **** REINOS ****
	public int getCounterReinos() {
		return reinos.getCounter();
	}
	public void addReinos (Reino r2, String name, String castle, Castelo c2) {
		c2=castelos.getCastelo(castle);
		reinos.addReino(r2, c2);
	}
	public String getReinosName(int i) {
		return reinos.getName(i);
	}
	public int getNCastlesByReino(int i) {
		return reinos.numberCastelos(i);
	}
	public int getNSoldados(int i) {
		return reinos.numberSoldiers(i);
	}
	public int getTotalTreasure(int i){
		return reinos.getTotalTreasure(i);
	}
	public String getTeamName() {
		return getReinosName(currentPlayer);
	}
	public int choseCastle (String name) {
		int i=-1;
		int j = 0;
		boolean found = false;
		while(!found && j<castelos.getCounter()) {
			if(name.equals(castelos.getName(j))){
				i=j;
				found=true;
			}
			else {
				j++;
			}
		}
		return i;
	}
	public String getReinoInfo(int i) {
		return reinos.getReinoInfo(i);
	}
	public void addSoldadoToReino(String type, String castle){
		reinos.addSoldadosToReino(type, castle, getPlayer());
	}
	public boolean hasCastleEnoughMoney(String castle, int money) {
		return reinos.castleHasEnoughMoney(getPlayer(), castle, money);
	}
	//    **** INTERACTOR ****
	public void inicializeInteratiorPlayer() {
		currentPlayer=0;
	}
	public boolean hasNextPlayer() {
		return (currentPlayer+1 < reinos.getCounter());
	}
	public void nextPlayer() {
		if(hasNextPlayer())
			currentPlayer++;
		else {
			currentPlayer=0;
		}
		addMoneyToCastelos();
	}
	public int getPlayer() {
		return currentPlayer;
	}
	public boolean reinoHasCastle(String castle) {
		return reinos.reinoHasCastle(getPlayer(), castle);
	}
	//   **** Condicoes ****
	
	public boolean mapSize() {
		return (getXMap()>=10 && getYMap()>=10);
	}
	public boolean castleNameFound(String castle) {
		return castelos.nameFound(castle);
	}
	public boolean reinoNameFound(String reino) {
		return reinos.nameFound(reino);
	}
	
	//   **** Castelos do Reino ***
	public String getCastelosNameByReino(int i) {
		return reinos.getReinoCastelosName(i, getPlayer());
	}
	public int getCastelosTreasureByReino(int i) {
		return reinos.getReinoCastelosTreasure(i, getPlayer());
	}
	public String getCastelosPositionByReino(int i) {
		String pos= "(" + reinos.getReinoCastelosPos(i, getPlayer()) + ")";
		return pos;
	}
	public boolean isReinoCasteloOcupado(String castle) {
		return reinos.isReinoCastleOcupado(getPlayer(), castle);
	}
}

