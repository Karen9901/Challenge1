package challenge1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public static int nivelDificultad(Scanner input) {

        int nivel = 0;

        do {
            try {

                System.out.println("Seleccione el nivel de dificultad: ");
                System.out.println("1) Nivel Basico (20Posiciones) \n"
                        + "2) Nivel Intermedio (30Posiciones \n"
                        + "3) Nivel Avanzado (50Posiciones");
                nivel = input.nextInt();
            } catch (Exception e) {
                System.out.print("Seleccione la opción correcta");
                System.out.println(" ");
                input.next();
            }

        } while (nivel <= 3 && nivel >= 1);

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
            } catch (InputMismatchException ime){
            System.out.print("Solo Valores de 2 a 4");
            System.out.println(" ");
            input.next();
            }
        } while (jugadores<=4 && jugadores>=2);
    
        return jugadores;
    }

}
