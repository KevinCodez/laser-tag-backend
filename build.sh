echo This script will install dependencies for the project such as: node version manager, node.js, angular-cli, and maven.
read -p "Would you still like to continue? (Y/N): " userInput

if [[ $userInput == "N" ]] || [[ $userInput == "n" ]];
then
  echo You must download the dependencies manually to run the project.
  exit 1
fi

git submodule update --init --recursive --remote
cd frontend
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.37.2/install.sh | bash
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm
[ -s "$NVM_DIR/bash_completion" ] && . "$NVM_DIR/bash_completion"  # This loads nvm bash_completion
nvm install --lts
npm install
npm install -g @angular/cli
ng build
cd ..
./mvnw clean package -DskipTests