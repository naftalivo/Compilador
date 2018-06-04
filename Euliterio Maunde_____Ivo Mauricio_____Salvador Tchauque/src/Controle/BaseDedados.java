/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;

public class BaseDedados {
    ArrayList<String> auxiliar = new ArrayList<>();
    
        public  String[] buscarPalavrasReservadas(){
          String especiais = "not if then else of do end read write for div or and not if while begin var function procedure program true false var";
                  return especiais.split(" ");
    }
            public  String[] buscarTipoDeDados(){
          String especiais = "array char integer boolean real string";
                  return especiais.split(" ");
    }
         public  String[] buscarSimbolosEspeciais(){
       String especiais = "= ( ) <= >= := . , : ; < > + / * - ";
                  return especiais.split(" "); 
    }
         public String[] todosCaracteres(){
             String letra ="A B C D E F G H I J K L M N O P Q R S T V M W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z";
             return letra.split("");
         }
         public String[] todosnumeros(){
             String letra ="0 1 2 3 4 5 6 7 8 9";
             return letra.split(" ");
         }
           public String[] outros(){
             String letra ="var begin end end. end; program";
             return letra.split(" ");
         }
         
}
