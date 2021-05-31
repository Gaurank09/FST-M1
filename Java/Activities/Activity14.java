package Activities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        
            File newfile = new File("/Users/gaurankarora/Desktop/FreshFile2.txt"); 
            
            boolean Status = newfile.createNewFile();
            
            if(Status == true) {
                System.out.println("File created successfully!");

                File newFile = FileUtils.getFile(newfile);
                String newFileData = FileUtils.readFileToString(newFile, "UTF8");
                
                System.out.println("Data in new file: " + newFileData);

            } 
            else {
                System.out.println("File already exists at this path.");
                
                File fileUtil = FileUtils.getFile("/Users/gaurankarora/Desktop/FreshFile2.txt");
                System.out.println("Data in Existing file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
                
            }
    }
}