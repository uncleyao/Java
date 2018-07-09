import edu.duke.*;
import java.io.File;

public class Part3 {
    public boolean twoOccurrences(String a, String b) {
        if (a == "" || b == "") {return false;}
        int firstIndex = b.indexOf(a);
        int lenA = a.length();
        if (firstIndex == -1) {return false;}
        int endIndex = b.substring(firstIndex+lenA).indexOf(a);
        if (endIndex == -1) {return false;}
        return true;    
    }
    
    public String lastPart(String a, String b) {
        if (a == "" || b == "") {return "";}
        int firstIndex = b.indexOf(a);
        int lenA = a.length();
        if (firstIndex == -1) {return b;}
        return b.substring(firstIndex+lenA);

    }
    
    public void testFindString() {
        String testA = "an";
        String testB = "banana";
        System.out.format("A is: %s, B is %s ", testA,testB);
        boolean result = twoOccurrences(testA,testB);
        String lastP  = lastPart(testA,testB);
        System.out.println("Find 2nd result: " + result);
        System.out.println("After that is:" + lastP);
    
    }
        
    

}
