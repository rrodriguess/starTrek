package br.com.renato.recurso;

import java.util.ArrayList;
import java.util.List;

import br.com.renato.model.Tripulante;
/**
 * Um <code>Quadrante</code> representa as adjac�ncias de um
 * determinado <i>Ponto</i> informado pelo usuario do sistema.
 * A classe <i>Principal</i> utiliza esse quadrante em sua matriz
 * para detectar poss�veis tripulantes.
 * 
 * @author Renato Rodrigues de Mello
 * @version 1.5
 * @since 1.0
 * 
 */
public class Quadrante {
	
	private String [][] area;
	private List<Tripulante> perdidos = new ArrayList<>();
	public static int sinalizadores = 0;

	public Quadrante() {}	
	/**
	 * Recupera o valor informado na principal. Esse m�todo
	 * ser� chamado por uma inst�ncia de <i>Quadrante</i> na
	 * Classe <i>Principal</i>.
	 * @return area
	 */
	public String[][] getArea() {
		return area;
	}
	/**
	 * Armazena valor informado na principal. Ser� 
	 * chamado por uma inst�ncia de <i>Quadrante</i>
	 * pela Classe <i>Principal</i>.
	 * @param area
	 */
	public void setArea(String[][] area) {
		this.area = area;
	}
	/**
	 * Recupera informa��o sobre tripulantes perdidos. Esse
	 * m�todo serve para verificar quantos tripulantes ainda
	 * n�o foram encontrados.
	 * @return
	 */
	public List<Tripulante> getPerdidos() {
		return perdidos;
	}
	/**
	 * Armazena informa��o sobre tripulantes perdidso. Esse
	 * m�todo utiliza uma lista para atualizar quais tripulantes
	 * ainda est�o perdidos.
	 * @param perdidos
	 */
	public void setPerdidos(List<Tripulante> perdidos) {
		this.perdidos = perdidos;
	}
	/**
	 * Metodo respons�vel por vascular a matriz em busca 
	 * de tripulantes. Utilizado pelo m�todo rastreie da 
	 * Classe <i>Principal</i> retornado a busca atualizada.
	 * 
	 * @param ponto
	 * @param tripulantes
	 * @param array
	 * @return
	 */
	public Quadrante encontrarTripulacao(Ponto ponto, List<Tripulante> tripulantes, String[][] array) {
		sinalizadores++;
		Quadrante quadrante = new Quadrante();
		
		for (Tripulante tripulante : tripulantes) {	
			boolean resgatado = false;
			for(Tripulante tripulanteII : tripulantes) {
				if((ponto.getX() == tripulanteII.getX() && ponto.getY() == tripulanteII.getY())
						&& tripulanteII.isResgatado() == false) {
					tripulanteII.setResgatado(true);
					array[ponto.getX()][ponto.getY()] = "X ";
					resgatado = true;
					break;
				}
			}
			if(resgatado == true) break;
			
			if(tripulante.isResgatado() == false){
				if(array[ponto.getX()][ponto.getY()] != "X " && array[ponto.getX()][ponto.getY()] != "! " )
					array[ponto.getX()][ponto.getY()] = "* ";			
				if(ponto.getX()+1 == tripulante.getX() && ponto.getY() == tripulante.getY()) {
					if(array[ponto.getX()+1][ponto.getY()] != "X ") {
						array[ponto.getX()+1][ponto.getY()] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
					}					
				} else {
					if(ponto.getX() != 10)
						if(array[ponto.getX()+1][ponto.getY()] != "X " && array[ponto.getX()+1][ponto.getY()] != "! ")
							array[ponto.getX()+1][ponto.getY()] = "* ";
				}
				if(ponto.getX()-1 == tripulante.getX() && ponto.getY()-1 == tripulante.getY()) {
					if(array[ponto.getX()-1][ponto.getY()] != "X ") {
						array[ponto.getX()-1][ponto.getY()] = "! ";						
						array = quadrante.observaAdjacencias(array, tripulante);
					}
				} else {
					if(array[ponto.getX()-1][ponto.getY()] != "X " && array[ponto.getX()-1][ponto.getY()] != "! ")
						array[ponto.getX()-1][ponto.getY()] = "* ";
				}
				//ponto debaixo			
				if(ponto.getX() == tripulante.getX() && ponto.getY()+1 == tripulante.getY()) {
					if(array[ponto.getX()][ponto.getY()+1] != "X ") {
						array[ponto.getX()][ponto.getY()+1] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
					}
				}else {
					if(ponto.getY() != 10)
						if(array[ponto.getX()][ponto.getY()+1] != "X " && array[ponto.getX()][ponto.getY()+1] != "! ")
							array[ponto.getX()][ponto.getY()+1] = "* ";
				}
				if(ponto.getX()-1 == tripulante.getX() && ponto.getY()+1 == tripulante.getY()) {
					if(array[ponto.getX()-1][ponto.getY()+1] != "X ") {
						array[ponto.getX()-1][ponto.getY()+1] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
					}
				}else {
					if(ponto.getY() != 10 && ponto.getX() != 1)
						if(array[ponto.getX()-1][ponto.getY()+1] != "X " && array[ponto.getX()-1][ponto.getY()+1] != "! ")
							array[ponto.getX()-1][ponto.getY()+1] = "* ";
				}
				if(ponto.getX()+1 == tripulante.getX() && ponto.getY()+1 == tripulante.getY()) {
					if(array[ponto.getX()+1][ponto.getY()+1] !="X ") {
						array[ponto.getX()+1][ponto.getY()+1] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
					}
				} else {
					if(ponto.getY() != 10 && ponto.getX() != 10)
						if(array[ponto.getX()+1][ponto.getY()+1] !="X " && array[ponto.getX()+1][ponto.getY()+1] !="! ")
							array[ponto.getX()+1][ponto.getY()+1] = "* ";
				}
				//ponto acima
				if(ponto.getX() == tripulante.getX() && ponto.getY()-1 == tripulante.getY()) {
					if(array[ponto.getX()][ponto.getY()-1] != "X ") {
						array[ponto.getX()][ponto.getY()-1] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
					}
				}else {
					if(array[ponto.getX()][ponto.getY()-1] != "X " && array[ponto.getX()][ponto.getY()-1] != "! ")
						array[ponto.getX()][ponto.getY()-1] = "* ";
				}
				if(ponto.getX()-1 == tripulante.getX() && ponto.getY()-1 == tripulante.getY()) {
					if(array[ponto.getX()-1][ponto.getY()-1] != "X ")
						array[ponto.getX()-1][ponto.getY()-1] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
				}else {
					if(array[ponto.getX()-1][ponto.getY()-1] != "X " && array[ponto.getX()-1][ponto.getY()-1] != "! ")
					array[ponto.getX()-1][ponto.getY()-1] = "* ";
				}
				if(ponto.getX()+1 == tripulante.getX() && ponto.getY()-1 == tripulante.getY()) {
					if(array[ponto.getX()+1][ponto.getY()-1] != "X ")
						array[ponto.getX()+1][ponto.getY()-1] = "! ";
						array = quadrante.observaAdjacencias(array, tripulante);
				} else {
					if(ponto.getX() !=10)
						if(array[ponto.getX()+1][ponto.getY()-1] != "X " && array[ponto.getX()+1][ponto.getY()-1] != "! ")
							array[ponto.getX()+1][ponto.getY()-1] = "* ";
				}
			}
		}
		
		for(Tripulante tripulante : tripulantes) {
			if(tripulante.isResgatado() != true) {
				quadrante.getPerdidos().add(tripulante);
			}
		}
		
		quadrante.setArea(array);
		return quadrante;
	}
	/**
	 * M�todo respons�vel por verificar adjac�ncias dos tripulantes, quando
	 * um ponto informado pelo usu�rio possui proximidade com o tripulante.
	 * utilizado pelo m�todo encontrarTripula��o da classe <i>Quadrante</i>
	 * @param array
	 * @param tripulante
	 * @return
	 */
	private String[][] observaAdjacencias(String[][] array, Tripulante tripulante) {
		array[tripulante.getX()][tripulante.getY()+1] = "! ";
		array[tripulante.getX()+1][tripulante.getY()+1] = "! ";
		array[tripulante.getX()+1][tripulante.getY()] = "! ";
		
		return array;
	}
}
