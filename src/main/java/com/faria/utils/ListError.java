package com.faria.utils;

import java.util.List;
import com.faria.utils.Database;

import java_cup.reduce_action;
 
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

    public void exportBd(int codeId) {
        Database db = new Database();

        for (Erro e: this.errors) {
            String tipo = e.getText().startsWith("[Léxico]") ? "Léxico" : "Sintático";
            
            db.insertErro(e.getText(), e.getLine(), e.getColumn(), tipo, codeId);
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

	public List<Erro> getErrors() {
		return this.errors;
	} 
     
} 