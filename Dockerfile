FROM springcloudenv:v1

MAINTAINER by wangtw

RUN mkdir -p /home/wangtw/springcloudtest && \
 cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
 echo 'Asia/Shanghai' >/etc/timezone
 
ENV LANG="C.UTF-8"

WORKDIR /home/wangtw/springcloudtest

COPY target/springboottest-0.0.1-SNAPSHOT.jar ./springboottest.jar

CMD java -jar springboottest.jar

