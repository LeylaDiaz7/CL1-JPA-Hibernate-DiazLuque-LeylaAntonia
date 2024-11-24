package pe.edu.i202220639.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220639.entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        /**
         * Elimine el país imaginario (Previamente creado). La eliminación debe eliminar el rastro de sus 3 ciudades y
         * 2 lenguajes nativos. Sólo debe realizar un llamado al método “remove”.
         */

        //Iniciar la transaccion
        em.getTransaction().begin();

        //Seleccionar el pais que creé en mi JPAPersist ("BRU")
        Country country = em.find(Country.class, "BRU");

        if(country != null)
        {
            em.remove(country);
            System.out.println("Se elimino el pais "+ country.getName() +", sus 3 ciudades y sus 2 lenguajes nativos");
        }else { System.out.println("No se encontó el país a eliminar");}

        // finalizar la transacción
        em.getTransaction().commit();
    }
}
