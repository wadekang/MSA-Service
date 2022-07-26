#!/bin/sh

name="hsuk6032"
app="consume-service"
namespace="hskang"


echo "build docker image..."
docker build --tag ${app}:0.1 ./

echo "docker push"
docker tag ${app}:0.1 ${name}/${app}:latest
docker push ${name}/${app}:latest

echo "kubernetes deployment ... "
sudo kubectl delete -f deployment.yml -n ${namespace}
sudo kubectl apply -f deployment.yml -n ${namespace} 