package com.learn.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gabbi on 29.06.15.
 */
public class PersonDataProcessor implements Processor{
    public void process(Exchange exchange) throws Exception {
        List<String> personDatas = exchange.getProperty("persons", List.class);

        exchange.getOut().setBody(personDatas.stream().map(x -> map(x)).collect(Collectors.toList()));
    }

    private PersonModel map(String personData) {
        String[] personNameData = personData.toUpperCase().split(" ");
        return new PersonModel(personNameData[0], personNameData[1]);
    }
}
