package com.faria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;

import java_cup.runtime.ComplexSymbolFactory;

// Resolver método para considerar leitura linha a linha ao invés de como está

public class Main {
    public static void main(String[] args) throws IOException{
        String rootPath = Paths.get("").toAbsolutePath().toString();
        BufferedReader text = new BufferedReader(new FileReader(rootPath + "/input.txt"));
        String line;
        while((line = text.readLine()) != null) {
            System.out.println("*".repeat(20) + "RESULTADO" + "*".repeat(20));
            ComplexSymbolFactory sf = new ComplexSymbolFactory();
            Yylex scanner = new Yylex(new StringReader(line), sf); 
            Parser parser = new Parser(scanner, sf); 
            try { 
                parser.parse(); 
            } catch (Exception e) { 
                System.out.print(""); 
            } 
            
            System.out.println("Sintaxe correta!"); 
            
        }
        text.close();
    }
}
