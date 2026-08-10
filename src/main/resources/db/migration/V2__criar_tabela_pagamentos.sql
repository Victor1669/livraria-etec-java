CREATE TABLE IF NOT EXISTS pagamentos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    idFuncionario INT NOT NULL,
    totalPago DECIMAL(10,2) NOT NULL,
    dataTransacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (idFuncionario)
	REFERENCES funcionarios(id)
);