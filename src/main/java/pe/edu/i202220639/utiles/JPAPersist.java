package pe.edu.i202220639.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220639.entity.City;
import pe.edu.i202220639.entity.Country;
import pe.edu.i202220639.entity.CountryLanguage;
import pe.edu.i202220639.entity.CountryLanguagePk;

import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {

        //Referencia a mi unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //Registrar un país imaginario , que tenga 3 ciudades y 2 lenguajes nativos. Sólo debe realizar un llamado al método “persist”.

        // Creando el país imaginario
        Country country = new Country();
        country.setCode("BRU");
        country.setName("BRUNOLANDIA");
        country.setContinent("Europe");
        country.setRegion("Eastern Europe");
        country.setSurfaceArea(7000.00);
        country.setIndepYear(1962);
        country.setPopulation(7733000);
        country.setLifeExpectancy(90.0);
        country.setGnp(10.0);
        country.setGnpOld(78.4);
        country.setLocalName("Brunoland");
        country.setGovernmentForm("Monarchy");
        country.setHeadOfState("BRUCE");
        country.setCapital(1);
        country.setCode2("B");

        // Creando ciudades
        City city1 = new City("City1", country, "District1",200);
        City city2 = new City("City2", country, "District2", 30000);
        City city3 = new City("City3", country, "District3", 27070);

        // Creando los lenguajes
        CountryLanguage language1 = new CountryLanguage(new CountryLanguagePk("BRU", "Ruso"), "T", 60.0, country);
        CountryLanguage language2 = new CountryLanguage(new CountryLanguagePk("BRU", "Ingles"), "F", 40.0, country);

        // Asociación de relaciones al país
        country.setCities(Arrays.asList(city1, city2, city3));
        country.setLanguages(Arrays.asList(language1, language2));

        // Persistir el país en todas las relaciones
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

    }

}
