/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.DataSet;
import java.util.Comparator;

/**
 *
 * @author bruno
 */
public class MyComparator {

    public MyComparator() {
    }
    
    
    
    
    public  Comparator<DataSet> ds = new Comparator<DataSet>() {

        @Override
        public int compare(DataSet ds1, DataSet ds2) {
            
            if(ds1.getxPonctual() < ds2.getxPonctual()){
                return 1;
            }
            
            return 0;
            
        }
				
	};
    
}
