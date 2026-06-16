package com.faria;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
 
%% 
 
%cup 
%unicode 
%line 
%column 
%{
    // Trecho de código qualquer
}%

letra = [a-zA-Zí]
digito = [0-9]
palavra = {letra}+
numero = {digito}+

%%

{numero}    {System.out.println("<NUMBER>");}
{palavra}   {System.out.println("<SYMBOL>");}
<<EOF>>     {return createSymbol(Sym.EOF);}