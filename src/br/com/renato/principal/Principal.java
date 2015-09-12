package br.com.renato.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.renato.model.Tripulante;
import br.com.renato.recurso.Ponto;
import br.com.renato.recurso.Quadrante;

public class Principal {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);		
		Quadrante quadrante = new Quadrante();			
		String[][] espaco = new String[11][11];
		
		List<Tripulante> tripulantes = new ArrayList<Tripulante>();
		Tripulante tripulante = criaTripulantes(3,3);
		tripulantes.add(tripulante);
		Tripulante tripulante2 = criaTripulantes(4,7);
		tripulantes.add(tripulante2);
		Tripulante tripulante3 = criaTripulantes(9,9);	
		tripulantes.add(tripulante3);
		
		
		imprimirMatriz(espaco);		
		
		rastreie(sc, quadrante, espaco, tripulantes);
		System.out.print("\n");
		
		System.out.println("Todos os tripulantes foram encontrados com " + Quadrante.sinalizadores + " sinalizadores");		
	}

	private static void rastreie(Scanner sc, Quadrante quadrante, String[][] espaco, List<Tripulante> tripulantes) {
		Quadrante quadranteTemp = new Quadrante();
		while(!tripulantes.isEmpty()) {			
			int pontoX = leiaX(sc);
			while(pontoX > 10 || pontoX < 1) {
				System.out.println("Coordenada Y fora do Quadrante");
				pontoX = leiaX(sc);
			}
			int pontoY = leiaY(sc);	
			while(pontoY > 10 || pontoY < 1) {
				System.out.println("Coordenada X fora do Quadrante");
				pontoY = leiaY(sc);
			}
			
			Ponto ponto = new Ponto(pontoX, pontoY);		
			quadranteTemp = quadrante.encontrarTripulacao(ponto, tripulantes, espaco);
			
			tripulantes.removeAll(tripulantes);
			tripulantes.addAll(quadranteTemp.getPerdidos());
			espaco = quadranteTemp.getArea();
			
			imprimirMatrizComValores(quadranteTemp.getArea());
		}
	}

	private static Tripulante criaTripulantes(int x, int y) {
		Tripulante tripulante = new Tripulante();
		tripulante.setX(x);
		tripulante.setY(y);
		return tripulante;
	}

	private static int leiaY(Scanner sc) {
		
		System.out.println("Informe as coordenadas do eixo X: " );
		int pontoY = sc.nextInt();
		return pontoY;
	}

	private static int leiaX(Scanner sc) {
		
		System.out.println("Informe as coordenadas do eixo Y: " );
		int pontoX = sc.nextInt();
		return pontoX;
	}

	private static void imprimirMatriz(String[][] quadrante) {
		System.out.print("////////////////////////////////// - X");
		System.out.print("\n");
		System.out.print("   ");
		for(int i = 1; i < quadrante.length; i++) {
			System.out.print(i + "  ");
		}
		System.out.print("\n");
		for (int i = 1; i < quadrante.length; i++) {
			System.out.print( i + "  ");
			for (int j = 1; j < quadrante.length; j++) {
				quadrante[i][j] = " " + " ";
				System.out.print(quadrante[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("Y - //////////////////////////////////");
		System.out.print("\n\n");
	}
	
	private static void imprimirMatrizComValores(String[][] quadrante) {
		System.out.print("////////////////////////////////// - X");
		System.out.print("\n");
		System.out.print("   ");
		for(int i = 1; i < quadrante.length; i++) {	
			System.out.print(i + "  ");//x		
		}
		System.out.print("\n");
		for (int i = 1; i < quadrante.length; i++) {
			if(i == 10) System.out.print(i + " ");
			else System.out.print( i + "  ");
			for (int j = 1; j < quadrante.length; j++) {
				System.out.print(quadrante[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("Y - //////////////////////////////////");
		System.out.print("\n\n");
	}

}
