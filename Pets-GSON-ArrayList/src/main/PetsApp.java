package main;

import java.util.ArrayList;

import data.GsonHelper;
import util.Finder;

public class PetsApp {

	public static void main(String args[]){	
		
		String json = null; 
		ArrayList<Mascota> list = null;
		
		try{
			list = GsonHelper.jsonFromArrayListMascotaToJson(json); 
		}catch (Exception e) {
			list = new ArrayList<Mascota>();
		}
		
		Finder<Mascota> finder = new Finder<Mascota>();
		
		// GsonHelper.listaMascotasToJson(list);
		
		/*
		finder.find(list, patron, new ContainChecker() {
			
			@Override
			public boolean containChecker(java.lang.Object object, java.lang.Object patron){
				return null;
			}
			
		})	; 
		
		 */
		
		String option = null;
		UserInterface.showWelcome();
		do{
			
			
		}while(!option.equals("salir"));
		
	}
	
	
}
