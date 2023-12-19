package hundirFlotaCarlos;

import java.util.Scanner;

public class HundirLaFlotaCarlos {

	public static void main(String[] args) {
		
		

		Scanner sc = new Scanner(System.in);
		int filas = 5;
		int columnas = 5;

		// Crear un tablero de 5x5
		int[][] tablero = new int[filas][columnas];

		// Llenar el tablero con valores (solo un ejemplo)
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				tablero[i][j] = 0; // Puedes asignar cualquier valor aquí
			}
		}

		// Mostrar el tablero
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}

		// Ejemplo de selección de coordenada (2, 3)
		System.out.println("Seleccione la fila");
		int filaSeleccionada = sc.nextInt();
		System.out.println("Seleccione la columna");
		int columnaSeleccionada = sc.nextInt();

		if (esCoordenadaValida(tablero, filaSeleccionada, columnaSeleccionada)) {
			int valorSeleccionado = seleccionarCoordenada(tablero, filaSeleccionada, columnaSeleccionada);
			System.out.println("El valor en la coordenada (" + filaSeleccionada + ", " + columnaSeleccionada + ") es: "
					+ valorSeleccionado);
		} else {
			System.out.println("La coordenada seleccionada está fuera del tablero.");
		}
		
		if(seleccionarCoordenada(tablero, filaSeleccionada, columnaSeleccionada)==1) {
			System.out.println("Le has dado a un barco");
		} else {
			System.out.println("Agua");
		}

	}

	// Método para verificar si la coordenada está dentro del tablero
	public static boolean esCoordenadaValida(int[][] tablero, int fila, int columna) {
		return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;
	}

	// Método para seleccionar una coordenada dentro del tablero
	public static int seleccionarCoordenada(int[][] tablero, int fila, int columna) {
		return tablero[fila][columna];
	}

}
