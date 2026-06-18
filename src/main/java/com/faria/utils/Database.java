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
    

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + Constantes.BANDO_DADOS);
    }

    public Database() {
        try(Connection conn = getConnection();
            Statement statement = conn.createStatement()) {
         
            statement.setQueryTimeout(30); 

            // Apaga tabela caso exista
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tabelaSimbolos (" +
                                    "id INTEGER, " +
                                    "lexema TEXT, " + 
                                    "token TEXT, " +
                                    "valor TEXT, " + 
                                    "line INTEGER, " +
                                    "column INTEGER, " +
                                    "codeinfo_id INTEGER, " +
                                    "PRIMARY KEY (id, codeinfo_id));");

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
              
        } catch (Exception e) {
            System.err.println("Erro ao inicializar o Banco de Dados: " + e.getMessage());
            e.printStackTrace();
        }
        
    }

    public void insertSimbolo(int id, String lexema, String token, String valor, 
                              int line, int column, int codeinfo_id) {
        
        String sql = "INSERT INTO tabelaSimbolos(id, lexema, token, valor, line, column, codeinfo_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, lexema);
            pstmt.setString(3, token);
            pstmt.setString(4, valor);
            pstmt.setInt(5, line);
            pstmt.setInt(6, column);
            pstmt.setInt(7, codeinfo_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados (Tabela de Simbolos): " + e.getMessage());
        }
        
    }

    public int insertCode(String filename) {

        LocalDate data = LocalDate.now();
        LocalTime time = LocalTime.now(); 
        String sql = "INSERT INTO codeinfo(filename, data, time) VALUES(?, ?, ?)";
        String consult = "SELECT * FROM codeinfo ORDER BY id DESC LIMIT 1";
        int ret = 0;

        try(Connection conn = getConnection();
            Statement statement = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filename);
            pstmt.setString(2, data.toString());
            pstmt.setString(3, time.toString().substring(0, 8));

            pstmt.executeUpdate();

            ResultSet rs = statement.executeQuery(consult);

            if (rs.next()) {
                ret = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados (CodeInfo): " + e.getMessage());
        }

        return ret;
    
    }

    public void insertErro(String descricao, int line, int column, String tipo, int codeinfo_id) {

        String sql = "INSERT INTO erroslogs(descricao, line, column, tipo, codeinfo_id) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(2, descricao);
            pstmt.setInt(3, line);
            pstmt.setInt(4, column);
            pstmt.setString(5, tipo);
            pstmt.setInt(6, codeinfo_id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados (Log de Erros): " + e.getMessage());
        } finally {

        }
    }

    public void delete() {
        // Incluir método que delete do banco de dados
    }


}
