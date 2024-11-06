package model;

import java.sql.Date;

public class Empleado {

    private int doc_identificacion;
    private String estado_civil;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private Date fecha_nacimiento;

    public Empleado(int doc_identificacion, String estado_civil, String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        this.doc_identificacion = doc_identificacion;
        this.estado_civil = estado_civil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Empleado() {
    }

    public int getDoc_identificacion() {
        return doc_identificacion;
    }

    public void setDoc_identificacion(int doc_identificacion) {
        this.doc_identificacion = doc_identificacion;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return this.getDoc_identificacion() + " " + this.getNombre() + " " + this.getApellido();
    }

}
