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

	/*
	*Filtroak erabiliko dituen opzioak ipintzen ditu.
	*/
	private void setOptions(){
		//filtroak behar dituen ezaugarriak ezarri
				stwv.setIDFTransform(false);
				stwv.setTFTransform(false);
				stwv.setAttributeIndices("1");
				stwv.setLowerCaseTokens(true);
				stwv.setOutputWordCounts(false);
				stwv.setWordsToKeep(1000);
			
	}

	/*
	*Aukeratutako filtroa erabiltzen du.
	*/
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

	/*
	*fitxategi berri bat sortzen du erabiltzailearen karpeta nagusian
	*/
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


	/*
	*Hasierako parametro moduan 3 int behar ditu, hauekin, jakin dezake nondik banatzen diren instantzia multzo bakoitza.
	*Hau jakinda, instantzia multzoa, 3 multzotan banatu egingo ditu, sartutako int-en arabera.
	*/	
	public void writeFiles(int tr, int dev, int test){
		Instances train = getInst(0, tr);
		writeTrainFile(train);
		
		Instances devI = getInst(tr,dev);
		writeDevFile(devI);
		
		Instances testI = getInst(tr+dev, test);
		writeTestFile(testI);

	/*
	* Instantzia multzo bat behar du hasierako parametro moduan.
	*entrenatzeko instantziak fitxategi batean gorde egingo ditu metodo honek.
	*/
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

	/*
	* Instantzia multzo bat behar du hasierako parametro moduan.
	*Dev instantziak fitxategi batean gorde egingo ditu metodo honek.
	*/
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

	/*
	* Instantzia multzo bat behar du hasierako parametro moduan.
	*Test instantziak fitxategi batean gorde egingo ditu metodo honek.
	*/
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
	/*
	*Sartutako zenbakien dauden artean instantziak bueltatu egingo du metodo honek.
	* Bi int behar ditu hasierako parametro moduan
	*Instantzia multzo bat bueltatuko du.
	*/
	public Instances getInst(int indexB,int indexE){
		Instances newData = new Instances(filteredData, indexB, indexE);
		/*for(int i = indexB; i<indexE; i++){
			newData.add(filteredData.instance(i));
		}*/
		return newData;
	}
	
}	
