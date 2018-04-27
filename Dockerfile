FROM springcloudenv:v1

MAINTAINER by wangtw

RUN mkdir -p /home/wangtw/springcloudtest

WORKDIR /home/wangtw/springcloudtest

COPY target/springboottest-0.0.1-SNAPSHOT.jar ./springboottest.jar

CMD java jar ./springboottest.jar > /dev/null 2>&1 &

