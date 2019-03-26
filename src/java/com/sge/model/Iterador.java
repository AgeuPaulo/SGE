/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sge.model;

import java.util.List;

/**
 *
 * @author Ageeu
 */
public class Iterador<T> implements Interator {

    List<T> lista;
    int idx = 0;

    public Iterador( List<T> lista) {
        this.lista = lista;
    }    
    
    @Override
    public boolean hasNext() {
        return !(this.idx >= this.lista.size() || this.lista.get(idx) == null);
    }

    @Override
    public Object next() {
        T objeto = this.lista.get(idx);
        this.idx++;

        return objeto;
    }
}

interface Interator {

    boolean hasNext();

    Object next();
}