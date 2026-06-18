package com.faria;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import com.faria.utils.Database;
import com.faria.utils.DerivationTree;

import java_cup.runtime.Symbol;

public class Main {
    public static void main(String[] args) throws IOException {

        // Executar tudo de uma vez
        RunParser.main(args);
        RunScanner.main(args);

        String rootPath = Paths.get("").toAbsolutePath().toString();
        
        // Abre o arquivo diretamente
        FileReader fileReader = new FileReader(rootPath + "/input.txt");

        // Code Info - Informações de execução
        Database db = new Database();
        int codeinfo_id = db.insertCode("input.txt");

        System.out.println("*".repeat(20) + " RESULTADO " + "*".repeat(20));

        Yylex scanner = new Yylex(fileReader, codeinfo_id); 
        Parser parser = new Parser(scanner); 
        
        try { 
            // O parser vai consumir os tokens automaticamente
            Symbol result = parser.parse(); 
            
            System.out.println("\nSintaxe correta! O Parse foi concluído com sucesso."); 
            
            // Geração da Árvore de Derivação (Graphviz)
            if(result.value instanceof DerivationTree) {
                DerivationTree root = (DerivationTree) result.value;
                // Remova os comentários abaixo para imprimir a árvore no console!
                // System.out.println("\n--- Código Graphviz (DOT) ---");
                root.dotNotation();
            }
            
        } catch (Exception e) { 
            System.out.println("\nErro Fatal: " + e.getMessage()); 
            //e.printStackTrace(); // Adicionado para mostrar a linha exata do erro, se houver
        } finally {
            fileReader.close();
        }
    }

    public int codeInfo() {
        return 0;
    }
}