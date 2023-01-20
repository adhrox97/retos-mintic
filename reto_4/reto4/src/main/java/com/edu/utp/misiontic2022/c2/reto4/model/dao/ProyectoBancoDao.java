package com.edu.utp.misiontic2022.c2.reto4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.utp.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;
import com.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;

//import static com.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities.*;
public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar_por_nombre(String nombre) throws SQLException{
        List<ProyectoBancoVo> resultado = null;
        Connection connection = null;
        Statement stament = null;        
        ResultSet rst = null;

        try{
            
              resultado = new ArrayList<ProyectoBancoVo>();  
              connection = JDBCUtilities.getConnection(); 
              stament = connection.createStatement();
              rst = stament.executeQuery("SELECT p.ID_Proyecto ,p.Constructora, p.Ciudad ,p.Clasificacion,t.Estrato ,l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido as Lider " 
                                        +" FROM Proyecto p" 
                                        +" join Lider l using (ID_Lider)"
                                        +" join Tipo t using (ID_Tipo)"
                                        +" WHERE p.Banco_Vinculado = '"+nombre+"'"
                                        +" ORDER by p.Fecha_Inicio DESC ,p.Ciudad ASC ,Constructora;");

                while (rst.next()) {
                    ProyectoBancoVo proyectoBanco = new ProyectoBancoVo();
                    proyectoBanco.setId(rst.getInt("ID_Proyecto"));
                    proyectoBanco.setConstructora(rst.getString("Constructora"));
                    proyectoBanco.setCiudad(rst.getString("Ciudad"));
                    proyectoBanco.setClasificacion(rst.getString("Clasificacion"));
                    proyectoBanco.setEstrato(rst.getInt("Estrato"));
                    proyectoBanco.setLider(rst.getString("Lider"));
                    resultado.add(proyectoBanco); 
                }


        }finally{
            if(connection!=null){
                connection.close();
            }
            if(stament!=null){
                stament.close();
            }
            if(rst!=null){
                rst.close();
            }
        }



            return resultado;
    }


}