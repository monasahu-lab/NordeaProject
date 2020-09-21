package TextToXMLANDCSV;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="test")
public class Sentence {

	
	 private List<String> sentence; //private List<Sentence> sentence2;
	 
	
	 @XmlElementWrapper (name="sentence")

	 @XmlElement(name="word") 
	 public List<String> getSentence() {
		 return sentence;
	  }
	  
	  
	  public Sentence(List<String> sentence) { this.sentence = sentence; }
	  
	  
	  public Sentence() {
	  
	  }
	  
	  public void setSentence(List<String> sentence) { this.sentence = sentence; }
	 
	
	/*
	 * private List<String> word; // @XmlElement public List<String> getWord() {
	 * return word; }
	 * 
	 * public void setWord(List<String> word) { this.word = word; }
	 * 
	 * public Sentence( List<String> word) { //super(); this.word = word; }
	 */

}
