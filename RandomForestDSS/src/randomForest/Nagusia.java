package randomForest;

public class Nagusia {

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
