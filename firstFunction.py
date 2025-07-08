def fetch_user_data(user_id):
    # Simulate a database call
    user_data = {
        1: {"name": "Alice", "age": 30},
        2: {"name": "Bob", "age": 25},
    }
    return user_data.get(user_id, {"name": "Unknown", "age": 0}) 

