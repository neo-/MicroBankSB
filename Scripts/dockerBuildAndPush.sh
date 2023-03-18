docker rmi naveejr/microbank-accounts:latest
docker rmi naveejr/microbank-cards:latest
docker rmi naveejr/microbank-configserver:latest
docker rmi naveejr/microbank-eurekaserver:latest
docker rmi naveejr/microbank-gatewayserver:latest
docker rmi naveejr/microbank-loans:latest

mvn spring-boot:build-image -DskipTests

docker push naveejr/microbank-accounts:latest
docker push naveejr/microbank-cards:latest
docker push naveejr/microbank-configserver:latest
docker push naveejr/microbank-eurekaserver:latest
docker push naveejr/microbank-gatewayserver:latest
docker push naveejr/microbank-loans:latest
