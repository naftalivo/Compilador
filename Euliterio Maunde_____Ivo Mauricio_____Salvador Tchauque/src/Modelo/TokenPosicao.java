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
public class TokenPosicao {
     private String token;
  
    private int posicao;

    public TokenPosicao(String token, int posicao) {
        this.token = token;
        this.posicao = posicao;
    }

    public TokenPosicao() {
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
