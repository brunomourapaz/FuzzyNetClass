# FuzzyNetClass

FuzzyNetClass addresses the uncertainties and inaccuracies in the network traffic classification process by exploring Interval-valued Fuzzy Logic to classify network traffic with a focus on streaming video.

FuzzyNetClass was conceived for classifying network traffic to identify video streaming flows. The FuzzyNetClass proposal considers a rule base acting in three stages: Fuzzification, Inference, and Defuzzification, returning as output the classification level of the analyzed network flow, allowing (or not) its identification as a video.
  
The modeling of FuzzyNetClass system was performed using the Interval Type-2 Fuzzy Logic System Toolbox module [[2]](https://ieeexplore.ieee.org/document/4295341) and Juzzy [[1]](http://juzzy.wagnerweb.net/). 

For the execution of the experiments, [datasets](https://github.com/emmonks/datasets) were generated from captures, and publicly available datasets.

## Publications

1. [Towards Interval-Valued Fuzzy Approach to Video Streaming Traffic Classification](https://ieeexplore.ieee.org/document/9882788/)
2. [Abordagem Fuzzy Valorada Intervalarmente para Classificação de Tráfego de Streaming de Vídeo](https://doi.org/10.5753/semish.2022.222827)

## Reference
[1] [C. Wagner, "Juzzy – A Java based Toolkit for Type-2 Fuzzy Logic", Proceedings of the IEEE Symposium Series on Computational Intelligence, Singapore, April 2013.](http://juzzy.wagnerweb.net/)

[2] [Castro, Juan R., Oscar Castillo, and Patricia Melin. "An interval type-2 fuzzy logic toolbox for control applications." 2007 IEEE international fuzzy systems conference. IEEE, 2007.](https://ieeexplore.ieee.org/document/4295341)
