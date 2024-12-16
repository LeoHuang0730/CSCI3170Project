SELECT s.sID, s.sName, s.sExperience, COUNT(t.tID) AS transaction_count
FROM salesperson s
         LEFT JOIN transaction t ON s.sID = t.sID
WHERE s.sExperience BETWEEN ? AND ?
GROUP BY s.sID, s.sName, s.sExperience
ORDER BY s.sID