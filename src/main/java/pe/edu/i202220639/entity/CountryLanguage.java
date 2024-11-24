package pe.edu.i202220639.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId //anotacion de una clave compuesta
    private CountryLanguagePk countryLanguagePk;

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private double percentage;

    @ManyToOne
    @JoinColumn(name="CountryCode")
    @MapsId("countryCode")
    private Country country;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguagePk countryLanguagePk) {
        this.countryLanguagePk = countryLanguagePk;
    }

    public CountryLanguage(CountryLanguagePk countryLanguagePk, String isOfficial, double percentage, Country country) {
        this.countryLanguagePk = countryLanguagePk;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    public CountryLanguagePk getCountryLanguagePk() {
        return countryLanguagePk;
    }

    public void setCountryLanguagePk(CountryLanguagePk countryLanguagePk) {
        this.countryLanguagePk = countryLanguagePk;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "countryLanguagePk=" + countryLanguagePk +
                ", isOfficial='" + isOfficial + '\'' +
                ", percentage=" + percentage +
                ", country=" + country +
                '}';
    }
}