@echo off

echo This script will install dependencies for the project such as: node package manager, node.js, angular-cli, and maven.
set /p userInput="Would you still like to continue? (Y/N): "

set input=false
if %userInput%==n set input=true
if %userInput%==N set input=true
if %input%==true (
    echo You must download the dependencies manually to run the project.
    exit 1
)

call git submodule update --init --recursive --remote
cd frontend
call winget install OpenJS.NodeJS.LTS
call npm install
call npm install -g @angular/cli
call ng build
cd ..
call mvnw.cmd clean package -DskipTests