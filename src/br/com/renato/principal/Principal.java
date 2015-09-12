package br.com.renato.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.renato.model.Tripulante;
import br.com.renato.recurso.Ponto;
import br.com.renato.recurso.Quadrante;

/**
 * A classe <code>Principal</code> é responsável por controlar 
 * o sistema, utiliza as classes <i>Tripulante</i>, <i>Quadrante</i>
 * como recursos para varrer uma matriz 10x10 e encontrar os tripulantes
 * perdidos. 
 * 
 * @author Renato Rodrigues de Mello
 * @version 1.5
 * @since 1.0
 * 
 * @see Ponto
 * @see Tripulante
 * @see Quadrante
 */

public class Principal {
	/**
	 * Método responsável pela ignição do sistema, nele
	 * ocorre o controle de variavéis locais e instâncias
	 * para criação do programa.
	 * @param args
	 */
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
		
		System.out.println("           Systema de Busca StarTrek               ");
		System.out.println("Digite as coodernadas para encontrar os tripulantes");
		imprimirMatriz(espaco);		
		
		rastreie(sc, quadrante, espaco, tripulantes);
		System.out.print("\n");
		
		System.out.println("Todos os tripulantes foram encontrados com " + Quadrante.sinalizadores + " sinalizadores");		
	}
	/**
	 * Método responsável por rastrear a matriz e vasculhar as adjacencias 
	 * dos pontos informados pelo usuário. 	 * 
	 * @param sc
	 * @param quadrante
	 * @param espaco
	 * @param tripulantes
	 */
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
	/**
	 * Método responsável por criar tripulantes
	 * @param x
	 * @param y
	 * @return
	 */
	private static Tripulante criaTripulantes(int x, int y) {
		Tripulante tripulante = new Tripulante();
		tripulante.setX(x);
		tripulante.setY(y);
		return tripulante;
	}
	/**
	 * Método responsável por receber a coordenada Y.
	 * @param sc
	 * @return
	 */
	private static int leiaY(Scanner sc) {
		
		System.out.println("Informe as coordenadas do eixo X: " );
		int pontoY = sc.nextInt();
		return pontoY;
	}
	/**
	 * Método responsável por receber a coordenada X.
	 * @param sc
	 * @return
	 */
	private static int leiaX(Scanner sc) {
		
		System.out.println("Informe as coordenadas do eixo Y: " );
		int pontoX = sc.nextInt();
		return pontoX;
	}
	/**
	 * Método responsável por imprimir uma matriz sem valor
	 * @param quadrante
	 */
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
	/**
	 * Método responsável por imprimir uma matriz com valores digitados
	 * e processados pelo sistema.
	 * @param quadrante
	 */
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
