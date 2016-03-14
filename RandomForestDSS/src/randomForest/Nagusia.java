package randomForest;

public class Nagusia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		arffConverter proba = new arffConverter();
		try {
			proba.main();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
