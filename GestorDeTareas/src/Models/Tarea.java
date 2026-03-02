/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author pablo
 */
public class Tarea {
    private String descripcion;
    private String prioridad;
    private String categoria;
    private String notas;
    private boolean completada;

    // Booleanos para decidir qué mostrar
    private boolean mostrarDescripcion = true;
    private boolean mostrarPrioridad = true;
    private boolean mostrarCategoria = true;
    private boolean mostrarNotas = false;
    private boolean mostrarEstado = true;

    // Constructor
    public Tarea(String descripcion, String prioridad, String categoria, String notas) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.notas = notas;
    }
    
    public Tarea(String descripcion, String prioridad, String categoria, String notas, boolean completada) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.notas = notas;
        this.completada = completada;
    }

    // --- Getters y Setters normales ---
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }

    // --- Getters y Setters de visibilidad ---
    public void setMostrarDescripcion(boolean mostrar) { this.mostrarDescripcion = mostrar; }
    public void setMostrarPrioridad(boolean mostrar) { this.mostrarPrioridad = mostrar; }
    public void setMostrarCategoria(boolean mostrar) { this.mostrarCategoria = mostrar; }
    public void setMostrarNotas(boolean mostrar) { this.mostrarNotas = mostrar; }
    public void setMostrarEstado(boolean mostrar) { this.mostrarEstado = mostrar; }

    // --- toString dinámico ---
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (mostrarEstado) {
            sb.append(completada ? "[Hecha] " : "[ ] ");
        }

        if (mostrarCategoria) {
            sb.append("(").append(categoria).append(") ");
        }

        if (mostrarDescripcion) {
            sb.append(descripcion).append(" ");
        }

        if (mostrarPrioridad) {
            sb.append("- ").append(prioridad).append(" ");
        }

        if (mostrarNotas) {
            sb.append("| Notas: ").append(notas);
        }

        return sb.toString().trim();
    }
}