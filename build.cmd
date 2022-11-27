@echo off

echo This script will install dependencies for the project such as: node version manager, node.js, angular-cli, and maven.
set /p userInput="Would you still like to continue? (Y/N): "

set input=false
if %userInput%==n set input=true
if %userInput%==N set input=true
if %input%==true (
    echo You must download the dependencies manually to run the project.
    exit 1
)

git submodule update --init --recursive --remote
cd frontend
winget install OpenJS.NodeJS.LTS
npm install
npm install -g @angular/cli
ng build
cd ..
./mvnw.cmd clean package -DskipTests