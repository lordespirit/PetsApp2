package test;

import org.junit.Assert;
import org.junit.Test;

import main.Ave;
import main.Canido;
import main.Felino;
import main.ListaMascotas;
import main.Person;
import main.Roedor;


public class TestMascotas {
	
	
	//@Test
	public void testListaMascotas(){
		
		ListaMascotas list = new ListaMascotas();  
		
		list.add(new Canido("Firulais", 40, 0.50f,0.50f));
		list.add(new Felino("Garffiel", 20, 0.20f,0.30f));
		list.add(new Ave("Parro", 0.5f, 0.10f,0.15f));
		list.add(new Ave("Miki", 0.2f, 0.5f,0.1f));
		
		// Error porque no extiende de Mascota 
		// list.add(new Zapato());
		Assert.assertNotNull(list.get(0));
		Assert.assertNotNull(list.get(1));
		Assert.assertNotNull(list.get(2));
		Assert.assertNotNull(list.get(3));

		for(int i=0; i< list.size(); i++)
		      System.out.println("\nMascota: " 
		    		  	+ list.get(i).getNombre() 
		    		  	+ "\nEstado Nutricion:" + list.get(i).getEstadoNutricion()
		    		  	+ "\nPeso Racion comida: " + list.get(i).getPesoRacion());  
				
	}
	
	

	//@Test
	public void testListaMascotas2(){
		
		ListaMascotas list = new ListaMascotas();  
		
		
		// Error porque no extiende de Mascota 
		// list.add(new Zapato());
		list.add(new Canido("Firulais", 40, 0.50f,0.50f));
		list.add(new Felino("Garffiel", 20, 0.20f,0.30f));
		list.add(new Ave("Parro", 0.5f, 0.10f,0.15f));
		list.add(new Roedor("Miki", 0.2f, 0.5f,0.1f));



		for(int i=0; i< list.size(); i++){
			if(list.get(i).getClass().isAssignableFrom(Canido.class)) {
				Canido  canido = (Canido) list.get(i);
				System.out.println("\nMascota: " 
		    		  	+  canido.getNombre() 
		    		  	+ "\nCalidad colmillos:" +  canido.getCalidadColmillo()); 
			}else if(list.get(i).getClass().isAssignableFrom(Felino.class)) {
				Felino  canido = (Felino) list.get(i);
				System.out.println("\nMascota: " 
		    		  	+  canido.getNombre() 
		    		  	+ "\nCalidad colmillos:" +  canido.getCalidadGarras());
			}else{
				 System.out.println("\nMascota: " 
			    		  	+ list.get(i).getNombre() 
			    		  	+ "\nEstado Nutricion:"  
			    		  	+ "\nPeso Racion comida: " + list.get(i).getPesoRacion()); 
			}
		}
		
		
		//Assert.assertEquals(expected, actual, 0.4f); 
		       
		
	}

	    //@Test
		public void testListaMascotasPropietario(){
			
			ListaMascotas list = new ListaMascotas();  
			
			Canido can = new Canido("Firulais", 40, 0.50f,0.50f);
			Person propietario = new Person("Fredy Campino; 0034784512; fredy@fredy.com; Calle busquela"); 
			can.setPropietario(propietario);
			list.add(can);
			
			
			
			list.add(new Felino("Garffiel", 20, 0.20f,0.30f));
			list.add(new Ave("Parro", 0.5f, 0.10f,0.15f));
			list.add(new Ave("Miki", 0.2f, 0.5f,0.1f));
			
			// Error porque no extiende de Mascota 
			// list.add(new Zapato());
			Assert.assertNotNull(list.get(0));
			Assert.assertNotNull(list.get(1));
			Assert.assertNotNull(list.get(2));
			Assert.assertNotNull(list.get(3));

			for(int i=0; i< list.size(); i++)
			      System.out.println("\nMascota: " 
			    		  	+ list.get(i).getNombre() 
			    		  	+ "\nEstado Nutricion:" + list.get(i).getEstadoNutricion()
			    		  	+ "\nPeso Racion comida: " + list.get(i).getPesoRacion());  
					
		}
		
	    @Test
		public void testArrayListSortNombre(){
	    		
	    	ListaMascotas list = new ListaMascotas();  
			
			Canido can = new Canido("Firulais", 40, 0.50f,0.50f);
			Person propietario1 = new Person("Fredy Campino; 0034784512; fredy@fredy.com; Calle Fredy"); 
			can.setPropietario(propietario1);
			list.add(can);
			
			Felino felino = new Felino("Garfield", 20, 0.20f,0.30f);
			Person propietario2 = new Person("Edu Valles; 003414785282; edu@edy.com; Calle Edu"); 
			felino.setPropietario(propietario2);
			list.add(felino);
			
			Ave ave1 = new Ave("Parro", 0.5f, 0.10f,0.15f);
			Person propietario3 = new Person("Maria Santo; 00347215444; maria@maria.com; Calle Maria"); 
			ave1.setPropietario(propietario3);
			list.add(ave1);
			
			Ave ave2 = new Ave("Miki", 0.2f, 0.5f,0.1f);
			Person propietario4 = new Person("Anna Gaston; 00347812434; anna@gaston.com; Calle Anna");
			ave2.setPropietario(propietario4);
			list.add(ave2);
			
			list.sortByName();
			
			Assert.assertEquals(list.get(0).getNombre(), "Firulais");
			Assert.assertEquals(list.get(1).getNombre(), "Garfield");
			Assert.assertEquals(list.get(2).getNombre(), "Miki");
			Assert.assertEquals(list.get(3).getNombre(), "Parro");
			
	    
	    }
	    
	    @Test
		public void testArrayListSortPeso(){
	    		
	    	ListaMascotas list = new ListaMascotas();  
			
			Canido can = new Canido("Firulais", 40, 0.55f,0.50f);
			Person propietario1 = new Person("Fredy Campino; 0034784512; fredy@fredy.com; Calle Fredy"); 
			can.setPropietario(propietario1);
			list.add(can);
			
			Felino felino = new Felino("Garfield", 20, 0.1f,0.30f);
			Person propietario2 = new Person("Edu Valles; 003414785282; edu@edy.com; Calle Edu"); 
			felino.setPropietario(propietario2);
			list.add(felino);
			
			Ave ave1 = new Ave("Parro", 0.5f, 0.10f,0.15f);
			Person propietario3 = new Person("Maria Santo; 00347215444; maria@maria.com; Calle Maria"); 
			ave1.setPropietario(propietario3);
			list.add(ave1);
			
			Ave ave2 = new Ave("Miki", 0.2f, 0.5f,0.1f);
			Person propietario4 = new Person("Anna Gaston; 00347812434; anna@gaston.com; Calle Anna");
			ave2.setPropietario(propietario4);
			list.add(ave2);
			
			list.SortByPesoMascota();
			
			Assert.assertEquals(list.get(0).getPeso(), 0.2f , 0);
			Assert.assertEquals(list.get(1).getPeso(), 0.5f , 0);
			Assert.assertEquals(list.get(2).getPeso(), 20f , 0);
			Assert.assertEquals(list.get(3).getPeso(), 40f , 0);
			
	    
	    }

}
