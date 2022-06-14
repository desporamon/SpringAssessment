package org.generation.SpringBootAssessment.repository.entity;

//This is in the Model component (MVC Design Pattern)
//Item Class object will be used to map up with the Item Table from the database

//We are using the same name for Class Object and Table name, as well as the name naming convention for the attributes

import org.generation.SpringBootAssessment.controller.dto.ItemDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//To inform Hibernate to map to a table with this class object

@Entity
public class Item {

    //using Wrapper Class Integer (Object) instead of int (Primitive Data type)

    //We need to identify which attribute is the id (Primary Key), and how the id is generated

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //need to pass the id to a class method findItemById()
    private String title;
    private String description;
    private String targetDate;

    //default constructor only exists for the sake of JPA; we do not use it directly
    public Item() {}

    //This constructor is the one you use to create instances of Item to be saved to the database
    public Item(ItemDTO itemDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the database table columns and be able
        // to save the data in the columns
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.targetDate = String.valueOf(itemDTO.getTargetDate());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetDate='" + targetDate + '\'' +
                '}';
    }
}
