package data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileHelper {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	
	/**
	 * Read the lines of a text file file, coded in UTF_8 
	 * 
	 * @param  fileLines name of text file
	 * @return the array with the lines of file, if there are problems reading the file it is null
	 */
	public static String[] readFile(String aFileName){
		String[] fileLines=null; 
		try {
			List<String> list = readSmallTextFile(aFileName);
			int size = list.size(); 
			fileLines = new String[size]; 
			for(int i=0; i<size; i++)
				fileLines[i] = list.get(i); 				
		} catch (IOException e) {
		     e.printStackTrace();
		}
		
		return fileLines;   
	}
	

	/**
	 * Write a String array to a text file
	 * @param aLines array width the lines that you want to write 
	 * @param aFileName name of file
	 * @return
	 */
	public static boolean writeFile(String[] aLines, String aFileName){
		boolean done = true; 
		List<String> list = new ArrayList<String>(aLines.length);
		
		for(int i=0; i < aLines.length; i++)
			list.add(aLines[i]); 
		
		try {
			writeSmallTextFile(list,aFileName);
		} catch (IOException e) {
			e.printStackTrace(); 
			done = false; 
		} 
		return done; 
	}
	

	private static List<String> readSmallTextFile(String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    return Files.readAllLines(path, ENCODING);
	}
		
	private static void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
	    Path path = Paths.get(aFileName);
	    Files.write(path, aLines, ENCODING, StandardOpenOption.CREATE,
	            StandardOpenOption.TRUNCATE_EXISTING );

    }
	
	/**
	 * Lee un archivo y retorna su contenido como un string, 
	 * si el archivo no existe debe crearlo y escrbir hola mundo.
	 * "Texto de prueba"
	 * 
	 * Utilice la clase String builder
	 * https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
	 * @param aFileName
	 * @return
	 */
	public static String readFileAsString(String aFileName){
		String str = null;
		StringBuilder builder = new StringBuilder();
		
		try {
			List<String> list = readSmallTextFile(aFileName);
			
			for (String strlist : list) {
			    if (builder.length() > 0) {
			        builder.append(" ");
			    }
			    builder.append(list);
			}

			str = builder.toString();
			
		} catch (NoSuchFileException e) {
		    
			writeFile(new String[0], "texto.txt");
			
		} catch (IOException e) {
			
			
			
		}
		
		return str;   
	}


}