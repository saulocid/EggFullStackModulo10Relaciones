package Entities;

import java.util.ArrayList;

public class Juego {

   private ArrayList<Jugador> jugadores;
   private Revolver revolver;

   public Juego() {
      jugadores = new ArrayList();
   }

   public Juego(ArrayList<Jugador> jugadores, Revolver revolver) {
      this.jugadores = jugadores;
      this.revolver = revolver;
   }

   public ArrayList<Jugador> getJugadores() {
      return jugadores;
   }

   public void setJugadores(ArrayList<Jugador> jugadores) {
      this.jugadores = jugadores;
   }

   public Revolver getRevolver() {
      return revolver;
   }

   public void setRevolver(Revolver revolver) {
      this.revolver = revolver;
   }

}
