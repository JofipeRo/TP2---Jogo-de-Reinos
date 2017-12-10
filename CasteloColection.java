
public class CasteloColection {
	private Castelo[] c1;
	private int counterCastelo;
	
	public CasteloColection(int size) {
		c1=new Castelo[size];
		counterCastelo=0;
	}
	public void addCastelo(Castelo c2) {
		c1[counterCastelo++]=c2;
	}
	public String getName(int i) {
		return c1[i].getName();
	}
	public int getTreasure(int i) {
		return c1[i].getTreasure();
	}
	public int getXPos(int i) {
		return c1[i].getXPos();
	}
	public int getYPos(int i) {
		return c1[i].getYPos();
	}
	public int getCounter() {
		return counterCastelo;
	}
	public boolean nameFound(String name) {
		boolean found=false;
		for(int i=0;i<counterCastelo;i++) {
			if(c1[i].getName().equals(name))
				found=true;
		}
		return found;
	}
	public int getCastleWithName(String name) {
		int j=-1;
		for(int i=0;i<counterCastelo;i++) {
			if(c1[i].getName().equals(name))
				j=i;
		}
		return j;
	}
	public Castelo getCastelo(String name) {
		Castelo c2=null;
		boolean found=false;
		for(int i=0;i<counterCastelo||found==false;i++) {
			if(c1[i].sameCastle(name)) {
				c2=c1[i];
				found=true;
			}
		}
		return c2;
	}
	public Castelo getCasteloInIndex(int i) {
		return c1[i];
	}
	public int getSumTreasure() {
		int treasure=0;
		for(int i=0; i<counterCastelo; i++) {
			treasure+=c1[i].getTreasure();
		}
		return treasure;
	}
	public void spendMoneyOfCastle(String type, int i) {
		c1[i].spendMoney(type);
	}
	public void addMoney(int i) {
		c1[i].addMoney();
	}
	public boolean castleHasEnoughMoney(int i, int money) {
		return c1[i].hasEnoughMoney(money);
	}
	public boolean castleOcupado(int i, int x, int y) {
		return c1[i].castleOcupado(x, y);
	}
	public boolean soldadoInCastelo(int xPos,int yPos, int soldado, String direcao) {
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
		for(int i=0; i<counterCastelo && equal==false ;i++) {
			if(i==soldado) {
			}
			else {
				if(yNewPos==c1[i].getYPos() && xNewPos==c1[i].getXPos()) {
					equal=true;
				}
			}
		}
		return equal;
	}
	public int getCastleInPos(int xPos, int yPos, String direcao) {
		int pos=-1;
		boolean found=false;
		int xNewPos=xPos;
		int yNewPos=yPos;
		if(direcao.equals("norte"))
			yNewPos++;
		if(direcao.equals("sul"))
			yNewPos--;
		if(direcao.equals("este"))
			xNewPos++;
		if(direcao.equals("oeste"))
			xNewPos--;
		for(int i=0; i<counterCastelo && found==false;i++) {
			if(c1[i].getXPos()==xNewPos && c1[i].getYPos()==yNewPos) {
				pos=i;
				found=true;
			}
				
		}
		return pos;
	}
}
