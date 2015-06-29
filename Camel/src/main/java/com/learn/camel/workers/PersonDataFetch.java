package com.learn.camel.workers;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gabbi on 29.06.15.
 */
public class PersonDataFetch {
    public List<String> fetch(String url) {
        System.out.println(url+" personfetch--"+Thread.currentThread().getName());
        return Arrays.asList(new String[]{"Gaurav Abbi", "S S"});
    }
}
