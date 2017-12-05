import dkpro.similarity.algorithms.api.SimilarityException;

import java.util.*;

/**
 * Created by apple on 17/12/4.
 */
public class Aligner {
    public static void main(String[] args) throws SimilarityException{
        ReadFile rd = new ReadFile();
        rd.read_file_from_txt("src/main/java/output__000.txt");
        List<String> chineseList = rd.getChineseList();
        List<String> englishList = rd.getEnglishList();
        List<String> translateList = rd.getTranslateList();

        for(int i = 0; i < chineseList.size(); i++){
            System.out.println(chineseList.get(i));
            System.out.println(translateList.get(i));
        }
        FindSimilarity fs = new FindSimilarity();
        int englishPointer = 0;
        int chinesePointer = 0;
        int maxRange = 3;
        System.out.println(fs.similarityScore("fuck you .","I bought a book ."));
//        while(englishPointer < englishList.size() && chinesePointer < chineseList.size()){
//            //this line should be google api
//
//
//        }
        
    }

}
