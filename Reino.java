
public class Reino {
	private String teamName;
	private SoldadoColection reinoSoldados;
	private CasteloColection reinoCastelos;
	
	public Reino(String name, int size) {
		reinoCastelos=new CasteloColection(size);
		reinoSoldados=new SoldadoColection();
		teamName=name;
	}
	public String getReinoName() {
		return teamName;
	}
	public int getNCastles() {
		return reinoCastelos.getCounter();
	}
	public int getNSoldiers() {
		return reinoSoldados.getCounterSoldados();
	}
	public boolean searchForCastle(String name) {
		return reinoCastelos.nameFound(name);
	}
	public void addCastelo(Castelo c2) {
		reinoCastelos.addCastelo(c2);
	}
	public String getCastleName(int i) {
		return reinoCastelos.getName(i);
	}
	public int getCastleTreasure(int i) {
		return reinoCastelos.getTreasure(i);
	}
	public int getCastleXPos(int i) {
		return reinoCastelos.getXPos(i);
	}
	public int getCastleYPos(int i) {
		return reinoCastelos.getYPos(i);
	}
	public int getTotalTreasure() {
		return reinoCastelos.getSumTreasure();
	}
	public int getSoldadoXPos(int i) {
		return reinoSoldados.getSoldadoXPos(i);
	}
	public int getSoldadoYPos(int i) {
		return reinoSoldados.getSoldadoYPos(i);
	}
	public String getSoldadoType(int i) {
		return reinoSoldados.getSoldadoType(i);
	}
	public boolean greaterThan(Reino other) {
		return this.getReinoName().compareTo(other.getReinoName())>0;
	}
	public void addSoldadoToReino(String type, String castle) {
		int i = getCastleWithName(castle);
		int x;
		int y;
		x=getCastleXPos(i);
		y=getCastleYPos(i);
		reinoSoldados.addSoldado(type, x, y);
		reinoCastelos.spendMoneyOfCastle(type, i);
		
	}
	public int getCastleWithName(String castle) {
		return reinoCastelos.getCastleWithName(castle);
	}
	public boolean castleHasEnoughMoney(String castle, int money) {
		return reinoCastelos.castleHasEnoughMoney(getCastleWithName(castle), money);
	}
	public boolean reinoCastleOcupado(String castle) {
		boolean found=false;
		for(int i = 0; i<getNSoldiers();i++) {
			int x= getSoldadoXPos(i);
			int y= getSoldadoYPos(i);
			if(reinoCastelos.castleOcupado(getCastleWithName(castle), x, y)) {
				found=true;
			}
		}
		return found;
	}
	public String printSoldadoInfo(int i) {
		return reinoSoldados.printSoldadoInfo(i);
	}
	public int findSoldadoIndex(int xPos, int yPos) {
		return reinoSoldados.getSoldadoIndex(xPos, yPos);
	}
	public void moveSoldado(int i, String direcao) {
		reinoSoldados.move(i , direcao);
	}
	public boolean soldadoColision(int xPos,int yPos, int soldado, String direcao) {
		return reinoSoldados.colision(xPos, yPos, soldado, direcao);
	}
	public int enemyColision(int xPos, int yPos) {
		return reinoSoldados.enemyColision(xPos, yPos);
	}
	public void killSoldadoFromReino(int soldado) {
		reinoSoldados.killSoldado(soldado);
	}
	public void removeCastleFromReino(String name) {
		reinoCastelos.removeCastle(name);
	}
	public boolean isReinoAlive() {
		return reinoCastelos.getCounter()>0 || reinoSoldados.getCounterSoldados()>0;
	}
}
