CREATE TABLE weather_history (
    id SERIAL PRIMARY KEY,
    city VARCHAR(50),
    temperature DECIMAL(5,2),
    description VARCHAR(100),
    query_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
