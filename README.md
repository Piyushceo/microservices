
#### nothing@nothing-desktop:~$ docker pull nginx:1.17.5  
Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Post http://%2Fvar%2Frun%2Fdocker.sock/v1.24/images/create?fromImage=nginx&tag=1.17.5: dial unix /var/run/docker.sock: connect: permission denied
nothing@nothing-desktop:~$ sudo docker pull nginx:1.17.5
[sudo] password for nothing: 
^C
#### nothing@nothing-desktop:~$ mkdir docker-learn  
#### nothing@nothing-desktop:~$ cd docker-learn && mkdir html  
#### nothing@nothing-desktop:~/docker-learn$ ls
html  
#### nothing@nothing-desktop:~/docker-learn$ sudo docker pull nginx:1.17.5  
        
1.17.5: Pulling from library/nginx  
8d691f585fa8: Pull complete  
5b07f4e08ad0: Pull complete  
abc291867bca: Pull complete   
Digest: sha256:922c815aa4df050d4df476e92daed4231f466acc8ee90e0e774951b0fd7195a4  
Status: Downloaded newer image for nginx:1.17.5  
docker.io/library/nginx:1.17.5  
#### nothing@nothing-desktop:~/docker-learn$ docker image ls
Got permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get http://%2Fvar%2Frun%2Fdocker.sock/v1.24/images/json: dial unix /var/run/docker.sock: connect: permission denied
nothing@nothing-desktop:~/docker-learn$ sudo docker image ls
REPOSITORY   TAG       IMAGE ID       CREATED         SIZE
nginx        1.17.5    540a289bab6c   17 months ago   126MB
#### nothing@nothing-desktop:~/docker-learn$ sudo su  
#### root@nothing-desktop:/home/nothing/docker-learn# docker run --name my-nginx -d -p 8085:80 /home/nothing/docker-learn/html:/usr/share/nginx/html nginx:1.17.5
docker: invalid reference format.  
See 'docker run --help'.  
#### root@nothing-desktop:/home/nothing/docker-learn# docker run --name my-nginx -d -p 8085:80 \home\nothing\docker-learn\html:/usr/share/nginx/html nginx:1.17.5
docker: invalid reference format.  
See 'docker run --help'.  
#### root@nothing-desktop:/home/nothing/docker-learn# docker run --name my-nginx -d -p 8085:80 -v /home/nothing/docker-learn/html:/usr/share/nginx/html nginx:1.17.5  
4a51cc13bc35bbcc99168e6c14bc97d9b9b4e2b2db7cd4e0e981a9a33b1d65b0  
root@nothing-desktop:/home/nothing/docker-learn# docker container js  

Usage:  docker container COMMAND  

Manage containers    

Commands:
  attach      Attach local standard input, output, and error streams to a running container  
  commit      Create a new image from a container's changes  
  cp          Copy files/folders between a container and the local filesystem 
  create      Create a new container  
  diff        Inspect changes to files or directories on a container's filesystem  
  exec        Run a command in a running container  
  export      Export a container's filesystem as a tar archive  
  inspect     Display detailed information on one or more containers  
  kill        Kill one or more running containers  
  logs        Fetch the logs of a container  
  ls          List containers  
  pause       Pause all processes within one or more containers  
  port        List port mappings or a specific mapping for the container  
  prune       Remove all stopped containers  
  rename      Rename a container  
  restart     Restart one or more containers  
  rm          Remove one or more containers  
  run         Run a command in a new container  
  start       Start one or more stopped containers  
  stats       Display a live stream of container(s) resource usage statistics  
  stop        Stop one or more running containers  
  top         Display the running processes of a container  
  unpause     Unpause all processes within one or more containers  
  update      Update configuration of one or more containers  
  wait        Block until one or more containers stop, then print their exit codes  

Run 'docker container COMMAND --help' for more information on a command.
#### root@nothing-desktop:/home/nothing/docker-learn# docker stop my-nginx
my-nginx
#### root@nothing-desktop:/home/nothing/docker-learn# docker container ls
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
#### root@nothing-desktop:/home/nothing/docker-learn# docker container ls -a
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS                      PORTS     NAMES  
4a51cc13bc35   nginx:1.17.5   "nginx -g 'daemon of…"   2 minutes ago   Exited (0) 39 seconds ago             my-nginx  
#### root@nothing-desktop:/home/nothing/docker-learn# docker start my-nginx
my-nginx
#### root@nothing-desktop:/home/nothing/docker-learn# docker container ls
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS          PORTS                  NAMES
4a51cc13bc35   nginx:1.17.5   "nginx -g 'daemon of…"   3 minutes ago   Up 57 seconds   0.0.0.0:8085->80/tcp   my-nginx
#### root@nothing-desktop:/home/nothing/docker-learn# docker start my-nginx
my-nginx
#### root@nothing-desktop:/home/nothing/docker-learn# docker container ls
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS                  NAMES
4a51cc13bc35   nginx:1.17.5   "nginx -g 'daemon of…"   4 minutes ago   Up 2 minutes   0.0.0.0:8085->80/tcp   my-nginx
#### root@nothing-desktop:/home/nothing/docker-learn# FROM nginx:1.17.5
FROM: command not found  
#### root@nothing-desktop:/home/nothing/docker-learn# nano Dockerfile
#### root@nothing-desktop:/home/nothing/docker-learn# docker build .
Sending build context to Docker daemon   2.56kB  
Step 1/2 : FROM nginx:1.17.5  
 ---> 540a289bab6c  
Step 2/2 : COPY home.html /usr/share/nginx/html  
COPY failed: file not found in build context or excluded by .dockerignore: stat home.html: file does not exist
#### root@nothing-desktop:/home/nothing/docker-learn# nano Dockerfile 
#### root@nothing-desktop:/home/nothing/docker-learn# docker build .
Sending build context to Docker daemon   2.56kB  
Step 1/2 : FROM nginx:1.17.5  
 ---> 540a289bab6c  
Step 2/2 : COPY index.html /usr/share/nginx/html  
COPY failed: file not found in build context or excluded by .dockerignore: stat index.html: file does not exist  
#### root@nothing-desktop:/home/nothing/docker-learn# nano Dockerfile   
#### root@nothing-desktop:/home/nothing/docker-learn# docker build .  
Sending build context to Docker daemon   2.56kB  
Step 1/2 : FROM nginx:1.17.5  
 ---> 540a289bab6c  
Step 2/2 : COPY home.html /usr/share/nginx/html  
COPY failed: file not found in build context or excluded by .dockerignore: stat home.html: file does not exist
#### root@nothing-desktop:/home/nothing/docker-learn# docker build .
Sending build context to Docker daemon  3.584kB  
Step 1/2 : FROM nginx:1.17.5  
 ---> 540a289bab6c  
Step 2/2 : COPY home.html /usr/share/nginx/html  
 ---> e6cad9190e1a  
Successfully built e6cad9190e1a  
#### root@nothing-desktop:/home/nothing/docker-learn# 
