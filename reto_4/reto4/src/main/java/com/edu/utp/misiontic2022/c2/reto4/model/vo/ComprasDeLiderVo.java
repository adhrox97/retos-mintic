package com.edu.utp.misiontic2022.c2.reto4.model.vo;

public class ComprasDeLiderVo {
    private String lider;
    private Double valor;
    public String getNombre() {
        return lider;
    }
    public void setNombre(String nombre) {
        this.lider = nombre;
    }
    public Double getTotal() {
        return valor;
    }
    public void setTotal(Double total) {
        this.valor = total;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-25s %,15.1f", lider, valor);
    }
    }