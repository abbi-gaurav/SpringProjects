package com.learn.camel;

import org.apache.camel.Exchange;

/**
 * Created by gabbi on 29.06.15.
 */
public class OrgDataProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().setBody(exchange.getProperty("orgs", String.class).toUpperCase(), String.class);
    }
}
