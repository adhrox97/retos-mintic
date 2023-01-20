package co.edu.utp.misiontic2022.reto1.p45;

public class BecaUniversitaria {

    // Atributos
    private int pTiempo;
    private double pMonto;
    private double pInteres;
  
    // Constructores
    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres){

        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
    }

    public BecaUniversitaria(){
        this.pTiempo = 0;
        this.pMonto = 0.0;
        this.pInteres = 0.0;
    }

    // Métodos
    //
    public double calcularInteresSimple( ){
        double interesSimple = Math.round( pMonto * (pInteres/100) * pTiempo );
        return interesSimple;

    }
    public double calcularInteresCompuesto( ){
        double resultado = Math.pow((1+ (pInteres/100)), pTiempo);
        double interesCompuesto =  Math.round(pMonto * ( resultado - 1 )) ;
        return  interesCompuesto;

    }
    public String compararInversion (int pTiempo, double pMonto, double
        pInteres){
            this.pTiempo = pTiempo;
            this.pMonto = pMonto;
            this.pInteres = pInteres;
            double diferencia = calcularInteresCompuesto() - calcularInteresSimple();
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
    
    }
    public String compararInversion ( ){
        if(pInteres == 0 && pTiempo == 0 && pMonto == 0){
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }
        else{
            double diferencia = calcularInteresCompuesto() - calcularInteresSimple();
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }
    }

    //Sección principal: Instanciación de clase y uso de métodos.
    //Importante: En la plataforma de iMaster se sube esta clase SIN MAIN.
    //Se indica esta sección para probar localmente antes de someter a revisión.

    public static void main(String[] args) {
    // Llamados para verificar con los casos de prueba el funcionamiento de la clase

    }
}