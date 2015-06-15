#!/usr/bin/env bash
 
apt-get update
 
apt-get -y --force-yes install \
openjdk-7-jdk \
git \
maven \
htop 

### To install mysql server ###
#apt-get -y --force-yes install mysql-server 

### To install tomcat7 ###
#apt-get -y --force-yes install tomcat7


