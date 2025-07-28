#!/bin/bash
# begin by installing all of the needed dependencies
# use dnf for Amazon 2023 instead of Yum
sudo dnf install java-17-amazon-corretto -y
sudo dnf install git -y
sudo dnf install maven -y

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

echo "Branch Checked Out: " "$(git branch)"



# generate an sskey and add it to git up if not already
# this is needed for the git clone to work properly
#ssh-keygen -t ed25519 -C "jefferyrutherford@outlook.com"
#tail -f ~/.ssh/id_ed25519.pub