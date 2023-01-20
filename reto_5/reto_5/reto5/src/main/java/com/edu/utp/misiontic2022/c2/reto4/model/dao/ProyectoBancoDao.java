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
    public List<ProyectoBancoVo> listar() throws SQLException{
        List<ProyectoBancoVo> respuesta = new ArrayList<ProyectoBancoVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad from Proyecto p where Clasificacion = 'Casa Campestre' and ciudad in('Santa Marta', 'Cartagena', 'Barranquilla')";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ProyectoBancoVo vo = new ProyectoBancoVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setHabitaciones(rs.getInt("habitaciones"));
                vo.setCiudad(rs.getString("ciudad"));
                
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn !=null){
                conn.close();
            }
        }
        return respuesta;
    }


}