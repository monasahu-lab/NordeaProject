package TextToXMLANDCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
public class TextToCSVMain {

	public static void main(String[] args) throws IOException {
		convertTextToCSV(new File("C:\\Users\\Monalisa Sahoo\\Documents\\mona.txt"));
	}

	private static void convertTextToCSV(File file) throws IOException {

		BufferedReader b = new BufferedReader(new FileReader(file));

		String readLine = "";

		//System.out.println("Reading file using Buffered Reader");
		List<String> list= new ArrayList<String>();
		int i=1;
		while ((readLine = b.readLine()) != null) {
			// System.out.println(readLine);
			String[] str = readLine.trim().split("[.]+");
			/*
			 * StringTokenizer st= new StringTokenizer(readLine); while(st.hasMoreTokens())
			 * { list.add(st.nextToken());
			 */
			for (String st : str) {
				list=convertToXML(st);
				//sentenceList.add(list);
				 System.out.println("sentence "+i+" "+getListAsCsvString(list));
				 i++;
				
			}
			
		}
		
		
		 

		
	}

	private static List<String> convertToXML(String st) {
        List<String> list = new ArrayList<>();
		
		Sentence sentence = new Sentence();
		StringTokenizer sb = new StringTokenizer(st);
		while (sb.hasMoreTokens()) {
			String[] str= sb.nextToken().trim().split(",");
			for(String st2: str) {
				list.add(st2);
				Collections.sort(list, new SortIgnoreCase());
			}
		
	}
		return list;
		//saveToFile("C:\\Users\\Monalisa Sahoo\\Documents\\output.txt", list);
}

	
	 public static String getListAsCsvString(List<String> list){
         
	        StringBuilder sb = new StringBuilder();
	        for(String str:list){
	            if(sb.length() != 0){
	                sb.append(",");
	            }
	            sb.append(str);
	        }
	        return sb.toString();
	    }
}