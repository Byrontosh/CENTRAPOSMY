
package com.mycompany.practicosistemadistribuidov2.principal;

import com.mycompany.practicosistemadistribuidov2.entidades.Productos;
import com.mycompany.practicosistemadistribuidov2.session.ProductosJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {


    public static void main(String[] args) {
   
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
               
        ProductosJpaController pjc = new ProductosJpaController(emf);
        
        
        
        Productos p = new Productos();
        p.setCodigo(1);
        p.setNombre("SOFTWARE RRHH");
        Double precio = 5000.99;
        BigDecimal bd1 = BigDecimal.valueOf(precio);
        p.setPrecio(bd1);
        p.setDetalle("Programa para manejo de personal");
        
        
        try {
            pjc.create(p);
            
        } catch (Exception ex) 
        {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
    }
    
}
