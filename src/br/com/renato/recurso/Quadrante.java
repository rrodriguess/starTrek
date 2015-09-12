package br.com.renato.recurso;

import java.util.ArrayList;
import java.util.List;

import br.com.renato.model.Tripulante;
/**
 * Um <code>Quadrante</code> representa as adjacências de um
 * determinado <i>Ponto</i> informado pelo usuario do sistema.
 * A classe <i>Principal</i> utiliza esse quadrante em sua matriz
 * para detectar possíveis tripulantes.
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
	 * Recupera o valor informado na principal. Esse método
	 * será chamado por uma instância de <i>Quadrante</i> na
	 * Classe <i>Principal</i>.
	 * @return area
	 */
	public String[][] getArea() {
		return area;
	}
	/**
	 * Armazena valor informado na principal. Será 
	 * chamado por uma instância de <i>Quadrante</i>
	 * pela Classe <i>Principal</i>.
	 * @param area
	 */
	public void setArea(String[][] area) {
		this.area = area;
	}
	/**
	 * Recupera informação sobre tripulantes perdidos. Esse
	 * método serve para verificar quantos tripulantes ainda
	 * não foram encontrados.
	 * @return
	 */
	public List<Tripulante> getPerdidos() {
		return perdidos;
	}
	/**
	 * Armazena informação sobre tripulantes perdidso. Esse
	 * método utiliza uma lista para atualizar quais tripulantes
	 * ainda estão perdidos.
	 * @param perdidos
	 */
	public void setPerdidos(List<Tripulante> perdidos) {
		this.perdidos = perdidos;
	}
	/**
	 * Metodo responsável por vascular a matriz em busca 
	 * de tripulantes. Utilizado pelo método rastreie da 
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
	 * Método responsável por verificar adjacências dos tripulantes, quando
	 * um ponto informado pelo usuário possui proximidade com o tripulante.
	 * utilizado pelo método encontrarTripulação da classe <i>Quadrante</i>
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
