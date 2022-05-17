/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import entities.DataSet;
import java.text.DecimalFormat;
import java.util.Comparator;


/**
 *
 * @author bruno
 */
public class ComparatorA implements Comparator<DataSet> {

    @Override
    public int compare(DataSet ds1, DataSet ds2) {

        double xInfIntA = 0;
        double xSupIntA = 0;
        double yInfIntB = 0;
        double ySupIntB = 0;

        //JOptionPane.showMessageDialog(null, "xInfIntA: "+ds1.getxInf()+" xSupIntA: "+ds1.getxSup()+"\n"+
        //        "yInfIntB: "+ds2.getxInf()+ " ySupIntB: "+ds2.getxSup());
        String xValIntATemp = "";
        String yValIntBTemp = "";

        Integer xInfPos1 = 0;
        Integer xInfPos2 = 0;
        Integer xInfPos3 = 0;
        Integer xInfPos4 = 0;
        Integer xSupPos1 = 0;
        Integer xSupPos2 = 0;
        Integer xSupPos3 = 0;
        Integer xSupPos4 = 0;

        Integer yInfPos1 = 0;
        Integer yInfPos2 = 0;
        Integer yInfPos3 = 0;
        Integer yInfPos4 = 0;
        Integer ySupPos1 = 0;
        Integer ySupPos2 = 0;
        Integer ySupPos3 = 0;
        Integer ySupPos4 = 0;

        xInfIntA = ds1.getxInf();
        xSupIntA = ds1.getxSup();

        yInfIntB = ds2.getxInf();
        ySupIntB = ds2.getxSup();

        if (xInfIntA == 10.00) {
            xInfIntA = 9.999999;
        }

        if (xSupIntA == 10.00) {
            xSupIntA = 9.999999;
        }

        if (yInfIntB == 10.00) {
            yInfIntB = 9.999999;
        }

        if (ySupIntB == 10.00) {
            ySupIntB = 9.999999;
        }

        //if (xInfIntA == 0.0)
        //    JOptionPane.showMessageDialog(null, "Zero");
        if (xInfIntA == 0.0) {
            xInfIntA = 0.000000;
            // xInfIntA = Double.parseDouble(String.format ("%.7f", xInfIntA).replaceAll(",", "."));

            //https://www.ti-enxame.com/pt/java/como-faco-para-imprimir-um-valor-duplo-sem-notacao-cientifica-usando-java/1072259054/            
            //System.out.println("Zero: "+xInfIntA+ " Convertido para decimal: "+String.format ("%.7f", xInfIntA));
        }

        if (xSupIntA == 0.0) {
            xSupIntA = 0.000000;
        }

        if (yInfIntB == 0.0) {
            yInfIntB = 0.000000;
        }

        if (ySupIntB == 0.0) {
            ySupIntB = 0.000000;
        }

        System.out.println("xInfIntA: " + xInfIntA + " xSupIntA: " + xSupIntA);
        System.out.println("yInfIntB: " + yInfIntB + " ySupIntB: " + ySupIntB);

        xInfPos1 = Integer.parseInt(String.format("%.7f", xInfIntA).substring(2, 3));  //Integer.parseInt(Double.toString(xInfIntA).substring(2, 3));
        xInfPos2 = Integer.parseInt(String.format("%.7f", xInfIntA).substring(3, 4));  //Integer.parseInt(Double.toString(xInfIntA).substring(3, 4));
        xInfPos3 = Integer.parseInt(String.format("%.7f", xInfIntA).substring(4, 5));  //Integer.parseInt(Double.toString(xInfIntA).substring(4, 5)); 
        xInfPos4 = Integer.parseInt(String.format("%.7f", xInfIntA).substring(5, 6)); //Integer.parseInt(Double.toString(xInfIntA).substring(5, 6));

        //System.out.println("xInfIntA: "+xInfIntA+" xInfPos2: "+xInfPos2);
        xSupPos1 = Integer.parseInt(String.format("%.7f", xSupIntA).substring(2, 3)); //Integer.parseInt(Double.toString(xSupIntA).substring(2, 3));
        xSupPos2 = Integer.parseInt(String.format("%.7f", xSupIntA).substring(3, 4)); //Integer.parseInt(Double.toString(xSupIntA).substring(3, 4));
        xSupPos3 = Integer.parseInt(String.format("%.7f", xSupIntA).substring(4, 5)); //Integer.parseInt(Double.toString(xSupIntA).substring(4, 5));
        xSupPos4 = Integer.parseInt(String.format("%.7f", xSupIntA).substring(5, 6)); //Integer.parseInt(Double.toString(xSupIntA).substring(5, 6));

        yInfPos1 = Integer.parseInt(String.format("%.7f", yInfIntB).substring(2, 3));  // Integer.parseInt(Double.toString(yInfIntB).substring(2, 3));
        yInfPos2 = Integer.parseInt(String.format("%.7f", yInfIntB).substring(3, 4)); //Integer.parseInt(Double.toString(yInfIntB).substring(3, 4));
        yInfPos3 = Integer.parseInt(String.format("%.7f", yInfIntB).substring(4, 5)); //Integer.parseInt(Double.toString(yInfIntB).substring(4, 5));
        yInfPos4 = Integer.parseInt(String.format("%.7f", yInfIntB).substring(5, 6)); //Integer.parseInt(Double.toString(yInfIntB).substring(5, 6));

        ySupPos1 = Integer.parseInt(String.format("%.7f", ySupIntB).substring(2, 3)); //Integer.parseInt(Double.toString(ySupIntB).substring(2, 3));
        ySupPos2 = Integer.parseInt(String.format("%.7f", ySupIntB).substring(3, 4)); //Integer.parseInt(Double.toString(ySupIntB).substring(3, 4));
        ySupPos3 = Integer.parseInt(String.format("%.7f", ySupIntB).substring(4, 5)); //Integer.parseInt(Double.toString(ySupIntB).substring(4, 5));
        ySupPos4 = Integer.parseInt(String.format("%.7f", ySupIntB).substring(5, 6)); //Integer.parseInt(Double.toString(ySupIntB).substring(5, 6));

        String strXInfPos1 = Integer.toString(xInfPos1);
        String strXSupPos1 = Integer.toString(xSupPos1);
        String strXInfPos2 = Integer.toString(xInfPos2);
        String strXSupPos2 = Integer.toString(xSupPos2);
        String strXInfPos3 = Integer.toString(xInfPos3);
        String strXSupPos3 = Integer.toString(xSupPos3);
        String strXInfPos4 = Integer.toString(xInfPos4);
        String strXSupPos4 = Integer.toString(xSupPos4);

        String strYInfPos1 = Integer.toString(yInfPos1);
        String strYSupPos1 = Integer.toString(ySupPos1);
        String strYInfPos2 = Integer.toString(yInfPos2);
        String strYSupPos2 = Integer.toString(ySupPos2);
        String strYInfPos3 = Integer.toString(yInfPos3);
        String strYSupPos3 = Integer.toString(ySupPos3);
        String strYInfPos4 = Integer.toString(yInfPos4);
        String strYSupPos4 = Integer.toString(ySupPos4);

        if ((xInfIntA >= 0) && (xInfIntA <= xSupIntA) && (xSupIntA < 10)) {

            //double xInfIntATemp = 0; double xSupIntATemp = 0;
            //double yInfIntBTemp = 0; double ySupIntBTemp = 0;
            //double xInfIntA =0; double xSupIntA =0;
            //double yInfIntB =0; double ySupIntB =0;
            xValIntATemp = "0." + strXInfPos1 + strXSupPos1 + strXInfPos2 + strXSupPos2 + strXInfPos3 + strXSupPos3 + strXInfPos4 + strXSupPos4;

            yValIntBTemp = "0." + strYInfPos1 + strYSupPos1 + strYInfPos2 + strYSupPos2 + strYInfPos3 + strYSupPos3 + strYInfPos4 + strYSupPos4;

            /*JOptionPane.showMessageDialog(null,"A = [ "+ xInfIntA+","+xSupIntA+" ]"+ " B = ["+yInfIntB+","+yInfIntB+" ] \n"+
					" xValIntATemp = "+xValIntATemp+ " e yValIntBTemp = "+yValIntBTemp); */
            //xSupPos1 = Integer.parseInt(String.format("%.7f", xSupIntA).substring(2, 3));
            //String.format("%.7f", Double.parseDouble(xValIntATemp));
            // ajustar o retorno aqui em baixo
            if (Double.parseDouble(xValIntATemp) < Double.parseDouble(yValIntBTemp)) {
                //return -1;
                return 1;
            } else if (Double.parseDouble(xValIntATemp) > Double.parseDouble(yValIntBTemp)) {
                //return 1;
                return -1;
            } else {
                return 0;
            }

            //if (Double.parseDouble(xValIntATemp) < Double.parseDouble(yValIntBTemp)) 
            //outputHost = listHostUseLevel.get(i).getPowerHost();
            //else
            //outputHost = listHostUseLevel.get(i+1).getPowerHost();
            //}else if ((tempXValue >= 0) && (tempYValue >= tempXValue ) && (tempYValue == 10)) {
        } else if ((xInfIntA >= 0) && (xSupIntA >= xInfIntA) && (xSupIntA == 10)) {

            xValIntATemp = "0." + strXInfPos1 + "9" + strXInfPos2 + "9" + strXInfPos3 + "9" + strXInfPos4;
            yValIntBTemp = "0." + strYInfPos1 + "9" + strYInfPos2 + "9" + strYInfPos3 + "9" + strYInfPos4;

            // ajustar o retorno aqui em baixo
            if (Double.parseDouble(xValIntATemp) < Double.parseDouble(yValIntBTemp)) {
                //return -1;
                return 1;
            } else if (Double.parseDouble(xValIntATemp) > Double.parseDouble(yValIntBTemp)) {
                //return 1;
                return -1;
            } else {
                return 0;
            }
            //if (Double.parseDouble(xValIntATemp) < Double.parseDouble(yValIntBTemp)) 
            //	outputHost = listHostUseLevel.get(i).getPowerHost();
            //else
            //	outputHost = listHostUseLevel.get(i+1).getPowerHost();
        } else {

            xValIntATemp = "10";
            yValIntBTemp = "10";
            // ajustar o retorno aqui em baixo
            return 0;
            //outputHost = listHostUseLevel.get(i).getPowerHost();

        }

    }

}
