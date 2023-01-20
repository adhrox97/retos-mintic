package co.edu.utp.misiontic2022.reto2.p45;
public class ComputadoresPortatiles extends Computadores {
    private final static Integer PULGADAS_BASE = 20;
    private Integer pulgadas;
    private boolean camaraITG;

    // Constructor
    public ComputadoresPortatiles() {
            this.pulgadas = PULGADAS_BASE;
            this.camaraITG = false;
    }

    // Constructor
    public ComputadoresPortatiles(Double precioBase, Integer peso) {
            super(precioBase, peso);
            this.pulgadas = PULGADAS_BASE;
            this.camaraITG = false;
    }

    // Constructor
    public ComputadoresPortatiles(Double precioBase, Integer peso, char consumoW, Integer pulgadas,
                    boolean camaraITG) {
            super(precioBase, peso, consumoW);
            this.pulgadas = pulgadas;
            this.camaraITG = camaraITG;
    }

    // Métodos
    public Double calcularPrecio() {
            double precio = super.calcularPrecio();
            if(pulgadas > 40){
                    precio += (super.getPrecioBase() * 0.3);
            }
            if(camaraITG){
                    precio += 50;
            }
            return precio;
    }
}
