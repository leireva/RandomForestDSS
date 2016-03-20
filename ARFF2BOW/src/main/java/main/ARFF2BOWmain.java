package main;

import mngmnt.ARFFreader;
import mngmnt.InstancesMNGMNT;
import mngmnt.StringToWordVFilter;
import weka.core.Instances;

public class ARFF2BOWmain {

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
		//train instances irakurri
		ARFFreader reader1 = new ARFFreader(args[0]);
		Instances dataT = reader1.readFile();
		
		//dev instances irakurri
		ARFFreader reader2 = new ARFFreader(args[1]);
		Instances dataDev = reader2.readFile();
		
		//test instances irakurri
		ARFFreader reader3 = new ARFFreader(args[2]);
		Instances dataTest = reader3.readFile();
		
		//data.setClassIndex(data.numAttributes()-1);
		Instances mainData = null;
		InstancesMNGMNT manager = new InstancesMNGMNT(dataT, dataDev, dataTest);
		mainData = manager.addToMainInstances();
		//filtroa aplikatu
		StringToWordVFilter st = new StringToWordVFilter(mainData);
		st.applyFilter(manager.getTrainNum(),manager.getDevNum(),manager.getTestNum());
		
	}

}
