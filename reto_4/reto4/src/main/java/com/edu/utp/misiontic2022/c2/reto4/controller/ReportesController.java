package com.edu.utp.misiontic2022.c2.reto4.controller;

import java.sql.SQLException;
import java.util.List;

import com.edu.utp.misiontic2022.c2.reto4.model.dao.ComprasDeLiderDao;
import com.edu.utp.misiontic2022.c2.reto4.model.dao.DeudasPorProyectoDao;
import com.edu.utp.misiontic2022.c2.reto4.model.dao.ProyectoBancoDao;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;

public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;

    public ReportesController(){
        this.proyectoBancoDao = new ProyectoBancoDao();
        this.deudasPorProyectoDao = new DeudasPorProyectoDao();
        this.comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ProyectoBancoVo> obtenerProyectosFinanciadosPorBancos(String banco) throws SQLException {
        return proyectoBancoDao.listar_por_nombre(banco);
    }

    public List<DeudasPorProyectoVo> obtenerProyectosPorDeudasNoPagados(Double limiteInferior) throws SQLException {
        return deudasPorProyectoDao.listar_Deudas_Por_Limite(limiteInferior);
    }

    public List<ComprasDeLiderVo> obtenerLideresQueMasHanGastado() throws SQLException {
        return comprasDeLiderDao.listar_Lideres_Con_mas_Compras();
    }
    
}
