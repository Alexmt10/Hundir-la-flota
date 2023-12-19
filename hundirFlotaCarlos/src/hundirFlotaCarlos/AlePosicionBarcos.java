package hundirFlotaCarlos;

import java.util.Arrays;
import java.util.Scanner;

public class AlePosicionBarcos {
    public static void main(String[] args) {
        int[][] tableroJ1 = new int[5][5];
        int[][] tableroJ2 = new int[5][5];

        for (int i = 0; i < 5; i++) {
            Arrays.fill(tableroJ1[i], 0);
        }

        System.out.println("Contenido de la tabla jugador 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(tableroJ1[i]));
        }

        posicionbarcos1(tableroJ1);
        
        System.out.println("Contenido de la tabla jugador 2:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(tableroJ2[i]));
        }
        
        
        posicionbarcos2(tableroJ2);
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
                if (!posicionOcupada(tablero, numfilas1, numcolumnas1) &&
                    !posicionOcupadaAlrededorj1(tablero, numfilas1, numcolumnas1)) {
                    colocarBarco(tablero, numfilas1, numcolumnas1);
                    barcos++;
                    System.out.println("Introduce las coordenadas del siguiente barco");
                } else {
                    System.out.println("La posición o las posiciones alrededor están ocupadas. Vuelve a introducir las coordenadas.");
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
                if (!posicionOcupada(tablero, numfilas2, numcolumnas2) &&
                    !posicionOcupadaAlrededorj2(tablero, numfilas2, numcolumnas2)) {
                    colocarBarco(tablero, numfilas2, numcolumnas2);
                    barcos++;
                    System.out.println("Introduce las coordenadas del siguiente barco");
                } else {
                    System.out.println("La posición o las posiciones alrededor están ocupadas. Vuelve a introducir las coordenadas.");
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
        return esPosicionValida(tablero, fila - 1, columna) && posicionOcupada(tablero, fila - 1, columna) ||
                esPosicionValida(tablero, fila + 1, columna) && posicionOcupada(tablero, fila + 1, columna) ||
                esPosicionValida(tablero, fila, columna - 1) && posicionOcupada(tablero, fila, columna - 1) ||
                esPosicionValida(tablero, fila, columna + 1) && posicionOcupada(tablero, fila, columna + 1) ||
                esPosicionValida(tablero, fila - 1, columna - 1) && posicionOcupada(tablero, fila - 1, columna - 1) ||
                esPosicionValida(tablero, fila - 1, columna + 1) && posicionOcupada(tablero, fila - 1, columna + 1) ||
                esPosicionValida(tablero, fila + 1, columna - 1) && posicionOcupada(tablero, fila + 1, columna - 1) ||
                esPosicionValida(tablero, fila + 1, columna + 1) && posicionOcupada(tablero, fila + 1, columna + 1);
    }
    public static boolean posicionOcupadaAlrededorj2(int[][] tableroj2, int fila, int columna) {
        // Verificar posiciones adyacentes y diagonales
        return esPosicionValida(tableroj2, fila - 1, columna) && posicionOcupada(tableroj2, fila - 1, columna) ||
                esPosicionValida(tableroj2, fila + 1, columna) && posicionOcupada(tableroj2, fila + 1, columna) ||
                esPosicionValida(tableroj2, fila, columna - 1) && posicionOcupada(tableroj2, fila, columna - 1) ||
                esPosicionValida(tableroj2, fila, columna + 1) && posicionOcupada(tableroj2, fila, columna + 1) ||
                esPosicionValida(tableroj2, fila - 1, columna - 1) && posicionOcupada(tableroj2, fila - 1, columna - 1) ||
                esPosicionValida(tableroj2, fila - 1, columna + 1) && posicionOcupada(tableroj2, fila - 1, columna + 1) ||
                esPosicionValida(tableroj2, fila + 1, columna - 1) && posicionOcupada(tableroj2, fila + 1, columna - 1) ||
                esPosicionValida(tableroj2, fila + 1, columna + 1) && posicionOcupada(tableroj2, fila + 1, columna + 1);
    }


    public static void colocarBarco(int[][] tablero, int fila, int columna) {
        tablero[fila][columna] = 1; 
        System.out.println("Barco colocado en la posición (" + fila + ", " + columna + ")");
    }
