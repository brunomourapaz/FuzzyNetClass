pkg load io


################ - Definição de arquivos de leitura e escrita - ##############


# define o nome do arquivo a ser lido
#fileName = 'dataset_17102021_out_redutor_center_of_sets.csv';
#fileName = 'dataset_24102021_out_redutor_center_of_sets.csv';
#fileName = 'dataset_17102021_out_redutor_centroid.csv';
#fileName = 'dataset_24102021_out_redutor_centroid.csv';

#fileName = 'dataset_17102021_out_redutor_center_of_sets.csv';
#fileName = 'dataset_17102021_out_redutor_centroid.csv';

#fileName = 'dataset_24102021_out_redutor_center_of_sets.csv';
fileName = 'dataset_24102021_out_redutor_centroid.csv';

# define o nome da funcao de entropia para salvar no arquivo de saida
entropyFunctionName = 'BustinceEtAl2019';

# define o nome do arquivo de saida
#outPutFileName = 'saida_17102021_center_of_sets.csv';
#outPutFileName = 'saida_24102021_center_of_sets.csv';
#outPutFileName = 'saida_17102021_centroid.csv';
#outPutFileName = 'saida_24102021_centroid.csv';

#outPutFileName = 'entropia_dataset_17102021_out_redutor_center_of_sets.csv';
#outPutFileName = 'entropia_dataset_17102021_out_redutor_centroid.csv';

#outPutFileName = 'entropia_dataset_24102021_out_redutor_center_of_sets.csv';
outPutFileName = 'entropia_dataset_24102021_out_redutor_centroid.csv';


# definie se grava saidas parcias em arquivo de saída
salveResult = true;



if(salveResult)
 arqId = fopen(outPutFileName, 'w'); 
endif;


################ - Inicializa variáveis globais - ###############

#p = input("Informe o valor de p: ");
p = 1.0;

#alfa = input("Informe o valor de alfa: ");
alfa = 0.5;


################# - Definicao de funções - ######################

# Conta a quantidade de linhas do arquivo
function lines = countLinesFile(fileName)
  arqId = fopen(fileName, "r");
  if(arqId == -1)
    fprintf("Erro o arquivo %s, nao foi localizado!\n", fileName);
    return;
  else
     fprintf("O arquivo %s foi localizado, processando!\n", fileName);
     cont_lines=0;
     while (!feof(arqId))
       cont_lines++;
       linha = fgets(arqId);
       #fprintf('%s', linha);
     endwhile;
   fprintf('Total de linhas do arquivo eh %d \n',cont_lines);
   lines = cont_lines;
   fclose(arqId);
  endif;
endfunction;


# Cria arquivo de saida
function cf = createOutPutFile(pathFileName)
 cf = fopen(pathFileName, 'w');
endfunction;


# Grava uma linha no arquivo de saida
function arqId = writeLine(fileName, linha)
   arqId = fopen(fileName, 'a');
   fputs(arqId, [linha, "\n"]);
   #fputs(arqId, linha);
   fclose(arqId);
endfunction;


# Calcula o diâmetro
function d = diametro(matriz)
   d = abs(matriz(1,2) - matriz(1,1));
endfunction


# Calcula o K_alfa
function k = K_alfa(matriz, alfa)
   k = ((1.0 - alfa) * matriz(1,1)) + (alfa * matriz(1,2));
endfunction


# Calcula o valor parcial, necessário para obter a Entropia INF e SUP
function vp = valorpacial(matriz, k, p)
   vp = 1.0 - (abs((2.0 * k) - 1.0))^p;
endfunction



#Adiciona hearder no arquivo de saida entropia geral
arqIdEntropia = fopen(outPutFileName, 'a');
strLinhaHeader = ['entropyFunctionName', ',', 'p', ',', 'alfa', ',' , 'filename', ',', 'LowLowerDegree', ',' , ' LowUpperDegree', ',' , 'ReasonableLowerDegree', ',' , ' ReasonableUpperDegree', ',', 'HighLowerDegree', ',' ,'HighUpperDegree'];
fputs(arqIdEntropia, [strLinhaHeader, "\n"]);
fclose(arqIdEntropia);


# PROCESSAMENTO

entropia_INF_L = 0;
entropia_SUP_L = 0;
entropia_INF_R = 0;
entropia_SUP_R = 0;
entropia_INF_H = 0;
entropia_SUP_H = 0;

  # obten a quantidade de linhas do arquivo
  ln = countLinesFile(fileName);


  #itera sobre as linhas do arquivo
  for i=1:(ln - 1)
    #https://octave.sourceforge.io/list_functions.php?q=dlmread&sort=package
    #                                                [linha, coluna, linha, coluna]
    matriz_utilization_low = dlmread(fileName, ',',  [i, 31, i, 32]);
    matriz_utilization_reasonable = dlmread(fileName, ',',  [i, 33, i, 34]);
    matriz_utilization_high = dlmread(fileName, ',',  [i, 35, i, 36]);
   
  if(i==1)
    fprintf('O valor da matriz low eh %d %d na linha %d \n', matriz_utilization_low(1,1), matriz_utilization_low(1,2), i);
    fprintf('O valor da matriz reasonable eh %d %d na linha %d \n', matriz_utilization_reasonable(1,1), matriz_utilization_reasonable(1,2), i);
    fprintf('O valor da matriz high eh %d %d na linha %d \n', matriz_utilization_high(1,1), matriz_utilization_high(1,2), i);
   endif; 
       
    # Diâmetro
    dl = diametro(matriz_utilization_low);
    dr = diametro(matriz_utilization_reasonable);
    dh = diametro(matriz_utilization_high);
    
    #fprintf('O valor dos diametros de dl %d da %d dh %d da linha %d \n', dl, da, dh, i);

    # K_alfa
    kl = K_alfa(matriz_utilization_low, alfa);
    kr = K_alfa(matriz_utilization_reasonable, alfa);
    kh = K_alfa(matriz_utilization_high, alfa);
    
    #fprintf('O valor dos diametros de kl %d ka %d kh %d da linha %d \n', kl, ka, kh, i);
    
    
    # Valor parcial
    vpl = valorpacial(matriz_utilization_low, kl, p);
    vpr = valorpacial(matriz_utilization_reasonable, kr, p);
    vph = valorpacial(matriz_utilization_high, kh, p);
    

   # Entropia de cada intervalo para LOW, AVERAGE e HIGH
    entropia_Xinf_l = max (0, (abs(vpl - dl)));
    entropia_Xsup_l = max (vpl, dl);
    
    entropia_Xinf_r = max (0, (abs(vpr - dr)));
    entropia_Xsup_r = max (vpr, dr);
    
    entropia_Xinf_h = max (0, abs(vph - dh));
    entropia_Xsup_h = max (vph, dh);
    
    #Acumula as Entropias Intervalares de todas as linhas do arquivo
    entropia_INF_L = entropia_INF_L + entropia_Xinf_l;
    entropia_SUP_L = entropia_SUP_L + entropia_Xsup_l;
    entropia_INF_R = entropia_INF_R + entropia_Xinf_r;
    entropia_SUP_R = entropia_SUP_R + entropia_Xsup_r;
    entropia_INF_H = entropia_INF_H + entropia_Xinf_h;
    entropia_SUP_H = entropia_SUP_H + entropia_Xsup_h;
    


#if(i==1)
	#fprintf('O valor da entropia INF VERY LOW eh %d na linha %d \n', entropia_Xinf_vl, i);
	#fprintf('O valor da entropia SUP VERY LOW eh %d na linha %d \n', entropia_Xsup_vl, i);
	#fprintf('O valor da entropia INF LOW eh %d na linha %d \n', entropia_Xinf_l, i);
	#fprintf('O valor da entropia SUP LOW eh %d na linha %d \n', entropia_Xsup_l, i);
	#fprintf('O valor da entropia INF BELLOW REASONABLE eh %d na linha %d \n', entropia_Xinf_br, i);
	#fprintf('O valor da entropia SUP BELLOW REASONABLE eh %d na linha %d \n', entropia_Xinf_br, i);
	#fprintf('O valor da entropia INF REASONABLE eh %d na linha %d \n', entropia_Xinf_r, i);
	#fprintf('O valor da entropia SUP REASONABLE eh %d na linha %d \n', entropia_Xinf_r, i);
	#fprintf('O valor da entropia INF HIGH eh %d na linha %d \n', entropia_Xinf_h, i);
	#fprintf('O valor da entropia SUP HIGH eh %d na linha %d \n', entropia_Xsup_h, i);
#endif;
    
  endfor;


 if(salveResult)
 fclose(arqId);
 endif;

  
 #Aplica o agregador da média aritmética para obter as Entropias Intervalares para cada parâmetro (low, reasonable e high)
 
 entropia_INF_L_geral = (entropia_INF_L)/ (ln-1);
 #fprintf('A entropia LOW INF eh %f \n', entropia_INF_L_geral);
 entropia_SUP_L_geral = (entropia_SUP_L)/ (ln-1);
 #fprintf('A entropia LOW SUP eh %f \n', entropia_SUP_L_geral);
 
 entropia_INF_R_geral = (entropia_INF_R)/ (ln-1);
 #fprintf('A entropia REASONABLE INF eh %f \n', entropia_INF_R_geral);
 entropia_SUP_R_geral = (entropia_SUP_R)/ (ln-1);
 #fprintf('A entropia REASONABLE SUP eh %f \n', entropia_SUP_R_geral);

 entropia_INF_H_geral = (entropia_INF_H)/ (ln-1);
 #fprintf('A entropia HIGH INF eh %f \n', entropia_INF_H_geral);
 entropia_SUP_H_geral = (entropia_SUP_H)/ (ln-1);
 #fprintf('A entropia HIGH SUP eh %f \n', entropia_SUP_H_geral);


 arqIdEntropia = fopen(outPutFileName, 'a');

 strLinhaEntropia = [entropyFunctionName, ',', num2str(p), ',', num2str(alfa), ',' ,fileName, ',', num2str(entropia_INF_L_geral), ',' , num2str(entropia_SUP_L_geral), ',', num2str(entropia_INF_R_geral), ',' ,num2str(entropia_SUP_R_geral), ',', num2str(entropia_INF_H_geral), ',' ,num2str(entropia_SUP_H_geral) ];
 fputs(arqIdEntropia, [strLinhaEntropia, "\n"]);

 fclose(arqIdEntropia);


fprintf('Processamento realizado! \n');

