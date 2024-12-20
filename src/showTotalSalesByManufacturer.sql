SELECT m.mID,
       m.mName,
       SUM(p.pPrice * sub.transaction_count) AS total_sales_value
FROM manufacturer m
         JOIN part p ON m.mID = p.mID
         JOIN (SELECT t.pID, COUNT(t.tID) AS transaction_count
               FROM transaction t
               GROUP BY t.pID) sub ON p.pID = sub.pID
GROUP BY m.mID, m.mName
ORDER BY total_sales_value DESC