
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
	
	public void move(String direcao) {
		direcao.toLowerCase();
		if(direcao.equals("norte"))
			yPos++;
		if(direcao.equals("sul"))
			yPos--;
		if(direcao.equals("este"))
			xPos++;
		if(direcao.equals("oeste"))
			xPos--;
	}
}
