/**
 * @author joaor 53349 & Frederico 52794 
 * Classe para definir uma colecao de soldados de um determinado reino.
 */
public class SoldadoColection {
	// Variaveis
	/**
	 * soldados - colecao de soldados.
	 * counterSoldados - counter da colecao de soldados.
	 */
	private Soldado[] soldados;
	private int counterSoldados;
	// Constantes
	/**
	 * DEFAULT_SIZE - constante para definir o tamanho default do vetor de soldados.
	 */
	private final int DEFAULT_SIZE=100;
	
	// Metodos
	/**
	 * Metodo para criar uma colecao de soldados com tamanho default e com counter inicializado a 0.
	 */
	public SoldadoColection() {
		soldados=new Soldado[DEFAULT_SIZE];
		counterSoldados=0;
	}
	/**
	 * Metodo para devolver o valor do counter da colecao.
	 * @return - Devolve o valor de counterSoldados.
	 */
	public int getCounterSoldados() {
		return counterSoldados;
	}
	/**
	 * Metodo para devolver a coordenada x do soldado na posicao i da colecao.
	 * @param i - posicao do soldado na colecao.
	 * @return - devolve a coordenada x do soldado.
	 */
	public int getSoldadoXPos(int i) {
		return soldados[i].getXPos();
	}
	/**
	 * Metodo para devolver a coordenada y do soldado na posicao i da colecao.
	 * @param i - posicao do soldado na colecao.
	 * @return - devolve a coordenada y do soldado.
	 */
	public int getSoldadoYPos(int i) {
		return soldados[i].getYPos();
	}
	/**
	 * Metodo para devolver o tipo do soldado na posicao i da colecao.
	 * @param i - posicao do soldado na colecao.
	 * @return - devolve o tipo do soldado.
	 */
	public String getSoldadoType(int i) {
		return soldados[i].getType();
	}
	/**
	 * Metodo para mover o soldade na posicao i da colecao.
	 * @param i - posicao do soldado a mover.
	 * @param direcao - direcao para o qual o soldado deve-se mover.
	 */
	public void move(int i,  String direcao) {
		soldados[i].move(direcao);
	}
	/**
	 * Metodo para adicionar um soldado a colecao, de coordenadas x y e do tipo type.
	 * @param type - tipo do soldado a adicionar.
	 * @param x - coordenada x do soldado a adicionar.
	 * @param y - coordenada y do soldado a adicionar.
	 */
	public void addSoldado(String type, int x, int y) {
		Soldado s1= new Soldado(x,y,type);
		soldados[counterSoldados++]=s1;
	}
	/**
	 * Metodo para devolver a String com as informacoes do soldado na posicao i da colecao.
	 * @param i - posicao do soldado na colecao.
	 * @return - devolve as informacoes do soldado.
	 */
	public String printSoldadoInfo(int i) {
		String info;
		info=getSoldadoType(i) + " na posicao (" + getSoldadoXPos(i) + "," + getSoldadoYPos(i) + ")";
		return info;
	}
	/**
	 * Metodo para devolver a posicao de um determinado Soldado da colecao atravez das suas coordenadas.
	 * @param xPos - posicao x do soldado a encontrar.
	 * @param yPos - posicao y do soldado a encontrar.
	 * @return - devolve a posicao do soldado na colecao
	 */
	public int getSoldadoIndex(int xPos, int yPos) {
		int j=-1;
		for(int i=0;i<counterSoldados && j==-1 ;i++) {
			if(soldados[i].getXPos()==xPos && soldados[i].getYPos()==yPos) {
				j=i;
			}
		}
		return j;
	}
	/**
	 * Metodo para averiguar se o movimento ira causar colisao com soldados da mesma colecao.
	 * @param xPos - coordenada x atual do soldado.
	 * @param yPos - coodenara y atual do soldado.
	 * @param soldado - posicao do soldado na colecao para que nao comparemos com ele mesmo
	 * @param direcao - direcao prevista para o movimento do soldado.
	 * @return - devolve true se houver colisao com um soldado da mesma colecao
	 */
	public boolean colision(int xPos,int yPos, int soldado, String direcao) {
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
		for(int i=0; i<counterSoldados && equal==false ;i++) {
			if(i==soldado) {
			}
			else {
				if(yNewPos==soldados[i].getYPos() && xNewPos==soldados[i].getXPos()) {
					equal=true;
				}
			}
		}
		return equal;
	}
	/**
	 * Metodo para averiguar se existe colisao entre um soldado de coordenadas xPos yPos, com algum soldado desta colecao.
	 * @param xPos - coordenada x do soldado a comparar.
	 * @param yPos - coordenada y do soldado a comparar.
	 * @return - devolve -1 se nao houver colisao, e caso haja, a posicao do soldado, na colecao, com quem ele colidio.
	 */
	public int enemyColision(int xPos, int yPos) {
		int colision=-1;
		for(int i=0; i<counterSoldados && colision==-1 ;i++) {
			if(yPos==soldados[i].getYPos() && xPos==soldados[i].getXPos()) {
				colision=i;
			}
		}
		return colision;

	}
	/**
	 * Metodo para matar um soldado retirando-o da colecao.
	 * @param soldado - posicao do soldado a remover.
	 */
	public void killSoldado(int soldado) {
		for(int i=soldado;i<counterSoldados-1;i++) {
			soldados[i]=soldados[i+1];
		}
		counterSoldados--;
	}
}
