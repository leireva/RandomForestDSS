package mngmnt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import weka.core.Instances;

public class InstancesMNGMNT {
	private Instances dataTrain;
	private Instances dataDev;
	private Instances dataTst;
	
	private Instances mainInst;
	public InstancesMNGMNT(Instances train, Instances dev, Instances tst){
		dataTrain = train;
		dataDev = dev;
		dataTst = tst;
		mainInst = dataTrain;
	}
	public int getTrainNum(){
		return dataTrain.numInstances();
	}
	public int getDevNum(){
		return dataDev.numInstances();
	}
	public int getTestNum(){
		return dataTst.numInstances();
	}
	public void addToMainInstances(){
		/*for(int i= 0; i<=getTrainNum(); i++){
			mainInst.add(dataTrain.instance(i));
		}*/
		for(int j= 0; j<getDevNum(); j++){
			mainInst.add(dataDev.instance(j));
		}
		for(int k= 0; k<getTestNum(); k++){
			mainInst.add(dataTst.instance(k));
		}
		//return mainInst;
		writeALLARFF();
	}
	public void writeALLARFF(){
		String user = System.getProperty("user.name");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(
			                           new FileWriter("/home/"+user+"/allDATA.arff"));
			writer.write(mainInst.toString());
			 writer.newLine();
			 writer.flush();
			 writer.close();
			 System.out.println("File name: allDATA.arff");
			 System.out.println("File succesfully saved at /home/"+user+"/");
			 System.out.println("_____________________________________________");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Instances getMainInstances(){
		return mainInst;
	}

}
