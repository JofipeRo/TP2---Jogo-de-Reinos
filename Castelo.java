
public class Castelo {
	private String castleName;
	private int treasure;
	private int xPos;
	private int yPos;
	
	public Castelo(String name, int treasure, int x, int y) {
		castleName=name;
		this.treasure=treasure;
		xPos = x;
		yPos = y;
	}
	
	public void addTreasure() {
		treasure++;
	}
	public String getName() {
		return castleName;
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public int getTreasure() {
		return treasure;
	}
	public boolean sameCastle(String name) {
		return getName().equals(name);
	}
	public void spendMoney(String type) {
		type.toLowerCase();
		if(type.equals("espadachim") || type.equals("lanceiro"))
			treasure-=2;
		if(type.equals("cavaleiro"))
			treasure-=4;
	}
	public void addMoney() {
		treasure++;
	}
	public boolean hasEnoughMoney(int money) {
		return treasure-money>=0;
	}
	public boolean castleOcupado(int x, int y) {
		return xPos==x && yPos==y;
	}
}
