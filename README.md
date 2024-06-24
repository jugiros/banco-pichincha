# banco-pichincha

La configuración de comunicación asíncrona se validó mediante rabbit para que la misma funcione correctamente e debe validar que rabbit se encuentre operativo y levantado dentro el servidor.

Caso contrario para probar los APIS se puede comentar la línea 30 de ClienteService.

Validación Docker comandos:

docker build -t microservice-1 .
docker build -t microservice-2 .

docker run -d --name microservice1 -p 8080:8080 microservice1
docker run -d --name microservice2 -p 8081:8081 microservice2

docker ps