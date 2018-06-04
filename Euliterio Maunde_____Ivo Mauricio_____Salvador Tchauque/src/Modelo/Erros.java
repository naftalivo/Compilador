/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.ModeloErro;
import static Modelo.Tabela.erros;
import static Modelo.Tabela.tokens;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Euliterio Maunde
 */
public class Erros {
    public static List<ModeloErro> erros = new ArrayList<>();
     public boolean organizarBug( ModeloErro bug){
        erros.add(bug);
        return true;
    }
      public List<ModeloErro> retornaErros(){
        return erros;
    } 
      public void limpar(){
          erros.clear();
      }
}
