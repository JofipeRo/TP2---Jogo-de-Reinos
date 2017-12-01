public class Condicoes {
	
	public Condicoes() {
		
	}
	
	public boolean mapSize(Game g1) {
		return (g1.getXMap()>=10 && g1.getYMap()>=10);
	}
	public boolean numberReinos(Game g1) {
		return (g1.getNReino()>=2 && g1.getNReino()<=8); 
	}
	public boolean numberCastles(Game g1) {
		return (g1.getNCastles()>=g1.getNReino() && g1.getNCastles()<=(g1.getXMap()*g1.getYMap()));
	}
	public boolean goodCastlesCordinates(Game g1, Castelos[] c1) {
		return (c1[g1.getCounterCastles()-1].getXPos()>0 && c1[g1.getCounterCastles()-1].getXPos()<=g1.getXMap()
				&& c1[g1.getCounterCastles()-1].getYPos()>0 && c1[g1.getCounterCastles()-1].getYPos()<=g1.getYMap());
	}
	public boolean goodCastlesTreasure(Game g1, Castelos[] c1) {
		return c1[g1.getCounterCastles()-1].getTreasure() > 0;
	}
	public boolean lookForCastleName(Castelos[] c1, Game g1, String name) {
		int i=0;
		boolean found=false;
		while(i<g1.getCounterCastles()-1 && !found) {
			if(name.compareTo(c1[i].getName())==0)
				found=true;
			i++;
		}
		return found;
	}
	public boolean lookForReinoName(Reinos[] r1, Game g1, String name) {
		int i=0;
		boolean found=false;
		while(i<g1.getCounterReinos()-1) {
			if(name.compareTo(r1[i].getReinoName())==0)
				found=true;
			i++;
		}
		return found;
	}
	public int castlesAlreadyTaken(Reinos[] r1, Castelos[] c1, Game g1, String name) {
		int found=-1;
		int i=0;
		while(i<g1.getCounterReinos() && found==-1) {
			if(name.compareTo(c1[i].getName())==0)
				found = 0;	
			if(found==0 && !c1[i].getOwner().equals("sem dono"))
				found=-2;
			i++;
		}
		return found;
	}
}
