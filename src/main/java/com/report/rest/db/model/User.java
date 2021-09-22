package com.report.rest.db.model;

import java.time.LocalDateTime;

public class User {
    public long id;
    public String nickname;
    public String name; // имя
    public String surname;
    public String patronymic;
    public String email;
    public String password;
    public LocalDateTime dateOfLastUpdate;
    public LocalDateTime dateOfCreation;
    public Boolean isDeleted;

    public User(String nickname, String name, String surname, String patronymic, String email, String password,
                LocalDateTime dateOfLastUpdate, LocalDateTime dateOfCreation, Boolean isDeleted) {
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.dateOfCreation = dateOfCreation;
        this.isDeleted = isDeleted;
    }

    public User(long id, String nickname, String name, String surname, String patronymic, String email,
                String password, LocalDateTime dateOfLastUpdate, LocalDateTime dateOfCreation, Boolean isDeleted) {
        this.id = id;
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.dateOfCreation = dateOfCreation;
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
