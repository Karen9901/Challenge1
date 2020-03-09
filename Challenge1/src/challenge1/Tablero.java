
package challenge1;

public class Tablero {

    private int nivel;
    private static Casilla head;

    public Tablero(int n) {
        this.nivel = n;
    }

    public void añadirCasilla(Casilla n) {
        Casilla aux = head;
        if (head == null) {
            head = n;
        } else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = n;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int n) {
        this.nivel = n;
    }

    public Casilla getHead() {
        return head;
    }

    public int lanzarDados(int max) {

        int dado = (int) (Math.random() * max) + 1;

        return dado;
    }

    public boolean verificarGanador(Jugadores jugador) {
        boolean res = false;

        if (jugador.getPosition().siguiente == null) {
            res = true;
        }

        return res;
    }

}
