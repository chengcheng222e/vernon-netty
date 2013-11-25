vernon-netty
===============

该项目是一个个人的开源项目, 是利用业余时间写的一个关于服务端通讯的项目.
项目托管在 https://github.com/chengcheng222e 上面

项目介绍:
---------------
        开发环境: Mac 10.9
        开发工具: IntelliJ IDEA 12, 一个很好的 Java 开发工具
        Jar 托管: gradle 1.6 现在最新的是 gradle 1.9
        JDK: 1.7
        数据库: MySQL 数据库

### 1.安装gradle
[http://www.gradle.org/](http://www.gradle.org/)<br/>
gradle官方使用说明，非常详细<br/>
[http://www.gradle.org/docs/current/userguide/userguide.html](http://www.gradle.org/docs/current/userguide/userguide.html)

### 2.项目导入IDEA
        本地local环境
        $ gradle idea -Denv=local, 默认是 local,可以指定是 alpha, product
        在 document 里面导入 sql, 创建好数据库


### 3.打jar包

        本地local环境
        $ gradle jar -Denv=local

        alpha环境
        $ gradle jar -Denv=alpha

        生产product环境
        $ gradle jar -Denv=product


> 联系方式 <br>
> QQ: 1147901965 <br>
> Email: chengcheng222e@sina.com   <br>

