package main;

import java.util.ArrayList;
import java.util.Comparator;

public class HelperMascota {

	public static void SortByNombreMascota(ArrayList<Mascota> list){
		
		Comparator<Mascota> compareSortName = new Comparator<Mascota>(){
			@Override
			public int compare(Mascota o1, Mascota o2) {
				return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
			}
		};
		
		list.sort(compareSortName);		
		
	}
	
	public static void SortByPesoMascota(ArrayList<Mascota> list){
		
		Comparator<Mascota> compareSortPeso= new Comparator<Mascota>(){
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
		
		list.sort(compareSortPeso);		
		
	}
	
	public static void SortByMailPropietario(ArrayList<Mascota> list){
		
		Comparator<Mascota> compareSortMail = new Comparator<Mascota>(){
			@Override
			public int compare(Mascota o1, Mascota o2) {
				return o1.getPropietario().getEmail().toLowerCase().compareTo(o2.getPropietario().getEmail().toLowerCase());
			}
		};
		
		list.sort(compareSortMail);		
		
	}
	
	public static void SortByMascotaLength(ArrayList<Mascota> list){
		
		Comparator<Mascota> compareSortLength = new Comparator<Mascota>(){
			@Override
			public int compare(Mascota o1, Mascota o2) {
				int r=0;
				if(o1.getLargo()<o2.getLargo()){
					r = -1;
				}else if(o1.getLargo()<o2.getLargo()){
					r = 1;
				}
				return r;
			}
		};
		
		list.sort(compareSortLength);		
		
	}
	
}
