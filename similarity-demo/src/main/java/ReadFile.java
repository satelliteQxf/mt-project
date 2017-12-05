import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class ReadFile {
    List<String> englishList = null;
    List<String> chineseList = null;
    List<String> translateList = null;

    public List<String> getTranslateList() {
        List<String> returnList = new ArrayList<String>();
        for(int i = 0; i < translateList.size(); i++){
            returnList.add(translateList.get(i) + " .");
        }
        return returnList;
    }

    public List<String> getEnglishList() {
        List<String> returnList = new ArrayList<String>();
        for(int i = 0; i < englishList.size(); i++){
            returnList.add(englishList.get(i) + " .");
        }
        return returnList;
    }

    public List<String> getChineseList() {
        List<String> returnList = new ArrayList<String>();
        for(int i = 0; i < chineseList.size(); i++){
            returnList.add(chineseList.get(i) + " 。");
        }
        return returnList;
    }

    public ReadFile(){
        englishList = new ArrayList<String>();
        chineseList = new ArrayList<String>();
        translateList = new ArrayList<String>();
    }

    public void read_file_from_txt(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int changeFlag = 0;
            while ((tempString = reader.readLine()) != null) {
                if(tempString.contains("*")){
                    changeFlag += 1;
                    continue;
                }else{
                    if(changeFlag == 0){
                        //System.out.println(Arrays.toString(splitSentence(tempString,true)));
                        englishList.addAll(Arrays.asList(splitSentence(tempString, true)));
                    }else if(changeFlag == 1){
                        chineseList.addAll(Arrays.asList(splitSentence(tempString, false)));
                    }else if(changeFlag == 2){
                        translateList.addAll(Arrays.asList(splitSentence(tempString,true)));
                    }
                }
            }
            //System.out.println(Arrays.toString(englishList.toArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String[] splitSentence(String paragraph, boolean isEnglish){
        if(isEnglish){
            return paragraph.split("\\?|\\. ");
        }else{
            return paragraph.split("？|。");
        }
    }

}
