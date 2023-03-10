docker rmi naveejr/microbank-cards:latest
docker rmi naveejr/microbank-loans:latest
docker rmi naveejr/microbank-accounts:latest
docker rmi naveejr/microbank-configserver:latest

mvn spring-boot:build-image

docker push naveejr/microbank-cards:latest
docker push naveejr/microbank-loans:latest
docker push naveejr/microbank-accounts:latest
docker push naveejr/microbank-configserver:latest
