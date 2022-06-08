# springboot_filter_demo

## springboot+loginFilter+redis的demo,用来实现用户登陆状态的过滤，防止越权操作
### 使用
>http://localhost:8080/api/login?username=chen&password=1234
登录,登陆界面懒得写

**两个表的SQL语句如下**

```
create table chen
(
    id   int unsigned auto_increment
        primary key,
    name varchar(100) not null,
    sex  varchar(40)  not null
)
    charset = utf8;
```
```
create table mumbers
(
    id       int auto_increment
        primary key,
    username varchar(50) not null,
    password varchar(50) not null,
    constraint mumbers_username_uindex
        unique (username)
);
```
