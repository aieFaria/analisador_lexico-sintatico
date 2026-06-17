package com.faria;

import com.faria.tree.DerivationTree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class TesteUnitario {
    @Nested
	@DisplayName("Testando geração de Dot Notation")
    public class dotNotation {

		@Test
		@DisplayName("Testando geração de arquivo de imagem DOT")
		void gerarPNG() {
            DerivationTree dt = new DerivationTree();

            String dotNotation = "digraph dt { a -> b; b -> c; c -> a; d -> e; }";

            dt.geraImagemDot(dotNotation);
			
		}
    }
}
