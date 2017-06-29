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
import util.Finder;
import util.Finder.ContainChecker;

public class testFinder {
	
	@Test
	public void testArrayListFinder(){
		
		String json = null; 
		ArrayList<Mascota> list = getMockListMascotas();
		Finder<Mascota> finder = new Finder<Mascota>();

		ArrayList<Mascota> resultListMascota = finder.find(list, "Garfield" , new Finder.ContainChecker<Mascota>() {
			@Override
			public boolean containChecker(Mascota mascota, Object patron) {
				String str = (String) patron;
				return mascota.getNombre().contains(str);
			}
		
		});
		
		Assert.assertEquals(1, resultListMascota.size());
		
	}
	
public 	ArrayList<Mascota> getMockListMascotas(){
		
		ArrayList<Mascota> list = new ArrayList<Mascota>();  
		
		
		// Mascotas 
		Canido can      = new Canido("Firulais", 40, 0.50f,0.50f);
		Felino felino   =new Felino("Garfield", 20, 0.20f,0.30f); 
		Ave parrot 		= new Ave("Parro", 0.5f, 0.10f,0.15f); 
		Roedor miki   = new Roedor("Miki", 0.2f, 0.5f,0.1f); 
		
		//Propietarios 
		Person propieCan = new Person("Fredy Campino;0034656000000;fredy@poo.com;Calle Campino"); 
		Person propieFelino = new Person("Alex  Guix;0034656000001; jordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc  Font;0034656000003;marc@poo.com;Calle font");
		
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
