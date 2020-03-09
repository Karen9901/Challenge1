package challenge1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Tablero tablero = new Tablero(nivelDificultad(input));

        Jugadores[] jugadores = new Jugadores[numeroJugadores(input)];

        casillasTablero(tablero);
        añadirJugadores(input, jugadores, tablero);

        iniciarJuego(jugadores, tablero, input);

    }

    public static int nivelDificultad(Scanner input) {

        int nivel = 0;

        do {
            try {

                System.out.println("Seleccione el nivel de dificultad: ");
                System.out.println("1) Nivel Basico (20 Posiciones):  \n"
                        + "2) Nivel Intermedio (30 Posiciones):  \n"
                        + "3) Nivel Avanzado (50 Posiciones): ");
                nivel = input.nextInt();
            } catch (Exception e) {
                System.out.print("Seleccione la opción correcta");
                System.out.println(" ");
                input.next();
            }

        } while (!validarNumero(nivel, 1, 3));

        switch (nivel) {
            case 1:
                nivel = 20;
                break;
            case 2:
                nivel = 30;
                break;
            case 3:
                nivel = 50;
                break;
        }

        return nivel;
    }

    public static int numeroJugadores(Scanner input) {

        int jugadores = 0;

        do {
            try {

                System.out.print("Ingresar cantidad de jugadores (De 2 a 4): ");
                jugadores = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Solo Valores de 2 a 4");
                System.out.println(" ");
                input.next();
            }
        } while (!validarNumero(jugadores, 2, 4));

        return jugadores;
    }

    public static boolean validarNumero(int n, int min, int max) {
        boolean res = false;

        if (n >= min && n <= max) {
            res = true;
        }

        return res;
    }

    public static void casillasTablero(Tablero tablero) {

        for (int i = 1; i <= tablero.getNivel(); i++) {
            tablero.añadirCasilla(new Casilla(i));
        }

    }

    public static void añadirJugadores(Scanner input, Jugadores[] jugadores, Tablero tablero) {

        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("Ingrese Nombre Jugador " + (i + 1) + " : ");
            jugadores[i] = new Jugadores(input.next());
            jugadores[i].setPosition(tablero.getHead());
        }
    }

    public static void cambiarPosicion(Jugadores jugador, int n) {

        for (int i = 0; i < n; i++) {
            if (jugador.getPosition().siguiente != null) {
                jugador.setPosition(jugador.getPosition().siguiente);
            } else {
                break;
            }
        }

    }

    public static void iniciarJuego(Jugadores[] jugadores, Tablero tablero, Scanner input) {
        boolean res = false;
        String ganador = "";
        do {
            for (int i = 0; i < jugadores.length; i++) {
                int avance = tablero.lanzarDados(6);

                System.out.println("Turno de : " + jugadores[i].getNombre() + ", Valor de dados: " + avance);

                if (avance % 2 == 0) {
                    jugadores[i].setPares(jugadores[i].getPares() + 1);
                } else {
                    jugadores[i].setPares(0);
                }

                if (jugadores[i].getPosition().siguiente == null || jugadores[i].getPares() == 3) {
                    ganador = jugadores[i].getNombre();
                    res = true;
                    break;
                } else {
                    cambiarPosicion(jugadores[i], avance);
                    System.out.println("Siguiente Tiro (Presiona una tecla");
                    input.nextLine();
                }
            }
        } while (!res);

        System.out.println("Ganador: " + ganador);
    }
}
