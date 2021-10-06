SELECT FL.title, *	
	FROM public.film FL
	left join public.inventory INV on (FL.film_id = INV.film_id)
	left join public.rental RENT on (RENT.inventory_id = INV.inventory_id)
	where RENT.rental_date >= '2005-05-24' and RENT.rental_date < '2005-05-25';