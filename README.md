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

### 1.安装gradle
        [http://www.gradle.org/]http://www.gradle.org/

        gradle官方使用说明，非常详细
        [http://www.gradle.org/docs/current/userguide/userguide.html]http://www.gradle.org/docs/current/userguide/userguide.html

### 2.项目导入eclipse
        本地local环境
        $ gradle eclipse

### 3.打jar包

        本地local环境
        $ gradle jar -Denv=local

        alpha环境
        $ gradle jar -Denv=alpha

        生产product环境
        $ gradle jar -Denv=product


> 文字被些字符包围开始
>
> > 只要再文字前面加上>空格即可
>
>  > > 如果你要换行的话,新起一行,输入>空格即可,后面不接文字
>
> > > > 但> 只能放在行首才有效

