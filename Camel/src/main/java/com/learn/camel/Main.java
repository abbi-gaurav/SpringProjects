package com.learn.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.util.jndi.JndiContext;

/**
 * Created by gabbi on 29.06.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        JndiContext jndiContext = new JndiContext();
        jndiContext.bind("personFetch", new PersonDataFetch());
        jndiContext.bind("orgFetch", new OrgDataFetch());
        CamelContext camelContext = new DefaultCamelContext(jndiContext);
        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("direct:start")
                            .multicast()
                            .parallelProcessing()
                            .to("direct:person", "direct:org")
                            .end();
                    from("direct:person")
                            .to("bean:personFetch?method=fetch")
                            .setProperty("persons", body())
                            .process(new PersonDataProcessor())
                            .marshal()
                            .bindy(BindyType.Csv,PersonModel.class)
                            .to("file://target/" + "persons")
                            .end();

                    from("direct:org")
                            .to("bean:orgFetch?method=fetch")
                            .setProperty("orgs", body())
                            .process(new OrgDataProcessor())
                            .setBody(simple("body: ${body}, thread: ${threadName}"))
                            .to("file://target/"+"orgs")
                            .end();
                }
            });

            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            template.sendBody("direct:start", "Multicast");
        } finally {
            camelContext.stop();
        }
    }
}
