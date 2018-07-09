import edu.duke.*;
import java.io.File;

public class Part4 {
    public StorageResource findURLs(String url) {
        URLResource page = new URLResource(url);
        String source = page.asString();
        StorageResource store = new StorageResource();
        int start = 0;
        while (true) {
            int index = source.indexOf("href=",start);
            if (index == -1) {break;}
            int endQuote = source.indexOf("\"",index+6);
            String sub = source.substring(index+6,endQuote);
            if (sub.toLowerCase().indexOf("youtube")!=-1){
                store.add(sub);
            }
            start = endQuote+1;
        
        }
        return store;
        
    }
    

    
    public void testURL() {
        StorageResource s1 = findURLs("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String link : s1.data()){
            System.out.print(link + "\n");
        }
    
    }
        
    

}

