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
sudo docker pull ubuntu
sudo docker run -i -t ubuntu /bin/bash
sudo docker search debian


# Newtork Tools
sudo apt update
sudo apt install net-tools
sudo apt install gparted

#NoSQL

sudo apt-get update
sudo apt-get install mysql-server
sudo ufw allow mysql
systemctl start mysql
systemctl enable mysql
sudo -i
# Unknown column 'Password' in 'field list'
# UPDATE mysql.user SET Password = PASSWORD('password') WHERE User = 'root';
/usr/bin/mysql -u root -p

UPDATE mysql.user SET authentication_string = PASSWORD('password') WHERE User = 'root';
FLUSH PRIVILEGES;
SELECT User, Host, authentication_string FROM mysql.user;


CREATE DATABASE wpdb;

INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject) VALUES ('wpadmin','localhost',PASSWORD('password'),'','','');
INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject) VALUES ('cuttlefish','localhost',PASSWORD('password'),'','','');

INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject) VALUES ('cuttle','localhost',PASSWORD('password'),'','','');


INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject)
VALUES('wpuser','localhost',PASSWORD('password'),'','','');
CREATE USER 'cuttlefish'@'localhost' IDENTIFIED BY 'password';
# connect wpdb
INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject) VALUES ('wpadmin','localhost',PASSWORD('password'),'','','')
CREATE USER 'wpuser'@'localhost' IDENTIFIED BY 'password';

FLUSH PRIVILEGES;


GRANT ALL PRIVILEGES ON wpdb.* to wpadmin@localhost;
GRANT ALL PRIVILEGES ON wpdb.* to wpuser@localhost;
GRANT ALL PRIVILEGES ON wpdb.* to cuttlefish@localhost;
GRANT ALL PRIVILEGES ON wpdb.* to cuttle@localhost;

SHOW GRANTS FOR 'wpadmin'@'localhost';
SELECT User, Host, authentication_string FROM mysql.user;

# MySQL Workbench
sudo apt install mysql-workbench
sudo nano /etc/mysql/my.cnf
bind-address = 0.0.0.0
# Wordpress



sudo docker run --name wordpress -p 80:80 wordpress
http://localhost/wp-admin/setup-config.php


