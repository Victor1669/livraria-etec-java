CREATE TABLE IF NOT EXISTS pagamentos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_funcionario INT NOT NULL,
    totalPago DECIMAL(10,2) NOT NULL,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (id_funcionario)
	REFERENCES funcionarios(id)
);