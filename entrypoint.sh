#!/bin/sh

touch env-variables.txt

prefix=SWAGGER_RESOURCE_
env | awk -F= '$1 ~ "^"pfx { print $2 }' pfx="$prefix" > env-variables.txt

echo -e "\nFound the following evironment variables for Swagger UI configuration:"
cat env-variables.txt

touch application.properties
echo "springfox.documentation.swagger.v2.path= /api-docs" > application.properties

let line_number=0
while read -r line; do
    echo "app.swagger.resources[$line_number].name=$(echo $line | cut -d';' -f1)" >> application.properties
    echo "app.swagger.resources[$line_number].location=$(echo $line | cut -d';' -f2)" >> application.properties
    echo "app.swagger.resources[$line_number].version=$(echo $line | cut -d';' -f3)" >> application.properties
    line_number=$((line_number+1))
done < "env-variables.txt"

rm env-variables.txt

echo -e "\nUsing this application.properties file for the application:"
cat application.properties

echo -e "\nStarting the application...\n"
/opt/java/openjdk/bin/java -jar app.jar --spring.config.location=/application.properties