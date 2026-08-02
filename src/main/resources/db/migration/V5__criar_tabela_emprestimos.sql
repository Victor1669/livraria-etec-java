CREATE TABLE IF NOT EXISTS emprestimos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    nome_livro VARCHAR(30) NOT NULL,

    FOREIGN KEY (id_usuario)
	REFERENCES usuarios(id),

    FOREIGN KEY (nome_livro)
	REFERENCES livros(nome)
);