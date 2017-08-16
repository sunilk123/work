nohup java -Dspring.data.mongodb.database=odp-dev  \
    -Dspring.data.mongodb.host=localhost \
    -Dspring.data.mongodb.port=27017 \
    -Dspring.data.mongodb.username=odp \
    -Dspring.data.mongodb.password=odp \
    -jar target/odp-api-app-1.0-SNAPSHOT.jar &