package test;

import java.io.IOException;

import org.junit.Test;

import data.FileHelper;

public class TestFileHelper {

	
	@Test
	public void testReadFileAsString(){
		
		FileHelper reader = new FileHelper();
		
		System.out.println(reader.readFileAsString("texto.txt"));
		
		
		
	}
	
}
