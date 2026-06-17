package com.faria.utils;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.faria.cons.Constantes;

/**
 * Classe para manipular banco de dados
 * 
 * Cada execução ficará registrada no banco de dados independentemente
 */
public class Database {
    
    private Connection conn;
    private Statement statement;
    private PreparedStatement pstmt;

    public Database() {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + Constantes.BANDO_DADOS);

            if (this.conn != null) {
                this.statement = this.conn.createStatement();
                this.statement.setQueryTimeout(30); 

                // Apaga tabela caso exista
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS tabelaSimbolos (" +
                                        "id INTEGER PRIMARY KEY, " +
                                        "lexema TEXT, " + 
                                        "token TEXT, " +
                                        "valor TEXT, " + 
                                        "line INTEGER, "+
                                        "column INTEGER, "+
                                        "codeinfo_id INTEGER);");

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS codeinfo (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "filename TEXT, " + 
                                        "data DATE, " +
                                        "time TIME);");

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS erroslogs (" +
                                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "descricao TEXT, " +  
                                        "line INTEGER, "+
                                        "column INTEGER, "+
                                        "tipo TEXT, " +
                                        "codeinfo_id INTEGER);");
            }    
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public void insertSimbolo(int id, String lexema, String token, String valor, 
                              int line, int column, int codeinfo_id) {
        
        String sql = "INSERT INTO tabelaSimbolos(id, lexema, token, valor, line, column, codeinfo_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            this.pstmt = conn.prepareStatement(sql); 

            this.pstmt.setInt(1, id);
            this.pstmt.setString(2, lexema);
            this.pstmt.setString(3, token);
            this.pstmt.setString(4, valor);
            this.pstmt.setInt(5, line);
            this.pstmt.setInt(6, column);
            this.pstmt.setInt(7, codeinfo_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados (Tabela de Simbolos): " + e.getMessage());
        }
        
    }

    public void insertCode(String filename) {

        LocalDate data = LocalDate.now();
        LocalTime time = LocalTime.now(); 
        String sql = "INSERT INTO codeinfo(filename, data, time) VALUES(?, ?, ?, ?)";

        try {
            this.pstmt = conn.prepareStatement(sql); 

            this.pstmt.setString(2, filename);
            this.pstmt.setString(3, data.toString());
            this.pstmt.setString(4, time.toString().substring(0, 8));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados (CodeInfo): " + e.getMessage());
        }

    }

    public void insertErro(String descricao, int line, int column, String tipo, int codeinfo_id) {

        String sql = "INSERT INTO erroslogs(descricao, line, column, tipo, codeinfo_id) VALUES(?, ?, ?, ?, ?)";

        try {
            this.pstmt = conn.prepareStatement(sql); 

            this.pstmt.setString(2, descricao);
            this.pstmt.setInt(3, line);
            this.pstmt.setInt(4, column);
            this.pstmt.setString(5, tipo);
            this.pstmt.setInt(6, codeinfo_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados (Log de Erros): " + e.getMessage());
        }
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
