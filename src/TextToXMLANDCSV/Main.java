package TextToXMLANDCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) throws JAXBException, IOException {

		convertTextToXML(new File("C:\\Users\\Monalisa Sahoo\\Documents\\mona.txt"));

	}

	private static void convertTextToXML(File file) throws JAXBException, IOException {
		
		BufferedReader b = new BufferedReader(new FileReader(file));

		String readLine = "";

		System.out.println("Reading file using Buffered Reader");
		ArrayList<Sentence> sentenceList= new ArrayList<Sentence>();
		
		while ((readLine = b.readLine()) != null) {
			// System.out.println(readLine);
			String[] str = readLine.trim().split("[.]+");
			/*
			 * StringTokenizer st= new StringTokenizer(readLine); while(st.hasMoreTokens())
			 * { list.add(st.nextToken());
			 */
			for (String st : str) {
				convertToXML(st);
				
			}
		}
        
		
		
	}
	// Collections.sort(list);

	private static void convertToXML(String st) throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Sentence.class);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		List<String> list = new ArrayList<>();
		
		Sentence sentence = new Sentence();
		StringTokenizer sb = new StringTokenizer(st);
		while (sb.hasMoreTokens()) {
			String[] str= sb.nextToken().split(",");
			for(String st2: str) {
				list.add(st2);
				Collections.sort(list, new SortIgnoreCase());
			}
			
			sentence.setSentence(list);
			
			
		}
		
		StringWriter sw= new StringWriter();
		marshaller.marshal(sentence,  sw);
		String xmlString= sw.toString();
		System.out.println(xmlString);
		//sentenceList.add(sentence);
		//Word word= new Word(sentenceList);
		
		
		//marshaller.marshal(test, new FileOutputStream("C:\\Users\\Monalisa Sahoo\\Documents\\xmloutput.xml"));
		
		//return list;
		

	}

}
