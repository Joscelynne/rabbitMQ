# RabbitMQ Tutorials

Aplicacion de consola con Spring Boot que envia mensajes a una cola RabbitMQ y los recibe mediante un listener.

## Requisitos

- Java 21
- Docker y Docker Compose

## Ejecucion

Desde la raiz del repositorio, inicia RabbitMQ:

```sh
docker compose up -d
```

Inicia la aplicacion en otra terminal:

```sh
./rabbitmq-tutorials/mvnw -f rabbitmq-tutorials/pom.xml spring-boot:run
```

Usa la opcion `1` para enviar un mensaje y `2` para salir. El listener imprime los mensajes recibidos en la consola.

RabbitMQ Management queda disponible en <http://localhost:15672> con las credenciales locales `guest` / `guest`.

Para detener RabbitMQ:

```sh
docker compose down
```

Para borrar tambien los mensajes persistidos localmente, usa `docker compose down --volumes`.

## Configuracion

La aplicacion usa estos valores por defecto para desarrollo local:

| Variable | Valor por defecto |
| --- | --- |
| `RABBITMQ_HOST` | `localhost` |
| `RABBITMQ_PORT` | `5672` |
| `RABBITMQ_USERNAME` | `guest` |
| `RABBITMQ_PASSWORD` | `guest` |
| `RABBITMQ_VIRTUAL_HOST` | `/` |
| `SERVER_PORT` | `8081` |

Define las variables de entorno correspondientes para conectar con otra instancia. Las credenciales incluidas en Docker Compose son solo para desarrollo local; no las reutilices en un despliegue publico.

## Pruebas

Las pruebas de contexto necesitan un broker RabbitMQ disponible en `localhost:5672`. Puedes iniciarlo con `docker compose up -d` y ejecutar:

```sh
./rabbitmq-tutorials/mvnw -f rabbitmq-tutorials/pom.xml --batch-mode verify
```

El workflow de GitHub Actions arranca RabbitMQ automaticamente y ejecuta esta verificacion en cada push y pull request.