/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mezzari.nota.model;

import java.sql.Date;

/**
 *
 * @author Thiago
 */
public class Nota {
    public int id;
    public Date Data;
    public String hora;

    public void setId(int id) {
        this.id = id;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public int getId() {
        return id;
    }

    public String getHora() {
        return hora;
    }

    public Date getData() {
        return Data;
    }

    public Nota(int id, Date Data, String hora) {
        this.id = id;
        this.Data = Data;
        this.hora = hora;
    }

    public Nota() {
        
    }
}
