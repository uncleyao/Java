import edu.duke.*;
import java.io.File;

public class Part2 {
    public String findSimpleGene(String dnaL) {
        
        String dna = dnaL.toLowerCase();
        String result = "";
        if (dna == "" || dna == null) { return "";}
        int startIndex = dna.indexOf("atg");
        if (startIndex == -1 ) {
            return "";
        }
        int stopIndex = dna.indexOf("taa",startIndex+3);
        if (stopIndex == -1 ) {
            return "";
        }
        if ((stopIndex-startIndex)%3 != 0 ) {
            return "";
        }
        return dnaL.substring(startIndex, stopIndex+3);    
    }
    
    public void testSimpleGene() {
        String[] testArray = new String[5];
        testArray[0] = "TAA";
        testArray[1] = "ATG";
        testArray[2] = "ATGTTTTAA";
        testArray[3] = "atgaaataa";
        testArray[4] = "ATGATAA";
        for (String testDNA : testArray){
            System.out.println("DNA is: "+ testDNA);
            String result = findSimpleGene(testDNA);
            System.out.println("Gene is: " + result);
    }
    }
        
    

}
