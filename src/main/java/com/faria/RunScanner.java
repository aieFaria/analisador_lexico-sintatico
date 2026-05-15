package com.faria;

import java.nio.file.Paths;

public class RunScanner {

	public static void main(String[] args) {
		
		String rootPath = Paths.get("").toAbsolutePath().toString();
		String subPath = "/src/main/java/com/faria/";
		
		String flexFile[] = {rootPath + subPath + "lexical_analyzer.flex"};
		jflex.Main.main(flexFile);
	}

}
