package br.com.renato.recurso;

/**
 * Um <code>Ponto</code> é responsável por 
 * definir uma coordenada X e Y dentro de 
 * uma matriz, armazena dados informados via 
 * input pelo usuário.
 * 
 * @author Renato Rodrigues de Mello
 * @version 1.5
 * @since 1.0
 */
public class Ponto {
	private int x; 
	private int y;
	
	public Ponto() {}
	
	public Ponto(int x, int y) {
		this.x = x; 
		this.y = y;
	}	
	/**
	 * Recupera valor informado na classe <i>Principal</i>
	 * @return 
	 */
	public int getX() {
		return x;
	}
	/**
	 * Armazena valor informado na classe <i>Principal</i>
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Recupera valor informado na classe <i>Principal</i>
	 * @return 
	 */
	public int getY() {
		return y;
	}
	/**
	 * Armazena valor informado na classe <i>Principal</i>
	 * @param Y
	 */
	public void setY(int y) {
		this.y = y;
	}	
	
}
