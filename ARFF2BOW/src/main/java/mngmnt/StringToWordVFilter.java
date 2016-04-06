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
	Instances filteredData;
	
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
				stwv.setOutputWordCounts(false);
				stwv.setWordsToKeep(1000);
			
	}

	public void applyFilter(){
		setOptions();
		//filtroa aplikatu
		try {
			stwv.setInputFormat(data);
			filteredData = Filter.useFilter(data, stwv);
			//writeFiles(tr, dev, test);
			write();
		} catch (Exception e) {
			System.out.println("ERROR! couldn't filter DATA :(");
			//e.printStackTrace();
		}
	}
	public void write(){
		String user = System.getProperty("user.name");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                           new FileWriter("/home/"+user+"/allBOW.arff"));
			writer.write(filteredData.toString());
			 writer.newLine();
			 writer.flush();
			 writer.close();
			 System.out.println("File name: allBOW.arff");
			 System.out.println("File succesfully saved at /home/"+user+"/");
			 System.out.println("_____________________________________________");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeFiles(int tr, int dev, int test){
		Instances train = getInst(0, tr);
		writeTrainFile(train);
		
		Instances devI = getInst(tr,dev);
		writeDevFile(devI);
		
		Instances testI = getInst(tr+dev, test);
		writeTestFile(testI);
	}
	public void writeTrainFile(Instances filteredData){
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
	public void writeDevFile(Instances filteredData){
		String user = System.getProperty("user.name");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                           new FileWriter("/home/"+user+"/devBOW.arff"));
			writer.write(filteredData.toString());
			 writer.newLine();
			 writer.flush();
			 writer.close();
			 System.out.println("File name: devBOW.arff");
			 System.out.println("File succesfully saved at /home/"+user+"/");
			 System.out.println("_____________________________________________");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeTestFile(Instances filteredData){
		String user = System.getProperty("user.name");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                           new FileWriter("/home/"+user+"/testBOW.arff"));
			writer.write(filteredData.toString());
			 writer.newLine();
			 writer.flush();
			 writer.close();
			 System.out.println("File name: testBOW.arff");
			 System.out.println("File succesfully saved at /home/"+user+"/");
			 System.out.println("_____________________________________________");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Instances getInst(int indexB,int indexE){
		Instances newData = new Instances(filteredData, indexB, indexE);
		/*for(int i = indexB; i<indexE; i++){
			newData.add(filteredData.instance(i));
		}*/
		return newData;
	}
	
	
}
