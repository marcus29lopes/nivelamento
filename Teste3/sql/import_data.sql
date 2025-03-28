LOAD DATA INFILE 'C:\Users\Usuario\Desktop\nivelamento\Teste3\downloads\1T2024.csv'
INTO TABLE demonstrativos_contabeis
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(operadora_id, ano, trimestre, categoria, valor);

LOAD DATA INFILE 'C:\Users\Usuario\Desktop\nivelamento\Teste3\downloads\relatorio_cadop.csv'
INTO TABLE operadoras_ativas
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(operadora_id, nome_operadora, cnpj, situacao, data_inicio_atividade, uf, municipio);
