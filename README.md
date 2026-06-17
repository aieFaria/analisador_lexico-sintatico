---
marp: true
tittle: JCUP e JFLEX
theme: uncover
backgroundColor:  #FFFFFF
color: #1E293B
style: |
  section {
    padding: 30px;
  }
---

<style scoped>
h2 { font-size: 50px; }
p, li { font-size: 25px; 
        text-align: justify;
 }
section { padding: 30px 20px 30px 20px;}
</style>

# 🔎 Analisador lexico & sintatico
A partir da linguagem PIX script apresentada, deseja criar um analisador léxico e sintático para verificar se o código de entrada, escrita em PIX Script, é válida. O analisador léxico deverá ser gerado usando a biblioteca JFlex e o analisador sintático JCup.

![width:40%](https://marp.app)

---
<style scoped>
h2 { 
     font-size: 72px; 
     text-align: left;
}
</style>


## ✒️ Grupo: 
| [<img src="https://avatars.githubusercontent.com/u/99749672?v=4" width=115><br><sub>Gabriel Alexandre</sub>](https://https://github.com/aieFaria) |
| :---: |


---

<style scoped>
h2 { font-size: 50px; }
h3 { font-size: 40px; text-align: left }
table {
  font-size: 30px;
}
p, li { font-size: 20px; }
section { padding: 30px 20px 30px 20px;}
</style>

## 💻 Técnologias usadas

| Tecnologia | Descrição |
| :--- | :--- |
| Java | Linguagem de programação usada |
| Maven | para gerenciar as dependencias do projeto |
| JFlex | Dependencia para criar analisador léxico |
| JCup | Dependencia para criar analisador sintático |
| Graphviz | Para gerar imagem da arvore de derivação |
| SQLite | Banco de dados |
| Marp | Para criar a apresentação via Readme |
| Draw.io | Para geração dos diagramas |



---

<style scoped>
h2 { font-size: 50px; }
h3 { font-size: 40px; text-align: left }
p, li { font-size: 20px; 
        text-align: justify;
}
section { padding: 30px 20px 30px 20px;}
</style>

## 📜 Tarefas realizadas:
### Gerais:
- [✔️] - Gerar Jflex;
- [✔️] - Gerar JCup;
- [❌] - Criar apresentação;

### Especificos:
- [✔️] (1,0 pontos) ter a gramática livre de contexto para validar as instruções do PIX
Script (Gabriel);
     - [❌] Sub tarefa: Criar GLC visual normal para inserir no slide (Railson);
- [❌] (1,0 pontos) ter as regras do analisador léxico para validar e gerar os tokens;
- [❌] (1,0 pontos) criar um sistema de log de erros;
- [🔘] (1,5 pontos) gerar a tabela de símbolos e gravar no banco de dados. Lembrando
que os lexemas gerados não podem se repetir na tabela de símbolos;
- [❌] (1,5 pontos) a partir do log de erros gravar no banco de dados;
- [❌] (2,0 pontos) gerar a árvore de derivação do código;
- [❌] (2,0 pontos) gere uma imagem apresentando a árvore de derivação. Sugestão:
você pode gerar essa imagem usando a biblioteca Graphviz. 


> ✔️ - Feito

> 🔘 - Em andamento

> ❌ - Não iniciado
---

<style scoped>
h2 { font-size: 50px; 
     text-align: left;}
h3 { font-size: 40px; text-align: left }
p, li { font-size: 20px; }
section { padding: 30px 20px 30px 20px;}
</style>


## 📦 Disposição do programa:
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

---

<style scoped>
h2 { font-size: 50px;}
h3 { font-size: 40px; text-align: left }
p, li { font-size: 30px; 
        text-align: justify;
}
section { padding: 30px 20px 30px 20px;}
</style>

## 👷 Desenvolvimento

### 1. 📚 Principais Classes
Descreve o funcionamento das principais classes do projeto.

---

<style scoped>
h3 { font-size: 40px; text-align: left }
p, li { font-size: 30px; 
        text-align: justify;
}
section { padding: 30px 20px 30px 20px;}
</style>


### JFlex

O JFlex é um gerador de analisador léxico que recebe um conjunto de regras escrito em expressões regulares e tokeniza um arquivo de texto de entrada de acordo com essas expressões.
<p align="center">
<img width="348" height="200" alt="image" src="https://github.com/user-attachments/assets/e2245436-062a-46ef-afc7-4b59acb98b5d" />
</p>

O analisador léxico é criado em um arquivo com a extensão .flex.  
Ao compilar o arquivo.flex, será gerado um arquivo chamado Yylex.java.  
Compile o Yylex.java para gerar o Yylex.class que lê um arquivo de entrada.txt e tokeniza em um arquivo de saida.txt.  
<p align="center">
  <img width="319" height="280" alt="image" src="https://github.com/user-attachments/assets/6c3c1150-43c6-4876-9b4a-bc8542929ec5" />
</p>

### JCup
aaa

### Gramática Livre De Contexto:
<p align="center">
<img width="760" height="605" alt="image" src="https://github.com/user-attachments/assets/4de8d9bb-fb62-4780-acc8-60f88b6d0b7d" />
</p>

### 2. 🎲 Banco de Dados

Inserir diagramas de representação do banco de dados


---

<style scoped>
h3 { font-size: 40px; text-align: left }
p, li { font-size: 30px; 
        text-align: justify;
}
section { padding: 30px 20px 30px 20px;}
</style>

### 3. ♻️ Fluxo de execução da classe App.java
Descreve o funcionamento ideal do nosso programa. A chamada da função:
```
public static void main(String[] args) { ... }
```
PROVAVELMENTE VAI PRECISAR DE VARIOS DESTES PARA EXPLICAR

---

<style scoped>
h3 { font-size: 40px; text-align: left }
p, li { font-size: 30px; 
        text-align: justify;
}
section { padding: 30px 20px 30px 20px;}
</style>

## 🚀 Como executar?
Pontos importantes a descrever:
- Como o programa própriamente: 
- Como são armazenados os Logs;


Com um clique se escolhe a carta e com outro se define o local de destino.
Dessa forma é possivel realizadar todas as movimentações necessárias.

