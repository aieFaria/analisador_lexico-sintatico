package com.faria.tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.parse.Parser;
import java.io.File;
import java.io.IOException;

public class DerivationTree {

    private String raiz;
    private int id;
    private List<DerivationTree> filhos;

    private static int cont = 0;

    public DerivationTree(String raiz, List<DerivationTree> filhos) {
        this.id = cont++;
        this.raiz = raiz;
        this.filhos = new ArrayList<>();
        
        this.filhos.addAll(filhos);
    }

    public DerivationTree(String raiz, DerivationTree sta) {
        this.id = cont++;
        this.raiz = raiz;
        this.filhos = new ArrayList<>();
        
        this.filhos.add( sta );
    }

    public DerivationTree(String raiz, Object obj) {
        this.id = cont++;
        this.raiz = raiz;
        this.filhos = new ArrayList<>();

        if(obj instanceof DerivationTree) {
            this.filhos.add( (DerivationTree) obj);
        } else if(obj instanceof String) {
            this.filhos.add(new DerivationTree( (String) obj ));
        }
    }

    public DerivationTree(String raiz, String sta) {
        this.id = cont++;
        this.raiz = raiz;
        this.filhos = new ArrayList<>();
        
        this.filhos.add( new DerivationTree(sta) );
    }

    public DerivationTree(String raiz) {
        this.id = cont++;
        this.raiz = raiz;
        this.filhos = new ArrayList<>();
    }

    public DerivationTree() {
        //TODO Auto-generated constructor stub
    }

    public void dotNotation() {
        // Gerar Dot Notation a partir deste método
        StringBuilder sb = new StringBuilder();

        sb.append("digraph ArvoreDerivacao {\n");
        sb.append("    rankdir=LR;\n    dpi=\"600\";");
        sb.append("    node [shape=plaintext];\n");
        sb.append("    edge [dir=none];\n\n");

        gerarNodes(sb);
        sb.append("\n");
        gerarEdges(sb);

        sb.append("\n}");

        String saidaDot = sb.toString();

        geraImagemDot(saidaDot);
    }

    public void geraImagemDot(String conteudoDot) {
        try {
            
            MutableGraph g = new Parser().read(conteudoDot);

            Graphviz.fromGraph(g)
                    .render(Format.PNG)
                    .toFile(new File("resource/arvoreDerivacao.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void gerarNodes(StringBuilder sb) {
        sb.append("  node").append(id).append(" [label=\"").append(raiz.replace("\"", "\\\""))
          .append("\"];\n");
        for (DerivationTree filho : filhos) {
            if(filho != null) {
                filho.gerarNodes(sb);
            }
        }
    }

    private void gerarEdges(StringBuilder sb) {
        for (DerivationTree filho : filhos) {
            if(filho != null) {
                sb.append("  node").append(id).append(" -> node").append(filho.id).append(";\n");
                filho.gerarEdges(sb);
            }
        }
    }

    public void addFilhos(String sta) {
        this.filhos.add( new DerivationTree(sta) );
    }
    
}
