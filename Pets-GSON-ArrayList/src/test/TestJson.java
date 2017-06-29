package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import data.GsonHelper;
import main.Ave;
import main.Canido;
import main.Felino;
import main.Mascota;
import main.Person;
import main.Roedor;
import util.FileHelper;

public class TestJson {

	@Test
	public void testFileHelper(){
		
		String str1 = "Hola que tal";
		String str2 = "Adios muy buenas";
		String strFinal = str1 + "\n" + str2;
		
		FileHelper.writeFileAsString(strFinal, "test.txt");
		
		String strTest = FileHelper.readFileAsString("test.txt");
		
		
		Assert.assertEquals(strFinal+ "\n",strTest );
		
		
		
			
	}
	
	@Test
	public void testGson(){
		
		// GUARDAMOS UNAS MASCOTAS DE EJEMPLO EN UN FICHERO EN JSON
		ArrayList<Mascota> list = getMockListMascotas(); 	
		String file = GsonHelper.listaMascotasToJson(list);
		FileHelper.writeFileAsString(file, "testfile.txt");
		
		// RECUPERAMOS ESTAS MASCOTAS COMO STRING Y PASAMOS A ArrayList
		String fileRecover = FileHelper.readFileAsString("testfile.txt");		
		ArrayList<Mascota> recoverList = GsonHelper.jsonFromArrayListMascotaToJson(fileRecover);
		
		// COMPROBAMOS CON ASSERT
		Assert.assertEquals(list.get(0).getNombre().equals("Firulais"), recoverList.get(0).getNombre().equals("Firulais"));
		Assert.assertEquals(list.get(0).getPropietario().getFullName().equals("Fredy Campino"),
				recoverList.get(0).getPropietario().getFullName().equals("Fredy Campino"));
		
		Assert.assertEquals(list.get(1).getNombre().equals("Garffiel"), recoverList.get(1).getNombre().equals("Garffiel"));
		Assert.assertEquals(list.get(1).getPropietario().getFullName().equals("Alex Guix"),
				recoverList.get(1).getPropietario().getFullName().equals("Alex Guix"));
		
	
		
	}

	public 	ArrayList<Mascota> getMockListMascotas(){
		
		ArrayList<Mascota> list = new ArrayList<Mascota>();  
		
		
		// Mascotas 
		Canido can      = new Canido("Firulais", 40, 0.50f,0.50f);
		Felino felino   =new Felino("Garffiel", 20, 0.20f,0.30f); 
		Ave parrot 		= new Ave("Parrot", 0.5f, 0.10f,0.15f); 
		Roedor miki   = new Roedor("Miki", 0.2f, 0.5f,0.1f); 
		
		//Propietarios 
		Person propieCan = new Person("Fredy Campino;0034656000000;bfredy@poo.com;Calle Campino"); 
		Person propieFelino = new Person("Alex Guix;0034656000001;ajordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc Font;0034656000003;cmarc@poo.com;Calle font");
		
		// iniciar el propietario a cada mascota
		can.setPropietario(propieCan);
		felino.setPropietario(propieFelino); 	
		parrot.setPropietario(propieParrot); 	
		miki.setPropietario(propieMiki); 
		
		//add a la lista 
		list.add(can);
		list.add(felino);
		list.add(parrot);
		list.add(miki);
		
		return list; 
		
		
	}
	
}
