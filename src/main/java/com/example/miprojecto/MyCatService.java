package com.example.miprojecto;

import org.springframework.stereotype.Service;

@Service
public class MyCatService {

    private String nombre = "Renato";
    private int hambre = 20;
    private int energia = 50;
    private int nivel = 1;
    private int experiencia = 1;
    private int felicidad = 10;
    private int enojo = 60;

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre.trim();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaEnojado() {
        return hambre >= 80 || energia <= 10;
    }

    public String alimentar() {
        if (hambre == 0) {
            return nombre + " ya esta lleno y te mira con desprecio.";
        }
        hambre = Math.max(0, hambre - 20);
        ganarExperiencia(10);
        return "Le diste comida a " + nombre + ". Hambre reducida.";
    }

    public String jugar() {
        if (energia <= 10) {
            return nombre + " esta muy cansado, dejalo dormir.";
        }
        energia -= 15;
        hambre = Math.min(100, hambre + 10);
        ganarExperiencia(15);
        return nombre + " jugo con vos y esta feliz!";
    }

    public String dormir() {
        energia = Math.min(100, energia + 30);
        ganarExperiencia(5);
        return nombre + " durmio una siesta y recupero energia.";
    }

    private void ganarExperiencia(int puntos) {
        experiencia += puntos;
        if (experiencia >= 100) {
            experiencia = 0;
            nivel++;
        }
    }

    public String obtenerEstado() {
        String humor;
        if (estaEnojado()) {
            humor = "ENOJADO (cuidalo)";
        } else {
            humor = "CONTENTO :) ya no te mirara con desprecio.";
        }

        return "GATO: " + nombre + " | Nivel: " + nivel + " (XP: " + experiencia + "/100)\n"
            + "Estado: " + humor + "\n"
            + "Hambre: " + hambre + "/100 | Energia: " + energia + "/100";
    }
}