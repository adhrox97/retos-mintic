package co.edu.utp.misiontic2022.reto2.p45;
public class ComputadoresMesa extends Computadores {
    private final static Integer ALMACENAMIENTO_BASE = 50; 
    //ATRIBUTO
    private int almacenamiento;
    // Constructor

    public ComputadoresMesa() {
        this.almacenamiento = ALMACENAMIENTO_BASE;
    }

    // Constructor
    public ComputadoresMesa(Double precioBase, Integer peso) {
        super(precioBase, peso);
        this.almacenamiento = ALMACENAMIENTO_BASE;
    }

    // Constructor
    public ComputadoresMesa(Double precioBase, Integer peso, char consumoW, Integer almacenamiento) {
        super(precioBase, peso, consumoW);
        this.almacenamiento = almacenamiento;
    }

    // Métodos
    public Double calcularPrecio() { 
        double precio = super.calcularPrecio();
        if(almacenamiento > 100){
            precio += ALMACENAMIENTO_BASE;
        }
        return precio;
    }

    public Integer getCarga() {
        return almacenamiento;
    }
} 
