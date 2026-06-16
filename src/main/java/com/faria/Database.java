package com.faria;

import java.sql.*;
import com.faria.cons.Constantes;

/**
 * Classe para manipular banco de dados
 * 
 */
public class Database {
    
    private Connection conn;
    private Statement statement;

    public Database() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + Constantes.BANDO_DADOS);

        if (this.conn != null) {
            this.statement = this.conn.createStatement();
            this.statement.setQueryTimeout(30); 

            // Apaga tabela caso exista
            statement.executeUpdate("DROP TABLE IF EXISTS tabelaSimbolos (" +
                                    "id INTEGER PRIMARY KEY, " +
                                    "lexema TEXT, " + 
                                    "token TEXT, " +
                                    "valor TEXT, " + 
                                    "line INTEGER, "+
                                    "column INTEGER, "+
                                    "codeinfo_id INTEGER);");
        }
    }

    public void insert(int id, String lexema, String token, String valor) {
        // Incluir método que faça inserção no banco de dados
    }

    public void delete() {
        // Incluir método que delete do banco de dados
    }

    // Método para fechar conexão com banco de dados
    private void close() {
        try {
            if(conn != null){
            conn.close();
            }
        } catch(SQLException e) {
            // Falhou também para fechar o arquivo
            System.err.println(e.getMessage());
        }
    }

}
