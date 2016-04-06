package randomForest;

public class Nagusia {
	/*
	*csv fitxategi baten path-a behar du.
	*behin bat sartuta, arffconverter.main metodoa egingo du, hau da, cvs fitxategiko datuak arff fitxategi batean sartu.
	*/
	public static void main(String[] args) {
		if( args.length < 1 ){
			System.out.println("ARGUMENTOS:");
			System.out.println("Ez duzu path -ik idatzi!!!!");
			return; 
		}

		arffConverter proba = new arffConverter();
		try {
			proba.main(args[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
