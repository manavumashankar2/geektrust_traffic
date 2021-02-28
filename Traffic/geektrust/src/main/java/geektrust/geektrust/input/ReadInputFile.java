package geektrust.geektrust.input;

import java.io.File;
import java.util.Scanner;

public class ReadInputFile {

	static String inputData = "" ;


	public static String getData(String filePath) {
		try {
			File file = new File(filePath);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				inputData = scan.nextLine();
			}
			scan.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return inputData;
	}
	

	@Override
	public String toString() {
		return "ReadInputFile [inputData=" + inputData + "]";
	}

}
