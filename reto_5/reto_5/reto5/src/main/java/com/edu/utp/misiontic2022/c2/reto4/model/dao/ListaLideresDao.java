package com.edu.utp.misiontic2022.c2.reto4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.utp.misiontic2022.c2.reto4.model.vo.ListaLideresVo;
import com.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;


public class ListaLideresDao {

    public List<ListaLideresVo> listar_Lideres_Con_mas_Compras() throws SQLException  {
        List<ListaLideresVo> resultado = null;
        Connection connection = null;
        Statement stament = null;
        ResultSet rst = null;

        try {

            resultado = new ArrayList<ListaLideresVo>();
            connection = JDBCUtilities.getConnection();
            stament = connection.createStatement();
            rst = stament.executeQuery("SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, Ciudad_Residencia as ciudad from Lider l order by Ciudad_Residencia");

            while (rst.next()) {
                ListaLideresVo lider = new ListaLideresVo();
                lider.setId(rst.getInt("id"));
                lider.setNombre(rst.getString("nombre"));
                lider.setApellido(rst.getString("apellido"));
                lider.setCiuidad(rst.getString("ciudad"));
                resultado.add(lider);
            }

        } 
        catch(SQLException  e){

        }
        finally {
            if (connection != null) {
                connection.close();
            }
            if (stament != null) {
                stament.close();
            }
            if (rst != null) {
                rst.close();
            }
        }

        return resultado;
    }

}