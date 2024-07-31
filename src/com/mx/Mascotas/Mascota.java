package com.mx.Mascotas;

public class Mascota {
    private String nombre;
    private String raza;
    private int edad;
    private String tipo;
    private String color;
    private double peso;
    private String condicionMedica;
    private String propietario;

    public Mascota(String nombre, String raza, int edad, String tipo, String color, double peso, String condicionMedica, String propietario) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tipo = tipo;
        this.color = color;
        this.peso = peso;
        this.condicionMedica = condicionMedica;
        this.propietario = propietario;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getCondicionMedica() { return condicionMedica; }
    public void setCondicionMedica(String condicionMedica) { this.condicionMedica = condicionMedica; }

    public String getPropietario() { return propietario; }
    public void setPropietario(String propietario) { this.propietario = propietario; }

    @Override
    public String toString() {
        return "Mascota [nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", tipo=" + tipo + ", color=" + color + ", peso=" + peso + ", condicionMedica=" + condicionMedica + ", propietario=" + propietario + "]";
    }
}
