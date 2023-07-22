package guía002;

import Entities.Jugador;
import Services.JugadorService;
import java.util.ArrayList;
import java.util.Scanner;

/*
Realiza un programa en donde exista una clase Jugador que contenga nombre, apellido, posición
y número. Luego otra clase Equipo que contenga una colección de jugadores. Una vez hecho
esto, desde el main recorreremos el equipo mostrando la información de cada jugador.
 */
public class Guía002 {

   public static void main(String[] args) {

      Scanner leer = new Scanner(System.in).useDelimiter("\n");
      JugadorService js = new JugadorService();
      ArrayList<Jugador> lista = new ArrayList();
      
      do{
         Jugador j = js.crearJugador();
         lista.add(j);
         System.out.print("Desea continuar cargando jugadores? ");
      } while (!leer.next().toUpperCase().equals("N"));
      
      js.mostrar(lista);
      
   }

}
