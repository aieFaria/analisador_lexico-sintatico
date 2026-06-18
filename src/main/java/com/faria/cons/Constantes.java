package com.faria.cons;

import java.nio.file.Paths;

public class Constantes {

    public static final String BANDO_DADOS = rootPath() + "/src/main/java/com/faria/db/banco-dados-ts.db";
    //

    public static String rootPath() {
        return Paths.get("").toAbsolutePath().toString();
    }
}
