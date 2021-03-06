package select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

public class SelectAttributes {
	private AttributeSelection filter;
	private Instances data;
	private Instances filteredData;
	
	public SelectAttributes(Instances pData){
		filter = new AttributeSelection();
		data = pData;
	}
	
	/*
	*SelectAtributes filtroa data instantzia multzoan aplikatu egingo da.
	*/
	public void apply() throws Exception{
		Ranker search = new Ranker();
		/*
		 * Set the threshold higher if you want fewer
			features to be chosen as the final set. 
		 */
		search.setNumToSelect(50);
		search.setThreshold(0.5);
		InfoGainAttributeEval eval = new InfoGainAttributeEval();
		
		ReplaceMissingValues replace = new ReplaceMissingValues();
		replace.setInputFormat(data);
		filteredData = Filter.useFilter(data, replace);
		
		filter.setEvaluator(eval);
		filter.setSearch(search);
		filter.setInputFormat(filteredData);
		Instances newData = Filter.useFilter(filteredData, filter);
		cleanAtss(getAttributes(newData));
		write(newData);
		//applyAttributeSelection(pFilter);
		//filter.SelectAttributes(filteredData);
		// write();
		
	}
	
	/*
	*Hasierako parametro moduan, String array bat behar du
	*Emandako String hau, atributo garbiketa metodo bat pasatuko zaio.
	*/
	public void cleanAtss(String[]a){
		CleanAttributes cA = new CleanAttributes(a);
		cA.apply();
	}
	
	/*
	*Hasierako parametro bezala, instantzia multzo bat behar du.
	*instanrtzia multzo hau, .arff fitxategi batean idatzi egingo da.
	*/
	public void write(Instances data){
		String user = System.getProperty("user.name");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                           new FileWriter("/home/"+user+"/trainBOWFSSInfoGain.arff"));
			writer.write(data.toString());
			 writer.newLine();
			 writer.flush();
			 writer.close();
			 System.out.println("File name: trainBOWFSSInfoGain.arff");
			 System.out.println("File succesfully saved at /home/"+user+"/");
			 System.out.println("_____________________________________________");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
 	* Hasierako parametro bezala instantzia multzo bat behar du
 	* Metodo honek, instantzia multzoa hartuko du, eta bere atributo multzoak atera egino ditu.
 	*erantzun bezala, ateratako atributoak, string array batean bueltako ditu.
	 */
	public String[] getAttributes(Instances trainData){
		String[] trainAtts = new String[trainData.numAttributes()];
		for(int index = 0; index < trainData.numAttributes(); index++){
			trainAtts[index] = trainData.attribute(index).name();
			System.out.println(trainAtts[index]);
		}return trainAtts;
		
	}
}
