# Eliminar todos los contenedores de docker
docker rm $(docker ps -a -q)
# Eliminar todas las imágenes de docker
docker rmi $(docker images -q)