package hundirFlotaCarlos;

import java.util.Arrays;

public class TablerosJavi {

	public static void main(String[] args) {
		
		int[][] tableroJ1 = new int[5][5];
		int[][] tableroJ2 = new int[5][5];
		
		//Se rellena el tablero con 0, que es el agua.
		for(int filas = 0 ; filas < tableroJ1.length ; filas++) {
			
			for(int columnas = 0 ; columnas < tableroJ2.length ; columnas++) {
				
				tableroJ1[filas][columnas] = 0;
				tableroJ2[filas][columnas]= 0;
				
			}
		}
		//Se muestran los tableros.
		System.out.println("Tablero 1");
		
		for(int filas = 0 ; filas < tableroJ1.length ; filas++) {
			System.out.println(Arrays.toString(tableroJ1[filas]));
			
		}
		System.out.println("Tablero 2");
		
		for(int filas = 0 ; filas < tableroJ1.length ; filas++) {
			System.out.println(Arrays.toString(tableroJ2[filas]));
			
		}
		
 	}
	
	public static void comprobacionBarcos (int tableroJ1[][] , int tableroJ2[][]) {
		
		int contadorBarcosJ1 = 0;
		int contadorBarcosJ2 = 0;
		
		
		//El programa analiza el tablero en busca de numeros 1, que son los barcos, para contar cuantos quedan
		for(int filas = 0 ; filas < tableroJ1.length ; filas++) {
			
			for(int columnas = 0 ; columnas < tableroJ2.length ; columnas++) {
				
				if(tableroJ1[filas][columnas] == 1) {
					contadorBarcosJ1++;
					
				}
			}
		}
		
		for(int filas = 0 ; filas < tableroJ2.length ; filas++) {
			
			for(int columnas = 0 ; columnas < tableroJ2.length ; filas++) {
				
				if(tableroJ2[filas][columnas] == 1) {
					contadorBarcosJ2++;
					
				}
				
			}
		}
		//Aqui el programa lo que hace es, a partir del resultado de los contadores, decir el numero de barcos
		//que quedan o decir que jugador ha ganado en funcion del numero de barcos que quedan.
		if(contadorBarcosJ1 > 0) {
			
			System.out.println("Al jugador 1 le quedan " + contadorBarcosJ1 + " barcos.");
			
		}else {
			
			System.out.println("Ha ganado el Jugador 2");
			
		}
			
		if(contadorBarcosJ2 > 0) {
			
			System.out.println("Al jugador 2 le quedan " + contadorBarcosJ2 + " barcos.");
			
		}else {
			
			System.out.println("Ha ganado el Jugador 2");
		}
	}
	


}
