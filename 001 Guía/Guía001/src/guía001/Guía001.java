package guía001;

import Entities.DNI;
import Entities.Persona;
import Services.PersonaService;

/**
Realiza un programa en donde una clase Persona tenga como atributo nombre, apellido y un
objeto de clase Dni. La clase Dni tendrá como atributos la serie (carácter) y número. Prueba
acceder luego a los atributos del dni de la persona creando objetos y jugando desde el main.
 */
public class Guía001 {

   public static void main(String[] args) {
      
      PersonaService ps = new PersonaService();
      DNI dni = new DNI('A',33331260);
      Persona p = new Persona("Saulo","Cid",dni);
            
      ps.mostrar(p);
      
   }
   
}
