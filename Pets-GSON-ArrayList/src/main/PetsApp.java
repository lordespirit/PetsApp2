package main;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

import data.FileHelper;
import data.GsonHelper;
import util.Finder;
import util.Input;

public class PetsApp {

	public static void main(String args[]){	
		
		final String FILE = "veterinaria.txt";
		String str = null; 
		ArrayList<Mascota> list = null;
		
		str = FileHelper.readFileAsString(FILE);
		list = GsonHelper.jsonFromArrayListMascotaToJson(str); 
		Finder<Mascota> finder = new Finder<Mascota>();
		
		String option = null;
		UserInterface.showWelcome();
		do{
			UserInterface.showMenuInit();	
			option = Input.scannLine().toLowerCase();
			switch(option){
				case "añadir":
					Mascota newMascota = UserInterface.scanMascota();
					UserInterface.addMascota(newMascota,list);
					break;
				case "listar":
					UserInterface.listAllMascotas(list);
					break;
				case "eliminar":
					UserInterface.removeFromIndexMascotas(list);
					break;
				case "editar":
					UserInterface.editMascota(list);
					break;
				case "buscar":
					UserInterface.listAllMascotas(UserInterface.showMenuBuscar(list));
					break;
				case "mascotas":
					UserInterface.listAllMascotas(UserInterface.sortMascotasByName(list));
					break;
				case "propietarios":
					break;
				case "clases":
					UserInterface.listAllMascotas(UserInterface.showMenuTipos(list));
					break;
				case "peso":
					break;
				case "salir":
					System.out.println(" <******  GRACIAS POR USAR PETS APP V2.0  ******>");
					break;
				default:
					System.out.println("Opción incorrecta. Vuelve a intentarlo.");
					break;
			}
			
			
		}while(!option.equals("salir"));
		
		str = GsonHelper.listaMascotasToJson(list);
		FileHelper.writeFileAsString(str, FILE);
	}
	
	
}
