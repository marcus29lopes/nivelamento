CREATE TABLE demonstrativos_contabeis (
    id INT AUTO_INCREMENT PRIMARY KEY,
    operadora_id INT,
    ano INT,
    trimestre INT,
    categoria VARCHAR(255),
    valor DECIMAL(15, 2),
    data_importacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE operadoras_ativas (
    operadora_id INT PRIMARY KEY,
    nome_operadora VARCHAR(255),
    cnpj VARCHAR(18),
    situacao VARCHAR(50),
    data_inicio_atividade DATE,
    uf CHAR(2),
    municipio VARCHAR(255)
);
