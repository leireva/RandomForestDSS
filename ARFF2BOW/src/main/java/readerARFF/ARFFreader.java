package readerARFF;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;

public class ARFFreader {

	Instances data;
	String path;
	public ARFFreader(String pPath){
		path = pPath;
		
	}
	
	public Instances readFile(){
		//BufferedReader reader;
		   // 1.2. Open the file
	    FileReader fi=null;
		try {
			//fi= new FileReader("~/software/weka-3-6-9/data/breast-cancer.arff"); //(args[0]) <-> ("~/software/weka-3-6-9/data/breast-cancer.arff" )
			fi= new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Revisar path del fichero de datos:"+path);
		}
		// 1.3. Load the instances
		Instances data=null;
		try {
			data = new Instances(fi);
		} catch (IOException e) {
			System.out.println("ERROR: Revisar contenido del fichero de datos: ");
		}
		// 1.4. Close the file
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return data;
	}
}
