/*
 * IntervalValuedFuzzyEvaluation.java
 *
 * Created on May 21st 2012
 *
 * Copyright 2012 Christian Wagner All Rights Reserved.
 */
package fuzzy;

import generic.Input;
import generic.Output;
import generic.Tuple;
import intervalType2.sets.IntervalT2MF_Interface;
import intervalType2.sets.IntervalT2MF_Trapezoidal;
import intervalType2.system.IT2_Antecedent;
import intervalType2.system.IT2_Consequent;
import intervalType2.system.IT2_Rule;
import intervalType2.system.IT2_Rulebase;

import java.util.TreeMap;
import tools.JMathPlotter;
import type1.sets.T1MF_Trapezoidal;

/**
 * A simple example of an interval Type-2 FLS based on the "How much to tip the
 * waiter" scenario. The example is an extension of the Type-1 FLS example where
 * we extend the MFs and use the Interval Type-2 System classes. Note that in
 * contrast to the type-1 case, here only two sets are used to model the service
 * quality. We have two inputs: food quality and service level and as an output
 * we would like to generate the applicable tip.
 *
 * @author Christian Wagner
 */
public final class IntervalValuedFuzzyEvaluation {

    private Input packetLengthMean, packetLengthStd, backwardIatTotal;  //the inputs to the FLS
    private Output video;             //the output of the FLS
    private IT2_Rulebase rulebase;   //the rulebase captures the entire FLS

    private double inPacketLengthMean;
    private double inPacketLengthStd;
    private double inBackwardIatTotal;

    private String typeIntersection;
    private String typeUnion;

    // Outs
    private double xPonctual;
    private double xInf;
    private double xSup;

    // degree Of Membership Functions packetLengthMean
    private double lowPacketLengthMeanUpperBound;
    private double lowPacketLengthMeanLowerBound;

    private double reasonablePacketLengthMeanUpperBound;
    private double reasonablePacketLengthMeanLowerBound;

    private double highPacketLengthMeanUpperBound;
    private double highPacketLengthMeanLowerBound;

    // degree Of Membership Functions packetLengthStd
    private double lowPacketLengthStdUpperBound;
    private double lowPacketLengthStdLowerBound;

    private double reasonablePacketLengthStdUpperBound;
    private double reasonablePacketLengthStdLowerBound;

    private double highPacketLengthStdUpperBound;
    private double highPacketLengthStdLowerBound;

    // degree Of Membership Functions backwardIatTotal
    private double lowBackwardIatTotalUpperBound;
    private double lowBackwardIatTotalLowerBound;

    private double reasonableBackwardIatTotalUpperBound;
    private double reasonableBackwardIatTotalLowerBound;

    private double highBackwardIatTotalUpperBound;
    private double highBackwardIatTotalLowerBound;

    // degree Of Membership Functions video
    private double lowVideoUpperBound;
    private double lowVideoLowerBound;

    private double averageVideoUpperBound;
    private double averageVideoLowerBound;

    private double highVideoUpperBound;
    private double highVideoLowerBound;

    //public IntervalValuedFuzzyEvaluation() {}
    public IntervalValuedFuzzyEvaluation(double inPacketLengthMean, double inPacketLengthStd, double inBackwardIatTotal,
            boolean isPlotMF, String typeIntersection, String typeUnion) {
        this.inPacketLengthMean = inPacketLengthMean;
        this.inPacketLengthStd = inPacketLengthStd;
        this.inBackwardIatTotal = inBackwardIatTotal;
        this.typeIntersection = typeIntersection;
        this.typeUnion = typeUnion;

        //Define the inputs
        this.packetLengthMean = new Input("packetLengthMean", new Tuple(0, 10)); // packetLengthMean
        this.packetLengthStd = new Input("packetLengthStd", new Tuple(0, 10)); // packetLengthStd
        this.backwardIatTotal = new Input("backwardIatTotal", new Tuple(0, 10)); // backwardIatTotal

        this.video = new Output("VIDEO", new Tuple(0, 10));   // a percentage for the video

        //Membership Functions Model
        // MF for PacketLengthMean
        //MF1='limited':'itrapatype2',[-2.269 -0.9 0.45 2.4 -1.329 -0.01882 1.5 3.5 0.9]
        T1MF_Trapezoidal lowPacketLengthMeanUMF = new T1MF_Trapezoidal("Upper MF for Low PacketLengthMean", new double[]{-2.27, -0.9, 1.5, 3.5});
        T1MF_Trapezoidal lowPacketLengthMeanLMF = new T1MF_Trapezoidal("Lower MF for Low PacketLengthMean", new double[]{-1.3, -0.2, 0.45, 2.4});
        IntervalT2MF_Trapezoidal lowPacketLengthMeanMF = new IntervalT2MF_Trapezoidal("IT2MF for Low PacketLengthMean", lowPacketLengthMeanUMF, lowPacketLengthMeanLMF);

        //MF2='reasonable':'itrapatype2',[1.6 3.8 5.4 7.4 2.6 4.6 6.3 8.4 0.9]
        T1MF_Trapezoidal reasonablePacketLengthMeanUMF = new T1MF_Trapezoidal("Upper MF for Reasonable PacketLengthMean", new double[]{1.6, 3.8, 6.3, 8.4});
        T1MF_Trapezoidal reasonablePacketLengthMeanLMF = new T1MF_Trapezoidal("Lower MF for Reasonable PacketLengthMean", new double[]{2.6, 4.6, 5.4, 7.4});
        IntervalT2MF_Trapezoidal reasonablePacketLengthMeanMF = new IntervalT2MF_Trapezoidal("IT2MF for Reasonable PacketLengthMean", reasonablePacketLengthMeanUMF, reasonablePacketLengthMeanLMF);

        //MF3='high':'itrapatype2',[6.65 7.65 10.19 12.34 7.65 8.5 11.19 13.34 0.9]
        T1MF_Trapezoidal highPacketLengthMeanUMF = new T1MF_Trapezoidal("Upper MF for High PacketLengthMean", new double[]{6.65, 7.65, 11.19, 13.34});
        T1MF_Trapezoidal highPacketLengthMeanLMF = new T1MF_Trapezoidal("Lower MF for High PacketLengthMean", new double[]{7.65, 8.5, 10.19, 12.34});
        IntervalT2MF_Trapezoidal highPacketLengthMeanMF = new IntervalT2MF_Trapezoidal("IT2MF for High PacketLengthMean", highPacketLengthMeanUMF, highPacketLengthMeanLMF);

        // MF for packetLengthStd
        //MF1='small':'itrapatype2',[-2.27 -0.8 0.5 2.4 -1.327 -0.01682 1.35 3.4 0.9]
        T1MF_Trapezoidal lowPacketLengthStdUMF = new T1MF_Trapezoidal("Upper MF for Small PacketLengthStd", new double[]{-2.27, -0.8, 1.35, 3.4});
        T1MF_Trapezoidal lowPacketLengthStdLMF = new T1MF_Trapezoidal("Lower MF for Small PacketLengthStd", new double[]{-1.3, -0.02, 0.5, 2.4});
        IntervalT2MF_Trapezoidal lowPacketLengthStdMF = new IntervalT2MF_Trapezoidal("IT2MF for Small PacketLengthStd", lowPacketLengthStdUMF, lowPacketLengthStdLMF);

        //MF3='average':'itrapatype2',[1.5 4 5.2 7.5 2.5 4.8 6 8.5 0.9]
        T1MF_Trapezoidal reasonablePacketLengthStdUMF = new T1MF_Trapezoidal("Upper MF for Average PacketLengthStd", new double[]{1.5, 4, 6, 8.5});
        T1MF_Trapezoidal reasonablePacketLengthStdLMF = new T1MF_Trapezoidal("Lower MF for Average PacketLengthStd", new double[]{2.5, 4.8, 5.2, 7.5});
        IntervalT2MF_Trapezoidal reasonablePacketLengthStdMF = new IntervalT2MF_Trapezoidal("IT2MF for Average PacketLengthStd", reasonablePacketLengthStdUMF, reasonablePacketLengthStdLMF);

        //MF2='big':'itrapatype2',[6.5 8.5 10 12 7.5 9.2 11.19 13.34 0.9]
        T1MF_Trapezoidal highPacketLengthStdUMF = new T1MF_Trapezoidal("Upper MF for High PacketLengthStd", new double[]{6.5, 8.5, 11.19, 13.34});
        T1MF_Trapezoidal highPacketLengthStdLMF = new T1MF_Trapezoidal("Lower MF for High PacketLengthStd", new double[]{7.5, 9.2, 10, 12});
        IntervalT2MF_Trapezoidal highPacketLengthStdMF = new IntervalT2MF_Trapezoidal("IT2MF for High PacketLengthStd", highPacketLengthStdUMF, highPacketLengthStdLMF);

        // MF for BackwardIatTotal
        //MF1='small':'itrapatype2',[-2.27 -0.8 0.5 2.4 -1.327 -0.01682 1.35 3.4 0.9]
        T1MF_Trapezoidal lowBackwardIatTotalUMF = new T1MF_Trapezoidal("Upper MF for Low BackwardIatTotal", new double[]{-2.27, -0.8, 1.35, 3.4});
        T1MF_Trapezoidal lowBackwardIatTotalLMF = new T1MF_Trapezoidal("Lower MF for Low BackwardIatTotal", new double[]{-1.327, -0.01682, 0.5, 2.4});
        IntervalT2MF_Trapezoidal lowBackwardIatTotalMF = new IntervalT2MF_Trapezoidal("IT2MF for Low BackwardIatTotal", lowBackwardIatTotalUMF, lowBackwardIatTotalLMF);

        //MF2='average':'itrapatype2',[1.5 4 5.2 7.5 2.5 4.8 6 8.5 0.9]
        T1MF_Trapezoidal reasonableBackwardIatTotalUMF = new T1MF_Trapezoidal("Upper MF for Reasonable BackwardIatTotal", new double[]{1.5, 4, 6, 8.5});
        T1MF_Trapezoidal reasonableBackwardIatTotalLMF = new T1MF_Trapezoidal("Lower MF for Reasonable BackwardIatTotal", new double[]{2.5, 4.8, 5.2, 7.5});
        IntervalT2MF_Trapezoidal reasonableBackwardIatTotalMF = new IntervalT2MF_Trapezoidal("IT2MF Reasonable BackwardIatTotal", reasonableBackwardIatTotalUMF, reasonableBackwardIatTotalLMF);

        //MF3='high':'itrapatype2',[6.5 8.5 10 12 7.5 9.2 11.19 13.34 0.9]
        T1MF_Trapezoidal highBackwardIatTotalUMF = new T1MF_Trapezoidal("Upper MF for High RATIO", new double[]{6.5, 8.5, 11.19, 13.34});
        T1MF_Trapezoidal highBackwardIatTotalLMF = new T1MF_Trapezoidal("Lower MF for High RATIO", new double[]{7.5, 9.2, 10, 12});
        IntervalT2MF_Trapezoidal highBackwardIatTotalMF = new IntervalT2MF_Trapezoidal("IT2MF for High RATIO", highBackwardIatTotalUMF, highBackwardIatTotalLMF);

        // MF for Video
        //MF1='low':'itrapatype2',[-1.74698039215686 -0.590980392156862 -0.569980392156862 3.99901960784314 -1.24678039215686 0.079019607843138 0.409019607843138 4.99901960784314 0.9]
        T1MF_Trapezoidal lowVideoUMF = new T1MF_Trapezoidal("Upper MF for Low Video", new double[]{-1.75, -0.6, 0.41, 5});
        T1MF_Trapezoidal lowVideoLMF = new T1MF_Trapezoidal("Lower MF for Low Video", new double[]{-1.2, 0.08, -0.57, 4.0}); //
        IntervalT2MF_Trapezoidal lowVideoMF = new IntervalT2MF_Trapezoidal("IT2MF for Low Video ", lowVideoUMF, lowVideoLMF);

        //MF2='average':'itrapatype2',[0.5 4.5 4.83 8.5 1.5 5.16 5.5 9.5 0.9]
        T1MF_Trapezoidal averageVideoUMF = new T1MF_Trapezoidal("Upper MF for Average Video", new double[]{0.5, 4.5, 5.5, 9.5});
        T1MF_Trapezoidal averageVideoLMF = new T1MF_Trapezoidal("Lower MF for Average Video", new double[]{1.5, 5.16, 4.83, 8.5});
        IntervalT2MF_Trapezoidal averageVideoMF = new IntervalT2MF_Trapezoidal("IT2MF for Average Video ", averageVideoUMF, averageVideoLMF);

        //MF3='high':'itrapatype2',[5 9.61 9.94 11.3 6 10.3 10.7 11.8 0.9]
        T1MF_Trapezoidal highVideoUMF = new T1MF_Trapezoidal("Upper MF for High Video", new double[]{5, 9.6, 10.7, 11.8});
        T1MF_Trapezoidal highVideoLMF = new T1MF_Trapezoidal("Lower MF for High Video", new double[]{6, 10.3, 9.94, 11.3});
        IntervalT2MF_Trapezoidal highVideoMF = new IntervalT2MF_Trapezoidal("IT2MF for High Video ", highVideoUMF, highVideoLMF);

        //plotMFs("Priority Membership Functions", new IntervalT2MF_Interface[]{lowPriorityMF, averagePriorityMF, highPriorityMF}, 10);
        //Set up the antecedents and consequents - note how the inputs are associated...
        IT2_Antecedent lowFPLMean = new IT2_Antecedent("lowPacketLengthMean", lowPacketLengthMeanMF, packetLengthMean);
        IT2_Antecedent reasonableFPLMean = new IT2_Antecedent("reasonablePacketLengthMean", reasonablePacketLengthMeanMF, packetLengthMean);
        IT2_Antecedent highFPLMean = new IT2_Antecedent("highPacketLengthMean", highPacketLengthMeanMF, packetLengthMean);

        IT2_Antecedent lowFPLStd = new IT2_Antecedent("lowPacketLengthStd", lowPacketLengthStdMF, packetLengthStd);
        IT2_Antecedent reasonableFPLStd = new IT2_Antecedent("reasonablePacketLengthStd", reasonablePacketLengthStdMF, packetLengthStd);
        IT2_Antecedent highFPLStd = new IT2_Antecedent("highPacketLengthStd", highPacketLengthStdMF, packetLengthStd);

        IT2_Antecedent lowBiatTotal = new IT2_Antecedent("lowBackwardIatTotal", lowBackwardIatTotalMF, backwardIatTotal);
        IT2_Antecedent reasonableBiatTotal = new IT2_Antecedent("reasonableBackwardIatTotal", reasonableBackwardIatTotalMF, backwardIatTotal);
        IT2_Antecedent highBiatTotal = new IT2_Antecedent("highBackwardIatTotal", highBackwardIatTotalMF, backwardIatTotal);

        IT2_Consequent lowVideo = new IT2_Consequent("lowVideo", lowVideoMF, video);
        IT2_Consequent averageVideo = new IT2_Consequent("averageVideo", averageVideoMF, video);
        IT2_Consequent highVideo = new IT2_Consequent("highVideo", highVideoMF, video);

        // Set up the rulebase and add rules
        rulebase = new IT2_Rulebase(27);

        /* rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, reasonableFPLStd}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, highFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, lowFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, reasonableFPLStd, reasonableFPLStd}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, highFPLStd, reasonableFPLStd}, highVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, highFPLStd, reasonableFPLStd}, highVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, reasonableFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, highFPLStd, lowBiatTotal}, highVideo));*/
        
        /*rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, highFPLStd, lowBiatTotal}, highVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, highFPLStd, lowBiatTotal}, highVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, reasonableFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, highFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, lowFPLStd, lowBiatTotal}, lowVideo));*/
 
 
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, lowFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, reasonableFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, highFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, highFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{lowFPLMean, highFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, lowFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, lowFPLStd, reasonableBiatTotal}, lowVideo));
        //rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, lowFPLStd, highBiatTotal}, Selecione));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, lowFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, reasonableFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, reasonableFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, reasonableFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, highFPLStd, lowBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, highFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{reasonableFPLMean, highFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, lowFPLStd, lowBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, lowFPLStd, reasonableBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, lowFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, reasonableFPLStd, reasonableBiatTotal}, averageVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, reasonableFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, reasonableFPLStd, lowBiatTotal}, highVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, highFPLStd, reasonableBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, highFPLStd, highBiatTotal}, lowVideo));
        rulebase.addRule(new IT2_Rule(new IT2_Antecedent[]{highFPLMean, highFPLStd, lowBiatTotal}, averageVideo));

        rulebase.setImplicationMethod((byte) 1);
        //rulebase.setTypeIntersection("TL"); // default juzzy maxmin
        //rulebase.setTypeUnion("TLN"); // default juzzy minmax
        rulebase.setTypeIntersection(this.typeIntersection); // default juzzy maxmin
        rulebase.setTypeUnion(this.typeUnion); // default juzzy minmax

        // obtem os graus de pertinência da entrada para PacketLengthMean
        setLowPacketLengthMeanLowerBound(getDegreeOfMembershipLower(this.inPacketLengthMean, lowPacketLengthMeanMF));
        setLowPacketLengthMeanUpperBound(getDegreeOfMembershipUpper(this.inPacketLengthMean, lowPacketLengthMeanMF));

        setReasonablePacketLengthMeanLowerBound(getDegreeOfMembershipLower(this.inPacketLengthMean, reasonablePacketLengthMeanMF));
        setReasonablePacketLengthMeanUpperBound(getDegreeOfMembershipUpper(this.inPacketLengthMean, reasonablePacketLengthMeanMF));

        setHighPacketLengthMeanLowerBound(getDegreeOfMembershipLower(this.inPacketLengthMean, highPacketLengthMeanMF));
        setHighPacketLengthMeanUpperBound(getDegreeOfMembershipUpper(this.inPacketLengthMean, highPacketLengthMeanMF));

        // obtem os graus de pertinência da entrada para PacketLengthStd
        setLowPacketLengthStdLowerBound(getDegreeOfMembershipLower(this.inPacketLengthStd, lowPacketLengthStdMF));
        setLowPacketLengthStdUpperBound(getDegreeOfMembershipUpper(this.inPacketLengthStd, lowPacketLengthStdMF));

        setReasonablePacketLengthStdLowerBound(getDegreeOfMembershipLower(this.inPacketLengthStd, reasonablePacketLengthStdMF));
        setReasonablePacketLengthStdUpperBound(getDegreeOfMembershipUpper(this.inPacketLengthStd, reasonablePacketLengthStdMF));

        setHighPacketLengthStdLowerBound(getDegreeOfMembershipLower(this.inPacketLengthStd, highPacketLengthStdMF));
        setHighPacketLengthStdLowerBound(getDegreeOfMembershipUpper(this.inPacketLengthStd, highPacketLengthStdMF));

        // obtem os graus de pertinência da entrada para backwardIatTotal
        setLowBackwardIatTotalLowerBound(getDegreeOfMembershipLower(this.inBackwardIatTotal, lowBackwardIatTotalMF));
        setLowBackwardIatTotalUpperBound(getDegreeOfMembershipUpper(this.inBackwardIatTotal, lowBackwardIatTotalMF));

        setReasonableBackwardIatTotalLowerBound(getDegreeOfMembershipLower(this.inBackwardIatTotal, reasonableBackwardIatTotalMF));
        setReasonableBackwardIatTotalUpperBound(getDegreeOfMembershipUpper(this.inBackwardIatTotal, reasonableBackwardIatTotalMF));

        setHighBackwardIatTotalLowerBound(getDegreeOfMembershipLower(this.inBackwardIatTotal, highBackwardIatTotalMF));
        setHighBackwardIatTotalUpperBound(getDegreeOfMembershipUpper(this.inBackwardIatTotal, highBackwardIatTotalMF));

        //get some outputs
        //getRating(1.0, 8.0, 1.0);
        //getRating(inPacketLengthMean, inPacketLengthStd, inBackwardIatTotal);
        // Faz a classificação
        getRating();

        // obtem os graus de pertinência da entrada para saída Video 
        setLowVideoLowerBound(getDegreeOfMembershipLower(this.xPonctual, lowVideoMF));
        setLowVideoUpperBound(getDegreeOfMembershipUpper(this.xPonctual, lowVideoMF));

        setAverageVideoLowerBound(getDegreeOfMembershipLower(this.xPonctual, averageVideoMF));
        setAverageVideoUpperBound(getDegreeOfMembershipUpper(this.xPonctual, averageVideoMF));

        setHighVideoLowerBound(getDegreeOfMembershipLower(this.xPonctual, highVideoMF));
        setHighVideoUpperBound(getDegreeOfMembershipUpper(this.xPonctual, highVideoMF));

        //plot some sets, discretizing each input into 100 steps.
        //plotMembershipFunctions(false);
        //private void plotMFs(String name, IntervalT2MF_Interface[] sets, int discretizationLevel)
        //plotMFs("packetLengthMean", new IntervalT2MF_Interface[]{lowPacketLengthMeanMF,reasonablePacketLengthMeanMF,highPacketLengthMeanMF}, 10);
        //plotMFs("packetLengthMean Membership Functions", new IntervalT2MF_Interface[]{lowPacketLengthMeanMF , reasonablePacketLengthMeanMF, highPacketLengthMeanMF}, 10);
        //plot control surface
        //do either height defuzzification (false) or centroid d. (true)
        // plotControlSurface(false, 100, 100);
        //print out the rules
        System.out.println("\n" + rulebase);

    }

    /**
     * Basic method that prints the output for a given set of inputs.
     *
     * @param inPacketLengthMean
     * @param inPacketLengthStd
     * @param inBackwardIatTotal
     */
    // public void getRating(double inPacketLengthMean, double inPacketLengthStd, double inBackwardIatTotal) {
    public void getRating() {
        //first, set the inputs

        packetLengthMean.setInput(this.inPacketLengthMean);
        packetLengthStd.setInput(this.inPacketLengthStd);
        backwardIatTotal.setInput(this.inBackwardIatTotal);

        //now execute the FLS and print output
        // private final byte CENTEROFSETS = 0;
	// private final byte CENTROID = 1;
        System.out.println("The packetLengthMean was: " + packetLengthMean.getInput());
        System.out.println("The packetLengthStd was: " + packetLengthStd.getInput());
        System.out.println("The backwardIatTotal was: " + backwardIatTotal.getInput());
        System.out.println("Using center of sets type reduction, the IT2 FLS recommends a "
                + "video of: " + rulebase.evaluate(0).get(video));
        System.out.println("Using centroid type reduction, the IT2 FLS recommends a "
                + "rating of: " + rulebase.evaluate(1).get(video));

        //show the output of the raw centroids
        System.out.println("Centroid of the output for Video (based on centroid type reduction):");

        TreeMap<Output, Object[]> centroid = rulebase.evaluateGetCentroid(0);
        Object[] centroidTip = centroid.get(video);
        Tuple centroidTipXValues = (Tuple) centroidTip[0];
        double centroidTipYValues = ((Double) centroidTip[1]);
        System.out.println(centroidTipXValues + " at y= " + centroidTipYValues);

        this.xPonctual = centroidTipXValues.getAverage();
        this.xInf = centroidTipXValues.getLeft();
        this.xSup = centroidTipXValues.getRight();
    }

    public double getDegreeOfMembershipUpper(double in, IntervalT2MF_Trapezoidal membershipFunction) {
        // this.degreeOfMembershipLowerBound = membershipFunction.getLowerBound(in);
        // this.degreeOfMembershipUpperBound = membershipFunction.getUpperBound(in);
        return membershipFunction.getUpperBound(in);
    }

    public double getDegreeOfMembershipLower(double in, IntervalT2MF_Trapezoidal membershipFunction) {
        // this.degreeOfMembershipLowerBound = membershipFunction.getLowerBound(in);
        // this.degreeOfMembershipUpperBound = membershipFunction.getUpperBound(in);
        return membershipFunction.getLowerBound(in);

    }

    private void plotMFs(String name, IntervalT2MF_Interface[] sets, int discretizationLevel) {
        JMathPlotter plotter = new JMathPlotter();
        plotter.plotMF(sets[0].getName(), sets[0], discretizationLevel, null, false);

        for (int i = 1; i < sets.length; i++) {
            plotter.plotMF(sets[i].getName(), sets[i], discretizationLevel, null, false);
        }
        plotter.show(name);
    }

    /*public void plotMembershipFunctions(boolean isPlot) {
     if (isPlot) {
         //packetLengthMean, packetLengthStd, backwardIatTotal; 
     plotMFs("packetLengthMean Membership Functions", new IntervalT2MF_Interface[]{lowPacketLengthMeanMF , reasonablePacketLengthMeanMF, highPacketLengthMeanMF}, 10);
     plotMFs("FIAT Membership Functions", new IntervalT2MF_Interface[]{smallFiatMF, averageFiatMF, highFiatMF}, 10);
     plotMFs("RATIO Membership Functions", new IntervalT2MF_Interface[]{lowBiatTotalMF, reasonableBiatTotalMF, highBiatTotalMF}, 10);
     plotMFs("VIDEO Membership Functions", new IntervalT2MF_Interface[]{lowVideoMF, averageVideoMF, highVideoMF}, 10);
     }
     }

 /*
     private void plotControlSurface(boolean useCentroidDefuzzification, int input1Discs, int input2Discs, int input3Discs)
     {
     double output;
     double[] x = new double[input1Discs];
     double[] y = new double[input2Discs];
     double[] j = new double[input3Discs];
        
     double[][][] z = new double[y.length][x.length][j.length];
     double incrX, incrY, incrJ;
     incrX = CP.getDomain().getSize()/(input1Discs-1.0);
     incrY = CC.getDomain().getSize()/(input2Discs-1.0);
     incrJ = RAM.getDomain().getSize()/(input3Discs-1.0);

     //first, get the values
     for(int currentX=0; currentX<input1Discs; currentX++)
     {
     x[currentX] = currentX * incrX;        
     }
     for(int currentY=0; currentY<input2Discs; currentY++)
     {
     y[currentY] = currentY * incrY;
     }
        
     for(int currentJ=0; currentJ<input3Discs; currentJ++)
     {
     j[currentJ] = currentJ * incrJ;
     }

        
     for(int currentX=0; currentX<input1Discs; currentX++)
     {
     CP.setInput(x[currentX]);
     for(int currentY=0; currentY<input2Discs; currentY++)
     {//System.out.println("Current x = "+currentX+"  current y = "+currentY);
     CC.setInput(y[currentY]);
     RAM.setInput(j[currentJ]);
     if(useCentroidDefuzzification)
     output = rulebase.evaluate(1).get(tip);
     else
     output = rulebase.evaluate(0).get(tip);
     z[currentY][currentX] = output;
     }    
     }
        
     //now do the plotting
     JMathPlotter plotter = new JMathPlotter();
     plotter.plotControlSurface("Control Surface",
     new String[]{food.getName(), service.getName(), "Tip"}, x, y, z, new Tuple(0.0,30.0), true); 
     plotter.show("Interval Type-2 Fuzzy Logic System Control Surface for Tipping Example");
     }
     */
 /*public static void main(String args[])
     {
     new SimpleIT2FLSIntFLBCC();
     }*/
    public Input getPacketLengthMean() {
        return packetLengthMean;
    }

    public void setPacketLengthMean(Input packetLengthMean) {
        this.packetLengthMean = packetLengthMean;
    }

    public Input getPacketLengthStd() {
        return packetLengthStd;
    }

    public void setPacketLengthStd(Input packetLengthStd) {
        this.packetLengthStd = packetLengthStd;
    }

    public Input getBackwardIatTotal() {
        return backwardIatTotal;
    }

    public void setBackwardIatTotal(Input backwardIatTotal) {
        this.backwardIatTotal = backwardIatTotal;
    }

    public Output getVideo() {
        return video;
    }

    public void setVideo(Output video) {
        this.video = video;
    }

    public IT2_Rulebase getRulebase() {
        return rulebase;
    }

    public void setRulebase(IT2_Rulebase rulebase) {
        this.rulebase = rulebase;
    }

    public double getInPacketLengthMean() {
        return inPacketLengthMean;
    }

    public void setInPacketLengthMean(double inPacketLengthMean) {
        this.inPacketLengthMean = inPacketLengthMean;
    }

    public double getInPacketLengthStd() {
        return inPacketLengthStd;
    }

    public void setInPacketLengthStd(double inPacketLengthStd) {
        this.inPacketLengthStd = inPacketLengthStd;
    }

    public double getInBackwardIatTotal() {
        return inBackwardIatTotal;
    }

    public void setInBackwardIatTotal(double inBackwardIatTotal) {
        this.inBackwardIatTotal = inBackwardIatTotal;
    }

    public String getTypeIntersection() {
        return typeIntersection;
    }

    public void setTypeIntersection(String typeIntersection) {
        this.typeIntersection = typeIntersection;
    }

    public String getTypeUnion() {
        return typeUnion;
    }

    public void setTypeUnion(String typeUnion) {
        this.typeUnion = typeUnion;
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

}
