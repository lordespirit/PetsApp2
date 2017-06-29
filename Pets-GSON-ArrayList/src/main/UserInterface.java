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
		System.out.println("****** PetsApp v1.1 *******");
		System.out.println("***************************");
	}

	public static void showMenuInit(){
		System.out.println("Opciones disponibles :");
		System.out.println("> A�adir [a�ade mascota]");
		System.out.println("> Eliminar [dar de alta una mascota]");
		System.out.println("> Buscar [busca una mascota por nombre]");
		System.out.println("> Editar [edita una mascota - se puede buscar por propietario o nombre de mascota]");
		System.out.println("> Mascotas [lista y ordena por nombre de mascotas]");
		System.out.println("> Propietarios [lista y ordena por nombre de propietarios]");
		System.out.println("> Peso [lista y ordena por peso de mascotas]");
		System.out.println("  ***********************************************************************************");
		System.out.println("> Escoge opci�n : ");
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
				System.out.print("> Tel�fono : ");
				telefono = Input.scannLine();
				if(!phoneValidator(telefono)){
					System.out.println("Formato tel�fono incorrecto\n"
							+ "Formato : �nicamente n�meros - M�nimo 9 cifras - M�ximo 13");
				}
			}while(!phoneValidator(telefono));
			
			do{
				System.out.print("> Email : ");
				eMail = Input.scannLine();
				if(!mailValidator(eMail)){
					System.out.println("El correo no est� en formato correcto...");
				}
			}while(!mailValidator(eMail));
			
			System.out.print("> Direcci�n : ");
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
	
	public static void addMascota(Mascota newMascota) {
		
		String json = null; 
		ArrayList<Mascota> list = null;
		
		try{
			list = GsonHelper.jsonFromArrayListMascotaToJson(json); 
		}catch (Exception e) {
			list = new ArrayList<Mascota>();
		}finally{
			
			list.add(newMascota);
			GsonHelper.listaMascotasToJson(list);
		}
	}
	
	public static int listaIndicesMascotas(){
		
		return 0;
		
	}
	
	public static void removeMascota(int indiceMascota) {
		
		String fichero = null; 
		ArrayList<Mascota> list = null;
		
		try{
			list = GsonHelper.jsonFromArrayListMascotaToJson(fichero); 
		}catch (Exception e) {
			list = new ArrayList<Mascota>();
		}finally{
			list.remove(indiceMascota);
			GsonHelper.listaMascotasToJson(list);
		}
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
		
}
