# Microservice Probe

[![Build](https://img.shields.io/badge/build-passing-brightgreen.svg?style=flat)]()
[![Coverage](https://img.shields.io/badge/coverage-96%20%25-brightgreen.svg?style=flat)]()

## Using it

### Docker
```dockerfile
FROM juliobulgarellitw/microservice-probe:1.0.0-SNAPSHOT

EXPOSE 8080

ENV DATABASE_HOST=localhost
ENV DATABASE_PORT=5432
ENV DATABASE_NAME=postgres
ENV DATABASE_SCHEMA=ms-probe
ENV DATABASE_USER=postgres
ENV DATABASE_PASS=postgres

...
```

### Docker Compose
```yaml
services:
  ...
  ms-probe:
    image: juliobulgarellitw/microservice-probe:1.0.0-SNAPSHOT
    ports:
      - "8080:8080"
    environment:
      - DATABASE_HOST=localhost
      - DATABASE_PORT=5432
      - DATABASE_NAME=postgres
      - DATABASE_SCHEMA=ms-probe
      - DATABASE_USER=postgres
      - DATABASE_PASS=postgres
  ...
```

## Building it
```shell
# Build applying quality assurance validations
./gradlew clean build;

# Build and publish the image
./gradlew clean jib;
```

## Testing it
[OpenAPI (Swagger) UI](http://localhost:8080/swagger-ui.html)

```shell
# /api-docs resource should return the official API spec (serialized in JSON)
curl -k http://localhost:8080/api-docs;
# > {"openapi": "3.0.1", "info": {"title": "OpenAPI definition", "version": "v0"}, ...

# /moods resource should return all moods
curl -k http://localhost:8080/moods;
# > [{"scale": "PASSIVE","comment": null},{"scale ...

# /moods/mean resource resource should return the mean mood
curl -k http://localhost:8080/moods/mean;
# > PASSIVE

# /moods resource should accept and process a new mood
curl -k -X POST -H 'Content-Type: application/json' -d '{"scale": "PASSIVE","comment": "another day, same old, same old"}' http://localhost:8080/moods;
# > {"scale": "PASSIVE","comment": "another day, same old, same old"}

# any exceptions are mapped as a consistent structure, without exposing infrastructure detail
# > {"message": "detail of the error","timestamp": "2024-08-19T17:01:25.772Z"}
```
