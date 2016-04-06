
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

	/*
	*int bat bueltatzen du, hau, train instantzia kopurua izango da.
	*/
	public int getTrainNum(){
		return dataTrain.numInstances();
	}
	/*
	*int bat bueltatzen du, hau, dev instantzia kopurua izango da.
	*/
	public int getDevNum(){
		return dataDev.numInstances();
	}
	/*
	*int bat bueltatzen du, hau, test instantzia kopurua izango da.
	*/
	public int getTestNum(){
		return dataTst.numInstances();
	}

	/*
	*metodo honek, 3 instantzia multzoak, batean batzen ditu.
	*/
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

	/*
	* Metodo honek, instantzia multzoa arff fitxategi batean gordeko ditu.
	*/
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

	/*
	*get metodo honek instantzia multzoa bueltatzen du.
	*/
	public Instances getMainInstances(){
		return mainInst;
	}

}

