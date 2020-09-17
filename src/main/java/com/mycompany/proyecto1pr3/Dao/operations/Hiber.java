/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1pr3.Dao.operations;

import com.mycompany.proyecto1pr3.Dao.modelo.PaisModelo;
import com.mycompany.proyecto1pr3.Dao.paisDao;
import java.util.Scanner;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Hiber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        paisDao pais1 = new paisDao();
        
        PaisModelo p1 = null;
        int opcion = -1;
        Scanner entrada = new Scanner(System.in);
        String id, nombre, abreviatura, idioma, moneda, religion;
  
        while (opcion !=0){
        
        try{
            System.out.println("Elige una opcion:\n1.-Listar Paises" + 
          "\n2.-Buscar pais por Id\n" +
                    "3.-Agregar un pais\n" +
                    "4.-Modificar un pais\n"+
                    "5.-Eliminar un pais\n" +
                    "0.-Salir\n");

            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion){
                case 1:
                    System.out.println("\n1.Listado de paises***********");
                    pais1.selectall();
                    break;
                    
                case 2:
                    System.out.println("\n2.Buscar pais por Id***********");
                    System.out.println("Introduce el Id de la pais a buscar:");
                    id = entrada.nextLine();
                    p1 = new PaisModelo();
                    p1.setId(new Integer(id));
                    p1 = pais1.fyndbyId(p1);
                    System.out.println("Registro encontrado:" + p1);
                    break;
                case 3:
                    System.out.println("\n3.Insertar pais***********");
                    System.out.println("Introduce el nombre del pais a agregar");
                    nombre = entrada.nextLine();
                    
                    System.out.println("Introduce la abreviatura del pais a agregar");
                    abreviatura = entrada.nextLine();
                    
                    System.out.println("Introduce el idioma del pais a agregar");
                    idioma = entrada.nextLine();
                    
                    System.out.println("Introduce la moneda del pais");
                    moneda = entrada.nextLine();
                    
                    System.out.println("Introduce la religion del pais");
                    religion = entrada.nextLine();
                                  
                    p1 = new PaisModelo();
                    p1.setNombre_pais(nombre);
                    p1.setAbreviatura(abreviatura);
                    p1.setIdioma(idioma);
                    p1.setMoneda(moneda);
                    p1.setReligion(religion);
                    pais1.Insertar(p1);
                    break;
                case 4:
                    System.out.println("\n4.Modificar pais ***********");
                    //primero buscamos la persona a modificar
                    System.out.println("Introducir el Id del pais a modificar");
                    id = entrada.nextLine();
                    p1= new PaisModelo();
                    p1.setId(new Integer(id));
                    pais1.fyndbyId(p1);
                    
                    System.out.println("Introduce el nombre del pais a modificar");
                    nombre = entrada.nextLine();
                    
                    System.out.println("Introduce la abreviatura del pais a buscar");
                    abreviatura = entrada.nextLine();
                    
                    System.out.println("Introduce el idioma del pais a agregar");
                    idioma = entrada.nextLine();
                    
                    System.out.println("Introduce la moneda del pais");
                    moneda = entrada.nextLine();
                    
                    System.out.println("Introduce la religion del pais");
                    religion = entrada.nextLine();
                    
                    p1.setNombre_pais(nombre);
                    p1.setAbreviatura(abreviatura);
                    p1.setIdioma(idioma);
                    p1.setMoneda(moneda);
                    p1.setReligion(religion);
                    pais1.actualizar(p1);
                    break;
                case 5:
                    System.out.println("\n5.Eliminar pais ***********");
                    //buscamos la persona a eliminar
                    System.out.println("Introuce el id del pais a eliminar");
                    id= entrada.nextLine();
                    p1 = new PaisModelo();
                    p1.setId(new Integer(id));
                    p1 = pais1.fyndbyId(p1);
                    //Eliminar el registro encontrado
                    pais1.eliminar(p1);
                    break;
                case 0:
                    System.out.println("Salida efectuada");
                    System.exit(0);
                    break;
                    
            
                } 
                    System.out.println("\n");
            
               }catch(Exception ex){
                    System.out.println("Surgio una falla en la ejecucion:" + ex.getMessage());
            }
        
        } 
    }
}
    

