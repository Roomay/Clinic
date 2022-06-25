## The directory is for the back-end build .

## The front-end is developed with Vue and wrapped in the directory "frontend".

### Docker 配置
docker 指定映射端口为3383(避免3306与其他docker实例混淆)
```
$ docker run --restart=always --name clinic -e MYSQL_ROOT_PASSWORD=123456 -p 3383:3306 -d mysql:8.0 
```

### Interfaces to be done
* 注册登录
* 所有doc
* 根据depar选
* 用户名 appoint （1，2）
* consultation
  * 显示医生的可预约时间
    * 以列表形式返回当天LIST<TIME_SLOT>
  * 显示病人的预约记录
  * 进行预约
