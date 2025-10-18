CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          cpf VARCHAR(11) NOT NULL UNIQUE
);

CREATE TABLE investimentos (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               tipo VARCHAR(50) NOT NULL,
                               valor DECIMAL(10,2) NOT NULL CHECK (valor >= 100),
                               cliente_id BIGINT NOT NULL,
                               CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
