package main;

import java.util.ArrayList;

import org.junit.Assert;

import data.GsonHelper;
import util.Input;

public class UserInterface {

	//list.contains(newMascota.getPropietario().getFullName().contains("Ed"));
	
	public static void showWelcome(){
		System.out.println("***************************");
		System.out.println("******* BIENVENIDO ********");
		System.out.println("****** PetsApp v2.0a *******");
		System.out.println("***************************");
	}

	public static void showMenuInit(){
		System.out.println("Opciones disponibles :");
		System.out.println("> Añadir [añade mascota]");
		System.out.println("> Eliminar [dar de alta una mascota]");
		System.out.println("> Listar [lista todas las mascotas mascota]");
		System.out.println("> Buscar [busca una mascota por nombre]");
		System.out.println("> Editar [edita una mascota - se puede buscar por propietario o nombre de mascota]");
		System.out.println("> Mascotas [lista y ordena por nombre de mascotas]");
		System.out.println("> Propietarios [lista y ordena por nombre de propietarios]");
		System.out.println("> Peso [lista y ordena por peso de mascotas]");
		System.out.println("  ***********************************************************************************");
		System.out.print("> Escoge opción : ");
	}
	
	public static Mascota scanMascota(){
		String name;
		String tipo;
		float peso;	
		float altura;
		float largo;

		do{
			System.out.println("******* MASCOTA *******");
			do{
				System.out.print("> Tipo Mascota [perro, gato, roedor, ave] : ");
				tipo = Input.scannLine();
				if(!(tipo.equals("perro")||tipo.equals("gato")||tipo.equals("roedor")||tipo.equals("ave"))){
					System.out.println("ERROR. Debe introducir un tipo de animal mostrado en la lista...");
				}
			}while(!(tipo.equals("perro")||tipo.equals("gato")||tipo.equals("roedor")||tipo.equals("ave")));
			
			System.out.print("> Nombre Mascota : ");
			name = Input.scannLine();
			System.out.print("> Peso  [formato Kg]: ");
			peso = Input.scannFloat();
			System.out.print("> Altura [formato metros] : ");
			altura = Input.scannFloat();
			System.out.print("> Largo [formato metros] : ");
			largo = Input.scannFloat();
		}while(name.equals("")||peso<=0||altura<=0||largo<=0);
		
		String nombreProp;
		String apellidoProp;
		String telefono;
		String eMail;
		String address;

		do{
			System.out.println("****** PROPIETARIO ******");
			System.out.print("> Nombre Propietario : ");
			nombreProp = Input.scannLine();
			System.out.print("> Apellido Propietario : ");
			apellidoProp = Input.scannLine();
			
			do{
				System.out.print("> Teléfono : ");
				telefono = Input.scannLine();
				if(!phoneValidator(telefono)){
					System.out.println("Formato teléfono incorrecto\n"
							+ "Formato : únicamente números - Mínimo 9 cifras - Máximo 13");
				}
			}while(!phoneValidator(telefono));
			
			do{
				System.out.print("> Email : ");
				eMail = Input.scannLine();
				if(!mailValidator(eMail)){
					System.out.println("El correo no está en formato correcto...");
				}
			}while(!mailValidator(eMail));
			
			System.out.print("> Dirección : ");
			address = Input.scannLine();
		
		}while(nombreProp.equals("")||apellidoProp.equals("")||telefono.equals("")|| eMail.equals("")||address.equals(""));
		
		
		Person newPerson = new Person(nombreProp + " " + apellidoProp + ";" + telefono + ";" + eMail + ";" + address);
		
		if(tipo.equals("perro")){
			Canido newMascota = new Canido(name,peso,altura,largo);
			newMascota.setPropietario(newPerson);
			return newMascota;
			
		}else if(tipo.equals("gato")){
			Felino newMascota = new Felino(name,peso,altura,largo);
			newMascota.setPropietario(newPerson);
			return newMascota;
			
		}else if(tipo.equals("roedor")){
			Roedor newMascota = new Roedor(name,peso,altura,largo);
			newMascota.setPropietario(newPerson);
			return newMascota;
			
		}else{
			Ave newMascota = new Ave(name,peso,altura,largo);
			newMascota.setPropietario(newPerson);
			return newMascota;		}
		
	}
	
	
	// TODO EDITAR MASCOTA O PROPIETARIO
	public static void editMascota(ArrayList<Mascota> list){
		
		if(list.size()==0){
			System.out.println("No se puede editar, no se encuentran mascotas");
		}else{

			
			
			String name;
			String tipo;
			float peso;	
			float altura;
			float largo;
				
			System.out.println("******* MENÚ EDICIÓN *******");
				
			do{
				System.out.println("******* MASCOTA *******");
				do{
					System.out.print("> Tipo Mascota [perro, gato, roedor, ave] : ");
					tipo = Input.scannLine();
					if(!(tipo.equals("perro")||tipo.equals("gato")||tipo.equals("roedor")||tipo.equals("ave"))){
						System.out.println("ERROR. Debe introducir un tipo de animal mostrado en la lista...");
					}
				}while(!(tipo.equals("perro")||tipo.equals("gato")||tipo.equals("roedor")||tipo.equals("ave")));
				
				System.out.print("> Nombre Mascota : ");
				name = Input.scannLine();
				System.out.print("> Peso  [formato Kg]: ");
				peso = Input.scannFloat();
				System.out.print("> Altura [formato metros] : ");
				altura = Input.scannFloat();
				System.out.print("> Largo [formato metros] : ");
				largo = Input.scannFloat();
			}while(name.equals("")||peso<=0||altura<=0||largo<=0);
			
			String nombreProp;
			String apellidoProp;
			String telefono;
			String eMail;
			String address;
	
			do{
				System.out.println("****** PROPIETARIO ******");
				System.out.print("> Nombre Propietario : ");
				nombreProp = Input.scannLine();
				System.out.print("> Apellido Propietario : ");
				apellidoProp = Input.scannLine();
				
				do{
					System.out.print("> Teléfono : ");
					telefono = Input.scannLine();
					if(!phoneValidator(telefono)){
						System.out.println("Formato teléfono incorrecto\n"
								+ "Formato : únicamente números - Mínimo 9 cifras - Máximo 13");
					}
				}while(!phoneValidator(telefono));
				
				do{
					System.out.print("> Email : ");
					eMail = Input.scannLine();
					if(!mailValidator(eMail)){
						System.out.println("El correo no está en formato correcto...");
					}
				}while(!mailValidator(eMail));
				
				System.out.print("> Dirección : ");
				address = Input.scannLine();
			
			}while(nombreProp.equals("")||apellidoProp.equals("")||telefono.equals("")|| eMail.equals("")||address.equals(""));
			
			
			Person newPerson = new Person(nombreProp + " " + apellidoProp + ";" + telefono + ";" + eMail + ";" + address);
			
			if(tipo.equals("perro")){
				Canido newMascota = new Canido(name,peso,altura,largo);
				newMascota.setPropietario(newPerson);
				//return newMascota;
				
			}else if(tipo.equals("gato")){
				Felino newMascota = new Felino(name,peso,altura,largo);
				newMascota.setPropietario(newPerson);
				//return newMascota;
				
			}else if(tipo.equals("roedor")){
				Roedor newMascota = new Roedor(name,peso,altura,largo);
				newMascota.setPropietario(newPerson);
				//return newMascota;
				
			}else{
				Ave newMascota = new Ave(name,peso,altura,largo);
				newMascota.setPropietario(newPerson);
				//return newMascota;
				}
		}
	}
	
	public static void addMascota(Mascota newMascota, ArrayList<Mascota> list) {
			list.add(newMascota);
			GsonHelper.listaMascotasToJson(list);
	}
	
	public static void removeMascota(int indiceMascota, ArrayList<Mascota> list) {
			list.remove(indiceMascota);
			GsonHelper.listaMascotasToJson(list);
	}
	
	private static boolean mailValidator(String mail){
		String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(mail.matches(pattern)){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean phoneValidator(String phone) {
		String pattern = "^[0-9]{9,13}$";
				if(phone.matches(pattern)){
					return true;
				}else{
					return false;
				}
	}

	public static void listAllMascotas(ArrayList<Mascota> list) {
		if(list.size()==0){
			System.out.println("La lista está vacía, pruebe primero a introducir nuevas mascotas.");
		}else{
			for(int i=0;i<list.size();i++){
				System.out.println(i+1 + " -> " + list.get(i).getNombre());
			}
		}
		
	}

	public static void removeFromIndexMascotas(ArrayList<Mascota> list) {
		listAllMascotas(list);
		if(list.size()!=0){
			int index;
			System.out.println("*******************************************");
			do{
				System.out.print("Introduce el índice a eliminar : ");
				index  = Input.scannInt() -1;
				if(index<0||index>list.size()){
					System.out.println("Error, índice incorrecto, vuelve a probar");
				}
			}while(index<0||index>list.size());
		removeMascota(index, list);
		}
	}
	
	
}
