package com.faria.utils;

import com.faria.Sym;

public class Token {
    
    private String idLexema;
    private String lexema;
    private String tipo;
    private boolean classe;

    public Token(int refSym, String lexema, String idLexema, boolean classe) {
        this.classe = classe;
        this(refSym, idLexema, lexema);
    }

    public Token(int refSym, String lexema, String idLexema) {
        this.classe = false;
        this.idLexema = idLexema;
        this(refSym, lexema);
    }

    public Token(int refSym, String lexema) {
        this.classe = false;

        this.lexema = lexema;
        this(refSym);
    }

    public Token(int refSym) {
        
        if (this.lexema == null) {
            this.classe = true;
            this.lexema = Sym.terminalNames[refSym];
        }
        
        this.tipo = Sym.terminalNames[refSym];
    }

    // terminalNames[Sym.EOF]; // -> Retorna a String "EOF"

    @Override
    public String toString() {

        if (idLexema != null) {
            return this.classe ? String.format("<%s>", this.tipo) : 
                   String.format("<%s, %s>", this.tipo, this.idLexema);
        } else {
            return this.classe ? String.format("<%s>", this.tipo) : 
                   String.format("<%s, %s>", this.tipo, this.lexema);
        }

    }

    public void setId(String id) {
        this.idLexema = id;
    }

    public String getLexema() {
        return this.lexema;
    }
}
