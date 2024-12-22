UPDATE part
SET pAvailableQuantity = pAvailableQuantity - 1
WHERE pID = :partID
  AND pAvailableQuantity > 0