#mvn exec:java -Dexec.mainClass="be.ac.ulb.infof307.g10.Main"

mvn clean compile assembly:single
java -jar target/groupe10-1.0-SNAPSHOT-jar-with-dependencies.jar