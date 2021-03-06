SELECT SUM(PAY.AMOUNT),
	SUM(PAY120.AMOUNT)
FROM PAYMENT PAY
LEFT JOIN RENTAL RENT ON (PAY.RENTAL_ID = RENT.RENTAL_ID)
LEFT JOIN INVENTORY INV ON (RENT.INVENTORY_ID = INV.INVENTORY_ID)
LEFT JOIN FILM FL ON (INV.FILM_ID = FL.FILM_ID)
LEFT JOIN PAYMENT PAY120 ON (PAY120.RENTAL_ID = RENT.RENTAL_ID
							 AND FL.LENGTH >= 120)
WHERE RENT.RENTAL_DATE >= '2005-06-20'
	AND RENT.RENTAL_DATE < '2005-06-21';