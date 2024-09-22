 docker build -t my-first-img:1.0 .  #Sirve para crear imágenesdocker
 docker run -p 8088:80 --name my-first-container -d my-first-img:1.0  #Sirve para crear contenedores

 docker run -p 5432:5432 --name my-first-postgres -e POSTGRES_DB=test -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=secret -v ./sql:/var/lib/postgresql/data -d postgres:16.1

 