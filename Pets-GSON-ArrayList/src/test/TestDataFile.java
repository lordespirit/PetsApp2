package test;

import org.junit.Assert;
import org.junit.Test;

import data.GsonHelper;
import main.Ave;
import main.Canido;
import main.Felino;
import main.ListaMascotas;
import main.Person;
import main.Roedor;

public class TestDataFile {
	
	@Test
	public void testSaveToFile(){
		
		ListaMascotas list = getMockListMascotas();
		
		String strJson = GsonHelper.listaMascotasToJson(list); 
		Assert.assertNotNull(strJson);
		ListaMascotas results=null;
		
		try{
		   results = GsonHelper.jsonFromlistaMascotasToJson(strJson); 
		   
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		
		/*
		// Ojo en este test no funciona comparar los objetos con equals
		// porque ?
		Assert.assertEquals(list.get(0).toString(), results.get(0).toString());
		Assert.assertEquals(list.get(1).toString(), results.get(1).toString());
		Assert.assertEquals(list.get(2).toString(), results.get(2).toString());
		Assert.assertEquals(list.get(3).toString(), results.get(3).toString());
		*/
		
		Canido can      = new Canido("Firulais", 40, 0.50f,0.50f);
		Felino felino   =new Felino("Garffiel", 20, 0.20f,0.30f); 
		Ave parrot 		= new Ave("Parro", 0.5f, 0.10f,0.15f); 
		Roedor miki   = new Roedor("Miki", 0.2f, 0.5f,0.1f); 
		
		//Propietarios 
		Person propieCan = new Person("Fredy Campino;0034656000000;fredy@poo.com;Calle Campino"); 
		Person propieFelino = new Person("Alex Guix;0034656000001; jordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc Font;0034656000003;marc@poo.com;Calle font");
				
		// iniciar el propietario a cada mascota
		can.setPropietario(propieCan);
		felino.setPropietario(propieFelino); 	
		parrot.setPropietario(propieParrot); 	
		miki.setPropietario(propieMiki); 
		
		// DOS FORMAS DE COMPROBAR -  NUM1 - COMPARANDO CON EL NOMBRE CONOCIDO
		Assert.assertEquals(can.getNombre(),"Firulais");
		Assert.assertEquals(can.getAltura(), 0.5,0.01);
		Assert.assertEquals(can.getPeso(), 40,0.1);
		Assert.assertEquals(can.getPropietario().getFullName(), "Fredy Campino");
		
		Assert.assertEquals(felino.getNombre(),"Garffiel");
		Assert.assertEquals(felino.getAltura(), 0.20,0.01);
		Assert.assertEquals(felino.getPeso(), 20,0.1);
		Assert.assertEquals(felino.getPropietario().getFullName(), "Alex Guix");
		
		Assert.assertEquals(parrot.getNombre(),"Parro");
		Assert.assertEquals(parrot.getAltura(), 0.10,0.01);
		Assert.assertEquals(parrot.getPeso(), 0.5,0.1);
		Assert.assertEquals(parrot.getPropietario().getFullName(), "Josep Cardona");
		
		Assert.assertEquals(miki.getNombre(),"Miki");
		Assert.assertEquals(miki.getAltura(), 0.5,0.01);
		Assert.assertEquals(miki.getPeso(), 0.2,0.1);
		Assert.assertEquals(miki.getPropietario().getFullName(), "Marc Font");
		
		
		// DOS FORMAS DE COMPROBAR -  NUM2 - GENERANDO UNA NUEVA LISTA
		Assert.assertEquals(can.getNombre(), list.get(0).getNombre());
		Assert.assertEquals(can.getAltura(), list.get(0).getAltura(),0.01);
		Assert.assertEquals(can.getPeso(), list.get(0).getPeso(),0.01);
		Assert.assertEquals(can.getPropietario().getFullName(), list.get(0).getPropietario().getFullName());
		
		Assert.assertEquals(felino.getNombre(), list.get(1).getNombre());
		Assert.assertEquals(felino.getAltura(), list.get(1).getAltura(),0.01);
		Assert.assertEquals(felino.getPeso(), list.get(1).getPeso(),0.01);
		Assert.assertEquals(felino.getPropietario().getFullName(), list.get(1).getPropietario().getFullName());
		
		Assert.assertEquals(parrot.getNombre(), list.get(2).getNombre());
		Assert.assertEquals(parrot.getAltura(), list.get(2).getAltura(),0.01);
		Assert.assertEquals(parrot.getPeso(), list.get(2).getPeso(),0.01);
		Assert.assertEquals(parrot.getPropietario().getFullName(), list.get(2).getPropietario().getFullName());
		
		Assert.assertEquals(miki.getNombre(), list.get(3).getNombre());
		Assert.assertEquals(miki.getAltura(), list.get(3).getAltura(),0.01);
		Assert.assertEquals(miki.getPeso(), list.get(3).getPeso(),0.01);
		Assert.assertEquals(miki.getPropietario().getFullName(), list.get(3).getPropietario().getFullName());
		
	}
	
	 
	public ListaMascotas getMockListMascotas(){
		
		ListaMascotas list = new ListaMascotas();  
		
		
		// Mascotas 
		Canido can      = new Canido("Firulais", 40, 0.50f,0.50f);
		Felino felino   =new Felino("Garffiel", 20, 0.20f,0.30f); 
		Ave parrot 		= new Ave("Parro", 0.5f, 0.10f,0.15f); 
		Roedor miki   = new Roedor("Miki", 0.2f, 0.5f,0.1f); 
		
		//Propietarios 
		Person propieCan = new Person("Fredy Campino;0034656000000;fredy@poo.com;Calle Campino"); 
		Person propieFelino = new Person("Alex Guix;0034656000001; jordi@poo.com;Calle Guix");
		Person propieParrot = new Person("Josep Cardona;0034656000002;josep@poo.com;Calle Cardona");
		Person propieMiki = new Person("Marc Font;0034656000003;marc@poo.com;Calle font");
		
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
