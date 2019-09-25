package com.javabrown.core.api.resources;


import com.javabrown.core.api.model.Country;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;
import java.util.UUID;

@RestController
@EnableWebMvc
public class RootController {
    @RequestMapping(path = "/country", method = RequestMethod.POST)
    public Country createCountry(@RequestBody Country newPet) {
        Country country = new Country();
        country.setId(UUID.randomUUID().toString());
        country.setName("USA");
        return country;
    }

    @RequestMapping(path = "/country", method = RequestMethod.GET)
    public Country[] listCountry() {
        Country[] countryList = new Country[10];

        for (int i = 0; i < 10; i++) {
            Country country = new Country();
            country.setId(UUID.randomUUID().toString());
            country.setName("USA " + i);
            countryList[i] = country;
        }

        return countryList;
    }

    @RequestMapping(path = "/country/{id}", method = RequestMethod.GET)
    public Country listPets(@PathVariable String id) {
        Country country = new Country();
        country.setId(id);
        country.setName("USA " + id);
        return country;
    }
}