/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;


import entities.DataSet;
import java.util.Comparator;

/**
 *
 * @author bruno
 */
public class ComparatorLex1 implements Comparator<DataSet>{
//https://cursos.alura.com.br/forum/topico-comparable-e-comparator-23978?gclid=CjwKCAjwzt6LBhBeEiwAbPGOgVshZ18r9zNTFCFVD34MwTzIdDAzppQjJhUwsOsch6bZNMSeoKYDnRoCy00QAvD_BwE
// retorna -1 para colocar objeto a esquerda
// retorna 1 para colocar objeto a direita    
// retorna 0 para manter a posição
    
    @Override
    public int compare(DataSet ds1, DataSet ds2) {
        
         if( (ds1.getxInf() < ds2.getxInf()) ||
                 (ds1.getxInf() == ds2.getxInf() &&
                 ds1.getxSup() <= ds2.getxSup())) {
            
                return 1;
            }
        
        return -1;
    }
    
}
