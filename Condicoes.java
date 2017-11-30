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
}
