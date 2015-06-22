package com.learn.spring.controller;

import com.learn.spring.entity.Contact;
import com.learn.spring.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gabbi on 19.06.15.
 * ss
 */
@RestController
@RequestMapping(value = "/contacts")
public class ContactResource {
    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Contact create(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Contact inRepo = contactRepository.findOne(id);
        inRepo.setName(contact.getName());
        return contactRepository.save(inRepo);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable String id) {
        contactRepository.delete(id);
    }
}
