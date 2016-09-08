package com.manulife.bootcamp;


import com.manulife.bootcamp.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main (String[] args) {
        SpringApplication.run (Application.class, args);
    }

    @Autowired
    JdbcTemplate _jdbcTemplate;

    @Override
    public void run (String... strings) throws Exception {
        log.info ("Creting tables ...");

        _jdbcTemplate.execute("DROP TABLE Customer IF EXISTS");
        _jdbcTemplate.execute("CREATE TABLE Customer (" +
                "id SERIAL, firstName VARCHAR(255), lastName VARCHAR(255) )");

        List<Object[]> nameList = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                            .stream()
                            .map(name -> name.split(" "))
                            .collect(Collectors.toList());

        nameList.forEach( name-> log.info(String.format("Inserting customer record for %s %s ", name[0], name[1])));

        _jdbcTemplate.batchUpdate("INSERT INTO Customer (firstName, lastName) VALUES (?, ?)", nameList);

        log.info("Querying for customer records where firstName = 'Josj'");

        _jdbcTemplate.query(
                "SELECT id, firstName, lastName FROM Customer WHERE firstName = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"))
        ).forEach(customer -> log.info(customer.toString()));




    }



}
