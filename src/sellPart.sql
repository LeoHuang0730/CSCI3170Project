UPDATE part
SET pAvailableQuantity = pAvailableQuantity - 1
WHERE pID = ?
  AND pAvailableQuantity > 0