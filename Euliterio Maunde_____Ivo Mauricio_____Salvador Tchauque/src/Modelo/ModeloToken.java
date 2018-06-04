/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Euliterio Maunde
 */
public class ModeloToken {
    private String descricao;
    private String token;
    private int posicao;

    public ModeloToken(String descricao, String token, int posicao) {
        this.descricao = descricao;
        this.token = token;
        this.posicao = posicao;
    }
    
    public ModeloToken(String descricao, String token) {
        this.descricao = descricao;
        this.token = token;
    }

    public ModeloToken() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
}
