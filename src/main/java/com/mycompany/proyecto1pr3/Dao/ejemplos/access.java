/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto1pr3.Dao.ejemplos;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class access {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BD select = new BD(); //Instanciamos el objeto que maneja las operaciones sobre la base de datos
         select.consultar();
    }
    
}
