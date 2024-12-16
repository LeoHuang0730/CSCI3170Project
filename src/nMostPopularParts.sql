SELECT p.pID,
       p.pName,
       COUNT(t.tID) AS transaction_count
FROM part p
         JOIN transaction t ON p.pID = t.pID
GROUP BY p.pID, p.pName
ORDER BY transaction_count DESC
    FETCH FIRST :limit ROWS ONLY