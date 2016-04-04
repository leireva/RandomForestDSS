package select;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.core.Instances;
import weka.filters.Filter;

public class SelectAttributes {
	private AttributeSelection filter;
	private Instances data;
	
	public SelectAttributes(Instances pData){
		filter = new AttributeSelection();
		data = pData;
	}
	public void apply() throws Exception{
		Ranker search = new Ranker();
		search.setNumToSelect(20);
		search.setThreshold(0.5);
		
		InfoGainAttributeEval eval = new InfoGainAttributeEval();
		
		filter.setEvaluator(eval);
		filter.setSearch(search);
		filter.SelectAttributes(data);
		
	}
	public void write(){
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

}
