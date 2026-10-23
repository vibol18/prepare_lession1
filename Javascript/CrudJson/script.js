
const output = document.getElementById("output");
const form = document.getElementById("product-form");
const submitBtn = document.getElementById("submit-btn");
const message = document.getElementById("message");

let products = [];
let editId = null;

// READ: Load data from products.json
async function loadProducts() {
    try {
        const response = await fetch("./Products.json");

        if (!response.ok) {
            throw new Error("Cannot load products.json");
        }

        products = await response.json();
        renderProducts();
    } catch (error) {
        message.textContent =
            "Failed to load products. Run this project using a local server.";
        console.error(error);
    }
}

// READ: Display products
function renderProducts() {
    output.innerHTML = "";

    products.forEach(product => {
        output.innerHTML += `
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><img src="${product.img}" width="80""></td>
                <td>$${product.price}</td>
                <td>${product.qty}</td>
                <td>
                    <button class="btn btn-warning btn-sm"
                        onclick="editProduct(${product.id})">
                        Edit
                    </button>

                    <button class="btn btn-danger btn-sm"
                        onclick="deleteProduct(${product.id})">
                        Delete
                    </button>
                </td>
            </tr>
        `;
    });

    if (products.length === 0) {
        output.innerHTML = `
            <tr>
                <td colspan="5" class="text-center">
                    No products found
                </td>
            </tr>
        `;
    }
}

// Open form for CREATE
function openAddForm() {
    form.reset();
    editId = null;
    submitBtn.textContent = "Add";
    form.style.display = "block";
}

// CREATE and UPDATE
form.addEventListener("submit", function (event) {
    event.preventDefault();

    const name = document.getElementById("name").value.trim();
    const price = Number(document.getElementById("price").value);
    const qty = Number(document.getElementById("qty").value);

    if (!name || price < 0 || qty < 0) {
        message.textContent = "Please enter valid product details.";
        return;
    }

    if (editId === null) {
        // CREATE
        const newProduct = {
            id: Date.now(),
            name: name,
            price: price,
            qty: qty
        };

        products.push(newProduct);
        message.textContent = "Product added in memory.";
    } else {
        // UPDATE
        const product = products.find(p => p.id === editId);

        if (product) {
            product.name = name;
            product.price = price;
            product.qty = qty;
        }

        message.textContent = "Product updated in memory.";
    }

    renderProducts();
    cancelForm();
});

// Load selected product into the form
function editProduct(id) {
    const product = products.find(p => p.id === id);

    if (!product) return;

    editId = id;

    document.getElementById("name").value = product.name;
    document.getElementById("price").value = product.price;
    document.getElementById("qty").value = product.qty;

    submitBtn.textContent = "Update";
    form.style.display = "block";
}

// DELETE
function deleteProduct(id) {
    if (!confirm("Are you sure you want to delete this product?")) {
        return;
    }

    products = products.filter(p => p.id !== id);
    renderProducts();

    message.textContent = "Product deleted from memory.";
}

// Cancel form
function cancelForm() {
    form.reset();
    form.style.display = "none";
    editId = null;
    submitBtn.textContent = "Add";
}

// Start application
loadProducts();
