package com.mycompany.principal;

import com.mycompany.entidades.Producto;
import com.mycompany.session.ProductoJpaController;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {
        //PRUEBA DE 16-06-2020
        
        //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        // LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXIÓN
        ProductoJpaController pjc = new ProductoJpaController(emf);
        //CREAMOS UN NUEVO PRODUCTO
        Producto p = new Producto();
        p.setCodigo(1);
        p.setNombre("Software CMS");
        Double d1 = 5000.99;
        BigDecimal bd1 = BigDecimal.valueOf(d1.doubleValue());
        p.setPrecio(bd1);
        p.setDetalle("Gestión de productos");

        try {

            pjc.create(p);
            //pjc.edit(p);
        } catch (Exception ex) {

            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }

    }

}
