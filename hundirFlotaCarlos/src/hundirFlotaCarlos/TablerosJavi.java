package hundirFlotaCarlos;

import java.util.Arrays;

public class TablerosJavi {

	public static void main(String[] args) {
		
		int[][] tableroJ1 = new int[5][5];
		int[][] tableroJ2 = new int[5][5];
		
		for(int filas = 0 ; filas < tableroJ1.length ; filas++) {
			
			for(int columnas = 0 ; columnas < tableroJ2.length ; columnas++) {
				
				tableroJ1[filas][columnas] = 0;
				tableroJ2[filas][columnas]= 0;
				
			}
		}
		System.out.println(Arrays.deepToString(tableroJ2));
		System.out.println(Arrays.deepToString(tableroJ1));
		
 	}

}
