#redis常用数据类型
string,hash,list,set,zset
#redis常用命令
##1、key相关
### （1）列出所有key： keys *
### （2）判断一个key是否存在，返回0为key不存在，返回1为key存在 
#### 用法：exists key  ->  exists name 
### （3）将key从当前库移动到指定库：  
#### 用法：move key db  ->  move name 1
### （4）查看key还有多少秒过期，如果key设置了过期时间，则返回还有多少秒过期，-1为永不过期，即没有设置过期时间，-2为已过期 
#### 用法：ttl key  ->  例子：ttl name
###（5）查看key的类型  
#### 用法：type key->  例子：type name
###（5）给已经存在的key设置过期时间（单位：秒），当key存在时才会设置成功，返回1，key不存在时返回0
#### 用法：expire key time  ->  例子：expire name 10
##2、string相关
###（1）set命令，单值单value
#### 用法：set key value  ->  例子：set name redis
###（2）get命令，获取key对应的值，key存在时返回对应的值，key不存在时返回null
#### 用法：get key  ->  get name
###（3）删除key
#### 用法：del key  ->  del name
#### 适用场景：
#### RedisTemplate对应的api：
###（4）对key的value进行尾部追加(如果key不存，在追加使用的key会被创建，并将追加的值设置给key)
#### 用法：append key value  ->  append name haha
###（5）计算key的长度
#### 用法：strlen key  ->  strlen name
###（6）对key的value进行增加，步长为1(value的类型必须为整形)
#### 用法：incr key  ->  incr age
###（7）对key的value进行减少，步长为1(value的类型必须为整形)
#### 用法：decr key  ->  decr age
###（8）对key的value按指定步长进行增加(value的类型必须为整形，且增加步长必须为整形)
#### 用法：incrby age unit  ->incrby age 10
###（9）对key的value按指定步长进行减少(value的类型必须为整形，且减少步长必须为整形)
#### 用法：decrby age unit  ->  decrby age 10
###（10）获取key指定index范围内的value
#### 用法：getrange ket start end  ->  getrange name 1 2  ->  getrange name 0 -1  == 获取全部
###（11）设置key的value指定下标开始，替换等同长度设置的值
#### 用法：setrange key offset value  ->  setrange name 1 000
###（11）设置key的时候一起设置过期时间（单位：秒）
#### 用法：setex key time value  ->  set name 10 haha 
###（11）设置key（key不存在时才可设置成功）
#### 用法：setnx key value  ->  setnx name
###（11）一次同时设置多个key-value健值对
#### 用法：  ->
###（11）一次同时获取多个key对应的value
#### 用法：  ->
###（11）获取key的value后进行设置(返回key的旧value值，新的value设置给key)
#### 用法：getset key  ->  getset key
###（11）设置范围
#### 用法：  ->
###（11）设置范围
#### 用法：  ->
###（11）设置范围
#### 用法：  ->
###（11）设置范围
#### 用法：  ->

##3、list相关
##4、set相关
##5、hash相关
##6、zset相关

#### 用法：  ->  