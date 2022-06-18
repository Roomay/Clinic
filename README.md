## The directory is for the back-end build .

## The front-end is developed with Vue and wrapped in the directory "frontend".

### Docker 配置
docker 指定映射端口为3383(避免3306与其他docker实例混淆)
```
$ docker run --restart=always --name clinic -e MYSQL_ROOT_PASSWORD=123456 -p 3383:3306 -d mysql:8.0 
```