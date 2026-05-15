package com.faria;

%%

%standalone

letra = [a-zA-Zí]
digito = [0-9]
palavra = {letra}+
numero = {digito}+

%%

{numero}    {System.out.println("<NUMBER>");}
{palavra}   {System.out.println("<SYMBOL>");}