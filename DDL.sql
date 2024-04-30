drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

CREATE TABLE cor_corpo(
 cor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
 cor_nome VARCHAR(100) NOT NULL UNIQUE,
 cor_descricao VARCHAR(200) NOT NULL,
 cor_raio INT,
 cor_distancia_estrela FLOAT NOT NULL
);


INSERT INTO cor_corpo (cor_nome, cor_descricao, cor_raio, cor_distancia_estrela)
VALUES 
('Terra', 'terceiro planeta do Sistema Solar', 6371, 1.0),
('Marte', 'quarto planeta do Sistema Solar', NULL, 1.5);
