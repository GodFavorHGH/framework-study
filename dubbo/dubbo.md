##springboot与dubbo整合的三种方式
###1、导入dubbo-spring-boot-starter，在application.yml中进行属性的配置，使用@Service暴露接口，使用@Reference调用服务，使用@EnableDubbo标注应用程序类开启dubbo注解
###2、保留dubbo xml配置文件  导入dubbo-spring-boot-starter，在应用程序主类使用@ImportResource(locations="classpath:xxx.xml")
###3、使用注解API的方式  将每一个注解手动创建到容器中  使用@Configuration
##高可用
###1、zookeeper旦机与dubbo直连（绕过注册中心）
zookeeper注册中心旦机，还可以消费dubbo暴露的服务，因为有本地缓存，但不能注册新服务
监控中心旦掉不影响使用，知识丢失部分采样数据
注册中心对等集群，任意一台旦掉后，将自动切换到另一台
注册中心全部旦掉后，服务提供者何服务消费者仍能通过本地缓存通讯
服务提供者无状态，任意一台旦掉，不影响使用
服务提供者全部旦掉后，服务消费者应用将无法使用，并无限次冲脸等待服务提供者恢复
高可用，通过设计，减少不能提供服务的时间

##dubbo负载均衡
###1、Random 随机权重
###2、RoundRobbin 轮询
###3、LeastActive 最少活跃数
###4、ConsistenceHash 一致性哈希
