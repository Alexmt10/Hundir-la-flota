package hundirFlotaCarlos;

import java.util.Arrays;
import java.util.Scanner;

public class HundirLaFlotaFuncional {

	public static void main(String[] args) {

		int[][] tableroJ1 = new int[5][5];
		int[][] tableroJ2 = new int[5][5];
		int contadorBarcosJ1 = 3;
		int contadorBarcosJ2 = 3;
		Scanner sc = new Scanner(System.in);

		// Se rellena el tablero con 0, que es el agua.
		for (int filas = 0; filas < tableroJ1.length; filas++) {

			for (int columnas = 0; columnas < tableroJ2.length; columnas++) {

				tableroJ1[filas][columnas] = 0;
				tableroJ2[filas][columnas] = 0;

			}
		}

		posicionbarcos1(tableroJ1);
		posicionbarcos2(tableroJ2);
		
		boolean[][] coordenadasSeleccionadasJ1 = new boolean[5][5];
		boolean[][] coordenadasSeleccionadasJ2 = new boolean[5][5];

		do {

			System.out.println("Tablero 1");

			for (int filas = 0; filas < tableroJ1.length; filas++) {
				System.out.println(Arrays.toString(tableroJ1[filas]));

			}
			System.out.println("Tablero 2");

			for (int filas = 0; filas < tableroJ2.length; filas++) {
				System.out.println(Arrays.toString(tableroJ2[filas]));

			}
			System.out.println();
			System.out.println("Turno del Jugador 1");
			System.out.println("Seleccione la fila");
			int filaSeleccionada = sc.nextInt();
			System.out.println("Seleccione la columna");
			int columnaSeleccionada = sc.nextInt();
			
			while (coordenadasSeleccionadasJ1[filaSeleccionada][columnaSeleccionada]) {
			        System.out.println("Ya has seleccionado esta coordenada. Elige otra.");
			        System.out.println("Seleccione la fila");
			        filaSeleccionada = sc.nextInt();
			        System.out.println("Seleccione la columna");
			        columnaSeleccionada = sc.nextInt();
			    }
			    coordenadasSeleccionadasJ1[filaSeleccionada][columnaSeleccionada] = true;

			if (esCoordenadaValida(tableroJ2, filaSeleccionada, columnaSeleccionada)) {
				int valorSeleccionado = seleccionarCoordenada(tableroJ1, filaSeleccionada, columnaSeleccionada);
				System.out.println("El valor en la coordenada (" + filaSeleccionada + ", " + columnaSeleccionada
						+ ") es: " + valorSeleccionado);
			} else {
				System.out.println("La coordenada seleccionada está fuera del tablero.");
			}
			if (seleccionarCoordenada(tableroJ2, filaSeleccionada, columnaSeleccionada) == 1) {
				System.out.println("Le has dado a un barco");
				tableroJ2[filaSeleccionada][columnaSeleccionada]=0;
				contadorBarcosJ2--;
			} else {
				System.out.println("Agua");
			}
			if (contadorBarcosJ2 > 0) {

				System.out.println("Al jugador 2 le quedan " + contadorBarcosJ2 + " barcos.");

			} else {

				System.out.println("Ha ganado el Jugador 1");
				break;
			}

			System.out.println();
			System.out.println("Turno del Jugador 2");

			System.out.println("Seleccione la fila");
			int filaSeleccionada2 = sc.nextInt();
			System.out.println("Seleccione la columna");
			int columnaSeleccionada2 = sc.nextInt();
			
			while (coordenadasSeleccionadasJ2[filaSeleccionada2][columnaSeleccionada2]) {
		        System.out.println("Ya has seleccionado esta coordenada. Elige otra.");
		        System.out.println("Seleccione la fila");
		        filaSeleccionada2 = sc.nextInt();
		        System.out.println("Seleccione la columna");
		        columnaSeleccionada2 = sc.nextInt();
		    }
		    coordenadasSeleccionadasJ2[filaSeleccionada2][columnaSeleccionada2] = true;

			if (esCoordenadaValida(tableroJ1, filaSeleccionada, columnaSeleccionada)) {
				int valorSeleccionado2 = seleccionarCoordenada(tableroJ1, filaSeleccionada2, columnaSeleccionada2);
				System.out.println("El valor en la coordenada (" + filaSeleccionada2 + ", " + columnaSeleccionada2
						+ ") es: " + valorSeleccionado2);
			} else {
				System.out.println("La coordenada seleccionada está fuera del tablero.");
			}
			if (seleccionarCoordenada(tableroJ1, filaSeleccionada2, columnaSeleccionada2) == 1) {
				System.out.println("Le has dado a un barco");
				tableroJ1[filaSeleccionada2][columnaSeleccionada2]=0;
				contadorBarcosJ1--;
			} else {
				System.out.println("Agua");
			}
			if (contadorBarcosJ1 > 0) {

				System.out.println("Al jugador 1 le quedan " + contadorBarcosJ1 + " barcos.");

			} else {

				System.out.println("Ha ganado el Jugador 2");
				break;

			}

		} while (contadorBarcosJ1 > 0 && contadorBarcosJ2 > 0);
	}

	// METODOOOOOOOOOOOOOOOOOS

	public static void comprobacionBarcos(int tableroJ1[][], int tableroJ2[][]) {

		int contadorBarcosJ1 = 0;
		int contadorBarcosJ2 = 0;

		// El programa analiza el tablero en busca de numeros 1, que son los barcos,
		// para contar cuantos quedan
		for (int filas = 0; filas < tableroJ1.length; filas++) {

			for (int columnas = 0; columnas < tableroJ1.length; columnas++) {

				if (tableroJ1[filas][columnas] == 1) {
					contadorBarcosJ1++;

				}
			}
		}

		for (int filas = 0; filas < tableroJ2.length; filas++) {

			for (int columnas = 0; columnas < tableroJ2.length; filas++) {

				if (tableroJ2[filas][columnas] == 1) {
					contadorBarcosJ2++;

				}

			}
		}
		// Aqui el programa lo que hace es, a partir del resultado de los contadores,
		// decir el numero de barcos
		// que quedan o decir que jugador ha ganado en funcion del numero de barcos que
		// quedan.
		if (contadorBarcosJ1 > 0) {

			System.out.println("Al jugador 1 le quedan " + contadorBarcosJ1 + " barcos.");

		} else {

			System.out.println("Ha ganado el Jugador 2");

		}

		if (contadorBarcosJ2 > 0) {

			System.out.println("Al jugador 2 le quedan " + contadorBarcosJ2 + " barcos.");

		} else {

			System.out.println("Ha ganado el Jugador 2");
		}

	}

	public static void posicionbarcos1(int[][] tablero) {
		var sc = new Scanner(System.in);

		System.out.println("Selecciona la posición donde quieres colocar tus barcos jugador 1");

		boolean coordenadasValidas = false;
		int barcos = 0;

		while (barcos < 3) {
			System.out.println("Selecciona la columna (entre 0 y 4): ");
			int numcolumnas1 = sc.nextInt();

			System.out.println("Selecciona la fila (entre 0 y 4): ");
			int numfilas1 = sc.nextInt();

			if (esPosicionValida(tablero, numfilas1, numcolumnas1)) {
				// Verificar que la posición y alrededores no estén ocupadas
				if (!posicionOcupada(tablero, numfilas1, numcolumnas1)
						&& !posicionOcupadaAlrededorj1(tablero, numfilas1, numcolumnas1)) {
					colocarBarco(tablero, numfilas1, numcolumnas1);
					barcos++;
					System.out.println("Introduce las coordenadas del siguiente barco");
				} else {
					System.out.println(
							"La posición o las posiciones alrededor están ocupadas. Vuelve a introducir las coordenadas.");
				}
			} else {
				System.out.println("Coordenadas fuera del rango. Vuelve a introducir las coordenadas.");
			}
		}

		System.out.println("Ya has introducido tus tres barcos. Turno del próximo jugador");
	}

	public static void posicionbarcos2(int[][] tablero) {
		var sc = new Scanner(System.in);

		System.out.println("Selecciona la posición donde quieres colocar tus barcos jugador 2");

		boolean coordenadasValidas = false;
		int barcos = 0;

		while (barcos < 3) {
			System.out.println("Selecciona la columna (entre 0 y 4): ");
			int numcolumnas2 = sc.nextInt();

			System.out.println("Selecciona la fila (entre 0 y 4): ");
			int numfilas2 = sc.nextInt();

			if (esPosicionValida(tablero, numfilas2, numcolumnas2)) {
				// Verificar que la posición y alrededores no estén ocupadas
				if (!posicionOcupada(tablero, numfilas2, numcolumnas2)
						&& !posicionOcupadaAlrededorj2(tablero, numfilas2, numcolumnas2)) {
					colocarBarco(tablero, numfilas2, numcolumnas2);
					barcos++;
					System.out.println("Introduce las coordenadas del siguiente barco");
				} else {
					System.out.println(
							"La posición o las posiciones alrededor están ocupadas. Vuelve a introducir las coordenadas.");
				}
			} else {
				System.out.println("Coordenadas fuera del rango. Vuelve a introducir las coordenadas.");
			}
		}

		System.out.println("Ya has introducido tus tres barcos. Empieza la partida a hundir los barcos.");
	}

	public static boolean esPosicionValida(int[][] tablero, int fila, int columna) {
		return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length;

	}

	public static boolean posicionOcupada(int[][] tablero, int fila, int columna) {
		return tablero[fila][columna] == 1;
	}

	public static boolean posicionOcupadaAlrededorj1(int[][] tablero, int fila, int columna) {
		// Verificar posiciones adyacentes y diagonales
		return esPosicionValida(tablero, fila - 1, columna) && posicionOcupada(tablero, fila - 1, columna)
				|| esPosicionValida(tablero, fila + 1, columna) && posicionOcupada(tablero, fila + 1, columna)
				|| esPosicionValida(tablero, fila, columna - 1) && posicionOcupada(tablero, fila, columna - 1)
				|| esPosicionValida(tablero, fila, columna + 1) && posicionOcupada(tablero, fila, columna + 1)
				|| esPosicionValida(tablero, fila - 1, columna - 1) && posicionOcupada(tablero, fila - 1, columna - 1)
				|| esPosicionValida(tablero, fila - 1, columna + 1) && posicionOcupada(tablero, fila - 1, columna + 1)
				|| esPosicionValida(tablero, fila + 1, columna - 1) && posicionOcupada(tablero, fila + 1, columna - 1)
				|| esPosicionValida(tablero, fila + 1, columna + 1) && posicionOcupada(tablero, fila + 1, columna + 1);
	}

	public static boolean posicionOcupadaAlrededorj2(int[][] tableroj2, int fila, int columna) {
		// Verificar posiciones adyacentes y diagonales
		return esPosicionValida(tableroj2, fila - 1, columna) && posicionOcupada(tableroj2, fila - 1, columna)
				|| esPosicionValida(tableroj2, fila + 1, columna) && posicionOcupada(tableroj2, fila + 1, columna)
				|| esPosicionValida(tableroj2, fila, columna - 1) && posicionOcupada(tableroj2, fila, columna - 1)
				|| esPosicionValida(tableroj2, fila, columna + 1) && posicionOcupada(tableroj2, fila, columna + 1)
				|| esPosicionValida(tableroj2, fila - 1, columna - 1)
						&& posicionOcupada(tableroj2, fila - 1, columna - 1)
				|| esPosicionValida(tableroj2, fila - 1, columna + 1)
						&& posicionOcupada(tableroj2, fila - 1, columna + 1)
				|| esPosicionValida(tableroj2, fila + 1, columna - 1)
						&& posicionOcupada(tableroj2, fila + 1, columna - 1)
				|| esPosicionValida(tableroj2, fila + 1, columna + 1)
						&& posicionOcupada(tableroj2, fila + 1, columna + 1);
	}

	public static void colocarBarco(int[][] tablero, int fila, int columna) {
		tablero[fila][columna] = 1;
		System.out.println("Barco colocado en la posición (" + fila + ", " + columna + ")");
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