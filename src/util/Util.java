/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import fuzzy.IntervalValuedFuzzyEvaluation;


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

    public void adicionarHeaderFiles() {

    }

    public Object getIntervalValuedFuzzySystemModel(String model, double normPacketLengthMean,
            double normFwdPacketLengthStd, double normBwdIATTotal) {

        Object obj = new Object();

        /*
           if(cmbModelagem.getSelectedItem() == "Convencional"){
                            JOptionPane.showMessageDialog(null, "Entrei");
                        }
                        
                        // cria objeto do sistema de inferencia fuzzy 
                        // e seta os valores das variáveis/atributos de entrada do sistema fuzzy
                        IntervalValuedFuzzyEvaluation fs
                                = new IntervalValuedFuzzyEvaluation(normPacketLengthMean, normFwdPacketLengthStd,
                                        normBwdIATTotal, false, "maxmin", "minmax");
         */
        if (model.equalsIgnoreCase("Convencional")) {
            obj = new IntervalValuedFuzzyEvaluation(normPacketLengthMean,
                    normFwdPacketLengthStd, normBwdIATTotal, false, "maxmin", "minmax");
        }
        
        
      
        return obj;

    }

}
