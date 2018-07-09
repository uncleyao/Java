import edu.duke.*;
import java.io.File;

public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        if (dna == "" || dna == null) { return "";}
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1 ) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA",startIndex+3);
        if (stopIndex == -1 ) {
            return "";
        }
        if ((stopIndex-startIndex)%3 != 0 ) {
            return "";
        }
        return dna.substring(startIndex, stopIndex+3);    
    }
    
    public void testSimpleGene() {
        String[] testArray = new String[5];
        testArray[0] = "TAA";
        testArray[1] = "ATG";
        testArray[2] = "ATGTTTTAA";
        testArray[3] = "";
        testArray[4] = "ATGATAA";
        for (String testDNA : testArray){
            System.out.println("DNA is: "+ testDNA);
            String result = findSimpleGene(testDNA);
            System.out.println("Gene is: " + result);
    }
    }
        
    

}
