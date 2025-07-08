/* 1. Context-Aware Code Completion */
function fetchDataUser(userId) {
    // Simulate an API call to fetch user data
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({ id: userId, name: "John Doe" });
        }, 1000);
    });
}

/* 3. Comment-Driven Developemnt (Natural Language to Code) */
// Create a funciton that returns a random password of 8 characters
function generateRandomPassword() { 
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let password = '';
    for (let i = 0; i < 8; i++) {
        const randomIndex = Math.floor(Math.random() * characters.length);
        password += characters[randomIndex];
    }
    return password;
}