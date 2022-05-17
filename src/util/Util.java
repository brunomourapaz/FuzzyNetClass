/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author bruno
 */
public class Util {

    public Util() {
    }
    

    public double normalizaValor(double valorReferencia,
            double valorParaNormalizar) {

        /*double saida = 0;
        
        if (valorReferencia < valorParaNormalizar) {
            saida = (valorParaNormalizar / valorParaNormalizar) * 10;
        } else {
            saida = (valorParaNormalizar / valorReferencia) * 10;
        }

        return saida;*/
        return (valorParaNormalizar / valorReferencia) * 10; 
    }
    
    public void adicionarHeaderFiles(){
        
    }

}
