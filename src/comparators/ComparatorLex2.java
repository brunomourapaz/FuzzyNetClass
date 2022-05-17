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
public class ComparatorLex2 implements Comparator<DataSet>{

    @Override
    public int compare(DataSet ds1, DataSet ds2) {
        
        if( (ds1.getxSup() < ds2.getxSup()) || (ds1.getxSup() == ds2.getxSup() &&
                ds1.getxInf() <= ds2.getxInf()) ){
            
            
            return -1;
            //return 1;
            
        }
        
        //return 0;
        return 1;
    }

        
       
    
    
}
