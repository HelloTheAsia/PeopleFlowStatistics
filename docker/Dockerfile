FROM bellsoft/liberica-openjdk-alpine:17

WORKDIR /app

VOLUME /app/logs

COPY target/app.jar /app/app.jar

ENV TOKEN=24.65652cb72f685cfe5ba9078193a6d657.2592000.1706359221.282335-459314

ENTRYPOINT java -jar -Dbaidu.api.token=$TOKEN app.jar
