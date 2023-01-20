package co.edu.utp.misiontic2022.reto2.p45;
public class Computadores {
    // CONSTANTES
    private final static double PRECIO_BASE = 100.0;
    private final static char CONSUMO_W = 'F';
    private final static int PESO_BASE = 5;
    // ATRIBUTOS
    private int peso;
    private char consumoW;
    private double precioBase;

    // CONSTRUCTORES
    public Computadores() {
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
    }

    public Computadores(Double precioBase, Integer peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoW = CONSUMO_W;
    }

    public Computadores(Double precioBase, Integer peso, char consumoW) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoW = consumoW;
    }

    // CONSULTORES
    public int getPeso() {
        return peso;
    }

    public char getConsumoW() {
        return consumoW;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    // MODIFICADORES
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setConsumoW(char consumoW) {
        this.consumoW = consumoW;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    // ACCIONES
    // Metodos
    public double calcularConsumoW() {
        double respuesta = 0;
        switch (consumoW) {
            case 'A':
                respuesta = 100;
                break;
            case 'B':
                respuesta = 80;
                break;
            case 'C':
                respuesta = 60;
                break;
            case 'D':
                respuesta = 50;
                break;
            case 'E':
                respuesta = 30;
                break;
            case 'F':
                respuesta = 10;
                break;
        }

        return respuesta;
    }

    public Double calcularPrecio() {
        Double adicion = calcularConsumoW() + calcularAdicionPeso();
        Double precioTotal = precioBase + adicion;
        return precioTotal;
    }

    public Double calcularAdicionPeso() {
        double respuesta = 0.0;
        if (peso >= 0 && peso < 19) {
            respuesta = 10;
        } else if (peso >= 20 && peso < 49) {
            respuesta = 50;
        } else if (peso >= 50 && peso <= 79) {
            respuesta = 80;
        } else if (peso >= 80) {
            respuesta = 100;
        }

        return respuesta;
    }
}

