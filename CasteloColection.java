
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
}
