/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import static Controle.AnalisadorLexico.baseDeDados;
import javax.swing.JOptionPane;

/**
 *
 * @author Euliterio Maunde
 */
public class AnalisadorSintactico {

    AnalisadorLexico verificacoes = new AnalisadorLexico();

    public String tirarPontoEvirgula(String string) {
        return string.replaceAll(";", "");

    }

    public boolean declaracaoDeVariaveis(String string) {
        if (string.contains(":")) {
            String[] string1 = string.split(",");
            String[] aux = string1[string1.length - 1].split(":");
            if (string1.length == 1) {
                if (verificacoes.verificaAtributo(aux[0])) {
                    if (verificacoes.verificarPontoEvirgula(aux[aux.length - 1].charAt(aux[aux.length - 1].length() - 1))) {
                        aux[1] = aux[1].replaceAll(" ", "");
                        if (verificacoes.verificarTipoDeDado(tirarPontoEvirgula(aux[aux.length - 1]))) {
                            return true;
                        }
                    }
                }
            } else {
                for (int i = 0; i < string1.length - 1; i++) {
                    if (verificacoes.verificaAtributo(string1[i]) && verificacoes.verificaAtributo(aux[0])) {
                        if (verificacoes.verificarPontoEvirgula(aux[aux.length - 1].charAt(aux[aux.length - 1].length() - 1))) {
                            aux[1] = aux[1].replaceAll(" ", "");
                            if (verificacoes.verificarTipoDeDado(tirarPontoEvirgula(aux[aux.length - 1]))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public int igual(String string) {
        int numero = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '=') {
                numero = numero + 1;
            }
        }
        return numero;
    }

    public boolean condicao(String string) {
        string = string.replaceAll("\\s+", "");
        string = string.replace('=', ' ');
        String[] strings = string.split(" ");
        //   System.out.println(string);

        for (int i = 0; i < strings.length; i++) {
            if (verificacoes.verificaAtributo(strings[i]) || verificacoes.verificaNumero(strings[i])) {

            } else {
                return false;
            }
        }
        return true;
    }

    public boolean comparacao(String string) {
        if (string.contains("<") || string.contains("=") || string.contains(">")) {

            string = string.replaceAll("\\s+", "");
            if (string.contains("<")) {
                string = string.replace('<', ' ');
            }
            if (string.contains(">")) {
                string = string.replace('>', ' ');
            }
            if (string.contains("=")) {
                string = string.replace('=', ' ');
            }

            String[] strings = string.split(" ");
            //   System.out.println(string);

            for (int i = 0; i < strings.length; i++) {
                 System.out.println("entrou");
                if (verificacoes.verificaAtributo(strings[i]) || verificacoes.verificaNumero(strings[i])) {
                   
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean atribuicao(String string) {
        string = string.replace(';', ' ');
        if (string.contains(":=")) {

            string = string.replaceAll("\\s+", "");
            if (string.contains(":=")) {
                string = string.replaceAll(":=", " ");
            }

            String[] strings = string.split(" ");

            if (verificacoes.verificaAtributo(strings[0])) {

                if (this.operacoesAritmetricas(strings[1]) || verificacoes.verificaAtributo(strings[1]) || verificacoes.verificaString(strings[1])) {
                    System.out.println(this.operacoesAritmetricas(strings[1]));
                    return true;
                }
            } else {
                return false;
            }

        }
        return false;
    }
        public boolean array(String string) {
        string = string.replace(';', ' ');
        if (string.contains(":")) {

            string = string.replaceAll("\\s+", "");
            if (string.contains(":")) {
                string = string.replaceAll(":", " ");
            }

            String[] strings = string.split(" ");

            if (verificacoes.verificaAtributo(strings[0])) {

                if (this.verificarArray(strings[1])) {
                    System.out.println(this.operacoesAritmetricas(strings[1]));
                    return true;
                }
            } else {
                return false;
            }

        }
        return false;
    }

    public boolean operacoesAritmetricas(String string) {
        string = string.replace(';', ' ');
        // System.out.println(string);
        if (string.contains("+") || string.contains("*") || string.contains("-") || string.contains("/")) {
            string = string.replaceAll("\\s+", "");
            if (string.contains("+")) {
                string = string.replace('+', ' ');
            }
            if (string.contains("*")) {
                string = string.replace('*', ' ');
            }
            if (string.contains("-")) {
                string = string.replace('-', ' ');
            }
            if (string.contains("/")) {
                string = string.replace('/', ' ');
            }
            String[] strings = string.split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (verificacoes.verificaAtributo(strings[i]) || verificacoes.verificaNumero(strings[i]) || verificacoes.verificaString(strings[i])) {
                    System.out.println(0);
                } else {
                    System.out.println("1");
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean verificarArray(String string) {
        string = string.replace(';', ' ');
        String stringAux = "";
        String[] strings = string.split(":");
        String[] string1 = strings[1].split("\\s+");
        if (verificacoes.verificaAtributo(strings[0]) && verificacoes.VerificarTipoDeDado(string1[string1.length - 1]) && string1[string1.length - 2].equalsIgnoreCase("of")) {
            string = " ";
            for (int i = 0; i < string1.length - 2; i++) {
                string = string + string1[i];
            }
            string = string.replaceAll("\\s+", "");
            // System.out.println(string);
            if (string.substring(0, 5).equalsIgnoreCase("array") && string.charAt(5) == '[' && string.charAt(string.length() - 1) == ']') {
//                  string = string.replaceAll("..", " ");

                for (int i = 5; i < string.length(); i++) {
                    stringAux = stringAux + string.charAt(i);
                }
                // System.out.println(string);
//                System.out.println(stringAux);
                stringAux = stringAux.replace('[', ' ');

                stringAux = stringAux.replace(']', ' ');
                if(stringAux.contains("..")){
                  stringAux = stringAux.replace('.', ' ');
                   
                }
                 System.out.println(stringAux);
              String []  s = stringAux.split("\\s+");
                 System.out.println(s[0]);

                for (int i = 1; i < s.length; i++) {
                   
                    if (verificacoes.verificaAtributo(s[i]) || verificacoes.verificaNumero(s[i])) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public boolean condicaIf(String string) {
        String[] ses = string.split("\\s+");
        if (ses.length > 3) {
            if (ses[0].equalsIgnoreCase("if") && ses[ses.length - 1].equalsIgnoreCase("then")) {
                string = null;
                for (int i = 1; i < ses.length - 1; i++) {
                    string = string + ses[i];
                }
                 string=string.replaceAll("and", " ");
                string=string.replaceAll("or", " ");
                if (this.condicao(string)) {
                    return true;
                }
            }
        } else {
            if (ses.length == 3) {
                if (ses[0].equalsIgnoreCase("if") && this.comparacao(ses[1]) && ses[2].equalsIgnoreCase("then")) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean verificarWhile(String string) {
        String[] ses = string.split("\\s+");
        if (ses.length > 3) {
            if (ses[0].equalsIgnoreCase("While") && ses[ses.length - 1].equalsIgnoreCase("do")) {
                string = null;
                for (int i = 1; i < ses.length - 1; i++) {
                    string = string + ses[i];
                }
                string=string.replaceAll("and", " ");
                string=string.replaceAll("or", " ");
                if (this.comparacao(string)) {
                    return true;
                }
            }
        } else {
            if (ses.length == 3) {
                if (ses[0].equalsIgnoreCase("while") && this.comparacao(ses[1]) && ses[2].equalsIgnoreCase("do")) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean write(String string) {
        string = string.replace(';', ' ');
        String auxiliar = "";
        String strings[];
        string.replaceAll("\\s+", "");
        if (string.length() >= 9) {
            if (string.substring(0, 5).equalsIgnoreCase("write") && string.charAt(5) == '(' && string.charAt(string.length() - 1) == ')') {
                for (int i = 6; i < string.length() - 1; i++) {
                    auxiliar = auxiliar + string.charAt(i);
                }
                strings = auxiliar.split(",");
                for (int i = 0; i < strings.length; i++) {
                    if (!(verificacoes.verificaAtributo(strings[i]) || verificacoes.verificaString(strings[i]))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean read(String string) {
        string = string.replace(';', ' ');
        String auxiliar = "";
        String strings[];
        string.replaceAll("\\s+", "");
        if (string.substring(0, 4).equalsIgnoreCase("read") && string.charAt(4) == '(' && string.charAt(string.length() - 1) == ')') {
            for (int i = 5; i < string.length() - 1; i++) {
                auxiliar = auxiliar + string.charAt(i);
            }
            strings = auxiliar.split(",");
            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
                if (!(verificacoes.verificaAtributo(strings[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean outros(String string) {
        for (int i = 0; i < baseDeDados.outros().length; i++) {
            if (string.equalsIgnoreCase(baseDeDados.outros()[i])) {
                return true;
            }
        }
        return false;
    }
    public boolean program(String string){
        string = string.replace(';', ' ');
        String[] strings = string.split("\\s+");
        if(strings.length==2){
            if(strings[0].equalsIgnoreCase("program") && verificacoes.verificaAtributo(strings[1])){
                return true;
            }
        }
        return false;
    }
    public boolean AnalisadorSintactico(String string) {
        if (this.operacoesAritmetricas(string)) {
//            JOptionPane.showMessageDialog(null, "1");
            return true;
        } else {
            if (this.write(string)) {
//                JOptionPane.showMessageDialog(null, "2");
                return true;
            } else {
                if (this.declaracaoDeVariaveis(string)) {
//                    JOptionPane.showMessageDialog(null, "3");
                    return true;
                } else {
                    if (this.condicaIf(string)) {
//                        JOptionPane.showMessageDialog(null, "4");
                        return true;
                    } else {
                        if (this.verificarWhile(string)) {
//                            JOptionPane.showMessageDialog(null, "5");
                            return true;
                        } else {
                            if (this.outros(string)) {
//                                JOptionPane.showMessageDialog(null, "6");
                                return true;
                            } else {
                                if (this.atribuicao(string)) {
//                                    JOptionPane.showMessageDialog(null, "6");
                                    return true;
                                }else{
                                    if(this.read(string)){
//                                        JOptionPane.showMessageDialog(null, "6");
                                    return true; 
                                    }else{
                                        if(this.program(string)){
                                            return true;
                                        }else{
                                           return false;  
                                        }
                                        
                                         
                                    }
                                }
                              
                            }
                        }
                    }
                }
            }
        }

    }

//    public static void main(String[] args) {
//        AnalisadorSintactico sintactico = new AnalisadorSintactico();
//        // System.out.println(sintactico.verificacoes.verificaAtributo("nome "));
//        //     System.out.println(sintactico.declaracaoDeVariaveis("nome,b : string;"));
//        // System.out.println(sintactico.condicao("numero = 5"));
//        //      System.out.println(sintactico.operacoesAritmetricas("nome=nome+nome*jjj"));
//        //   System.out.println("nxxn+djdjd".);
//        // System.out.println(sintactico.condicaIf("if 7 = numero = 5 then"));
//        // String [] a = "array[1..7]".split("array");
////       System.out.println("write('Ola mundo',nome)".substring(0, 5).equalsIgnoreCase("write"));
////        System.out.println("Olam..amaam".split("..", 1)[0]);
//     //   System.out.println(sintactico.("nomes: array [1..2] of integer"));
////        System.out.println(sintactico.write("write(Ola mundo',nome)"));
////System.out.println(sintactico.atribuicao("nome := nome+2"));
////System.out.println(sintactico.operacoesAritmetricas("nome+2"));
////System.out.println(sintactico.verificacoes.verificaString("'euliterio'"));
//        //System.out.println(sintactico.comparacao("nome=nome"));
//
//    }
}
