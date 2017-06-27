package main;

public class UserInterface {

	public static void showWelcome(){
		System.out.println("***************************");
		System.out.println("******* BIENVENIDO ********");
		System.out.println("****** PetsApp v1.1 *******");
		System.out.println("***************************");
	}

	public static void showMenuInit(){
		System.out.println("Opciones disponibles :");
		System.out.println("> añadir");
		System.out.println("> eliminar");
		System.out.println("> buscar");
		System.out.println("> mascotas [lista y ordena por nombre de mascotas]");
		System.out.println("> propietarios [lista y ordena por nombre de propietarios]");
		System.out.println("> peso [lista y ordena por peso de mascotas]");
	}
	
	public static Mascota scanMascota(){
		System.out.println("**** AÑADIR MASCOTA ****");
		System.out.print("> Nombre : ");
		String name;
		
		System.out.print("> Peso : ");
		float peso;
				
		System.out.print("> Altura : ");
		float altura;
		
		return null;
	}
		
}
