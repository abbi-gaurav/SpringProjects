package com.learn.spring.repository;

import com.learn.spring.entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by gabbi on 19.06.15.
 */
public interface ContactRepository extends MongoRepository<Contact, String> {
}
