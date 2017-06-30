package test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import data.FileHelper;

public class TestFileHelper {

	
	@Test
	public void testFileHelper(){
		
		String str1 = "Hola que tal";
		String str2 = "Adios muy buenas";
		String strFinal = str1 + "\n" + str2;
		
		FileHelper.writeFileAsString(strFinal, "test.txt");
		
		String strTest = FileHelper.readFileAsString("test.txt");
		
		
		Assert.assertEquals(strFinal+ "\n",strTest );		
	}
	
}
