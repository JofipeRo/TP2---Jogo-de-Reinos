
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
	public void addCasteloToReino(Castelo c2, int i) {
		r1[i].addCastelo(c2);
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
	public String getReinoInfo(int k) {
		Reino[] rr = new Reino[counterReino];
		Reino r2;
		for(int a=0; a<counterReino; a++) {
			r2=r1[a];
			rr[a]=r2;
		}
		String reinoInfo = "";
		for(int i=1; i<counterReino; i++) {
			for(int j= counterReino-1; j>=i ;j--) {
				if(rr[j-1].greaterThan(rr[j])) {
					Reino temp = rr[j-1];
					rr[j-1]=rr[j];
					rr[j]=temp;
					}		
				}
		}
		reinoInfo=reinoInfo+rr[k].getReinoName() + ", " + rr[k].getNCastles() + " castelos, " + rr[k].getNSoldiers() + " soldados, ";
		reinoInfo=reinoInfo+rr[k].getTotalTreasure() + " de riqueza";
		return reinoInfo;
		}
	
	
	public void addSoldadosToReino(String type, String castle, int i) {
		r1[i].addSoldadoToReino(type, castle);
	}
	public boolean reinoHasCastle(int i, String castle) {
		return r1[i].getCastleWithName(castle)!=-1;
	}
	public boolean castleHasEnoughMoney(int i, String castle, int money) {
		return r1[i].castleHasEnoughMoney(castle, money);
	}
	public boolean isReinoCastleOcupado(int i, String castle) {
		return r1[i].reinoCastleOcupado(castle);
	}
	public String printReinoSoldadoInfo(int i, int player) {
		return r1[player].printSoldadoInfo(i);
	}
	public int getReinoSoldadoXPos(int i, int player) {
		return r1[player].getSoldadoXPos(i);
	}
	public int getReinoSoldadoYPos(int i, int player) {
		return r1[player].getSoldadoYPos(i);
	}
	public String getReinoSoldadoType(int i, int player) {
		return r1[player].getSoldadoType(i);
	}
	public int findSoldadoIndex(int xPos, int yPos, int player) {
		return r1[player].findSoldadoIndex(xPos, yPos);
	}
	public void moveReinoSoldado(int i, String direcao, int player) {
		r1[player].moveSoldado(i, direcao);
	}
	public boolean reinoSoldadoColision(int xPos,int yPos, int soldado, String direcao, int player) {
		return r1[player].soldadoColision(xPos, yPos, soldado, direcao);
	}
	public int enemyColisiom(int xPos, int yPos, int player) {
		int colision=-1;
		for(int i=0;i<counterReino;i++) {
			if(i==player) {}
			else {
				if(r1[i].enemyColision(xPos, yPos)!=-1)
					colision=i;
			}
		}
		return colision;
	}
	// 0 - morre equipa 2     1 - morre equipa 1
	public int compareType(String type, int xPos, int yPos, int player) {
		int fightType=-1;
		int teamSol2=enemyColisiom(xPos, yPos, player);
		int indexSol2=findSoldadoIndex(xPos, yPos, teamSol2);
		String type2= getReinoSoldadoType(indexSol2,teamSol2);
		if(type.equals(type2)) {
			fightType=0;
		}
		else {
			if(type.equals("espadachim")) {
				if(type2.equals("lanceiro"))
					fightType=0;
				if(type2.equals("cavaleiro"))
					fightType=1;
				}
			if(type.equals("lanceiro")) {
				if(type2.equals("espadachim"))
					fightType=1;
				if(type2.equals("cavaleiro"))
					fightType=0;
			}
			if(type.equals("cavaleiro")) {
				if(type2.equals("lanceiro"))
					fightType=1;
				if(type2.equals("espadachim"))
					fightType=0;
			}
		}
		return fightType;
	}
	
	public void killSoldier(String type, int xPos, int yPos, int player, int soldado) {
		int teamSol2=enemyColisiom(xPos, yPos, player);
		int indexSol2=findSoldadoIndex(xPos, yPos, teamSol2);
		int fightCompare=compareType(type, xPos, yPos, player);
		if(fightCompare==0)
			r1[teamSol2].killSoldadoFromReino(indexSol2);
		if(fightCompare==1) 
			r1[player].killSoldadoFromReino(soldado);
	}
	public String getFightMessage(String type, int xPos, int yPos, int player) {
		String message="";
		int teamSol2=enemyColisiom(xPos, yPos, player);
		int indexSol2=findSoldadoIndex(xPos, yPos, teamSol2);
		String type2= getReinoSoldadoType(indexSol2,teamSol2);
		int fightCompare=compareType(type, xPos, yPos, player);
		if(fightCompare==0) 
			message="Muhahah, sou um " + r1[player].getReinoName() + "! Sou invencivel! Nenhum " +  type2 + " me faz frente!";
		if(fightCompare==1)
			message="Argh! A dor! Maldito sejas, " + type2 + " " + r1[teamSol2].getReinoName()+".";
		
		return message;
	}
	public int getReinoWithNameIndex(String reino) {
		int player=-1;
		for(int i=0;i<counterReino;i++) {
			if(r1[i].getReinoName().equals(reino)) {
				player=i;
			}
		}
		return player;
	}
	public void removeCastleFromReino(String name, String reino) {
		int player=getReinoWithNameIndex(reino);
		r1[player].removeCastleFromReino(name);
	}
	public void removeReino(int player) {
		for(int i=player;i<counterReino-1;i++) {
			r1[i]=r1[i+1];
		}
		counterReino--;
	}
	public int isReinoDead() {
		int dead =-1;
		for(int i=0; i<counterReino && dead ==-1;i++) {
			if(!r1[i].isReinoAlive()) {
				dead = i;
			}
		}
		return dead;
	}
	public boolean lastReino() {
		return counterReino==1;
	}
}
