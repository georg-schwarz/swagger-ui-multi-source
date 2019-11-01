[![Build Status](https://travis-ci.org/georg-schwarz/swagger-ui-multi-source.svg?branch=master)](https://travis-ci.org/georg-schwarz/swagger-ui-multi-source)
![tag](https://img.shields.io/github/v/tag/georg-schwarz/swagger-ui-multi-source.svg)
![license](https://img.shields.io/github/license/georg-schwarz/swagger-ui-multi-source.svg)

This project provides a docker image for serving a Swagger UI with multiple selectable APIs, like of multiple microservices.

# Usage

Use the image provided on [DockerHub](https://hub.docker.com/r/georgschwarz/swagger-ui-multi-source) and add sources by using environment variables! Environment variables have to be prefixed with `SWAGGER_RESOURCE_`  in order to be added to the configuration. The value of the environment variable has to follow the pattern `{api_name};{swagger_doc_location};{sawagger_version}`.

```yml
version: '3.7'

services:
  swagger-ui:
    image: georgschwarz/swagger-ui-multi-source:0.1.0
    environment:
      - SWAGGER_RESOURCE_1=test1;https://petstore.swagger.io/v2/swagger.json;2.0
      - SWAGGER_RESOURCE_2=test2;https://petstore.swagger.io/v2/swagger.json;2.0
    ports:
      - 8080:8080
```

The configured Swagger UI will be available under `http://localhost:{your_mapped_port}/`


# Documentation

This Docker image performs the following steps in order to serve the multi-source Swagger UI:

* Step 1 (entrypoint.sh): parse environment variables and construct a `application.application` file
* Step 2 (/src): start a Spring Boot application that configures the Swagger UI with the given APIs

# TODOs

* enable auth for Swagger UI


# License

Copyright 2019 Georg-Daniel Schwarz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
