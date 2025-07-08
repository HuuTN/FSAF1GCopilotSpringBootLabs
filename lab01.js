// def fetch_user_data(user_id):
function fetch_user_data(user_id) {
    // Simulate fetching user data from a database
    const user_data = {
        1: { name: "Alice", age: 30 },
        2: { name: "Bob", age: 25 },
        3: { name: "Charlie", age: 35 }
    };
    
    return user_data[user_id] || null;
}

// Create a function that returns a random password of 8 characters
function generate_random_password() {
    const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    let password = "";
    for (let i = 0; i < 8; i++) {
        const random_index = Math.floor(Math.random() * characters.length);
        password += characters[random_index];
    }
    return password;
}


// Explain what this function does: def get_top_customers(customers, limit=5): sorted_customers = sorted(customers, key=lambda c: c['revenue'], reverse=True) return sorted_customers[:limit]
function get_top_customers(customers, limit = 5) {
    // This function sorts a list of customers based on their revenue in descending order
    // and returns the top 'limit' number of customers.
    const sorted_customers = customers.sort((a, b) => b.revenue - a.revenue);
    return sorted_customers.slice(0, limit);
}
