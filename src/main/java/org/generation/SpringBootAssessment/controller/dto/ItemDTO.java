package org.generation.SpringBootAssessment.controller.dto;

//Data Transfer Object for Item
//In the controller component (MVC), this class object is going to receive the info/data that is sent from
// the client (through the HTTP POST request)

//Controller will then call the required method (save method) to perform Create and pass the info/data to the
// service layer

import java.time.LocalDate;

public class ItemDTO {

    //fields
    private String title;
    private String description;
    private LocalDate targetDate;

    //Constructor
    public ItemDTO(String title, String description, LocalDate targetDate) {
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
    }

    //Getter and Setters
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

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
