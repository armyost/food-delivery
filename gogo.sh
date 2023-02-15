#!/bin/bash
version=21

echo "!!! delete app !!!"
kubectl delete deployment app
kubectl delete deployment gateway
kubectl delete deployment pay
kubectl delete deployment store


echo "!!! mvn packaing !!!"

cd /workspace/food-delivery/app
mvn package -B -DskipTests

cd /workspace/food-delivery/pay
mvn package -B -DskipTests

cd /workspace/food-delivery/store
mvn package -B -DskipTests

cd /workspace/food-delivery/gateway
mvn package -B -DskipTests



echo "!!! docker packaing !!!"

cd /workspace/food-delivery/app
docker build -t armyost/app:v$version .

cd /workspace/food-delivery/pay
docker build -t armyost/pay:v$version .

cd /workspace/food-delivery/store
docker build -t armyost/store:v$version .

cd /workspace/food-delivery/gateway
docker build -t armyost/gateway:v$version .

echo "!!! docker push !!!"

docker push armyost/app:v$version
docker push armyost/pay:v$version
docker push armyost/store:v$version
docker push armyost/gateway:v$version






echo "!!! deploy app !!!"

cd /workspace/food-delivery/app/kubernetes
kubectl apply -f deployment.yml


cd /workspace/food-delivery/pay/kubernetes
kubectl apply -f deployment.yml


cd /workspace/food-delivery/store/kubernetes
kubectl apply -f deployment.yml


cd /workspace/food-delivery/gateway/kubernetes
kubectl apply -f deployment.yaml


kubectl get pods -w
