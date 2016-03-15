package mngmnt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class StringToWordVFilter {
	
	private StringToWordVector stwv;
	Instances data;
	
	public StringToWordVFilter(Instances pdata){
		stwv = new StringToWordVector();
		data = pdata;
	}
	private void setOptions(){
		//filtroak behar dituen ezaugarriak ezarri
				stwv.setIDFTransform(false);
				stwv.setTFTransform(false);
				stwv.setAttributeIndices("1");
				stwv.setLowerCaseTokens(true);
				stwv.setOutputWordCounts(true);
				stwv.setWordsToKeep(2000);
	}

	public void applyFilter(){
		Instances filteredData = null;
		setOptions();
		//filtroa aplikatu
		try {
			stwv.setInputFormat(data);
			filteredData = Filter.useFilter(data, stwv);
			writeFile(filteredData);
		} catch (Exception e) {
			System.out.println("ERROR! couldn't filter DATA :(");
			//e.printStackTrace();
		}
	}
	private void writeFile(Instances filteredData){
		String user = System.getProperty("user.name");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                           new FileWriter("/home/"+user+"/trainBOW.arff"));
			writer.write(filteredData.toString());
			 writer.newLine();
			 writer.flush();
			 writer.close();
			 System.out.println("File name: trainBOW.arff");
			 System.out.println("File succesfully saved at /home/"+user+"/");
			 System.out.println("_____________________________________________");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
