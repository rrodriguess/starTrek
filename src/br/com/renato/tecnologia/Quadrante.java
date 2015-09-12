package br.com.renato.tecnologia;

import java.util.ArrayList;
import java.util.List;

import br.com.renato.objetivo.Tripulante;

public class Quadrante {
	
	private String [][] area;
	private List<Tripulante> perdidos = new ArrayList<>();
	public static int sinalizadores = 0;

	public Quadrante() {}	
	
	public String[][] getArea() {
		return area;
	}

	public void setArea(String[][] area) {
		this.area = area;
	}
	
	public List<Tripulante> getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(List<Tripulante> perdidos) {
		this.perdidos = perdidos;
	}
	
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

	private String[][] observaAdjacencias(String[][] array, Tripulante tripulante) {
		array[tripulante.getX()][tripulante.getY()+1] = "! ";
		array[tripulante.getX()+1][tripulante.getY()+1] = "! ";
		array[tripulante.getX()+1][tripulante.getY()] = "! ";
		
		return array;
	}
}
