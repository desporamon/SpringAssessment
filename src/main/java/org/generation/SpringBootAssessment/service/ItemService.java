package org.generation.SpringBootAssessment.service;


//Interface to be used as a guide on what are the methods that are available that the controller
//can call and perform action.

//Service layer is to developed by developer A, controller layer is to be developed by developer B
//Developer B will be accessing the interface document to know what are the methods available for
//him/her to call


import org.generation.SpringBootAssessment.repository.entity.Item;
import java.util.List;

//will show what are the methods for this Item Service
public interface ItemService {

    //Read all items/ provides list all items from the database
    List<Item> all();

    //this method is used for two purposes - create new item & update existing item
    Item save(Item item);

    //Read an item from database - based on item Id
    Item findById(int itemId);

}