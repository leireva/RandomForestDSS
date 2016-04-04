package main;

import select.ARFFreader;
import select.SelectAttributes;
import weka.core.Instances;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		if( args.length < 1 ){
			//System.out.println("OBJETIVO: Seleccionar atributos (AttributeSelection<-CfsSubsetEval, search<-BestFirst) y Evaluar clasificador NaiveBayes con 10-fold cross-validation.");
			System.out.println("ARGUMENTOS:");
			System.out.println("\t1. Path del fichero de entrada: datos en formato .arff");
			return; 
		}
		ARFFreader reader = new ARFFreader(args[0]);
		Instances data = reader.readFile();
		
		 
		data.setClassIndex(0);
		SelectAttributes select = new SelectAttributes(data);
		select.apply();
	}

}
