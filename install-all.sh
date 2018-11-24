#!/bin/sh

#stop any running services
sudo service apache2 stop
sudo service jenkins stop
sudo service nginx stop

#Java
sudo add-apt-repository ppa:webupd8team/java
sudo apt update
sudo apt install oracle-java8-installer -y

#Git and Maven
sudo apt update
sudo apt install git-all -y
sudo apt-get install maven
git config --global user.name "Triple Baconator"
git config --global user.email triple@baconator.on.ca
sudo apt-get install tree
sudo apt-get install git-flow

#Jenkins
wget -q -O - https://pkg.jenkins.io/debian/jenkins-ci.org.key | sudo apt-key add -
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
sudo apt-get update
sudo apt-get install jenkins -y

#Artifactory

wget https://bintray.com/jfrog/artifactory/download_file?file_path=jfrog-artifactory-oss-6.5.2.zip
# unzip jfrog-artifactory-oss-6.5.2.zip
unzip download_file?file_path=jfrog-artifactory-oss-6.5.2.zip
cd art*
cd bin*
sudo ./installService.sh
# sudo service artifactory start

#Docker
sudo apt-get update
sudo apt-get -y install docker.io
sudo ln -sf /usr/bin/docker.io /usr/local/bin/docker
sed -i '$acomplete -F _docker docker' /etc/bash_completion.d/docker.io
sudo update-rc.d docker.io defaults



