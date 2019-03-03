apt-get install libxtst6 libgtk2.0-0 libxft2Copy

apt-get install libxtst6 libgtk2.0-0 libc6:i386 libgcc1:i386 libgtk2.0-0:i386  libswt-glx-gtk-3-jni:i386 libstdc++6:i386 libxft2 libxft2:i386Copy

apt-get install libxtst6 libgtk2.0-0 libxft2Copy

apt-get install libc6:i386 libgcc1:i386Copy

apt-get install libgtk2.0-0:i386 libswt-glx-gtk-3-jni:i386

apt-get install libstdc++6:i386

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
