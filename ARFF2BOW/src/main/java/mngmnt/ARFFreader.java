package mngmnt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.core.Instances;

public class ARFFreader {

	Instances data;
	String path;
	
	/*
	*Klasearen metodo eraikitzailea
	* String bat behar du sarrera moduan, hau bihurtu nahi dugun fitxategiaren path-a izango da.
	*/
	public ARFFreader(String pPath){
		path = pPath;
		
	}
	/*
	 * readFile() eraikitzailean sartutako path-an dagoen fitxategia ireki egingo du
	 * Bukaeran ffitxategian zeuden instanziak bueltatu gingo ditu.
	*/
	public Instances readFile(){
		
		   // 1.2. Open the file
	    FileReader fi=null;
		try {
			
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
			
		}
		return data;
	}
	
}
