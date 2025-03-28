SELECT operadora_id, SUM(valor) AS total_despesas
FROM demonstrativos_contabeis
WHERE categoria = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
AND trimestre = (SELECT MAX(trimestre) FROM demonstrativos_contabeis WHERE ano = YEAR(CURRENT_DATE))
AND ano = YEAR(CURRENT_DATE)
GROUP BY operadora_id
ORDER BY total_despesas DESC
LIMIT 10;


SELECT operadora_id, SUM(valor) AS total_despesas
FROM demonstrativos_contabeis
WHERE categoria = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
AND ano = YEAR(CURRENT_DATE) - 1
GROUP BY operadora_id
ORDER BY total_despesas DESC
LIMIT 10;
