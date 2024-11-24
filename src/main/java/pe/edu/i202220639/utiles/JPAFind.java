package pe.edu.i202220639.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import pe.edu.i202220639.entity.City;
import pe.edu.i202220639.entity.Country;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {

        // Referenciando otra vez mi unidad de persistencia uu
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        /**
         * Realizar una sola consulta a la entidad “Country” (Busque el código “PER” usando find) y en base al resultado imprima el nombre
         * de las ciudades peruanas con población > 700k. Deberá usar una función lambda para discriminar el resultado.
         */
        Country country = em.find(Country.class, "PER");

        // Mostrar un mensaje y resultado si se encontró el pais
        if (country != null) {
            System.out.println("País encontrado: " + country.getName());

            // Filtrar las ciudades del país que tienen una población mayor a 700,000
            country.getCities().stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println(city.getName()));
        } else {
            System.out.println("No se encontró el país con  código 'PER' ");
        }

    }
}
