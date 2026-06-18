package com.faria.utils;

public class Erro { 
 
    private int line, column; 
    private String text; 

    public Erro(int line, int column, String text) { 
        this.line = line; 
        this.column = column; 
        this.text = text; 
    } 

    public void print() { 
        String aux = "Erro na linha " + line + " e coluna " + column + ": "; 
        if(this.text == null) 
            aux += "Erro desconhecido"; 
        else 
            aux += this.text; 
        System.out.println(aux); 
    } 

    public String getText() { 
        return text != null ? text : ""; 
    } 
        
    public void setText(String text) { 
        this.text = text; 
    } 

    public int getLine(){
        return this.line;
    }

    public int getColumn(){
        return this.column;
    }
}