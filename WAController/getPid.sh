#!/bin/bash

port=$1
echo `lsof -i:${port} | grep java | awk -F" " '{print $2}'` 
