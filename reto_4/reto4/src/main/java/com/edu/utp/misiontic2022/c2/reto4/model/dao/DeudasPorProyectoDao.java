package com.edu.utp.misiontic2022.c2.reto4.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.utp.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import com.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;

//import static com.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities.*;

public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar_Deudas_Por_Limite(Double limite_inferior) throws SQLException {
        List<DeudasPorProyectoVo> resultado = null;
        Connection connection = null;
        Statement stament = null;
        ResultSet rst = null;

        try {

            resultado = new ArrayList<DeudasPorProyectoVo>();
            connection = JDBCUtilities.getConnection();
            stament = connection.createStatement();
            rst = stament.executeQuery("SELECT p.ID_Proyecto ,SUM( m.Precio_Unidad*c.Cantidad)  as Valor"
            +" from Compra c"
            +" join MaterialConstruccion m  using (ID_MaterialConstruccion)"
            +" join Proyecto p using (ID_Proyecto)"
            +" group by ID_Proyecto , Pagado"
            +" having c.Pagado = 'No' and Valor >"+limite_inferior 
            +" order by Valor DESC;");

            while (rst.next()) {
                DeudasPorProyectoVo deudasporproyecto = new DeudasPorProyectoVo();
                deudasporproyecto.setId(rst.getInt("ID_Proyecto"));
                deudasporproyecto.setValor(rst.getDouble("Valor"));

                resultado.add(deudasporproyecto);
            }

        } finally {
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
