package com.learn.spring.controller;

import com.learn.spring.entity.Contact;
import com.learn.spring.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gabbi on 19.06.15.
 */
@RestController
@RequestMapping("/contacts")
public class ContactResource {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
