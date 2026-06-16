package com.faria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TabelaSimbolos {
    
    private ArrayList<String[]> tabela = new ArrayList<>();
    private HashSet<String> hashCtrl = new HashSet<>();

    // hashCtrl serve para controle de lexemas que já existem para não adicionar novamente a tabela de simbolos
    // Estou usando String mas pode ser um objeto Symbol
    public void exemplo(String termo){
        if ( hashCtrl.contains(termo) ) {
            // Se já possuir não precisa fazer nada
        } else {
            // Do contrário incluir na tabela da seguinte forma:
            String[] linha = new String[4];

            linha[0] = tabela.size()+""; // ID
            linha[1] = termo; // Lexema
            linha[2] = termo; // Token
            linha[3] = termo; // Valor
            
            tabela.add(linha);
        }
    }
}
