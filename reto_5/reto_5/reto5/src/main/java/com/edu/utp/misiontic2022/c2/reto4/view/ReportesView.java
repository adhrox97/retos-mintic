package com.edu.utp.misiontic2022.c2.reto4.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

import com.edu.utp.misiontic2022.c2.reto4.controller.ReportesController;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.*;


public class ReportesView extends JFrame implements ActionListener{
    private ReportesController controlador;
    private JButton boton1,boton2,boton3;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controlador = new ReportesController();
        
        botones();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void botones(){

        boton1=new JButton("Informe 1");
        boton1.setBounds(10,100,90,30);
        add(boton1);
        boton1.addActionListener(this);
        boton2=new JButton("Informe 2");
        boton2.setBounds(110,100,90,30);
        add(boton2);
        boton2.addActionListener(this);
        boton3=new JButton("Informe 3");
        boton3.setBounds(210,100,90,30);
        add(boton3);
        boton3.addActionListener(this);

    }

    public void tabla(){
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(700,370));
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);   
    }

    public void etiqueta1(){
        lblTitulo = new JLabel("RETO 5");
        lblTitulo.setPreferredSize(new Dimension(700, 50));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }
    public void etiqueta2(){
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(700, 50)); 
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);
    }

    public void segundoInforme() {
        try{
            List<ProyectoBancoVo> proyectos = controlador.obtenerProyectosFinanciadosPorBancos();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");
            for(ProyectoBancoVo proyecto: proyectos){
                Object[] fila = new Object[4];
                fila[0]= proyecto.getId();
                fila[1]= proyecto.getConstructora();
                fila[2]= proyecto.getHabitaciones();
                fila[3]= proyecto.getCiudad();   
                modelo.addRow(fila);                 
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
            
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
    
}
public void tercerInforme() {
        try{
            List<DeudasPorProyectoVo> compras = controlador.obtenerProyectosPorDeudasNoPagados();
            modelo = new DefaultTableModel();
            modelo.addColumn("Id compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco Vinculado");
            
            for(DeudasPorProyectoVo compra: compras){
                Object[] fila = new Object[4];
                fila[0]= compra.getId();
                fila[1]= compra.getConstructora();
                fila[2]= compra.getBanco();
                modelo.addRow(fila);                 
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    
}
public void primerInforme() {
    try{
        List<ListaLideresVo> lideres = controlador.obtenerLideresQueMasHanGastado();
        //Creeación del modelo:
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Lider");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Ciudad");
        for(ListaLideresVo lider: lideres){
            Object[] fila = new Object[4];
            fila[0]= lider.getId();
            fila[1]= lider.getNombre();
            fila[2]= lider.getApellido();
            fila[3]= lider.getCiudad();   
            modelo.addRow(fila);                 
        }
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
    }
    catch(Exception e){
        System.out.println("Error: " + e.getMessage());
    }
}

    public void proyectosFinanciadosPorBanco()  {
        
            
            try {
               var proyectos = controlador.obtenerProyectosFinanciadosPorBancos();
               proyectos.stream().forEach(System.out::println);
            } catch (SQLException e) {
               System.err.println("ERROR"+e);
                e.printStackTrace();
            }
            
        }
    

    public void totalAdeudadoPorProyectosSuperioresALimite()  {
        
            
            try {
               var proyectos = controlador.obtenerProyectosPorDeudasNoPagados();
               proyectos.stream().forEach(System.out::println);
            } catch (SQLException e) {
                System.err.println("ERROR"+e);
                e.printStackTrace();
            }
            
        }
    

    public void lideresQueMasGastan()  {

      
        try {
            var lideres = controlador.obtenerLideresQueMasHanGastado();
            lideres.stream().forEach(System.out::println);
        } catch (SQLException e) {
            System.err.println("ERROR"+e);
            e.printStackTrace();
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            primerInforme();
            lblConsulta.setText("Informe líderes");
        }
        if(e.getSource()==boton2){
            segundoInforme();
            lblConsulta.setText("Informe proyecto");
        }
        if(e.getSource()==boton3){
            tercerInforme();
            lblConsulta.setText("Informe compras");
        }
        
    }


}