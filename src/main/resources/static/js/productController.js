//Doing a Product web app, in product page to
//display the name, description, imageUrl, style, price, ..., ...,.....,....


const createHTMLList = (index, title, description, targetDate) =>
`
  <tr>
    <td>${title}</td>
    <td>${description}</td>
    <td>${targetDate}</td>
  </tr>
`;


class ProductsController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array
    addItem(title, description, targetDate)
    {
        //fetch POST HTTP method to send the data to the backend via the API
        var productController = this;
        const formData = new FormData();
         formData.append('title', title);
         formData.append('description', description);
         formData.append('targetDate', targetDate);

           fetch('http://localhost:8090/item/add', {
                method: 'POST',
                body: formData
                })
                .then(function(response) {
                    console.log(response.status); // Will show you the status
                    if (response.ok) {
                        alert("Successfully added task!")
                      }
                 })
                 .catch((error) => {
                     console.error('Error:', error);
                     alert("Error adding task to ToDo List")
                 });
    }

    displayItem()
    {
        //fetch the items from the database using the API [GET HTTP method (default)]
        let productController = this;
        productController._items = [];

         //fetch data from database using the REST API endpoint from Spring Boot
         fetch('http://localhost:8090/item/all')
              .then((resp) => resp.json())
              .then(function(data) {
                  console.log("2. receive data")
                  console.log(data);
                  data.forEach(function (item, index) {
                      const itemObj = {
                         id: item.id,
                         title: item.title,
                         description: item.description,
                         targetDate: item.targetDate,
                      };
                      productController._items.push(itemObj); //item array consists of all the data that we retrieved
                      //from the database through the API
                  });

                      productController.renderProductPage(); //create html elements

                    })
                    .catch(function(error) {
                        console.log(error);
                    });

    }


    renderProductPage()
    {
        const productHTMLList = [];
        let productController = this;

        for (let i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.title, item.description, item.targetDate);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and separate by a break
        const pHTML = productHTMLList.join('\n');
        const itemsContainer = document.getElementById('tbody');
        itemsContainer.innerHTML = pHTML;
    }
}   //End of ProductsController class