package com.edu.utp.misiontic2022.c2.reto4.model.vo;

public class DeudasPorProyectoVo {
    private Integer id;
    private Double valor;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%3d %,15.1f", id, valor);
    }
}