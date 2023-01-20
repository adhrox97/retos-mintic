package co.edu.utp.misiontic2022.reto2.p45;
public class PrecioTotal {
    private Double totalComputadores = 0.0;
    private Double totalComputadoresPortatiles = 0.0;
    private Double totalComputadoresMesa = 0.0;
    private Computadores[] listaComputadores;

    // Constructor
    PrecioTotal(Computadores[] pComputadores) {
        this.listaComputadores = pComputadores;
    }

    public void mostrarTotales() {
        ComputadoresPortatiles objP = new ComputadoresPortatiles();
        ComputadoresMesa objM = new ComputadoresMesa();

        for(int i = 0; i < listaComputadores.length; i++){
            Computadores computador = listaComputadores[i];
            if(computador.getClass() == objP.getClass()){
                totalComputadoresPortatiles += computador.calcularPrecio();
            }else if(computador.getClass() == objM.getClass()){
                totalComputadoresMesa += computador.calcularPrecio();
            }
            totalComputadores += computador.calcularPrecio();
            
        }
        
        // Mostramos los resultados
        System.out.println("La suma del precio de los computadores es de " + totalComputadores);
        System.out.println("La suma del precio de los computadores de mesa es de " + totalComputadoresMesa);
        System.out.print("La suma del precio de los computadores portátiles es de " + totalComputadoresPortatiles);
    }
}
