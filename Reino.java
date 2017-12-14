/**
 * @author joaor 53349 & Frederico 52794 
 * Classe para definir o objeto Reino da ser utilizado pelo jogo.
 */
public class Reino {
	// Variaveis
	/**
	 * teamName - nome do reino.
	 * reinoSoldados - colecao de soldados do reino.
	 * reinoCastelos - reino de castelos do reino.
	 */
	private String teamName;
	private SoldadoColection reinoSoldados;
	private CasteloColection reinoCastelos;
	// Metodos
	/**
	 * Metodo para criar um reino, com nome name e com tanho de colecao de castelos size.
	 * @param name - nome do reino.
	 * @param size - tamanho da colecao.
	 * @pre - name nao e igual ao nome de outro reino.
	 */
	public Reino(String name, int size) {
		reinoCastelos=new CasteloColection(size);
		reinoSoldados=new SoldadoColection();
		teamName=name;
	}
	/**
	 * Metodo para devolver o nome do reino.
	 * @return - Devolve o nome do reino.
	 */
	public String getReinoName() {
		return teamName;
	}
	/**
	 * Metodo para devolver o numero de castelos na colecao de soldados do reino.
	 * @return - devolve o numero de castelos do reino.
	 */
	public int getNCastles() {
		return reinoCastelos.getCounter();
	}
	/**
	 * Metodo para devolver o numero de soldados na colecao de soldados do reino.
	 * @return - devolve o numero de soldados do reino.
	 */
	public int getNSoldiers() {
		return reinoSoldados.getCounterSoldados();
	}
	/**
	 * Metodo para saber se existe um castelo com nome name, na colecao de castelos do reino.
	 * @param name - nome do castelo a procurar.
	 * @return - Devolve true se houver um castelo com nome name na colecao de castelos do reino.
	 */
	public boolean searchForCastle(String name) {
		return reinoCastelos.nameFound(name);
	}
	/**
	 * Metodo para adicionar um castelo a colecao de castelos do reino.
	 * @param c2 - castelo a adicionar ao reino.
	 */
	public void addCastelo(Castelo c2) {
		reinoCastelos.addCastelo(c2);
	}
	/**
	 * Metodo para devolver o nome do castelo na posicao i da colecao de castelos.
	 * @param i - posicao do castelo na colecao de castelos.
	 * @return - devolve o nome do castelo.
	 */
	public String getCastleName(int i) {
		return reinoCastelos.getName(i);
	}
	/**
	 * Metodo para devolver o tesouro do castelo na posicao i da colecao de castelos.
	 * @param i - posicao do castelo na colecao de castelos.
	 * @return - devolve o tesouro do castelo.
	 */
	public int getCastleTreasure(int i) {
		return reinoCastelos.getTreasure(i);
	}
	/**
	 * Metodo para devolver a coordenada x do castelo na posicao i da colecao de castelos.
	 * @param i - posicao do castelo na colecao de castelos.
	 * @return - devolve a coordenada x do castelo.
	 */
	public int getCastleXPos(int i) {
		return reinoCastelos.getXPos(i);
	}
	/**
	 * Metodo para devolver a coordenada y do castelo na posicao i da colecao de castelos.
	 * @param i - posicao do castelo na colecao de castelos.
	 * @return - devolve a coordenada y do castelo.
	 */
	public int getCastleYPos(int i) {
		return reinoCastelos.getYPos(i);
	}
	/**
	 * Metodo para devolver o tesouro total do reino, ou seja, a soma do tesouro de todos os castelos do reino.
	 * @return - devolve o tesouro total do reino.
	 */
	public int getTotalTreasure() {
		return reinoCastelos.getSumTreasure();
	}
	/**
	 * Metodo para devolver a coordenada x do soldado na posicao i da colecao de soldados.
	 * @param i - posicao do soldado na colecao de soldados.
	 * @return - devolve a coordenada x do soldado.
	 */
	public int getSoldadoXPos(int i) {
		return reinoSoldados.getSoldadoXPos(i);
	}
	/**
	 * Metodo para devolver a coordenada y do soldado na posicao i da colecao de soldados.
	 * @param i - posicao do soldado na colecao de soldados.
	 * @return - devolve a coordenada y do soldado.
	 */
	public int getSoldadoYPos(int i) {
		return reinoSoldados.getSoldadoYPos(i);
	}
	/**
	 * Metodo para devolver o tipo do soldado na posicao i da colecao de soldados.
	 * @param i - posicao do soldado na colecao de soldados.
	 * @return - devolve o tipo do soldado.
	 */
	public String getSoldadoType(int i) {
		return reinoSoldados.getSoldadoType(i);
	}
	/**
	 * Metodo para comparar nomes de reinos distintos, e determinar qual vem primeiro em ordem alfabetica.
	 * @param other - outro objeto Reino com o qual iremos comparar o nome
	 * @return - devolve true se o nome deste reino vier primeiro alfabeticamente que o nome do outro reino.
	 */
	public boolean greaterThan(Reino other) {
		return this.getReinoName().compareTo(other.getReinoName())>0;
	}
	/**
	 * Metodo para adicionar um soldado a colecao de soldados do reino de tipo type,
	 * num certo castelo da colecao de castelos do reino.
	 * @param type - tipo do soldado a adicionar.
	 * @param castle - nome do castelos no qual o soldado vai ser criado (coordenadas equivalentes).
	 */
	public void addSoldadoToReino(String type, String castle) {
		int i = getCastleWithName(castle);
		int x;
		int y;
		x=getCastleXPos(i);
		y=getCastleYPos(i);
		reinoSoldados.addSoldado(type, x, y);
		reinoCastelos.spendMoneyOfCastle(type, i);
		
	}
	/**
	 * Metodo para encontrar a posicao do castelo com nome castle na colecao de castelos do reino.
	 * @param castle - nome do castelo a encontrar a posicao.
	 * @return - posicao do castelo na colecao.
	 */
	public int getCastleWithName(String castle) {
		return reinoCastelos.getCastleWithName(castle);
	}
	/**
	 * Metodo para saber se o castelo com nome castle da colecao,
	 * tem moedas suficientes para efetuar um recrutamento de custo money.
	 * @param castle - nome do castelo de que queremos verificar a condicao.
	 * @param money - custo de moedas do recrutamento.
	 * @return - devolve true se o castelo tiver dinheiro suficiente.
	 */
	public boolean castleHasEnoughMoney(String castle, int money) {
		return reinoCastelos.castleHasEnoughMoney(getCastleWithName(castle), money);
	}
	/**
	 * Metodo para saber se um castelo de nome castle do reino esta ocupado por um soldado do reino.
	 * @param castle - nome do castelo do reino.
	 * @return - devolve true se o castelo estiver ocupado
	 */
	public boolean reinoCastleOcupado(String castle) {
		boolean found=false;
		for(int i = 0; i<getNSoldiers();i++) {
			int x= getSoldadoXPos(i);
			int y= getSoldadoYPos(i);
			if(reinoCastelos.castleOcupado(getCastleWithName(castle), x, y)) {
				found=true;
			}
		}
		return found;
	}
	/**
	 * Devolve a String com as informacoes do soldado na posicao i da colecao de soldados.
	 * @param i - posicao do soldado na colecao de soldados.
	 * @return - devolve a informacao do soldado.
	 */
	public String printSoldadoInfo(int i) {
		return reinoSoldados.printSoldadoInfo(i);
	}
	/**
	 * Metodo para econtrar a posicao do soldado na colecao de soldados atraves das coordenadas xPos yPos.
	 * @param xPos - coordenada x do soldado a encontrar a posicao.
	 * @param yPos - coordenada y do soldado a encontrar a posicao.
	 * @return - devolve a posicao do soldado na colecao de soldados.
	 */
	public int findSoldadoIndex(int xPos, int yPos) {
		return reinoSoldados.getSoldadoIndex(xPos, yPos);
	}
	/**
	 * Metodo para mover o soldado de posicao i na colecao de soldados para a certa direcao.
	 * @param i - posicao do soldado a mover.
	 * @param direcao - direcao para o qual o soldado deve mover-se.
	 */
	public void moveSoldado(int i, String direcao) {
		reinoSoldados.move(i , direcao);
	}
	/**
	 * Metodo para verificar se o soldado de posicao xPos, yPos colide com um outro soldado da mesma colecao.
	 * @param xPos - coordenada x do soldado.
	 * @param yPos - coordenada y do soldado.
	 * @param soldado - posicao do soldado na colecao.
	 * @param direcao - direcao para o qual so soldado pretende mover-se.
	 * @return devolve true se houver colisao entre soldados.
	 */
	public boolean soldadoColision(int xPos,int yPos, int soldado, String direcao) {
		return reinoSoldados.colision(xPos, yPos, soldado, direcao);
	}
	/**
	 * Metodo para verificar se o soldado de posicao xPos yPos colide com um soldado deste reino.
	 * @param xPos - coordenada x do soldado.
	 * @param yPos - coordenada y do soldado.
	 * @return - devolve tru se houver colisao entre soldados.
	 */
	public int enemyColision(int xPos, int yPos) {
		return reinoSoldados.enemyColision(xPos, yPos);
	}
	/**
	 * Metodo para matar um soldado deste reino e remove-lo da colecao de soldados.
	 * @param soldado - posicao do soldado na colecao de soldados
	 */
	public void killSoldadoFromReino(int soldado) {
		reinoSoldados.killSoldado(soldado);
	}
	/**
	 * Metodo para remover um castelo da colecao de castelos deste reino.
	 * @param name - mome do castelo a remover da colecao.
	 */
	public void removeCastleFromReino(String name) {
		reinoCastelos.removeCastle(name);
	}
	/**
	 * Metodo para saber se o reino ainda sobrevive, ou seja, tem pelo menos ou 1 castelo ou 1 soldado.
	 * @return - devolve true se o reino ainda sobrevive.
	 */
	public boolean isReinoAlive() {
		return reinoCastelos.getCounter()>0 || reinoSoldados.getCounterSoldados()>0;
	}
}
