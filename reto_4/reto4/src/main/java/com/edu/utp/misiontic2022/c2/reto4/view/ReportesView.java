package com.edu.utp.misiontic2022.c2.reto4.view;

import java.sql.SQLException;

import com.edu.utp.misiontic2022.c2.reto4.controller.ReportesController;
//import com.edu.utp.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;


public class ReportesView {
    private ReportesController controlador;

    public ReportesView() {
        this.controlador = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco)  {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                    "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            
            try {
               var proyectos = controlador.obtenerProyectosFinanciadosPorBancos(banco);
               proyectos.stream().forEach(System.out::println);
            } catch (SQLException e) {
               System.err.println("ERROR"+e);
                e.printStackTrace();
            }
            
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior)  {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %14s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            
            try {
               var proyectos = controlador.obtenerProyectosPorDeudasNoPagados(limiteInferior);
               proyectos.stream().forEach(System.out::println);
            } catch (SQLException e) {
                System.err.println("ERROR"+e);
                e.printStackTrace();
            }
            
        }
    }

    public void lideresQueMasGastan()  {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %14s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
      
        try {
            var lideres = controlador.obtenerLideresQueMasHanGastado();
            lideres.stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.err.println("ERROR"+e);
            e.printStackTrace();
        }
        
    }

}