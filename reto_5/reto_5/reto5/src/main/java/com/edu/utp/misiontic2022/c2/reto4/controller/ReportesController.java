package com.edu.utp.misiontic2022.c2.reto4.controller;

import java.sql.SQLException;
import java.util.List;

import com.edu.utp.misiontic2022.c2.reto4.model.dao.ListaLideresDao;
import com.edu.utp.misiontic2022.c2.reto4.model.dao.DeudasPorProyectoDao;
import com.edu.utp.misiontic2022.c2.reto4.model.dao.ProyectoBancoDao;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.ListaLideresVo;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import com.edu.utp.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;

public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ListaLideresDao listaLideresDao;

    public ReportesController(){
        this.proyectoBancoDao = new ProyectoBancoDao();
        this.deudasPorProyectoDao = new DeudasPorProyectoDao();
        this.listaLideresDao = new ListaLideresDao();
    }

    public List<ProyectoBancoVo> obtenerProyectosFinanciadosPorBancos() throws SQLException {
        return proyectoBancoDao.listar();
    }

    public List<DeudasPorProyectoVo> obtenerProyectosPorDeudasNoPagados() throws SQLException {
        return deudasPorProyectoDao.listar();
    }

    public List<ListaLideresVo> obtenerLideresQueMasHanGastado() throws SQLException {
        return listaLideresDao.listar_Lideres_Con_mas_Compras();
    }
    
}
