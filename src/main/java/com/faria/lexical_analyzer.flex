package com.faria;

import java_cup.runtime.Symbol;
import com.faria.utils.Database;
import com.faria.utils.*;

%%

%cup
%unicode
%line
%column
%public
%class Yylex

%{

    Database db = new Database();

    int codeinfo_id;

    public Yylex(java.io.Reader in, int codeinfo_id) { 
        this(in); 
        this.codeinfo_id = codeinfo_id;
    } 

    // Métodos para encapsular a criação de objetos Symbol do JCup
    private Symbol createSymbol(int type) {
        return new Symbol(type, yyline + 1, yycolumn + 1);
    }

    private Symbol createSymbol(int type, Object value) {
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
    }

    private ListError listError = new ListError(); // <-- Mochila criada no Lexer!

    public ListError getListError() {
        return this.listError;
    }

    public void defineError(int line, int column, String text) {
        // Envia erros léxicos para a mesma lista que o Parser!
        this.listError.defineError(line, column, "[Léxico] " + text);
    }

    public void defineError(int line, int column) {
        this.listError.defineError(line, column);
    }
%}

digito = [0-9]
espaco = [ \t\r\n]+

id     = [a-zA-Z_$][a-zA-Z0-9_$]*
texto  = \'[^\']*\' | \"[^\"]*\"
numero = {digito}+("."{digito}+)?

%%

/* Estrutura Principal da Linguagem */
"LEDGER"        { return createSymbol(Sym.LEDGER); }
"CLOSE"         { return createSymbol(Sym.CLOSE); }
"LET"           { return createSymbol(Sym.LET); }
"$>"            { return createSymbol(Sym.PRINT); }

/* Palavras-Chave e Condicionais */
"IF"            { return createSymbol(Sym.IF); }
"::"            { return createSymbol(Sym.ELSE); }
"TRUE"          { return createSymbol(Sym.TRUE); }
"FALSE"         { return createSymbol(Sym.FALSE); }

/* Símbolos de Tipagem (Separados para bater com a GLC do Parser) */
"$" /{id}            { return createSymbol(Sym.DECI); }
"#" /{id}            { return createSymbol(Sym.INT); }
"@" /{id}            { return createSymbol(Sym.STR); }
"?" /{id}            { return createSymbol(Sym.BOO); }
"!" /{id}            { return createSymbol(Sym.KEY); }
"~" /{id}            { return createSymbol(Sym.NULL); }

/* Delimitadores e Agrupadores */
"{"             { return createSymbol(Sym.KEY_OPEN); }
"}"             { return createSymbol(Sym.KEY_CLOSE); }
"("             { return createSymbol(Sym.PAR_OPEN); }
")"             { return createSymbol(Sym.PAR_CLOSE); }

/* Operador de Atribuição */
"<-"            { return createSymbol(Sym.setaE); }

/* Operadores Aritméticos */
"++"            { return createSymbol(Sym.SOMA); }
"--"            { return createSymbol(Sym.SUB); }
"**"            { return createSymbol(Sym.MULT); }
"//"            { return createSymbol(Sym.DIV); }
"%%"            { return createSymbol(Sym.RESTO); }

/* Operadores Relacionais e Lógicos */
"=="            { return createSymbol(Sym.IGUAL); }
"!="            { return createSymbol(Sym.DIF); }
">>"            { return createSymbol(Sym.MAIOR); }
"<<"            { return createSymbol(Sym.MENOR); }
">="            { return createSymbol(Sym.MAIOR_IGUAL); }
"<="            { return createSymbol(Sym.MENOR_IGUAL); }
"&&"            { return createSymbol(Sym.AND); }
"||"            { return createSymbol(Sym.OR); }
"!!"            { return createSymbol(Sym.NOT); }

{numero}        { return createSymbol(Sym.NUMBER, yytext()); }
{id}            { return createSymbol(Sym.ID, yytext()); }
{texto}         { return createSymbol(Sym.TEXT, yytext()); }
{espaco}        { /* ignorar */ }

.               { 
                    System.out.println("Erro Lexico encontrado: " + yytext());
                    defineError(yyline + 1, yycolumn + 1, "Caractere inválido ou inesperado '" + yytext() + "'");
                    return createSymbol(Sym.error); // Não é obrigatório criar esse simbolo
                }


<<EOF>>             { return createSymbol(Sym.EOF); }
