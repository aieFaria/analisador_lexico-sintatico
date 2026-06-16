# analisador_lexico-sintatico
A partir da linguagem PIX script apresentada, deseja criar um analisador léxico e sintático para verificar se o código de entrada, escrita em PIX Script, é válida. O analisador léxico deverá ser gerado usando a biblioteca JFlex e o analisador sintático JCup.

> import java.util.Stack

A partir da linguagem apresentada, deseja criar um analisador léxico e sintático para
verificar se o código de entrada, escrita em PIX Script, é válida. O analisador léxico
deverá ser gerado usando a biblioteca JFlex e o analisador sintático JCup. O seu projeto
deverá:



## 📜 Tarefas a serem realizadas:
### Gerais:
- [❌] - Gerar Jflex;
- [❌] - Gerar JCup;
- [❌] - Criar apresentação;

### Especificos:
- [✔️] (1,0 pontos) ter a gramática livre de contexto para validar as instruções do PIX
Script (Gabriel);
     - [❌] Sub tarefa: Criar GLC visual normal para inserir no slide (Railson);
- [❌] (1,0 pontos) ter as regras do analisador léxico para validar e gerar os tokens;
- [❌] (1,0 pontos) criar um sistema de log de erros;
- [❌] (1,5 pontos) gerar a tabela de símbolos e gravar no banco de dados. Lembrando
que os lexemas gerados não podem se repetir na tabela de símbolos;
- [❌] (1,5 pontos) a partir do log de erros gravar no banco de dados;
(2,0 pontos) gerar a árvore de derivação do código;
- [❌] (2,0 pontos) gere uma imagem apresentando a árvore de derivação. Sugestão:
você pode gerar essa imagem usando a biblioteca Graphviz. 


> ✔️ - Feito

> 🔘 - Em andamento

> ❌ - Não iniciado


## 📦 Disposição do programa
     .
     ├── abalisador_lexico-sintatico
     │   └── src
     │       ├── main
     │       │    └── java
     │       │         └── com.faria
     │       │              ├── Main.java
     │       │              ├── .java
     │       │              ├── enums
     │       │              │    ├── Naipes.java
     │       │              │    └── NumCarta.java
     │       │              │
     │       │              └── pasta
     │       │                   ├── ScreenDeCompra.java
     │       │                   ├── ScreenJogo.java
     │       │                   ├── ScreenMain.java
     │       │                   └── ScreenGuardar.java
     │       │
     │       └── test.java
     │           └── testMain.java
     │
     ├── target
     ├── README.md
     ├── pom.xml
     └── analisador_lexico-sintatico.jar
     .

## 👷 Desenvolvimento

1.  ### 📚 Principais Classes
Descreve o funcionamento das principais classes do projeto.

2. ###  ♻️ Fluxo de execução da classe App.java
Descreve o funcionamento ideal do nosso programa. A chamada da função:
```
public static void main(String[] args) { ... }
```

## 👾 Como executar?
Pontos importantes a descrever:
- Como o programa própriamente: 
- Como são armazenados os Logs;


Com um clique se escolhe a carta e com outro se define o local de destino.
Dessa forma é possivel realizadar todas as movimentações necessárias.

## ✒️ Autores: 
| [<img src="https://avatars.githubusercontent.com/u/99749672?v=4" width=115><br><sub>Gabriel Alexandre</sub>](https://https://github.com/aieFaria) |
| :---: |
