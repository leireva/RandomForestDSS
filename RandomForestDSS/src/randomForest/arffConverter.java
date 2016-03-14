package randomForest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class arffConverter {

	public arffConverter(){}
	
	
public  void main(String path)throws Exception{
		
		//String helbidea;
		String user = System.getProperty("user.name");
		File f = new File("/home/"+user+"/train.arff");
		System.out.println("====================");
		System.out.println("Zure fitxategia hemen eratuko da : /home/"+user+"/train.arff");
		if (!f.exists())
			f.createNewFile();
		else
			f.delete();
		
		//helbidea= "/home/bingen/train.csv";
		//fitxategia eratzeko pausuak
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr=new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		//.arff fitxategi baten goiburua
		bw.write("@RELATION tweetSentiment.dev.csv\n\n");
		bw.write("@ATTRIBUTE Text string \n\n");
		bw.write("@ATTRIBUTE CLASS {neutral,positive,negative}\n");
		bw.write("@DATA\n");
		String lerroa=br.readLine();
		while ((lerroa=br.readLine())!=null){
			if(lerroa.startsWith("\"")&&!lerroa.startsWith("\"\"")){
			lerroa=lerroa.substring(1, lerroa.length());
			String[] atazak= lerroa.split("\",\"");
				
					if(!atazak[1].equalsIgnoreCase("irrelevant")){
					//String data;
					/*data=atazak[3].substring(26, atazak[3].length())+" "+atazak[3].substring(11,19);*/
					//bw.write(atazak[1]+",'"+atazak[4].replace("'", "�")+"'\n");
					String myString = "'"+atazak[4].replace("'", "�")+"',"+atazak[1]+"\n";
					byte ptext[] = myString.getBytes();
					String value = new String(ptext, "UTF-8");
					bw.write(value);
					bw.flush();}
			}
			}//while
		System.out.println("Eginda ;)");
			bw.close();
			br.close();
		 }
	

	

}

