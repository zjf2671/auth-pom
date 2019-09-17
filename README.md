# SpringCloud Oauth2学习项目

## 版本

#### SpringCloud Greenwich.RELEASE + SpringBoot 2.1.4.RELEASE

## 实现

- 采用jwt对称加解密试生成token
- 支持oauth2四种生成token模式

## 启动

- 先把db文件夹里面的数据导入到mysql数据库中

- 先后启动auth-server（认证服务） 和client-server-1（资源服务）两个服务

## 测试（以密码模式测试）

### 1、获取token：


curl -X POST --user client1:123456 http://localhost:8080/auth/oauth/token -H "accept: application/json"  -H “Content-Type: application/x-www-form-urlencoded”  -d “grant_type=password&username=harry1&password=123456&scope=server”


响应案例

```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSB6amYiLCJ1c2VyX2lkIjoxLCJ1c2VyX25hbWUiOiJoYXJyeTEiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTY4NzQ5NjM5LCJkZXB0X2lkIjoxLCJhdXRob3JpdGllcyI6WyJyb2xlX3JvbGUtMSJdLCJqdGkiOiI4NDNkYmI2NC1jY2M3LTQwNjUtOGI4Yi1iMjNmOWI0YmJiNzQiLCJjbGllbnRfaWQiOiJjbGllbnQxIiwidXNlcm5hbWUiOiJoYXJyeTEifQ.N8fS8IvMlPcCHeWXXRnI3gCX13gDo2tMJfVrSul_Lf4",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSB6amYiLCJ1c2VyX2lkIjoxLCJ1c2VyX25hbWUiOiJoYXJyeTEiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiYXRpIjoiODQzZGJiNjQtY2NjNy00MDY1LThiOGItYjIzZjliNGJiYjc0IiwiZXhwIjoxNTcxMjk4NDM5LCJkZXB0X2lkIjoxLCJhdXRob3JpdGllcyI6WyJyb2xlX3JvbGUtMSJdLCJqdGkiOiIwZDgwZWFiNS0zNzc1LTRjZDktOWEwNC01MWQ2ZWU0MGI5NTEiLCJjbGllbnRfaWQiOiJjbGllbnQxIiwidXNlcm5hbWUiOiJoYXJyeTEifQ.u82nfAiIxWIGNTcXTeIjlIybgnFic0dbeQmVE1f_NIY",
    "expires_in": 43199,
    "scope": "server",
    "license": "made by zjf",
    "dept_id": 1,
    "user_id": 1,
    "username": "harry1",
    "jti": "843dbb64-ccc7-4065-8b8b-b23f9b4bbb74"
}
```

### 2、访问资源服务api


curl -X GET http://localhost:8081/client1/api/user  -H “Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJsaWNlbnNlIjoibWFkZSBieSB6amYiLCJ1c2VyX2lkIjoxLCJ1c2VyX25hbWUiOiJoYXJyeTEiLCJzY29wZSI6WyJzZXJ2ZXIiXSwiZXhwIjoxNTY4NzQ5NjM5LCJkZXB0X2lkIjoxLCJhdXRob3JpdGllcyI6WyJyb2xlX3JvbGUtMSJdLCJqdGkiOiI4NDNkYmI2NC1jY2M3LTQwNjUtOGI4Yi1iMjNmOWI0YmJiNzQiLCJjbGllbnRfaWQiOiJjbGllbnQxIiwidXNlcm5hbWUiOiJoYXJyeTEifQ.N8fS8IvMlPcCHeWXXRnI3gCX13gDo2tMJfVrSul_Lf4”


响应案例

```json
{
    "password": "N/A",
    "username": "harry1",
    "authorities": [
        {
            "authority": "role_role-1"
        }
    ],
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true,
    "enabled": true,
    "id": 1,
    "deptId": 1
}
```

