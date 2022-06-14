package org.generation.SpringBootAssessment.service;


import org.generation.SpringBootAssessment.repository.ItemRepository;
import org.generation.SpringBootAssessment.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//must use @service annotation at the top to tell SpringBoot this is a service layer
@Service
public class ItemServiceMySQL implements ItemService {

    /*
        Dependency Injection
        - transferring the task of creating the object to someone else

        Normally how we create an instance object of another class
        ItemServiceMySQL depends on the CRUDRepository Class to perform the CRUD operation

        //We are creating the instance object inside the ItemServiceMySQL Class
        ItemServiceMySQL myService = new CrudRepository();  //Cannot

        //ItemServiceMySQL is dependent on CrudRepository

        //1) Adhere to the abstraction (hiding details) principle, where we only have access to the interface of the Class object.
        //We have no direct access to the Class Object itself.

        //2) Dependency Injection - Inversion of Control (DI - IOC) - The creation of the instance object is done by another object instead of in the ItemService SQL Class
     */

    //The dependency instance object will be injected through the constructor, inform Springboot using annotation @AutoWired
    //declare a private variable to reference it before it is injected
    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        //Injecting an instance object of the CrudRepository object
        //We are able to make use of this.itemRepository to access the properties and
        // methods from the CrudRepository object

        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);   //CrudRepository
    }

    @Override
    public List<Item> all() {
        //create ArrayList to hold whatever is returned back and add it to the results arraylist
        //make use of the itemRepository and call the method findAll(iterate through the records)
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result :: add);
        return result;
    }

    @Override
    public Item findById(int itemId) {

        //Item is an object
        Optional<Item> item = itemRepository.findById(itemId);   //Cannot be a null
        Item itemResponse = item.get();
        return itemResponse;
    }
}
