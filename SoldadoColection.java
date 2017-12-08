
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
	public void addSoldado(String type, int x, int y) {
		Soldado s1= new Soldado(x,y,type);
		soldados[counterSoldados++]=s1;
	}
}
