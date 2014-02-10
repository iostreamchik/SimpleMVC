package com.springapp.entitys;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document(collection = "users")
public class User {
    @Id
    private ObjectId _id;
    @NotNull
    @Size(min = 3, max = 15)
//    @Pattern(regexp = "^[A-Za-z0-9_-]$")
    private String username;
    @NotNull
    @Size(min = 6, max = 24)
//    @Pattern(regexp = "^[a-zA-Z0-9@*#]$")
    private String password;
    @Email
    @NotNull
    private String email;

    public User() {
        this._id = ObjectId.get();
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
