
public class ReinoColection {
	private Reino[] r1;
	private int counterReino;
	
	public ReinoColection(int size) {
		r1=new Reino[size];
		counterReino=0;
	}
	public void addReino(Reino r2, Castelo c2) {
		r1[counterReino]=r2;
		r1[counterReino++].addCastelo(c2);
	}
	public String getName(int i) {
		return r1[i].getReinoName();
	}
	public int numberCastelos(int i) {
		return r1[i].getNCastles();
	}
	public int numberSoldiers(int i) {
		return r1[i].getNSoldiers();
	}
	public int getTotalTreasure(int i) {
		return r1[i].getTotalTreasure();
	}
	public int getCounter() {
		return counterReino;
	}
	public int searchForCastle(String name) {
		int i=-1;
		for(int i2=0; i2<counterReino; i2++) {
			if(r1[i2].searchForCastle(name))
				i=i2;
		}
		return i;
	}
	public boolean nameFound(String name) {
		boolean found=false;
		for(int i=0;i<counterReino;i++) {
			if(r1[i].getReinoName().equals(name))
				found=true;
		}
		return found;
	}
	public void addCasteloToReino(Castelo c2) {
		r1[counterReino++].addCastelo(c2);
	}
	public String getReinoCastelosName(int i, int player) {
		return r1[player].getCastleName(i);
	}
	public int getReinoCastelosTreasure(int i, int player) {
		return r1[player].getCastleTreasure(i);
	}
	public String getReinoCastelosPos(int i, int player) {
		String Pos=r1[player].getCastleXPos(i)+","+r1[player].getCastleYPos(i);
		return Pos;
	}
}
