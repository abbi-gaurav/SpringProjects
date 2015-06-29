package com.learn.camel.workers;

/**
 * Created by gabbi on 29.06.15.
 */
public class OrgDataFetch {
    public String fetch(String url) {
        System.out.println(url+" Org data fetch--"+Thread.currentThread().getName());
        return "iteratec";
    }
}
