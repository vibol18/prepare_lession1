
const pageContent = document.getElementById("pageContent");
const menuLinks = document.querySelectorAll(".menu-link");
const sidebar = document.getElementById("sidebar");
const overlay = document.getElementById("overlay");

const students = [
    { id: 1, name: "Sok Rina", email: "rina@gmail.com", status: "Active" },
    { id: 2, name: "Chan Dara", email: "dara@gmail.com", status: "Active" },
    { id: 3, name: "Meas Sophal", email: "sophal@gmail.com", status: "Pending" },
    { id: 4, name: "Kim Vanny", email: "vanny@gmail.com", status: "Active" }
];

const products = [
    { id: 1, name: "Laptop", price: "$850", stock: 12 },
    { id: 2, name: "Keyboard", price: "$45", stock: 30 },
    { id: 3, name: "Mouse", price: "$25", stock: 45 },
    { id: 4, name: "Monitor", price: "$220", stock: 8 }
];

const orders = [
    { id: "#1001", customer: "Sok Rina", total: "$850", status: "Completed" },
    { id: "#1002", customer: "Chan Dara", total: "$45", status: "Pending" },
    { id: "#1003", customer: "Meas Sophal", total: "$220", status: "Completed" }
];

function renderTable(headers, rows) {
    return `
        <div class="panel">
            <div class="table-wrap">
                <table>
                    <thead>
                        <tr>${headers.map(h => `<th>${h}</th>`).join("")}</tr>
                    </thead>
                    <tbody>
                        ${rows.length
                            ? rows.map(row => `
                                <tr>${row.map(value => `<td>${value}</td>`).join("")}</tr>
                              `).join("")
                            : `<tr><td colspan="${headers.length}" class="empty">No data found</td></tr>`
                        }
                    </tbody>
                </table>
            </div>
        </div>
    `;
}

function dashboardPage() {
    return `
        <div class="page-heading">
            <div>
                <h1>Dashboard</h1>
                <p>Welcome back, Vibol! Here's your overview.</p>
            </div>
            <span class="date">${new Date().toLocaleDateString()}</span>
        </div>

        <section class="stats">
            <div class="stat-card">
                <div class="stat-icon blue"><i class="fa-solid fa-users"></i></div>
                <div><p>Total Students</p><h2>248</h2><small>+12% this month</small></div>
            </div>

            <div class="stat-card">
                <div class="stat-icon green"><i class="fa-solid fa-box"></i></div>
                <div><p>Total Products</p><h2>56</h2><small>+8% this month</small></div>
            </div>

            <div class="stat-card">
                <div class="stat-icon purple"><i class="fa-solid fa-cart-shopping"></i></div>
                <div><p>Total Orders</p><h2>1,248</h2><small>+18% this month</small></div>
            </div>

            <div class="stat-card">
                <div class="stat-icon orange"><i class="fa-solid fa-dollar-sign"></i></div>
                <div><p>Total Revenue</p><h2>$12,480</h2><small>+25% this month</small></div>
            </div>
        </section>

        <section class="panel">
            <h2>Sales Overview</h2>
            <div class="chart">
                ${[25, 40, 32, 55, 43, 70, 60, 88, 72, 100]
                    .map(height => `<div class="bar" style="height:${height}%"></div>`)
                    .join("")}
            </div>
            <div class="chart-labels">
                <span>Jan</span><span>Feb</span><span>Mar</span>
                <span>Apr</span><span>May</span><span>Jun</span>
                <span>Jul</span><span>Aug</span><span>Sep</span><span>Oct</span>
            </div>
        </section>

        <h2 style="margin-bottom:16px">Latest Students</h2>
        ${renderTable(
            ["ID", "Name", "Email", "Status"],
            students.map(s => [
                s.id,
                s.name,
                s.email,
                `<span class="status">${s.status}</span>`
            ])
        )}
    `;
}

function studentsPage() {
    return `
        <div class="page-heading">
            <div><h1>Students</h1><p>Manage your students.</p></div>
            <button class="btn" id="addStudent">+ Add Student</button>
        </div>
        <div id="studentTable">
            ${renderTable(
                ["ID", "Name", "Email", "Status"],
                students.map(s => [s.id, s.name, s.email, s.status])
            )}
        </div>
    `;
}

function productsPage() {
    return `
        <div class="page-heading">
            <div><h1>Products</h1><p>Manage your products.</p></div>
            <button class="btn" id="addProduct">+ Add Product</button>
        </div>
        ${renderTable(
            ["ID", "Product", "Price", "Stock"],
            products.map(p => [p.id, p.name, p.price, p.stock])
        )}
    `;
}

function ordersPage() {
    return `
        <div class="page-heading">
            <div><h1>Orders</h1><p>View and manage orders.</p></div>
        </div>
        ${renderTable(
            ["Order ID", "Customer", "Total", "Status"],
            orders.map(o => [o.id, o.customer, o.total, o.status])
        )}
    `;
}

function analyticsPage() {
    return `
        <div class="page-heading">
            <div><h1>Analytics</h1><p>Overview of your business performance.</p></div>
        </div>
        <section class="stats">
            <div class="stat-card"><div><p>Visitors</p><h2>8,420</h2></div></div>
            <div class="stat-card"><div><p>Conversion</p><h2>4.8%</h2></div></div>
        </section>
        <section class="panel">
            <h2>Monthly Performance</h2>
            <div class="chart">
                ${[35, 48, 40, 60, 50, 75, 65, 90]
                    .map(h => `<div class="bar" style="height:${h}%"></div>`)
                    .join("")}
            </div>
        </section>
    `;
}

function settingsPage() {
    return `
        <div class="page-heading">
            <div><h1>Settings</h1><p>Manage your preferences.</p></div>
        </div>
        <section class="panel">
            <h2>Profile Settings</h2>
            <p style="margin-bottom:16px">Username: Vibol</p>
            <p style="margin-bottom:16px">Role: Administrator</p>
            <label>
                <input type="checkbox" id="notificationSetting" checked>
                Enable notifications
            </label>
        </section>
    `;
}

const pages = {
    dashboard: dashboardPage,
    students: studentsPage,
    products: productsPage,
    orders: ordersPage,
    analytics: analyticsPage,
    settings: settingsPage
};

function changePage(page) {
    if (!pages[page]) page = "dashboard";

    pageContent.innerHTML = pages[page]();

    menuLinks.forEach(link => {
        link.classList.toggle("active", link.dataset.page === page);
    });

    sidebar.classList.remove("open");
    overlay.classList.remove("show");

    document.querySelector(".content").scrollTop = 0;
    window.scrollTo(0, 0);
}

// Click sidebar menu to change page
menuLinks.forEach(link => {
    link.addEventListener("click", function(event) {
        event.preventDefault();

        const page = this.dataset.page;

        history.replaceState(null, "", "#" + page);
        changePage(page);
    });
});

// Toggle sidebar on mobile
document.getElementById("menuToggle").addEventListener("click", () => {
    sidebar.classList.toggle("open");
    overlay.classList.toggle("show");
});

overlay.addEventListener("click", () => {
    sidebar.classList.remove("open");
    overlay.classList.remove("show");
});

// Search current page table
document.getElementById("searchInput").addEventListener("input", function() {
    const keyword = this.value.toLowerCase();

    document.querySelectorAll("#pageContent tbody tr").forEach(row => {
        row.style.display = row.textContent.toLowerCase().includes(keyword)
            ? ""
            : "none";
    });
});

// Demo buttons
pageContent.addEventListener("click", function(event) {
    if (event.target.closest("#addStudent")) {
        alert("Connect this button to your Add Student form.");
    }

    if (event.target.closest("#addProduct")) {
        alert("Connect this button to your Add Product form.");
    }
});

document.getElementById("logout").addEventListener("click", function(event) {
    event.preventDefault();

    if (confirm("Are you sure you want to logout?")) {
        alert("Connect this action to your authentication system.");
    }
});

// Load page based on URL hash
const initialPage = location.hash.replace("#", "") || "dashboard";
changePage(initialPage);
