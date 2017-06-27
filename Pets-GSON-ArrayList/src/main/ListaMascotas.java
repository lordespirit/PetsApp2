package main;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaMascotas {
	
	//private Mascota[] arrayMascotas;
	ArrayList<Mascota> arrayMascotas;
	
	public ListaMascotas(){
		arrayMascotas = new ArrayList<Mascota>();
	}
	
	public ListaMascotas(String[] vetContacts){
		// Falta iniciar constructor con fichero 
	}
	
	Comparator<Mascota> compareName = new Comparator<Mascota>(){
		@Override
		public int compare(Mascota o1, Mascota o2) {
			return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
		}
	};
	
	Comparator<Mascota> comparePeso = new Comparator<Mascota>(){
		@Override
		public int compare(Mascota o1, Mascota o2) {
			int r=0;
			if(o1.getPeso()<o2.getPeso()){
				r = -1;
			}else if(o1.getPeso()>o2.getPeso()){
				r = 1;
			}
			
			return r;
		}
	};

	public Mascota get(int index){
		return arrayMascotas.get(index);
	}
	
	public int size(){
		return arrayMascotas.size();
	}
	
	public void add(Mascota mascota){
		arrayMascotas.add(mascota);
	}
	
	public void sortByName(){
		arrayMascotas.sort(compareName);
	}
	
	public void SortByPesoMascota(){
		arrayMascotas.sort(comparePeso);
	}
	
	/*
	@Deprecated
	public void add2(Mascota mascota){
		Mascota[] copyMascotas = new Mascota[arrayMascotas.length+1];
		for(int i=0;i<arrayMascotas.length;i++){
			copyMascotas[i]=arrayMascotas[i];
		}
		copyMascotas[copyMascotas.length-1]=mascota;
		arrayMascotas = copyMascotas;
	}
	*/
	
	/*
	@Deprecated
	public int indexOf2(Mascota mascota){
		int index = -1; 
		for(int i=0; i<arrayMascotas.length; i++){
			if(arrayMascotas[i].equals(mascota)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}
	*/
	
	/*
	@Deprecated
	public int indexOf(Mascota mascota){
		int index = -1; 
		for(int i=0; i<arrayMascotas.length; i++){
			if(arrayMascotas[i].equals(mascota)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}
	*/
	
	/*
	public void remove(Mascota mascota) {
		int index = indexOf(mascota);
		remove(index);
	}
	*/	
	
	/*
	public void remove(int index){
		
		checkIndex(index);
		
		if(index<0||index>arrayMascotas.length){
			System.out.println("Índice incorrecto...");
			return;
		}else{
			Mascota[] copyMascotas = new Mascota[arrayMascotas.length-1];
			int j=0;
			for(int i=0;i<arrayMascotas.length;i++){
				if(i!=index){
					copyMascotas[j++]=arrayMascotas[i];
				}
			}
			arrayMascotas = copyMascotas;
		}
	}
	*/
	
	/*
	private void checkIndex(int index){
		if(index>=arrayMascotas.length||index<0){
			throw new RuntimeException("Error, el indice no existe");
		}
	}
	 */
	
	/*
	public Mascota[] findByOwnerName(String name){
		Mascota findNameArrayMascotas[];  
		int counter = 0;
		for(int i = 0; i<arrayMascotas.length;i++){
			if(arrayMascotas[i].getPropietario().getFullName().startsWith(name))
				counter++;
		}
		findNameArrayMascotas = new Mascota[counter];  
		for(int i=0,k=0; i<findNameArrayMascotas.length; i++){
			if(arrayMascotas[i].getPropietario().getFullName().startsWith(name))
				findNameArrayMascotas[k++]=arrayMascotas[i];
		}
		return findNameArrayMascotas;
	}
	*/
	
	/*
	public Mascota[] findByOwnerEmail(String email){
		Mascota findEmailArrayMascotas[];  
		int counter = 0;
		for(int i = 0; i<arrayMascotas.length;i++){
			if(arrayMascotas[i].getPropietario().getEmail().startsWith(email))
				counter++;
		}
		findEmailArrayMascotas = new Mascota[counter];  
		for(int i=0,k=0; i<findEmailArrayMascotas.length; i++){
			if(arrayMascotas[i].getPropietario().getEmail().startsWith(email))
				findEmailArrayMascotas[k++]=arrayMascotas[i];
		}
		return findEmailArrayMascotas;
	}
	*/

	
	
}

