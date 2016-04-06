package select;

import weka.core.Instances;

public class CleanAttributes {

	private Instances test;
	private Instances dev;
	private String[] attrNames;
	
	public CleanAttributes(String[] trainAttributes){
		readFile();
		setStr(trainAttributes);
	}
	/*
	 * Hartu devBOW.arff eta testBOW.arff atributuen "garbiketa" egiteko
	 */
	private void readFile(){
		String user = System.getProperty("user.name");
		ARFFreader reader = new ARFFreader("/home/"+user+"/devBOW.arff");
		dev = reader.readFile();
		
		reader = new ARFFreader("/home/"+user+"/testBOW.arff");
		test = reader.readFile();
	}
	private void setStr(String[] trainAttributes){
		attrNames = new String[trainAttributes.length];
		for(int i = 0 ; i<trainAttributes.length ; i++){
			attrNames[i] = trainAttributes[i];
		}
	}
	public void apply(){
		getAttsIndex(dev);
	}
	private void getAttsIndex(Instances data){
		System.out.println("ATRIBUTU BERRIEN index -ak:");
		Integer[]attributeIndexes = new Integer[attrNames.length];
		int pA = 0;
		for(int index = 0; index<data.numAttributes() ; index++){
			for(int indexStr = 0; indexStr<attrNames.length ; indexStr++){
				if(attrNames[indexStr].equals(data.attribute(index).name())){
					//System.out.println("same attrs");
					attributeIndexes[pA] = index;
					System.out.println(index);
					pA = pA+1;
				}
				if(indexStr == attrNames.length){
					indexStr = 0;
				}
			}
		}//luzera atributu kopurua
		//System.out.println(attributeIndexes.length);
		//return attributeIndexes;
	}
}
