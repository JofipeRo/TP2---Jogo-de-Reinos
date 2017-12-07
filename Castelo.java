
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
}
