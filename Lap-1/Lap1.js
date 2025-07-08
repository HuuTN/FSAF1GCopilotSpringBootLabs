/* 1. Context-Aware Code Completion */
function fetchDataUser(userId) {
    // Fetch user data from an API
    return fetch(`https://api.example.com/users/${userId}`)
        .then(response => response.json())
        .then(data => {
            console.log(`User ID: ${data.id}, Name: ${data.name}`);
            return data;
        })
        .catch(error => console.error('Error fetching user data:', error));
}

/* 2. Inline Suggestion and Completions */
// Done

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

/* 4. Explain Source Code */
/*
This JavaScript function, generateRandomPassword, creates a random password consisting of 8 characters. It starts by defining a string called characters that contains all uppercase and lowercase English letters, as well as digits from 0 to 9. This string serves as the pool of possible characters for the password.

The function initializes an empty string called password to build the result. It then uses a for loop that runs 8 times—once for each character in the password. Inside the loop, it generates a random index by multiplying Math.random() (which returns a number between 0 and 1) by the length of the characters string, and then rounding it down with Math.floor(). This ensures the index is always a valid position within the characters string.

On each iteration, the character at the randomly chosen index is appended to the password string. After the loop completes, the function returns the generated password. This approach ensures that each password is a random combination of letters and numbers, making it suitable for basic password generation needs.

*/