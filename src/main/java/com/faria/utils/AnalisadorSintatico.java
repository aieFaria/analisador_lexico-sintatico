package com.faria.utils;


/**
 * Tenattiva de minimizar códigos dentro o Jcup
*/
public class AnalisadorSintatico {

    public static String validar(String tipo, String valor) {
        
        if (tipo == null || tipo.isEmpty() || valor == null || valor.isEmpty()) {
            return null;
        }
        if (valor.equals("EXPR_MAT") || valor.equals("EXPR_LOG")) {
            return null;
        }

        switch (tipo) {
            case "@": // STR
                if (!valor.startsWith("'"))
                    return "[Sintatico] Tipo incompativel: " + valor;
                break;
            case "!": // KEY (PIX)
                if (!valor.startsWith("\""))
                    return "[Sintatico] Tipo incompativel: " + valor;
                break;
            case "#": // INT
                if (valor.contains(".") || !valor.matches("-?\\d+"))
                    return "[Sintatico] Tipo incompativel: " + valor;
                break;
            case "$": // DECI
                if (!valor.matches("-?\\d+(\\.\\d+)?"))
                    return "[Sintatico] Tipo incompativel: " + valor;
                break;
            case "?": // BOO
                if (!valor.equals("TRUE") && !valor.equals("FALSE"))
                    return "[Sintatico] Tipo incompativel: " + valor;
                break;
        }
        
        return null;
    }
}