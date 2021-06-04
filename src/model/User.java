package model;

import java.time.LocalDate;

public class User {

    private String id, name, lastName;
    private DocumentType documentType;
    private Gender gender;
    private LocalDate birthDay;
    private int age;

    public User(String id, String name, String lastName, DocumentType documentType, Gender gender, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentType = documentType;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public User(String id, String name, String lastName, DocumentType documentType, Gender gender, LocalDate birthDay, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentType = documentType;
        this.gender = gender;
        this.birthDay = birthDay;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return
                 id + ";" + name +";"+ lastName +";"+ documentType +";"+ gender +";"+ birthDay +";"+ age;
    }
}
