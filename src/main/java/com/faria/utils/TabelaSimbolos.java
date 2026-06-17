package com.faria.utils;

import java.util.ArrayList;
import java.util.HashSet;

public class TabelaSimbolos {
    
    private ArrayList<String[]> tabela = new ArrayList<>();
    private HashSet<String> hashCtrl = new HashSet<>();

    // hashCtrl serve para controle de lexemas que já existem para não adicionar novamente a tabela de simbolos
    // Estou usando String mas pode ser um objeto Symbol
    public void inserirSimbolo(String termo, Token token){
        if ( hashCtrl.contains(termo) ) {
            // Se já possuir não precisa fazer nada
            System.out.println("Já está na tabela de simbolos");
        } else {
            // Do contrário incluir na tabela da seguinte forma:
            String[] linha = new String[4];
            int id = tabela.size();

            token.setId(id+"");

            linha[0] = id+""; // ID
            linha[1] = termo; // Lexema
            linha[2] = token.toString(); // Token

            // Valor
            try {
                int numero = Integer.parseInt(termo);
                linha[3] = numero+"";
            } catch (NumberFormatException e) {
                linha[3] = "-";
            }

            tabela.add(linha);

            hashCtrl.add(termo); // Para não repetir mesmo objeto
        }
    }

    public void exportBd() {
        // Método para exportar a tabela de simbolos para o banco de dados
        // OBS: id precisa ser convertido para "int" novamente
    }

    public void imprimirTabela() {
        System.out.println("Tabela de Simbolos: ");
        for (String[] linha: this.tabela) {
            System.out.println("| id:" + linha[0] +" | lx:" + linha[1] + " | tk:" + linha[2] + " |v:" + linha[3]);
        }
    }
}
