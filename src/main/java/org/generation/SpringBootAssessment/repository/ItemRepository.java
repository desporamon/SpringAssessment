package org.generation.SpringBootAssessment.repository;

//The ItemRepository created is to extend the CRUDRepository provided by Spring DataJPA package


import org.generation.SpringBootAssessment.repository.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer>
{
    //Not only the ItemRepository inherit all the methods from the CrudRepository
    // Interface, ItemRepository can also have its own methods (do not need)

    //So now I can use the ItemRepository interface to perform basic CRUD operation

}
