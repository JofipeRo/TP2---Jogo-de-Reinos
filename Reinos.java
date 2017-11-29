
public class Reinos {
	private String teamName;
	private int numberCastles;
	private int numberSoldiers;
	private int totalTreasure;
	
	public Reinos(String name, int treasure) {
		teamName=name;
		numberCastles=1;
		numberSoldiers=0;
		totalTreasure=treasure;
	}
	public String getReinoName() {
		return teamName;
	}
	public int getNCastles() {
		return numberCastles;
	}
	public int getNSoldiers() {
		return numberSoldiers;
	}
	public int getTotalTreasur() {
		return totalTreasure;
	}
}
