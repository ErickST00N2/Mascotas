package com.mx.Mascotas;
/**
 * 
 */

/**
 * Una interface es una plantilla para la construcción de una clase.
 */
public interface IMetodos {
	//CRUD: es un acronimo para las operaciones CREATE, READ, UPDATE, DELETE.
	
	
	// void
	public void guardar(Mascota mascota);
	
	public void mostrar();
	
	public void editar(int indice, Mascota mascota);
	
	public void eliminar(int indice);
	
	public Mascota buscar(int indice);
	
}
