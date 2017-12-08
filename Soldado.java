
public class Soldado {
	private int xPos;
	private int yPos;
	private String type;
	
	public Soldado(int x, int y, String type) {
		xPos=x;
		yPos=y;
		this.type=type;
	}
	
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public String getType() {
		return type;
	}
}
