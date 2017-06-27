package test;

import java.util.ArrayList;


import org.junit.Assert;
import org.junit.Test;

import main.Ave;
import main.Canido;
import main.Felino;
import main.HelperMascota;
import main.Mascota;
import main.Person;
import main.Roedor;

public class TestHelperMascota {

	
	@Test
	public void testSortByName(){		
		ArrayList<Mascota> list = getMockListMascotas(); 		
		HelperMascota.sortArrayMascotaByName(list);
		Assert.assertEquals( "Firulais" ,list.get(0).getNombre()); 
		Assert.assertEquals( "Garffiel" ,list.get(1).getNombre()); 
		Assert.assertEquals( "Miki" ,list.get(2).getNombre()); 
		Assert.assertEquals( "Parrot" ,list.get(3).getNombre());  
	}
	
	
	@Test
	public void testSortByLength(){
				
		ArrayList<Mascota> list = getMockListMascotas(); 		
		HelperMascota.sortArrayMascotaByLength(list);		
		int size= list.size()-1;		
		for(int i=0; i<size; i++)
		   Assert.assertTrue(list.get(i).getLargo()<list.get(i+1).getLargo());
		
	}
	
	@Test
	public void testSortByOwnerName(){		
		ArrayList<Mascota> list = getMockListMascotas(); 		
		HelperMascota.sortArrayMascotaByEmailOwner(list);
		
		Assert.assertEquals( "ajordi@poo.com" ,list.get(0).getPropietario().getEmail()); 
		Assert.assertEquals( "bfredy@poo.com" ,list.get(1).getPropietario().getEmail()); 
		Assert.assertEquals( "cmarc@poo.com" ,list.get(2).getPropietario().getEmail()); 
		Assert.assertEquals( "josep@poo.com" ,list.get(3).getPropietario().getEmail());  
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
		Person propieFelino = new Person("Alex  Guix;0034656000001;ajordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc  Font;0034656000003;cmarc@poo.com;Calle font");
		
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