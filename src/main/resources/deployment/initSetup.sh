#!/bin/bash
# begin by installing all of the needed dependencies
# use dnf for Amazon 2023 instead of Yum
sudo dnf install java-17-amazon-corretto -y
sudo dnf install git -y
sudo dnf install maven -y
sudo dnf install telnet -y

#sudo dnf install git java-17-amazon-corretto maven -y
#for one line command

echo "Git version: $(git --version)"
echo "Java version: $(java -version 2>&1 | head -n 1)"
echo "Maven version: $(mvn -version | head -n 1)"

cd /home/ec2-user
cd SocialGaming

git clone git@github.com:jefferyrutherford/SocialGaming.git
chmod +x ./mvnw
./mvnw clean package

echo "Branch Checked Out: $(git branch)"
#swap to dev branch

#setting the profile to test for now and skipping tests, my tests arent aware of what profile to use yet.
./mvnw clean install -Dspring.profiles.active=test -DskipTests

cd .


# Install Node.js (use LTS version)
curl -fsSL https://rpm.nodesource.com/setup_18.x | sudo bash -
sudo yum install -y nodejs

echo "Node Version: $(node -v)"
echo "NPM Version: $(npm -v)"

sudo npm install -g @angular/cli

echo "Angular CLI Version: $(ng version)"

# generate an sshkey and add it to git if not already
# this is needed for the git clone to work properly and authenticate the ec2 user with github
#ssh-keygen -t ed25519 -C "jefferyrutherford@outlook.com"
#tail -f ~/.ssh/id_ed25519.pub