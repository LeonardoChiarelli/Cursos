CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    ssn VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    birth DATE NOT NULL,
    password VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)
);

CREATE TABLE access_profiles(
    id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL UNIQUE,

    PRIMARY KEY(id)
);

CREATE TABLE users_profiles(
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,

    PRIMARY KEY(user_id, profile_id)
);

INSERT INTO access_profiles VALUES(1, 'ROLE_ADMIN');
INSERT INTO access_profiles VALUES(2, 'ROLE_COSTUMER');

INSERT INTO users VALUES(1, 'Administrator', '00000000000', 'admin@email.com.br', '2006-03-16', '$2a$10$NRPNQpth64z1VKCrOdtZ/Otpk5zHsbaVXdXYPJazgsaH/QBvE3WPy');
INSERT INTO users VALUES(2, 'Costumer', '11111111111', 'costumer@email.com.br', '1980-10-10', '$2a$10$f.lj9PV2eC2H3LLZzsYciu.Gkg.zTu9mIa05DfCQMCvmzw47WolXu');

INSERT INTO users_profiles VALUES(1, 1);
INSERT INTO users_profiles VALUES(1, 2);
INSERT INTO users_profiles VALUES(2, 2);
