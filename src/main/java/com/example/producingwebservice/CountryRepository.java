package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        Country kz = new Country();
        kz.setName("Kazakhstan");
        kz.setCapital("Nur-Sultan");
        kz.setCurrency(Currency.KZT);
        kz.setPopulation(20000000);

        Country ru = new Country();
        ru.setName("Russia");
        ru.setCapital("Moscow");
        ru.setCurrency(Currency.RUB);
        ru.setPopulation(156000000);

        countries.put(spain.getName(), spain);
        countries.put(poland.getName(), poland);
        countries.put(uk.getName(), uk);
        countries.put(kz.getName(), kz);
        countries.put(ru.getName(), ru);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }
}