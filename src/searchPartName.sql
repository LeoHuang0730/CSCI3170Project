SELECT p.pID                AS ID,
       p.pName              AS Name,
       m.mName              AS Manufacturer,
       c.cName              AS Category,
       p.pAvailableQuantity AS Quantity,
       p.pWarrantyPeriod    AS Warranty,
       p.pPrice             AS Price
FROM part p
         JOIN
     manufacturer m ON p.mID = m.mID
         JOIN
     category c ON p.cID = c.cID
WHERE LOWER(p.pName) LIKE LOWER(?)
