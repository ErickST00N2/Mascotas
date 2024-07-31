package com.mx.Mascotas;

import java.util.ArrayList;
import java.util.List;

public class Implementacion {
    List<Mascota> mascotas = new ArrayList<>();

    public void guardar(Mascota mascota) {
        mascotas.add(mascota);
    }

    public Mascota buscar(int index) {
        if (index >= 0 && index < mascotas.size()) {
            return mascotas.get(index);
        } else {
            System.out.println("Índice fuera de rango");
            return null;
        }
    }

    public void editar(int index, Mascota mascota) {
        if (index >= 0 && index < mascotas.size()) {
            mascotas.set(index, mascota);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }

    public void eliminar(int index) {
        if (index >= 0 && index < mascotas.size()) {
            mascotas.remove(index);
        } else {
            System.out.println("Índice fuera de rango");
        }
    }

    public void mostrar() {
        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }
    }

    public void contarRegistros() {
        System.out.println("Total de mascotas registradas: " + mascotas.size());
    }
}
