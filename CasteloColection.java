
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
	public void removeCastle(String name) {
		int castelo=-1;
		for(int i0=0;i0<counterCastelo;i0++) {
			if(c1[i0].getName().equals(name))
				castelo=i0;
		}
		for(int i=castelo;i<counterCastelo-1;i++) {
			c1[i]=c1[i+1];
		}
		counterCastelo--;
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
	public boolean soldadoInCastelo(int xPos,int yPos, int soldado) {
		boolean equal=false;
		for(int i=0; i<counterCastelo && equal==false ;i++) {
				if(yPos==c1[i].getYPos() && xPos==c1[i].getXPos()) {
					equal=true;
			}
		}
		return equal;
	}
	public int getCastleInPos(int xPos, int yPos) {
		int pos=-1;
		boolean found=false;
		for(int i=0; i<counterCastelo && found==false;i++) {
			if(c1[i].getXPos()==xPos && c1[i].getYPos()==yPos) {
				pos=i;
				found=true;
			}
				
		}
		return pos;
	}
	public boolean castleInSamePos(int xPos, int yPos) {
		boolean found=false;
		for(int i=0;i<counterCastelo && found==false;i++) {
			if(c1[i].getXPos()==xPos && c1[i].getYPos()==yPos) {
				found=true;
			}
		}
		return found;
	}
}
