const forminput = document.getElementById("forminput")
const message = document.getElementById('message')
const cart = document.getElementById('cart')
const navbar = document.getElementById('navbar')
 message.innerHTML+=""
let output = document.getElementById('output')
forminput.addEventListener("click",function(e){
    e.preventDefault();
    const size = document.getElementById('size').value
    for (let i = 0; i < size; i++) {
       message.style.color = 'blue'
       cart.style.display ='block'
       message.innerHTML += `Hello <br>`  
    }
    if(size <= 0){
        cart.style.display = 'none'
    }
    if(size == 10){
        message.innerHTML+=`<h1>10 hz jng ban man tt</h1>`
    }else if(size == 15){
        cart.innerHTML += `<h1>Hello world</h1>
                           <img src="https://www.w3schools.com/aws/images/awslogo.png" width="100">
                           <p>From cloud computing</p>
                           `
    }
})
function cancel(){
    cart.style.display = 'none'
}
function opencart (){
    cart.style.display ='block';
    navbar.style.display ='block'
}
for (let index = 0; index < 10; index++) {
    output.innerHTML +=`

       <h1>Hello</h1>

`;
    
}

navbar.innerHTML +=`
    <table border="1px">
        <h1>Product</h1>

        <tr>
            <td colspan="7" align="center" style="background-color: blue;">
                Products

            </td>
        </tr>
        <tr>
            <td rowspan="4" style="color: pink; background-color: darkmagenta;">
                ROW
            </td>
        </tr>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>stock</th>
            <th>qty</th>
            <th>Action</th>
        </tr>
        <tr>
            <td>Coca</td>
            <td>12$</td>
            <td>13</td>
            <td>34</td>
            <td>
                <button onclick="update(id)">Update</button>
                <button onclick="update(id)">Delete</button>
            </td>
        </tr>

        <tr>
            <td>String</td>
            <td>1$</td>
            <td>3</td>
            <td>34</td>
            <td>
                <button onclick="update()">Update</button>
                <button>Delete</button>
            </td>
        </tr>
`;
function update(id){
    alert('hello'+id)
}
// let names = prompt('Enter name')
// document.writeln(`<h1>Hello ${names}</h1>`)
