/**produto*/
CREATE TABLE IF NOT EXISTS prod (
	id INT AUTO_INCREMENT PRIMARY KEY,
	descr VARCHAR(255) NOT NULL,
	qtd INTEGER,
	prc_venda NUMERIC(10,2),
    prc_custo NUMERIC(10,2),
    un VARCHAR(2)
);

INSERT INTO prod VALUES (1, 'Leite', 43, 56.32, 12.65, 'UN');
INSERT INTO prod VALUES (2, 'Café', 63, 7.63, 3.65, 'UN');
INSERT INTO prod VALUES (3, 'Feijão', 23, 13.32, 2.99, 'UN');
INSERT INTO prod VALUES (4, 'Biscoito', 66, 6.32, 2.23, 'PC');
INSERT INTO prod VALUES (5, 'Livro', 23, 12,33, 1,21, 'UN');
INSERT INTO prod VALUES (6, 'Notebook', 96, 6986.32, 3222.32, 'UN');

/**endereco**/
CREATE TABLE IF NOT EXISTS ende (
    id INT AUTO_INCREMENT PRIMARY KEY,
    logr VARCHAR(100),
    num VARCHAR(10),
    bairro VARCHAR(100),
    cep VARCHAR(8),
    uf VARCHAR(2)
);
INSERT INTO ende VALUES (1, 'Passagem teste1', '14000', 'telégrafo', '66113666', 'PA');
INSERT INTO ende VALUES (2, 'Av. são joão', '32', 'barreiro','54586336', 'PA');
INSERT INTO ende VALUES (3, 'Av. AAAAAAA', '14000', 'jurunas', '66113666', 'PA');
INSERT INTO ende VALUES (4, 'Passagem KKKKKKKKKKKKK', '14000', 'aaaaaa', '66113666', 'PA');
INSERT INTO ende VALUES (5, 'Passagem OOOOOOOOOO', '14000', '0bbbbbbbbbbbbbb', '66113666', 'PA');
/**pessoa*/
CREATE TABLE IF NOT EXISTS pess (
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_ende INT NOT NULL,
	nome VARCHAR(255),
	cpf_cnpj VARCHAR(15),
	email VARCHAR(100),
	contato VARCHAR(100),
    CONSTRAINT fk_pess_ende FOREIGN KEY (id_ende) REFERENCES pos.ende(id)
);

INSERT INTO pess VALUES (1, 1, 'Nome teste 1', '00022200063', 'aaaa', 'bbbb');
INSERT INTO pess VALUES (2, 2, 'Nome teste 2', '00022200063', 'aaaa', 'bbbb');
INSERT INTO pess VALUES (3, 3, 'Nome teste 3', '00022200063', 'aaaa', 'bbbb');
INSERT INTO pess VALUES (4, 4, 'Nome teste 3', '00022200063', 'aaaa', 'bbbb');
INSERT INTO pess VALUES (5, 5, 'Nome teste 4', '00022200063', 'aaaa', 'bbbb');
