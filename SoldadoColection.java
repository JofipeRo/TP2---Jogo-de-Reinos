
public class SoldadoColection {
	private Soldado[] soldados;
	private final int DEFAULT_SIZE=100;
	private int counterSoldados;
	
	
	public SoldadoColection() {
		soldados=new Soldado[DEFAULT_SIZE];
		counterSoldados=0;
	}
	
	public int getCounterSoldados() {
		return counterSoldados;
	}
	public int getSoldadoXPos(int i) {
		return soldados[i].getXPos();
	}
	public int getSoldadoYPos(int i) {
		return soldados[i].getYPos();
	}
	public String getSoldadoType(int i) {
		return soldados[i].getType();
	}
	public void move(int i,  String direcao) {
		soldados[i].move(direcao);
	}
	public void addSoldado(String type, int x, int y) {
		Soldado s1= new Soldado(x,y,type);
		soldados[counterSoldados++]=s1;
	}
	public String printSoldadoInfo(int i) {
		String info;
		info=getSoldadoType(i) + " na posicao (" + getSoldadoXPos(i) + "," + getSoldadoYPos(i) + ")";
		return info;
	}
	public int getSoldado(int xPos, int yPos) {
		int j=-1;
		for(int i=0;i<counterSoldados && j==-1 ;i++) {
			if(soldados[i].getXPos()==xPos && soldados[i].getYPos()==yPos) {
				j=i;
			}
		}
		return j;
	}
	public boolean colision(int xPos,int yPos, int soldado, String direcao) {
		int xNewPos=xPos;
		int yNewPos=yPos;
		boolean equal=false;
		if(direcao.equals("norte"))
			yNewPos++;
		if(direcao.equals("sul"))
			yNewPos--;
		if(direcao.equals("este"))
			xNewPos++;
		if(direcao.equals("oeste"))
			xNewPos--;
		for(int i=0; i<counterSoldados && equal==false ;i++) {
			if(i==soldado) {
			}
			else {
				if(yNewPos==soldados[i].getYPos() && xNewPos==soldados[i].getXPos()) {
					equal=true;
				}
			}
		}
		return equal;
	}
}
