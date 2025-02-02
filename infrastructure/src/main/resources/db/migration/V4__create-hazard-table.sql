CREATE TABLE Hazard (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    hazard_type_id INT NOT NULL,
    description TEXT,
    latitude DECIMAL(9, 6) NOT NULL,
    longitude DECIMAL(9, 6) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (hazard_type_id) REFERENCES hazard_type(id) ON DELETE SET NULL
);