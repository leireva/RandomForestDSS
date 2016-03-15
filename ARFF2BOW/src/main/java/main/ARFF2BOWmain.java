package main;

import mngmnt.ARFFreader;
import mngmnt.StringToWordVFilter;
import weka.core.Instances;

public class ARFF2BOWmain {

	public static void main(String[] args) {
		if( args.length < 1 ){
			//System.out.println("OBJETIVO: Seleccionar atributos (AttributeSelection<-CfsSubsetEval, search<-BestFirst) y Evaluar clasificador NaiveBayes con 10-fold cross-validation.");
			System.out.println("ARGUMENTOS:");
			System.out.println("\t1. Path del fichero de entrada: datos en formato .arff");
			return; 
		}
		ARFFreader reader = new ARFFreader(args[0]);
		Instances data = reader.readFile();

		data.setClassIndex(data.numAttributes()-1);
		
		//filtroa aplikatu
		StringToWordVFilter st = new StringToWordVFilter(data);
		st.applyFilter();
		
	}

}
