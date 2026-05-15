package com.faria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException{
        String rootPath = Paths.get("").toAbsolutePath().toString();
        BufferedReader text = new BufferedReader(new FileReader(rootPath + "\\input.txt"));
        String line;
        while((line = text.readLine()) != null) {
            try{
                Yylex scanner = new Yylex(new StringReader(line));
                while (true) {
                    int token = scanner.yylex();
                    if (token == Yylex.YYEOF) {
                        break;
                    }
                    System.out.println("Token: " + token);
                }
            }catch(Exception ex){
                System.out.println("Erro de sintaxe: " + line);
            }
        }
        text.close();
    }
}
