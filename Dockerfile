FROM openjdk:17-slim

WORKDIR /app

VOLUME /app/logs

COPY /target/app.jar /app/app.jar

ENV TZ=Asia/Shanghai

ENV TOKEN=test
ENV CLIENT_ID=test
ENV CLIENT_SECRET=test

ENTRYPOINT java -jar -Dbaidu.api.token=$TOKEN -Dbaidu.api.client_id=$CLIENT_ID -Dbaidu.api.client_secret=$CLIENT_SECRET app.jar
