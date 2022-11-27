#!/bin/zsh

git submodule update --init --recursive --remote
cd frontend
ng build
cd ..
mvnw clean package -DskipTests
