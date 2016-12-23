#!/bin/sh

port=$1
jarName=/Users/NI362849/Documents/workspace/WAController/$2
appname=$3
nohup java -Dserver.port=$port -jar $jarName > /Users/NI362849/Documents/workspace/WAController/$appname.out &
