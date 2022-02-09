FROM openjdk

RUN mkdir /opt/backend_java
COPY target/help-1.0.0-SNAPSHOT-runner.jar /opt/backend_java/ 

RUN useradd -ms /bin/bash backenduser && \
    echo 'backenduser:&jsgcksj3408moas%@@#1' | chpasswd && \
    chown -R backenduser /opt/backend_java 

USER backenduser
WORKDIR /opt/backend_java

CMD java -jar help-1.0.0-SNAPSHOT-runner.jar
