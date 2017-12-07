
public class Reino {
	private String teamName;
	private int numberCastles;
	private int numberSoldiers;
	private int totalTreasure;
	private CasteloColection reinoCastelos;
	
	public Reino(String name, int treasure, int size) {
		reinoCastelos=new CasteloColection(size);
		teamName=name;
		numberCastles = reinoCastelos.getCounter();
		numberSoldiers=0;
		totalTreasure=treasure;
	}
	public String getReinoName() {
		return teamName;
	}
	public int getNCastles() {
		return reinoCastelos.getCounter();
	}
	public int getNSoldiers() {
		return numberSoldiers;
	}
	public int getTotalTreasure() {
		return totalTreasure;
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
	}
