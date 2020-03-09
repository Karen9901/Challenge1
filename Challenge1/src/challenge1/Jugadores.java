package challenge1;

public class Jugadores {

    private String nombre;
    private Casilla posicion;
    private int pares;

    public Jugadores(String name) {
        this.nombre = name;
        this.posicion = null;
        this.pares = 0;
    }

    public void setPosition(Casilla n) {
        posicion = n;
    }

    public Casilla getPosition() {
        return posicion;
    }

    public void setPares(int n) {
        pares = n;
    }

    public int getPares() {
        return pares;
    }

    public String getNombre() {
        return nombre;
    }
}
