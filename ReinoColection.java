/**
 * @author joaor 53349 & Frederico 52794 
 * Classe para definir uma colecao de reinos de um jogo.
 */
public class ReinoColection {
	// Variaveis.
	/**
	 * r1 - vetor de reinos.
	 * counterReino - valor do counter do vetor reino.
	 */
	private Reino[] r1;
	private int counterReino;
	// Metodos
	/**
	 * Metodo para criar uma colecao de reinos de tamanho size e com counter inicializado a 0.
	 * @param size - tamanho do vetor.
	 */
	public ReinoColection(int size) {
		r1=new Reino[size];
		counterReino=0;
	}
	/**
	 * Metodo para adicionar um reino a colecao com um castelo para que cumpra os requesitos de castelo vivo.
	 * @param r2 - reino a adicionar a coleacao.
	 * @param c2 - castelo a adicionar ao reino.
	 */
	public void addReino(Reino r2, Castelo c2) {
		r1[counterReino]=r2;
		r1[counterReino++].addCastelo(c2);
	}
	/**
	 * Metodo para devolver o nome do reino na posicao i da colecao
	 * @param i - posicao do reino na colecao.
	 * @return - devolve o nome do reino.
	 */
	public String getName(int i) {
		return r1[i].getReinoName();
	}
	/**
	 * Metodo para devolver o numero de castelos do reino na posicao i da colecao
	 * @param i - posicao do reino na colecao.
	 * @return - devolve o numero de castelos do reino.
	 */
	public int numberCastelos(int i) {
		return r1[i].getNCastles();
	}
	/**
	 * Metodo para devolver numero de soldados do reino na posicao i da colecao
	 * @param i - posicao do reino na colecao.
	 * @return - devolve o numero de soldados do reino.
	 */
	public int numberSoldiers(int i) {
		return r1[i].getNSoldiers();
	}
	/**
	 * Metodo para devolver o tesouro total do reino na posicao i da colecao
	 * @param i - posicao do reino na colecao.
	 * @return - devolve o tesouro total do reino.
	 */
	public int getTotalTreasure(int i) {
		return r1[i].getTotalTreasure();
	}
	/**
	 * Metodo para devolver o valor do counter da colecao.
	 * @return - devolve o valor de counterReino.
	 */
	public int getCounter() {
		return counterReino;
	}
	/**
	 * Metodo para encontrar se algum reino da colecao possui o castelo de nome name.
	 * @param name - nome do castelo a procurar.
	 * @return - Devolve -1 se nenhum reino da colecao possuir o castelo, caso contrario
	 * devolve a posicao do reino que possui o castelo.
	 */
	public int searchForCastle(String name) {
		int i=-1;
		for(int i2=0; i2<counterReino; i2++) {
			if(r1[i2].searchForCastle(name))
				i=i2;
		}
		return i;
	}
	/**
	 * Metodo para saber se certo name ja foi utilizado para nome de algum reino da colecao.
	 * @param name - nome a pesquisar.
	 * @return - devolve true se ja houver um reino com nome name.
	 */
	public boolean nameFound(String name) {
		boolean found=false;
		for(int i=0;i<counterReino;i++) {
			if(r1[i].getReinoName().equals(name))
				found=true;
		}
		return found;
	}
	/**
	 * Metodo para adicionar um castelo ao reino de posicao i na colecao.
	 * @param c2 - castelo a adicionar.
	 * @param i - posicao do reino ao qual vamos adicionar o castelo.
	 */
	public void addCasteloToReino(Castelo c2, int i) {
		r1[i].addCastelo(c2);
	}
	/**
	 * Metodo para devolver o nome de um castelo de posicao i na colecao de reinos do reino de posicao player nesta colecao.
	 * @param i - posicao do castelo na colecao de castelos do reino.
	 * @param player - posicao do reino desta colecao.
	 * @return - devolve o nome do castelo.
	 */
	public String getReinoCastelosName(int i, int player) {
		return r1[player].getCastleName(i);
	}
	/**
	 * Metodo para devolver o tesouro de um castelo de posicao i na colecao de reinos do reino de posicao player nesta colecao.
	 * @param i - posicao do castelo na colecao de castelos do reino.
	 * @param player - posicao do reino desta colecao.
	 * @return - devolve o tesouro do castelo.
	 */
	public int getReinoCastelosTreasure(int i, int player) {
		return r1[player].getCastleTreasure(i);
	}
	/**
	 * Metodo para devolver as coordenadas x y de um castelo,
	 * de posicao i na colecao de reinos do reino de posicao player nesta colecao, na forma "x,y".
	 * @param i - posicao do castelo na colecao de castelos do reino.
	 * @param player - posicao do reino desta colecao.
	 * @return - devolve as coordenadas do castelo.
	 */
	public String getReinoCastelosPos(int i, int player) {
		String Pos=r1[player].getCastleXPos(i)+","+r1[player].getCastleYPos(i);
		return Pos;
	}
	/**
	 * Metodo para devolver a informacao do reino de posicao k de um vetor auxiliar no qual os reinos estao listados por ordem
	 * alfabetica, na forma de nomeReino, numero de castelos, numero de soldados, riqueza total.
	 * @param k - posicao do reino no vetor auxiliar.
	 * @return - devolve a informacao do reino.
	 */
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
	
	/**
	 * Metodo para adicionar um soldado de tipo type ao reino de posicao i nesta colecao, num castelo castle desse mesmo reino.
	 * @param type - tipo do soldado.
	 * @param castle - castelo no qual o soldado deve ser criado.
	 * @param i - posicao do reino nesta colecao.
	 */
	public void addSoldadosToReino(String type, String castle, int i) {
		r1[i].addSoldadoToReino(type, castle);
	}
	/**
	 * Metodo para saber se um reino de posicao i nesta colecao, tem o castelo de nome castle.
	 * @param i - posicao do reino nesta colecao.
	 * @param castle - nome do castelo a averiguar.
	 * @return - devolve true se o reino tiver o castelo.
	 */
	public boolean reinoHasCastle(int i, String castle) {
		return r1[i].getCastleWithName(castle)!=-1;
	}
	/**
	 * Metodo para saber se o castelo de nome castle do reino de posicao i nesta colecao
	 * tem moedas suficientes para efetuar um recrutameto de custo money.
	 * @param i - posicao do reino desta colecao.
	 * @param castle - nome do castelo a verificar.
	 * @param money - custo de moedas a verificar.
	 * @return devolve true se o castelo tiver moedas suficientes.
	 */
	public boolean castleHasEnoughMoney(int i, String castle, int money) {
		return r1[i].castleHasEnoughMoney(castle, money);
	}
	/**
	 * Metodo para saber se o castelo de nome caste do reino de posicao i nesta colecao
	 * esta ocupado por algum soldado desse mesmo reino.
	 * @param i - posicao do reino nesta colecao.
	 * @param castle - nome do castelo nesta colecao.
	 * @return - devolve true se o castelo estiver ocupado.
	 */
	public boolean isReinoCastleOcupado(int i, String castle) {
		return r1[i].reinoCastleOcupado(castle);
	}
	/**
	 * Metodo para devolver a informacao de um soldado de posicao i na colecao de soldados
	 * do reino de posicao player desta colecao.
	 * @param i - posicao do soldado na colecao de soldados do reino.
	 * @param player - posicao do reino nesta colecao.
	 * @return - devolve a informacao do soldado.
	 */
	public String printReinoSoldadoInfo(int i, int player) {
		return r1[player].printSoldadoInfo(i);
	}
	/**
	 * Metodo para devolver a coordenada x do soldado de posicao i na colecao de soldados
	 * do reino de posicao player desta colecao.
	 * @param i - posicao do soldado na colecao de soldados do reino.
	 * @param player - posicao do reino nesta colecao.
	 * @return - devolve a coordenada x do soldado.
	 */
	public int getReinoSoldadoXPos(int i, int player) {
		return r1[player].getSoldadoXPos(i);
	}
	/**
	 * Metodo para devolver a coordenada y do soldado de posicao i na colecao de soldados
	 * do reino de posicao player desta colecao.
	 * @param i - posicao do soldado na colecao de soldados do reino.
	 * @param player - posicao do reino nesta colecao.
	 * @return - devolve a coordenada y do soldado.
	 */
	public int getReinoSoldadoYPos(int i, int player) {
		return r1[player].getSoldadoYPos(i);
	}
	/**
	 * Metodo para devolver o tipo do soldado de posicao i na colecao de soldados
	 * do reino de posicao player desta colecao.
	 * @param i - posicao do soldado na colecao de soldados do reino.
	 * @param player - posicao do reino nesta colecao.
	 * @return - devolve o tipo do soldado.
	 */
	public String getReinoSoldadoType(int i, int player) {
		return r1[player].getSoldadoType(i);
	}
	/**
	 * Metodo para encontra a posicao do soldado na colecao de soldados do reino de posicao player nesta colecao
	 * atraves das suas coordenadas.
	 * @param xPos - coordenada x do soldado a encontrar.
	 * @param yPos - coordenada y do soldado a encontrar.
	 * @param player - posicao do reino no qual procurar o soldado.
	 * @return - Devolve -1 se nao houver esse soldado no reino, caso contrario devolve a sua posicao na colecao de
	 * soldados do reino.
	 */
	public int findSoldadoIndex(int xPos, int yPos, int player) {
		return r1[player].findSoldadoIndex(xPos, yPos);
	}
	/**
	 * Metodo para mover o soldado de posicao i na colecao de soldados, do reino de
	 * posicao player nesta colecao, para certa direcao.
	 * @param i - posicao do soldado na colecao de soldados.
	 * @param direcao - direcao para o qual o soldado deve mover-se.
	 * @param player - posicao do reino desta colecao.
	 */
	public void moveReinoSoldado(int i, String direcao, int player) {
		r1[player].moveSoldado(i, direcao);
	}
	/**
	 * Metodo para averiguar se houve colisao entre um soldado do reino de posicao player nesta colecao,
	 * e os outros soldados desse reino.
	 * @param xPos - coordenada x do soldado.
	 * @param yPos - coordenada y do soldado.
	 * @param soldado - posicao do soldado na colecao de soldados do reino.
	 * @param direcao - direcao para o qual so soldado pretende mover-se.
	 * @param player - posicao do reino nesta colecao.
	 * @return - devolve true se houver colisao.
	 */
	public boolean reinoSoldadoColision(int xPos,int yPos, int soldado, String direcao, int player) {
		return r1[player].soldadoColision(xPos, yPos, soldado, direcao);
	}
	/**
	 * Metodo para verificar se o soldado de posicao xPos yPos do reino de posicao player,
	 * colide com um soldado dos outros reinos da colecao.
	 * @param xPos - coordenada x do soldado.
	 * @param yPos - coordenada y do soldado.
	 * @param player - posicao do reino, ao qual o soldado pertence, nesta colecao.
	 * @return - devolve true se houver colisao entre soldados.
	 */
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
	/**
	 * Metodo que em caso de colisao, compara os tipos do dois soldados para saber quem morre.
	 * @param type - tipo do soldado do reino que esta a jogar.
	 * @param xPos - coordenada x do soldado da equipa que esta a jogar.
	 * @param yPos - coordenada y do soldado da equipa que esta a jogar.
	 * @param player - reino que esta a jogar.
	 * @return - Devolve -1 caso nao haja colisao, 0 se morre o soldado da equipa fora de turno
	 * e 1 se morre o soldado da equipa que esta a jogar
	 */
	// 0 - morre soldado da equipa fora de turno     1 - morre soldado da equipa que esta a jogar
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
	/**
	 * Metodo para matar o soldado que perdeu o combate depedendo da comparacao de tipos.
	 * @param type - tipo do soldado do reino que esta a jogar.
	 * @param xPos - coordenada x do soldado da equipa que esta a jogar.
	 * @param yPos - coordenada y do soldado da equipa que esta a jogar.
	 * @param player - reino que esta a jogar.
	 * @param soldado - posicao do soldado na colecao do reino que esta a jogar.
	 */
	public void killSoldier(String type, int xPos, int yPos, int player, int soldado) {
		int teamSol2=enemyColisiom(xPos, yPos, player);
		int indexSol2=findSoldadoIndex(xPos, yPos, teamSol2);
		int fightCompare=compareType(type, xPos, yPos, player);
		if(fightCompare==0)
			r1[teamSol2].killSoldadoFromReino(indexSol2);
		if(fightCompare==1) 
			r1[player].killSoldadoFromReino(soldado);
	}
	/**
	 * Metodo para devolver a mensagem de combate, conforme o resultado da comparacao
	 * @param type - tipo do soldado do reino que esta a jogar.
	 * @param xPos - coordenada x do soldado da equipa que esta a jogar.
	 * @param yPos - coordenada y do soldado da equipa que esta a jogar.
	 * @param player - reino que esta a jogar.
	 * @return devolve a mensagem de combate.
	 */
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
	/**
	 * Metodo para devolver a posicao do reino de nome reino nesta colecao.
	 * @param reino - nome do reino.
	 * @return - devolve a posicao do reino nesta colecao.
	 */
	public int getReinoWithNameIndex(String reino) {
		int player=-1;
		for(int i=0;i<counterReino;i++) {
			if(r1[i].getReinoName().equals(reino)) {
				player=i;
			}
		}
		return player;
	}
	/**
	 * Metodo para remover o castelo de nome name do reino de nome reino.
	 * @param name - nome do castelo a remover.
	 * @param reino - nome do reino do qual o castelo deve ser removido.
	 */
	public void removeCastleFromReino(String name, String reino) {
		int player=getReinoWithNameIndex(reino);
		r1[player].removeCastleFromReino(name);
	}
	/**
	 * Metodo para remover o reino de posicao player da colecao.
	 * @param player - posicao do reino a remover.
	 */
	public void removeReino(int player) {
		for(int i=player;i<counterReino-1;i++) {
			r1[i]=r1[i+1];
		}
		counterReino--;
	}
	/**
	 * Metodo para verificar se algum reino da colecao está "morto".
	 * @return - devolve -1 se todos os reinos tiverem vivos, caso contrario devolve a sua posicao nesta colecao.
	 */
	public int isReinoDead() {
		int dead =-1;
		for(int i=0; i<counterReino && dead ==-1;i++) {
			if(!r1[i].isReinoAlive()) {
				dead = i;
			}
		}
		return dead;
	}
	/**
	 * Metodo para verificar se so ha 1 reino restante na colecao.
	 * @return devolve true se so restar 1 reino na colecao
	 */
	public boolean lastReino() {
		return counterReino==1;
	}
}
