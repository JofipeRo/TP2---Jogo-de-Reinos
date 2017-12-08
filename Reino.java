
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
	public boolean greaterThan(Reino other) {
		return this.getReinoName().compareTo(other.getReinoName())>0;
	}
	}
