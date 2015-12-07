#!/usr/bin/env bash
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/
mvn install
java -cp target/uber-SimpleMovingAvg-1.0-SNAPSHOT.jar com.shapira.examples.newconsumer.simplemovingavg.SimpleMovingAvgNewConsumer localhost:9092 mygroup1 first 10
