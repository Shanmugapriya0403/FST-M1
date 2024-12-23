package javapractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/newfile.txt");
			boolean fstatus=file.createNewFile();
			if(fstatus) {
				System.out.println("File created successfully!");
			}else {
				System.out.println("File already exist at its path.");
			}
			//Get file object
			File filetext= FileUtils.getFile("src/newfile.txt");
			//Read file
			System.out.println("Data in file:" + FileUtils.readFileToString(filetext,"UTF-8"));
			//Create directory
			File destDir=new File("resource");
			FileUtils.copyFileToDirectory(file, destDir);
			//Get file from new directory
			File newFile=FileUtils.getFile(destDir,"newfile.txt");
			//Read data from file
			String newFileData=FileUtils.readFileToString(newFile,"UTF-8");
			//Print new file
			System.out.println("Data in new file:" +newFileData);
		}
		catch (IOException errMessage) {
			// TODO: handle exception
			System.out.println(errMessage);
		}
	}

}
