package main;

import mngmnt.ARFFreader;
import mngmnt.InstancesMNGMNT;
import mngmnt.StringToWordVFilter;
import weka.core.Instances;

public class ARFF2BOWmain {

	/*
	*Metodo nagusia.
	*Sarrera moduan, hiru arff fitxategien path-a behar du
	*3 fitxategiak irakurtzen ditu,gero, instantzia multzoak multzo bakar batean gordetzen ditu, eta azkenik, fltroak aplikatzen dizkio.
	*/
	public static void main(String[] args) {
		/**
		 * Hiru fitxategien path -a behar da
		 * trainBOW.arff
		 * devBOW.arff
		 * testBOW.arff
		 * batera sortzeko
		 */
		if( args.length < 1 ){
			//System.out.println("OBJETIVO: Seleccionar atributos (AttributeSelection<-CfsSubsetEval, search<-BestFirst) y Evaluar clasificador NaiveBayes con 10-fold cross-validation.");
			System.out.println("ARGUMENTOS:");
			System.out.println("\t1. Path del fichero de entrada: datos en formato .arff");
			return; 
		}
		if ( args.length < 3){
			System.out.println("Hiru fitxategi sartu behar dira, eskerrik asko :)");
		}
		//train instances irakurri
		ARFFreader reader1 = new ARFFreader(args[0]);
		Instances dataT = reader1.readFile();
		int trainIndex = dataT.numInstances();
		
		//dev instances irakurri
		ARFFreader reader2 = new ARFFreader(args[1]);
		Instances dataDev = reader2.readFile();
		int devIndex = dataDev.numInstances();
		
		//test instances irakurri
		ARFFreader reader3 = new ARFFreader(args[2]);
		Instances dataTest = reader3.readFile();
		int testIndex = dataTest.numInstances();
		//data.setClassIndex(data.numAttributes()-1);
		
		//Instances mergedINST = Instances.mergeInstances(dataT, dataDev);
		//Instances mainData = Instances.mergeInstances(mergedINST, dataTest);
		InstancesMNGMNT manager = new InstancesMNGMNT(dataT, dataDev, dataTest);
		manager.addToMainInstances();
		
		//manager.writeALLARFF(mainData);
		//filtroa aplikatu
		StringToWordVFilter st = new StringToWordVFilter(manager.getMainInstances());
		
		st.applyFilter();
		//st.applyFilter(manager.getTrainNum(),manager.getDevNum(),manager.getTestNum());
		st.writeFiles(trainIndex, devIndex, testIndex);
	}

}
