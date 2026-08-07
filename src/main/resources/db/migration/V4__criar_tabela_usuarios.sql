CREATE TABLE IF NOT EXISTS usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) UNIQUE NOT NULL,
    role ENUM("user", "admin") DEFAULT "user",
    senha VARCHAR(30) NOT NULL
);