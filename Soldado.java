/**
 * @author joaor 53349 & Frederico 52794 
 * Classe para definir o objeto Soldado utilizado pelos diferentes Reinos.
 */
public class Soldado {
	// Variaveis
	/**
	 * xPos - coordenada X do soldado no mapa.
	 * yPos - coordenada Y do soldado no mapa.
	 * type - tipo que o resultado representa.
	 * @pre - xPos > 0 && xPos <= limite este do mapa && yPos > 0 && yPos <= limite norte do mapa.
	 * @pre - type == espadachim || type == lanceiro || type == cavaleiro.
	 */
	private int xPos;
	private int yPos;
	private String type;
	//Metodos
	/**
	 * Metodo para criar um Soldado.
	 * @param x - coordenada x em que o soldado e inicializado.
	 * @param y - coordenada y em que o soldado e inicializado.
	 * @param type - tipo do soldado
	 */
	public Soldado(int x, int y, String type) {
		xPos=x;
		yPos=y;
		this.type=type;
	}
	/**
	 * Metodo para devolver a coordenada x do Soldado.
	 * @return - devolve a coordenada x do Soldado.
	 */
	public int getXPos() {
		return xPos;
	}
	/**
	 * Metodo para devolver a coordenada y do Soldado.
	 * @return - devolve a coordenada y do Soldado.
	 */
	public int getYPos() {
		return yPos;
	}
	/**
	 * Metodo para devolver o tipo do Soldado.
	 * @return - devolve o tipo do Soldado.
	 */
	public String getType() {
		return type;
	}
	/**
	 * Metodo para mover o Soldado.
	 * @param direcao - direcao para o qual o Soldado deve ser movido.
	 */
	public void move(String direcao) {
		direcao.toLowerCase();
		if(direcao.equals("norte"))
			yPos++;
		if(direcao.equals("sul"))
			yPos--;
		if(direcao.equals("este"))
			xPos++;
		if(direcao.equals("oeste"))
			xPos--;
	}
}
