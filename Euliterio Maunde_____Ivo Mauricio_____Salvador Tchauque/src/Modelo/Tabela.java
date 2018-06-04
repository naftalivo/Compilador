/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Euliterio Maunde
 * @ivo Mauricio
 */
public class Tabela extends AbstractTableModel{
         public static ArrayList<ModeloToken> tokens = new ArrayList<>();
                  public static List<ModeloToken> erros = new ArrayList<>();

    // Funcionario f = new Funcionario(formacao, nome, bi, endereco, Long.MIN_VALUE, data);
    String[] colunas = {"Classe","Lexema"};
    /**
     * este metodo retorna o numero de linhas
     * @return numerode linhas da tabela
     */
    @Override
    public int getRowCount() {
        return tokens.size();
    }
    /**
     * este metodo retorna o numero de colunas da tabela
     * @return numero de colunas 
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    /**
     * este metodoretorn o nome das colunas da tabela
     * @param numCol posicao da coluna
     * @return nome das colunas
     */
    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }
    /**
     * este metodo retorna os objecto para a tabela
     * @param i posicao do objecto no ArrayList
     * @param i1 posicao da linha
     * @return 
     */
    @Override
    public Object getValueAt(int i, int i1) {
       ModeloToken token = this.tokens.get(i);

        switch (i1) {
            case 0:
                return token.getDescricao();
            case 1:
                return token.getToken();
            default:
                return null;
        }
    }
    public void limpar(){
        tokens.clear();
         actualizar();
    }
    public boolean gravarNaTabela( ModeloToken modeloToken){
        if (!tokens.contains(modeloToken)) {
            tokens.add(modeloToken);
            actualizar();
        }
        return true;
    }
    public boolean actualizar() {
        fireTableRowsInserted(tokens.size() - 7, tokens.size() - 7);
        return true;
    }
   
 
}
