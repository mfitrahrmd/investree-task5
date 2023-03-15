db-start:
	docker run -dt --rm --name pg -p 5433:5432 --env-file .env postgres:alpine