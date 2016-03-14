package aRFFmaker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ARFFmaker {

	
public static void main(String[] args)throws Exception{
		
		String helbidea;
		File f = new File("train.arff");
		if (!f.exists())
			f.createNewFile();
		else
			f.delete();
		
		helbidea= "/home/bingen/train.csv";
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr=new FileReader(helbidea);
		BufferedReader br = new BufferedReader(fr);
		
		bw.write("@RELATION tweetSentiment.dev.csv\n\n");
		//bw.write("@ATTRIBUTE Topic  string \n");
		bw.write("@ATTRIBUTE CLASS {neutral,positive,negative}\n");
		//bw.write("@ATTRIBUTE ID NUMERIC \n");
		//bw.write("@ATTRIBUTE timestamp DATE  \"HH:mm:ss\" \n");
		bw.write("@ATTRIBUTE Text string \n\n");
		bw.write("@DATA\n");
		String lerroa=br.readLine();
		while ((lerroa=br.readLine())!=null){
			if(lerroa.startsWith("\"")&&!lerroa.startsWith("\"\"")){
			lerroa=lerroa.substring(1, lerroa.length());
			String[] atazak= lerroa.split("\",\"");
				
					if(!atazak[1].equalsIgnoreCase("irrelevant")){
					//String data;
					/*data=atazak[3].substring(26, atazak[3].length())+" "+atazak[3].substring(11,19);*/
					bw.write(atazak[1]+",'"+atazak[4].replace("'", "�")+"'\n");
					bw.flush();}
			}
			}//while
		System.out.println("Eginda");
			bw.close();
			br.close();
		 }
	

	

}
