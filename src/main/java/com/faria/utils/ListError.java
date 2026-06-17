package com.faria.utils;

import java.util.List; 
 
public class ListError { 
 
    private List<Erro> errors; 
 
    public ListError() { 
        this.errors = new java.util.ArrayList<Erro>(); 
    } 
 
    public void defineError(int line, int column, String text) { 
        this.errors.add(new Erro(line, column, text)); 
    } 
 
    public void defineError(int line, int column) { 
        this.errors.add(new Erro(line, column, null)); 
    } 
 
    public void defineError(String text) { 
        for(Erro e : this.errors) { 
            if(e.getText() == null) { 
                e.setText(text); 
                return; 
            } 
        } 
    } 
 
    public void logErrors() { 
        for(Erro e : this.errors) {
            e.print(); 
        } 
    } 
 
    public boolean hasErrors() { 
        return this.errors.size() > 0; 
    } 
     
} 