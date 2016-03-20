package mngmnt;

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
	public Instances addToMainInstances(){
		for(int i= 0; i<=getTrainNum(); i++){
			mainInst.add(dataTrain.instance(i));
		}
		for(int j= 0; j<=getDevNum(); j++){
			mainInst.add(dataDev.instance(j));
		}
		for(int k= 0; k<=getTestNum(); k++){
			mainInst.add(dataTst.instance(k));
		}
		return mainInst;
	}

}
