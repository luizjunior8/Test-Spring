package com.ufpb.lcc.jrwalker.request;

import com.ufpb.lcc.jrwalker.model.User;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {
    private Integer id;
    @NotNull
    @Size (min = 3, max = 255, message = "Nome deve ter entre 3 e 255 caracteres")
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    @Email
    private String email;

    public UserRequest() {
          }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toModel() {
        return new User(null, this.name, this.age, this.email);
    }
}
