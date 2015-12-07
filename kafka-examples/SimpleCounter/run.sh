#!/usr/bin/env bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/
mvn install
java -cp target/uber-SimpleCounter-1.0-SNAPSHOT.jar com.shapira.examples.producer.simplecounter.SimpleCounter localhost:9092 first new sync 500 10
