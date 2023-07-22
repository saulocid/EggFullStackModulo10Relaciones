package Entities;

public class Revolver {

   private Integer posicionActual;
   private Integer posicionAgua;

   public Revolver() {
   }

   public Revolver(Integer posicionActual, Integer posicionAgua) {
      this.posicionActual = posicionActual;
      this.posicionAgua = posicionAgua;
   }

   public Integer getPosicionActual() {
      return posicionActual;
   }

   public void setPosicionActual(Integer posicionActual) {
      this.posicionActual = posicionActual;
   }

   public Integer getPosicionAgua() {
      return posicionAgua;
   }

   public void setPosicionAgua(Integer posicionAgua) {
      this.posicionAgua = posicionAgua;
   }

   @Override
   public String toString() {
      return "El tambor está en la posición " + posicionActual + " y el chorro de agua se encuentra en la posición " + posicionAgua;
   }

}
