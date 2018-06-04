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
public class ModeloErro {
    private String token;
    private String descricao;
    private int posicao;

    public ModeloErro() {
    }
    
    public ModeloErro(String token, String descricao) {
        this.token = token;
        this.descricao = descricao;
    }

    public ModeloErro(String token, String descricao, int posicao) {
        this.token = token;
        this.descricao = descricao;
        this.posicao = posicao;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
}
