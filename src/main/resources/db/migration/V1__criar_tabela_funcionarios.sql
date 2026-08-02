CREATE TABLE IF NOT EXISTS funcionarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    tipoFuncionario ENUM('bibliotecario', 'gerente') DEFAULT 'bibliotecario'
);