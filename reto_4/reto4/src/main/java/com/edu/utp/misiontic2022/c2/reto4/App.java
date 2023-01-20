package com.edu.utp.misiontic2022.c2.reto4;

//import java.sql.SQLException;

//import com.edu.utp.misiontic2022.c2.reto4.model.dao.ProyectoBancoDao;
import com.edu.utp.misiontic2022.c2.reto4.view.ReportesView;

public class App 
{
    public static void main( String[] args )
    {
     
       

            var reportesView = new ReportesView();
            var banco = "Conavi";
            reportesView.proyectosFinanciadosPorBanco(banco);

            var limiteInferior = 50_000d;
            reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);

            reportesView.lideresQueMasGastan();

    }
}