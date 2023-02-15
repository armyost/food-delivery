#!/bin/bash


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
docker build -t armyost/app:v230214 .

cd /workspace/food-delivery/pay
docker build -t armyost/pay:v230214 .

cd /workspace/food-delivery/store
docker build -t armyost/store:v230214 .

cd /workspace/food-delivery/gateway
docker build -t armyost/gateway:v230215 .

echo "!!! docker push !!!"

docker push armyost/app:v230214
docker push armyost/pay:v230214
docker push armyost/store:v230214
docker push armyost/gateway:v230215






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
