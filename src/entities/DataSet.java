/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



import com.opencsv.bean.CsvBindByPosition;
import java.util.Objects;

/**
 *
 * @author bruno
 */
public class DataSet implements Comparable<DataSet> {

    // atributos do dataset de origem
    @CsvBindByPosition(position = 0)
    private double fwdPacketLengthMean;
    
    @CsvBindByPosition(position = 1)
    private double fwdPacketLengthStd;
    
    @CsvBindByPosition(position = 2)
    private double bwdIATTotal;
    
    @CsvBindByPosition(position = 3)
    private double packetLengthMean;
    
    @CsvBindByPosition(position = 4)
    private String floxLabel;
    
    @CsvBindByPosition(position = 5)
    private double normFwdPacketLengthMean;
    
    @CsvBindByPosition(position = 6)
    private double normPacketLengthMean;
    
    @CsvBindByPosition(position = 7)
    private double normFwdPacketLengthStd;
    
    @CsvBindByPosition(position = 8)
    private double normBwdIATTotal;


    // atributos para agregar ao dataset da parte fuzzy
    @CsvBindByPosition(position = 9)
    private double xPonctual;
    
    @CsvBindByPosition(position = 10)
    private double xInf;
    
    @CsvBindByPosition(position = 11)
    private double xSup;

    // degree Of Membership Functions packetLengthMean
    @CsvBindByPosition(position = 12)
    private double lowPacketLengthMeanUpperBound;
    
    @CsvBindByPosition(position = 13)
    private double lowPacketLengthMeanLowerBound;

    @CsvBindByPosition(position = 14)
    private double reasonablePacketLengthMeanUpperBound;
    
    @CsvBindByPosition(position = 15)
    private double reasonablePacketLengthMeanLowerBound;
    
    @CsvBindByPosition(position = 16)
    private double highPacketLengthMeanUpperBound;
    
    @CsvBindByPosition(position = 17)
    private double highPacketLengthMeanLowerBound;

    // degree Of Membership Functions packetLengthStd
    @CsvBindByPosition(position = 18)
    private double lowPacketLengthStdUpperBound;
    
    @CsvBindByPosition(position = 19)
    private double lowPacketLengthStdLowerBound;
    
    @CsvBindByPosition(position = 20)
    private double reasonablePacketLengthStdUpperBound;
    
    @CsvBindByPosition(position = 21)
    private double reasonablePacketLengthStdLowerBound;
    
    @CsvBindByPosition(position = 22)
    private double highPacketLengthStdUpperBound;
    
    @CsvBindByPosition(position = 23)
    private double highPacketLengthStdLowerBound;

    // degree Of Membership Functions backwardIatTotal
    
    @CsvBindByPosition(position = 24)
    private double lowBackwardIatTotalUpperBound;
    
    @CsvBindByPosition(position = 25)
    private double lowBackwardIatTotalLowerBound;

    
    @CsvBindByPosition(position = 26)
    private double reasonableBackwardIatTotalUpperBound;
    
    @CsvBindByPosition(position = 27)
    private double reasonableBackwardIatTotalLowerBound;

    @CsvBindByPosition(position = 28)
    private double highBackwardIatTotalUpperBound;
    
    @CsvBindByPosition(position = 29)
    private double highBackwardIatTotalLowerBound;

    // degree Of Membership Functions video
    @CsvBindByPosition(position = 30)
    private double lowVideoUpperBound;
    
    @CsvBindByPosition(position = 31)
    private double lowVideoLowerBound;

    @CsvBindByPosition(position = 32)
    private double averageVideoUpperBound;
    
    @CsvBindByPosition(position = 33)
    private double averageVideoLowerBound;

    @CsvBindByPosition(position = 34)
    private double highVideoUpperBound;
    
    @CsvBindByPosition(position = 35)
    private double highVideoLowerBound;
    
    @CsvBindByPosition(position = 36)
    private int sequencial;

    public DataSet() {
    }

    
    
    

    @Override
    public int compareTo(DataSet t) {
        
        if (this.xPonctual < t.getxPonctual()) {
            return 1;

        } else if (this.xPonctual > t.getxPonctual()) {
            return -1;
        } else {

            return 0;
        }
    }

//    public static Comparator<DataSet> dataset = new Comparator<DataSet>() {
//        //https://www.alura.com.br/artigos/ordenando-uma-lista-de-objetos-em-java?gclid=CjwKCAjwq9mLBhB2EiwAuYdMtQQUDLiI1LNBAYH25aUKv1FoZuHiaAUVXLjapAVxaKePmwmeGq_jTxoC0dUQAvD_BwE
//        @Override
//        public int compare(DataSet ds1, DataSet ds2) {
//            //((ds1.getxInf() + ds1.getxSup()) < (ds2.getxInf() + ds2.getxSup()))
//        
//            if( (ds1.getxInf() + ds1.getxSup()) < (ds2.getxInf() + ds2.getxSup()) ||
//                    (ds1.getxInf() + ds1.getxSup()) == (ds2.getxInf() + ds2.getxSup()) &&
//                    (ds1.getxSup() - ds1.getxInf()) <= (ds2.getxSup() - ds2.getxInf()) ) {
//            
//                return -1;
//            }
//            
//            return 0;
//        }
//        
//    };

    @Override
    public String toString() {
        //return "DataSet{" + "sequencial=" + sequencial + '}';
        return "sequencial=" + sequencial + "\n";
    }



    public DataSet(double fwdPacketLengthMean, double fwdPacketLengthStd, double bwdIATTotal, double packetLengthMean, String floxLabel, double normFwdPacketLengthMean, double normPacketLengthMean, double normFwdPacketLengthStd, double normBwdIATTotal, double xPonctual, double xInf, double xSup, double lowPacketLengthMeanUpperBound, double lowPacketLengthMeanLowerBound, double reasonablePacketLengthMeanUpperBound, double reasonablePacketLengthMeanLowerBound, double highPacketLengthMeanUpperBound, double highPacketLengthMeanLowerBound, double lowPacketLengthStdUpperBound, double lowPacketLengthStdLowerBound, double reasonablePacketLengthStdUpperBound, double reasonablePacketLengthStdLowerBound, double highPacketLengthStdUpperBound, double highPacketLengthStdLowerBound, double lowBackwardIatTotalUpperBound, double lowBackwardIatTotalLowerBound, double reasonableBackwardIatTotalUpperBound, double reasonableBackwardIatTotalLowerBound, double highBackwardIatTotalUpperBound, double highBackwardIatTotalLowerBound, double lowVideoUpperBound, double lowVideoLowerBound, double averageVideoUpperBound, double averageVideoLowerBound, double highVideoUpperBound, double highVideoLowerBound, int sequencial) {
        this.fwdPacketLengthMean = fwdPacketLengthMean;
        this.fwdPacketLengthStd = fwdPacketLengthStd;
        this.bwdIATTotal = bwdIATTotal;
        this.packetLengthMean = packetLengthMean;
        this.floxLabel = floxLabel;
        this.normFwdPacketLengthMean = normFwdPacketLengthMean;
        this.normPacketLengthMean = normPacketLengthMean;
        this.normFwdPacketLengthStd = normFwdPacketLengthStd;
        this.normBwdIATTotal = normBwdIATTotal;
        this.xPonctual = xPonctual;
        this.xInf = xInf;
        this.xSup = xSup;
        this.lowPacketLengthMeanUpperBound = lowPacketLengthMeanUpperBound;
        this.lowPacketLengthMeanLowerBound = lowPacketLengthMeanLowerBound;
        this.reasonablePacketLengthMeanUpperBound = reasonablePacketLengthMeanUpperBound;
        this.reasonablePacketLengthMeanLowerBound = reasonablePacketLengthMeanLowerBound;
        this.highPacketLengthMeanUpperBound = highPacketLengthMeanUpperBound;
        this.highPacketLengthMeanLowerBound = highPacketLengthMeanLowerBound;
        this.lowPacketLengthStdUpperBound = lowPacketLengthStdUpperBound;
        this.lowPacketLengthStdLowerBound = lowPacketLengthStdLowerBound;
        this.reasonablePacketLengthStdUpperBound = reasonablePacketLengthStdUpperBound;
        this.reasonablePacketLengthStdLowerBound = reasonablePacketLengthStdLowerBound;
        this.highPacketLengthStdUpperBound = highPacketLengthStdUpperBound;
        this.highPacketLengthStdLowerBound = highPacketLengthStdLowerBound;
        this.lowBackwardIatTotalUpperBound = lowBackwardIatTotalUpperBound;
        this.lowBackwardIatTotalLowerBound = lowBackwardIatTotalLowerBound;
        this.reasonableBackwardIatTotalUpperBound = reasonableBackwardIatTotalUpperBound;
        this.reasonableBackwardIatTotalLowerBound = reasonableBackwardIatTotalLowerBound;
        this.highBackwardIatTotalUpperBound = highBackwardIatTotalUpperBound;
        this.highBackwardIatTotalLowerBound = highBackwardIatTotalLowerBound;
        this.lowVideoUpperBound = lowVideoUpperBound;
        this.lowVideoLowerBound = lowVideoLowerBound;
        this.averageVideoUpperBound = averageVideoUpperBound;
        this.averageVideoLowerBound = averageVideoLowerBound;
        this.highVideoUpperBound = highVideoUpperBound;
        this.highVideoLowerBound = highVideoLowerBound;
        this.sequencial = sequencial;
    }

    
    
    
    
    public double getFwdPacketLengthMean() {
        return fwdPacketLengthMean;
    }

    public void setFwdPacketLengthMean(double fwdPacketLengthMean) {
        this.fwdPacketLengthMean = fwdPacketLengthMean;
    }

    public double getFwdPacketLengthStd() {
        return fwdPacketLengthStd;
    }

    public void setFwdPacketLengthStd(double fwdPacketLengthStd) {
        this.fwdPacketLengthStd = fwdPacketLengthStd;
    }

    public double getBwdIATTotal() {
        return bwdIATTotal;
    }

    public void setBwdIATTotal(double bwdIATTotal) {
        this.bwdIATTotal = bwdIATTotal;
    }

    public double getPacketLengthMean() {
        return packetLengthMean;
    }

    public void setPacketLengthMean(double packetLengthMean) {
        this.packetLengthMean = packetLengthMean;
    }

    public String getFloxLabel() {
        return floxLabel;
    }

    public void setFloxLabel(String floxLabel) {
        this.floxLabel = floxLabel;
    }

    public double getNormFwdPacketLengthMean() {
        return normFwdPacketLengthMean;
    }

    public void setNormFwdPacketLengthMean(double normFwdPacketLengthMean) {
        this.normFwdPacketLengthMean = normFwdPacketLengthMean;
    }

    public double getNormPacketLengthMean() {
        return normPacketLengthMean;
    }

    public void setNormPacketLengthMean(double normPacketLengthMean) {
        this.normPacketLengthMean = normPacketLengthMean;
    }

    public double getNormFwdPacketLengthStd() {
        return normFwdPacketLengthStd;
    }

    public void setNormFwdPacketLengthStd(double normFwdPacketLengthStd) {
        this.normFwdPacketLengthStd = normFwdPacketLengthStd;
    }

    public double getNormBwdIATTotal() {
        return normBwdIATTotal;
    }

    public void setNormBwdIATTotal(double normBwdIATTotal) {
        this.normBwdIATTotal = normBwdIATTotal;
    }

    public double getxPonctual() {
        return xPonctual;
    }

    public void setxPonctual(double xPonctual) {
        this.xPonctual = xPonctual;
    }

    public double getxInf() {
        return xInf;
    }

    public void setxInf(double xInf) {
        this.xInf = xInf;
    }

    public double getxSup() {
        return xSup;
    }

    public void setxSup(double xSup) {
        this.xSup = xSup;
    }

    public double getLowPacketLengthMeanUpperBound() {
        return lowPacketLengthMeanUpperBound;
    }

    public void setLowPacketLengthMeanUpperBound(double lowPacketLengthMeanUpperBound) {
        this.lowPacketLengthMeanUpperBound = lowPacketLengthMeanUpperBound;
    }

    public double getLowPacketLengthMeanLowerBound() {
        return lowPacketLengthMeanLowerBound;
    }

    public void setLowPacketLengthMeanLowerBound(double lowPacketLengthMeanLowerBound) {
        this.lowPacketLengthMeanLowerBound = lowPacketLengthMeanLowerBound;
    }

    public double getReasonablePacketLengthMeanUpperBound() {
        return reasonablePacketLengthMeanUpperBound;
    }

    public void setReasonablePacketLengthMeanUpperBound(double reasonablePacketLengthMeanUpperBound) {
        this.reasonablePacketLengthMeanUpperBound = reasonablePacketLengthMeanUpperBound;
    }

    public double getReasonablePacketLengthMeanLowerBound() {
        return reasonablePacketLengthMeanLowerBound;
    }

    public void setReasonablePacketLengthMeanLowerBound(double reasonablePacketLengthMeanLowerBound) {
        this.reasonablePacketLengthMeanLowerBound = reasonablePacketLengthMeanLowerBound;
    }

    public double getHighPacketLengthMeanUpperBound() {
        return highPacketLengthMeanUpperBound;
    }

    public void setHighPacketLengthMeanUpperBound(double highPacketLengthMeanUpperBound) {
        this.highPacketLengthMeanUpperBound = highPacketLengthMeanUpperBound;
    }

    public double getHighPacketLengthMeanLowerBound() {
        return highPacketLengthMeanLowerBound;
    }

    public void setHighPacketLengthMeanLowerBound(double highPacketLengthMeanLowerBound) {
        this.highPacketLengthMeanLowerBound = highPacketLengthMeanLowerBound;
    }

    public double getLowPacketLengthStdUpperBound() {
        return lowPacketLengthStdUpperBound;
    }

    public void setLowPacketLengthStdUpperBound(double lowPacketLengthStdUpperBound) {
        this.lowPacketLengthStdUpperBound = lowPacketLengthStdUpperBound;
    }

    public double getLowPacketLengthStdLowerBound() {
        return lowPacketLengthStdLowerBound;
    }

    public void setLowPacketLengthStdLowerBound(double lowPacketLengthStdLowerBound) {
        this.lowPacketLengthStdLowerBound = lowPacketLengthStdLowerBound;
    }

    public double getReasonablePacketLengthStdUpperBound() {
        return reasonablePacketLengthStdUpperBound;
    }

    public void setReasonablePacketLengthStdUpperBound(double reasonablePacketLengthStdUpperBound) {
        this.reasonablePacketLengthStdUpperBound = reasonablePacketLengthStdUpperBound;
    }

    public double getReasonablePacketLengthStdLowerBound() {
        return reasonablePacketLengthStdLowerBound;
    }

    public void setReasonablePacketLengthStdLowerBound(double reasonablePacketLengthStdLowerBound) {
        this.reasonablePacketLengthStdLowerBound = reasonablePacketLengthStdLowerBound;
    }

    public double getHighPacketLengthStdUpperBound() {
        return highPacketLengthStdUpperBound;
    }

    public void setHighPacketLengthStdUpperBound(double highPacketLengthStdUpperBound) {
        this.highPacketLengthStdUpperBound = highPacketLengthStdUpperBound;
    }

    public double getHighPacketLengthStdLowerBound() {
        return highPacketLengthStdLowerBound;
    }

    public void setHighPacketLengthStdLowerBound(double highPacketLengthStdLowerBound) {
        this.highPacketLengthStdLowerBound = highPacketLengthStdLowerBound;
    }

    public double getLowBackwardIatTotalUpperBound() {
        return lowBackwardIatTotalUpperBound;
    }

    public void setLowBackwardIatTotalUpperBound(double lowBackwardIatTotalUpperBound) {
        this.lowBackwardIatTotalUpperBound = lowBackwardIatTotalUpperBound;
    }

    public double getLowBackwardIatTotalLowerBound() {
        return lowBackwardIatTotalLowerBound;
    }

    public void setLowBackwardIatTotalLowerBound(double lowBackwardIatTotalLowerBound) {
        this.lowBackwardIatTotalLowerBound = lowBackwardIatTotalLowerBound;
    }

    public double getReasonableBackwardIatTotalUpperBound() {
        return reasonableBackwardIatTotalUpperBound;
    }

    public void setReasonableBackwardIatTotalUpperBound(double reasonableBackwardIatTotalUpperBound) {
        this.reasonableBackwardIatTotalUpperBound = reasonableBackwardIatTotalUpperBound;
    }

    public double getReasonableBackwardIatTotalLowerBound() {
        return reasonableBackwardIatTotalLowerBound;
    }

    public void setReasonableBackwardIatTotalLowerBound(double reasonableBackwardIatTotalLowerBound) {
        this.reasonableBackwardIatTotalLowerBound = reasonableBackwardIatTotalLowerBound;
    }

    public double getHighBackwardIatTotalUpperBound() {
        return highBackwardIatTotalUpperBound;
    }

    public void setHighBackwardIatTotalUpperBound(double highBackwardIatTotalUpperBound) {
        this.highBackwardIatTotalUpperBound = highBackwardIatTotalUpperBound;
    }

    public double getHighBackwardIatTotalLowerBound() {
        return highBackwardIatTotalLowerBound;
    }

    public void setHighBackwardIatTotalLowerBound(double highBackwardIatTotalLowerBound) {
        this.highBackwardIatTotalLowerBound = highBackwardIatTotalLowerBound;
    }

    public double getLowVideoUpperBound() {
        return lowVideoUpperBound;
    }

    public void setLowVideoUpperBound(double lowVideoUpperBound) {
        this.lowVideoUpperBound = lowVideoUpperBound;
    }

    public double getLowVideoLowerBound() {
        return lowVideoLowerBound;
    }

    public void setLowVideoLowerBound(double lowVideoLowerBound) {
        this.lowVideoLowerBound = lowVideoLowerBound;
    }

    public double getAverageVideoUpperBound() {
        return averageVideoUpperBound;
    }

    public void setAverageVideoUpperBound(double averageVideoUpperBound) {
        this.averageVideoUpperBound = averageVideoUpperBound;
    }

    public double getAverageVideoLowerBound() {
        return averageVideoLowerBound;
    }

    public void setAverageVideoLowerBound(double averageVideoLowerBound) {
        this.averageVideoLowerBound = averageVideoLowerBound;
    }

    public double getHighVideoUpperBound() {
        return highVideoUpperBound;
    }

    public void setHighVideoUpperBound(double highVideoUpperBound) {
        this.highVideoUpperBound = highVideoUpperBound;
    }

    public double getHighVideoLowerBound() {
        return highVideoLowerBound;
    }

    public void setHighVideoLowerBound(double highVideoLowerBound) {
        this.highVideoLowerBound = highVideoLowerBound;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.fwdPacketLengthMean) ^ (Double.doubleToLongBits(this.fwdPacketLengthMean) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.fwdPacketLengthStd) ^ (Double.doubleToLongBits(this.fwdPacketLengthStd) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.bwdIATTotal) ^ (Double.doubleToLongBits(this.bwdIATTotal) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.packetLengthMean) ^ (Double.doubleToLongBits(this.packetLengthMean) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.floxLabel);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.normFwdPacketLengthMean) ^ (Double.doubleToLongBits(this.normFwdPacketLengthMean) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.normPacketLengthMean) ^ (Double.doubleToLongBits(this.normPacketLengthMean) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.normFwdPacketLengthStd) ^ (Double.doubleToLongBits(this.normFwdPacketLengthStd) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.normBwdIATTotal) ^ (Double.doubleToLongBits(this.normBwdIATTotal) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.xPonctual) ^ (Double.doubleToLongBits(this.xPonctual) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.xInf) ^ (Double.doubleToLongBits(this.xInf) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.xSup) ^ (Double.doubleToLongBits(this.xSup) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowPacketLengthMeanUpperBound) ^ (Double.doubleToLongBits(this.lowPacketLengthMeanUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowPacketLengthMeanLowerBound) ^ (Double.doubleToLongBits(this.lowPacketLengthMeanLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.reasonablePacketLengthMeanUpperBound) ^ (Double.doubleToLongBits(this.reasonablePacketLengthMeanUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.reasonablePacketLengthMeanLowerBound) ^ (Double.doubleToLongBits(this.reasonablePacketLengthMeanLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highPacketLengthMeanUpperBound) ^ (Double.doubleToLongBits(this.highPacketLengthMeanUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highPacketLengthMeanLowerBound) ^ (Double.doubleToLongBits(this.highPacketLengthMeanLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowPacketLengthStdUpperBound) ^ (Double.doubleToLongBits(this.lowPacketLengthStdUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowPacketLengthStdLowerBound) ^ (Double.doubleToLongBits(this.lowPacketLengthStdLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.reasonablePacketLengthStdUpperBound) ^ (Double.doubleToLongBits(this.reasonablePacketLengthStdUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.reasonablePacketLengthStdLowerBound) ^ (Double.doubleToLongBits(this.reasonablePacketLengthStdLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highPacketLengthStdUpperBound) ^ (Double.doubleToLongBits(this.highPacketLengthStdUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highPacketLengthStdLowerBound) ^ (Double.doubleToLongBits(this.highPacketLengthStdLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowBackwardIatTotalUpperBound) ^ (Double.doubleToLongBits(this.lowBackwardIatTotalUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowBackwardIatTotalLowerBound) ^ (Double.doubleToLongBits(this.lowBackwardIatTotalLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.reasonableBackwardIatTotalUpperBound) ^ (Double.doubleToLongBits(this.reasonableBackwardIatTotalUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.reasonableBackwardIatTotalLowerBound) ^ (Double.doubleToLongBits(this.reasonableBackwardIatTotalLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highBackwardIatTotalUpperBound) ^ (Double.doubleToLongBits(this.highBackwardIatTotalUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highBackwardIatTotalLowerBound) ^ (Double.doubleToLongBits(this.highBackwardIatTotalLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowVideoUpperBound) ^ (Double.doubleToLongBits(this.lowVideoUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.lowVideoLowerBound) ^ (Double.doubleToLongBits(this.lowVideoLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.averageVideoUpperBound) ^ (Double.doubleToLongBits(this.averageVideoUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.averageVideoLowerBound) ^ (Double.doubleToLongBits(this.averageVideoLowerBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highVideoUpperBound) ^ (Double.doubleToLongBits(this.highVideoUpperBound) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.highVideoLowerBound) ^ (Double.doubleToLongBits(this.highVideoLowerBound) >>> 32));
        hash = 59 * hash + this.sequencial;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataSet other = (DataSet) obj;
        if (Double.doubleToLongBits(this.fwdPacketLengthMean) != Double.doubleToLongBits(other.fwdPacketLengthMean)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fwdPacketLengthStd) != Double.doubleToLongBits(other.fwdPacketLengthStd)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bwdIATTotal) != Double.doubleToLongBits(other.bwdIATTotal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.packetLengthMean) != Double.doubleToLongBits(other.packetLengthMean)) {
            return false;
        }
        if (Double.doubleToLongBits(this.normFwdPacketLengthMean) != Double.doubleToLongBits(other.normFwdPacketLengthMean)) {
            return false;
        }
        if (Double.doubleToLongBits(this.normPacketLengthMean) != Double.doubleToLongBits(other.normPacketLengthMean)) {
            return false;
        }
        if (Double.doubleToLongBits(this.normFwdPacketLengthStd) != Double.doubleToLongBits(other.normFwdPacketLengthStd)) {
            return false;
        }
        if (Double.doubleToLongBits(this.normBwdIATTotal) != Double.doubleToLongBits(other.normBwdIATTotal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.xPonctual) != Double.doubleToLongBits(other.xPonctual)) {
            return false;
        }
        if (Double.doubleToLongBits(this.xInf) != Double.doubleToLongBits(other.xInf)) {
            return false;
        }
        if (Double.doubleToLongBits(this.xSup) != Double.doubleToLongBits(other.xSup)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowPacketLengthMeanUpperBound) != Double.doubleToLongBits(other.lowPacketLengthMeanUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowPacketLengthMeanLowerBound) != Double.doubleToLongBits(other.lowPacketLengthMeanLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.reasonablePacketLengthMeanUpperBound) != Double.doubleToLongBits(other.reasonablePacketLengthMeanUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.reasonablePacketLengthMeanLowerBound) != Double.doubleToLongBits(other.reasonablePacketLengthMeanLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highPacketLengthMeanUpperBound) != Double.doubleToLongBits(other.highPacketLengthMeanUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highPacketLengthMeanLowerBound) != Double.doubleToLongBits(other.highPacketLengthMeanLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowPacketLengthStdUpperBound) != Double.doubleToLongBits(other.lowPacketLengthStdUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowPacketLengthStdLowerBound) != Double.doubleToLongBits(other.lowPacketLengthStdLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.reasonablePacketLengthStdUpperBound) != Double.doubleToLongBits(other.reasonablePacketLengthStdUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.reasonablePacketLengthStdLowerBound) != Double.doubleToLongBits(other.reasonablePacketLengthStdLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highPacketLengthStdUpperBound) != Double.doubleToLongBits(other.highPacketLengthStdUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highPacketLengthStdLowerBound) != Double.doubleToLongBits(other.highPacketLengthStdLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowBackwardIatTotalUpperBound) != Double.doubleToLongBits(other.lowBackwardIatTotalUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowBackwardIatTotalLowerBound) != Double.doubleToLongBits(other.lowBackwardIatTotalLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.reasonableBackwardIatTotalUpperBound) != Double.doubleToLongBits(other.reasonableBackwardIatTotalUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.reasonableBackwardIatTotalLowerBound) != Double.doubleToLongBits(other.reasonableBackwardIatTotalLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highBackwardIatTotalUpperBound) != Double.doubleToLongBits(other.highBackwardIatTotalUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highBackwardIatTotalLowerBound) != Double.doubleToLongBits(other.highBackwardIatTotalLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowVideoUpperBound) != Double.doubleToLongBits(other.lowVideoUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lowVideoLowerBound) != Double.doubleToLongBits(other.lowVideoLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.averageVideoUpperBound) != Double.doubleToLongBits(other.averageVideoUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.averageVideoLowerBound) != Double.doubleToLongBits(other.averageVideoLowerBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highVideoUpperBound) != Double.doubleToLongBits(other.highVideoUpperBound)) {
            return false;
        }
        if (Double.doubleToLongBits(this.highVideoLowerBound) != Double.doubleToLongBits(other.highVideoLowerBound)) {
            return false;
        }
        if (this.sequencial != other.sequencial) {
            return false;
        }
        if (!Objects.equals(this.floxLabel, other.floxLabel)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
