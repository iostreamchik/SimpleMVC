package com.springapp.service;

import com.springapp.entitys.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION = "users";

    public List<User> getAll() {
        return mongoTemplate.findAll(User.class, COLLECTION);
    }

    public User findById(ObjectId id) {
        return mongoTemplate.findById(id, User.class);
    }

    public User findByUsername(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, User.class);
    }

    public void update(User user) {
        mongoTemplate.save(user, COLLECTION);
    }

    public void delete(User user) {
        mongoTemplate.remove(user, COLLECTION);
    }

    public void add(User user) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }
        mongoTemplate.insert(user, COLLECTION);
    }

}
