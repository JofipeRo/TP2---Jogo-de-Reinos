
public class Castelos {
	private String castleName;
	private int treasure;
	private int xPos;
	private int yPos;
	private String owner;
	
	public Castelos(String name, int treasure, int x, int y) {
		castleName=name;
		this.treasure=treasure;
		xPos = x;
		yPos = y;
		owner = "sem dono";
	}
	
	public void changeOwner(Reinos r1) {
		owner=r1.getReinoName();
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
	public String getOwner() {
		return owner;
	}
	public int getTreasure() {
		return treasure;
	}
}
