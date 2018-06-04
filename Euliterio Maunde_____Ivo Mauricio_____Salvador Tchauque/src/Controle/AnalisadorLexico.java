/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Erros;
import Modelo.Tabela;
import Modelo.ModeloToken;
import Modelo.ModeloErro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Euliterio Maunde
 * @author ivo Mauricio
 * @author Salvador Chauque
 */
public class AnalisadorLexico {

    String temporaria;
    int i = 0;
    ModeloToken modeloToken;
    Tabela modeloTabela = new Tabela();
    ModeloErro modeloErros = new ModeloErro();
    Erros erros = new Erros();
    Tabela bug = new Tabela();
    static BaseDedados baseDeDados = new BaseDedados();

    public String levarString(String string) {
        return string;
    }

    public boolean verificaString(String string) {
        if (verificaPlica(string.charAt(0)) && verificaPlica(string.charAt(string.length() - 1))) {
            return true;
        }
        return false;
    }

    public String[] tokens(String string) {
        temporaria = string.replaceAll("\n", " ");
        return temporaria.split("\\s+");
    }

    public boolean VerificarTipoDeDado(String string) {
        for (String tdd : baseDeDados.buscarTipoDeDados()) {
            if (tdd.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaNumero(String string) {
        if (this.verificarNumero(string.charAt(0))) {
            for (int j = 1; j < string.length(); j++) {
                if (!(this.verificarNumero(string.charAt(j)) || this.verificarPonto(string.charAt(j)))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean VerificarPalavraReservada(String string) {
        for (String tdd : baseDeDados.buscarPalavrasReservadas()) {
            if (tdd.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean VerificarSimboloEspescial(String string) {
        for (String tdd : baseDeDados.buscarSimbolosEspeciais()) {
            if (tdd.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarTipoDeDado(String string) {
        for (String tdd : baseDeDados.buscarTipoDeDados()) {
            if (tdd.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaAtributo(String string) {
        if (this.verificarLetra(string.charAt(0)) || this.verificarAndascor(string.charAt(0))) {
            for (int j = 1; j < string.length(); j++) {
                if (!(this.verificarLetra(string.charAt(j)) || this.verificarNumero(string.charAt(j)) || this.verificarAndascor(string.charAt(j)))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean verificacaoTotal(String string) {
        if (verificarTipoDeDado(string)) {
            this.modeloToken = new ModeloToken("Identifier Tipe", string);
            this.modeloTabela.gravarNaTabela(modeloToken);
            return true;
        } else {
            if (VerificarPalavraReservada(string)) {
                this.modeloToken = new ModeloToken("Special Symbol", string);
                this.modeloTabela.gravarNaTabela(modeloToken);
                return true;
            } else {
                if (VerificarSimboloEspescial(string)) {
                    this.modeloToken = new ModeloToken("Special Symbol", string);
                    this.modeloTabela.gravarNaTabela(modeloToken);
                    return true;
                } else {
                    if (verificaAtributo(string)) {
                        this.modeloToken = new ModeloToken("Identifier", string);
                        this.modeloTabela.gravarNaTabela(modeloToken);
                        return true;
                    } else {
                        if (this.verificaNumero(string)) {
                            this.modeloToken = new ModeloToken("Number", string);
                            this.modeloTabela.gravarNaTabela(modeloToken);
                            return true;
                        } else {
                            if (this.verificaString(string)) {
                                this.modeloToken = new ModeloToken("character constant", string);
                                this.modeloTabela.gravarNaTabela(modeloToken);
                                return true;
                            } else {
                                if (this.verifaSimboloNaPalavra(string)) {
                                    this.verificaJunto(string);
                                } else {
                                    this.modeloErros = new ModeloErro("Lexema nao esperado   ", string);
                                    erros.organizarBug(modeloErros);
                                    return false;
                                }

                            }

                        }
                    }
                }
            }
        }
        return false;
    }
     public boolean verificacaoTotalText(int posicao,String string) {
        if (verificarTipoDeDado(string)) {
            this.modeloToken = new ModeloToken("Identifier Tipe", string);
            this.modeloTabela.gravarNaTabela(modeloToken);
            return true;
        } else {
            if (VerificarPalavraReservada(string)) {
                this.modeloToken = new ModeloToken("Special Symbol", string);
                this.modeloTabela.gravarNaTabela(modeloToken);
                return true;
            } else {
                if (VerificarSimboloEspescial(string)) {
                    this.modeloToken = new ModeloToken("Special Symbol", string);
                    this.modeloTabela.gravarNaTabela(modeloToken);
                    return true;
                } else {
                    if (verificaAtributo(string)) {
                        this.modeloToken = new ModeloToken("Identifier", string);
                        this.modeloTabela.gravarNaTabela(modeloToken);
                        return true;
                    } else {
                        if (this.verificaNumero(string)) {
                            this.modeloToken = new ModeloToken("Number", string);
                            this.modeloTabela.gravarNaTabela(modeloToken);
                            return true;
                        } else {
                            if (this.verificaString(string)) {
                                this.modeloToken = new ModeloToken("character constant", string);
                                this.modeloTabela.gravarNaTabela(modeloToken);
                                return true;
                            } else {
                                if (this.verifaSimboloNaPalavra(string)) {
                                    this.verificaJunto(string);
                                } else {
                                    this.modeloErros = new ModeloErro("erro lexico na posicao "+posicao+" Lexema nao esperado   ", string);
                                    erros.organizarBug(modeloErros);
                                    return false;
                                }

                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean verificarLetra(char c) {
        for (String s : baseDeDados.todosCaracteres()) {
            if (s.equals(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarNumero(char c) {
        for (String s : baseDeDados.todosnumeros()) {
            if (s.equalsIgnoreCase(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarAndascor(char c) {
        return '_' == c;
    }

    public boolean verificarPonto(char c) {
        return '.' == c;
    }
     public boolean verificarPontoEvirgula(char c) {
        return ';' == c;
    }
    public ArrayList<ModeloErro> retornaErros() {
        return (ArrayList<ModeloErro>) this.erros.retornaErros();
    }

    public void tirarBug() {
        this.erros.limpar();
    }

    public boolean verificaPlica(char c) {
        return String.valueOf(c).equals("'");
    }

    public void verificaJunto(String string) {
        String[] ses = clean(string).split("\\s+");
        for (String se : ses) {
            this.verificacaoTotal(se);
            System.out.println(se);
        }
    }

    public String clean(String string) {
        String s = string;
        for (int j = 0; j < string.length(); j++) {
            for (int k = 0; k < baseDeDados.buscarSimbolosEspeciais().length; k++) {
                try {
                    if (String.valueOf(string.charAt(j)).equals(baseDeDados.buscarSimbolosEspeciais()[k])) {
                        s = s.replaceAll(baseDeDados.buscarSimbolosEspeciais()[k], " ") + " " + baseDeDados.buscarSimbolosEspeciais()[k];
                    }
                } catch (Exception erro) {
                    s = s.replaceAll("\\" + baseDeDados.buscarSimbolosEspeciais()[k], " ") + " " + baseDeDados.buscarSimbolosEspeciais()[k];
                }

            }
        }

        return s;
    }

    public boolean verifaSimboloNaPalavra(String string) {
        for (int j = 0; j < string.length(); j++) {
            for (int k = 0; k < baseDeDados.buscarSimbolosEspeciais().length; k++) {
                if (String.valueOf(string.charAt(j)).equals(baseDeDados.buscarSimbolosEspeciais()[k])) {
                    return true;
                }
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        AnalisadorLexico verificacoes = new AnalisadorLexico();
//        System.out.println(verificacoes.clean("*"));
//    }
}
