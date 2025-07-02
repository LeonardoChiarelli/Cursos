CREATE TABLE events(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    ´date´ DATETIME NOT NULL,
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL,
    public_area VARCHAR(100) NOT NULL,
    neighbor VARCHAR(100) NOT NULL,
    postal_code VARCHAR(9) NOT NULL,
    number VARCHAR(20),
    complement VARCHAR(100),

    PRIMARY KEY(id)
);

CREATE TABLE purchases(
    id BIGINT NOT NULL AUTO_INCREMENT,
    ´date´ DATETIME NOT NULL,
    user_id BIGINT NOT NULL,
    payment_method VARCHAR(50) NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_purchases_user_id FOREIGN KEY(user_id) REFERENCES users(id)
);

CREATE TABLE tickets(
    id BIGINT NOT NULL AUTO_INCREMENT,
    event_id BIGINT NOT NULL,
    description VARCHAR(100) NOT NULL,
    ´value´ DECIMAL(7,2) NOT NULL,
    code VARCHAR(255) NOT NULL UNIQUE,
    purchase_id BIGINT,
    type VARCHAR(100),
    version INT NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT dk_tickets_event_id FOREIGN KEY(event_id) REFERENCES events(id),
    CONSTRAINT fk_tickets_purchase_id FOREIGN KEY(purchase_id) REFERENCES purchases(id)
);
