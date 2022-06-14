//productForm.js was created to handle the front-end form-validation, clicking of button.

const productsControl = new ProductsController();
//var storeImage = ""

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemTitle = document.querySelector('#newItemTitle');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemTargetDate = document.querySelector('#newItemTargetDate');

    /*
        Do the Validation code here
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const title = newItemTitle.value;
    const description = newItemDescription.value;
    const targetDate = newItemTargetDate.value;

    // Clear the form
    newItemTitle.value = '';
    newItemDescription.value = '';
    newItemTargetDate.value = '';

    // Add the task to the task manager
    //After we get all the values and object from the form, we will call the addItem
    //method in the ProductsController class to peform the POST HTTP Request by calling the
    //REST API provided by the backend
    productsControl.addItem(title, description, targetDate);

});


