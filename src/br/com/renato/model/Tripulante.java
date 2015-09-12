package br.com.renato.model;
/**
 * Um <code>Tripulante</code> representa as coordenadas 
 * a serem encontradas. A classe <i>Principal</i> cria 
 * os tripulantes e os insere na matrix, enquante a classe
 * <i>Quadrante</i> cria uma lista de tripulantes para serem 
 * encontrados.
 * 
 * @author Renato Rodrigues de Mello
 * @version 1.5
 * @since 1.0
 */
public class Tripulante {
	private int x;
	private int y;
	private boolean resgatado = false;

	public Tripulante() {
	}
	/**
	 * Recupera a informação referente ao estado 
	 * do tripulante, se ele foi encontrado ou não.
	 * @return
	 */
	public boolean isResgatado() {
		return resgatado;
	}
	/**
	 * Armazena a informação referente ao estado
	 * do tripulante. 
	 * @param resgatado
	 */
	public void setResgatado(boolean resgatado) {
		this.resgatado = resgatado;
	}
	/**
	 * Recupera a coordenada X do tripulante.
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 * Armazena a coordenada X do tripulante.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Recupera a coordenada Y do tripulante.
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * Armazena a coordenada Y do tripulante.
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
