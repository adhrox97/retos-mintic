package com.edu.utp.misiontic2022.c2.reto4;
import java.awt.*;
//import java.sql.SQLException;

import javax.swing.JFrame;

//import com.edu.utp.misiontic2022.c2.reto4.model.dao.ProyectoBancoDao;
import com.edu.utp.misiontic2022.c2.reto4.view.ReportesView;

public class App 
{
    public static void main( String[] args )
    {
     
       

            var reportesView = new ReportesView();
            reportesView.setLayout(new FlowLayout());
            reportesView.setSize(800,600);
            reportesView.setVisible(true);
            reportesView.setResizable(false);
            reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            reportesView.setLocationRelativeTo(null);
    }
}