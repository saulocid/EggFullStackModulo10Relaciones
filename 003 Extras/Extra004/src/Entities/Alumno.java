package Entities;

import java.util.HashSet;

public class Alumno {
   
   private String nombreApellido;
   private Integer DNI;
   private Integer cantidadVotos;
   private HashSet<String> votados = new HashSet<>();

   public Alumno() {
   }

   public Alumno(String nombreApellido, Integer DNI, Integer cantidadVotos) {
      this.nombreApellido = nombreApellido;
      this.DNI = DNI;
      this.cantidadVotos = cantidadVotos;
   }

   public String getNombreApellido() {
      return nombreApellido;
   }

   public void setNombreApellido(String nombreApellido) {
      this.nombreApellido = nombreApellido;
   }

   public Integer getDNI() {
      return DNI;
   }

   public void setDNI(Integer DNI) {
      this.DNI = DNI;
   }

   public Integer getCantidadVotos() {
      return cantidadVotos;
   }

   public void setCantidadVotos(Integer cantidadVotos) {
      this.cantidadVotos = cantidadVotos;
   }

   public HashSet<String> getVotados() {
      return votados;
   }

   public void setVotados(HashSet<String> votados) {
      this.votados = votados;
   }

   @Override
   public String toString() {
      return "El alumno es " + nombreApellido + ", con DNI nº " + DNI + " y tiene " + cantidadVotos +" cantidad de votos";
   }
   
}
