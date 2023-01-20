package com.edu.utp.misiontic2022.c2.reto4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.utp.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import com.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;


public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> listar_Lideres_Con_mas_Compras() throws SQLException  {
        List<ComprasDeLiderVo> resultado = null;
        Connection connection = null;
        Statement stament = null;
        ResultSet rst = null;

        try {

            resultado = new ArrayList<ComprasDeLiderVo>();
            connection = JDBCUtilities.getConnection();
            stament = connection.createStatement();
            rst = stament.executeQuery(
                    "SELECT l.Nombre ||' '||l.Primer_Apellido ||' '|| l.Segundo_Apellido as Lider, SUM(c.Cantidad*mc.Precio_Unidad) as Total"
                    + " from Compra c "
                    + " join Proyecto p using(ID_Proyecto)"
                    + " join Lider l using(ID_Lider)"
                    + " join MaterialConstruccion mc using (ID_MaterialConstruccion)"
                    + " group by Lider"
                    + " order by Total DESC "
                    + " limit 10");

            while (rst.next()) {
                ComprasDeLiderVo lider = new ComprasDeLiderVo();
                lider.setNombre(rst.getString("Lider"));
                lider.setTotal(rst.getDouble("Total"));
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