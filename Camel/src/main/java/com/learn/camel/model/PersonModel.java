package com.learn.camel.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

/**
 * Created by gabbi on 29.06.15.
 */
@CsvRecord(separator = ";", generateHeaderColumns = true, name = "PersonsRecord")
public class PersonModel {
    @DataField(pos = 1, name = "First Name")
    private final String firstName;

    @DataField(pos = 2, name = "Last Name")
    private final String lastName;

    public PersonModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
