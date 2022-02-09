# spring-config-ant
可以配合任何分布式订阅中心的client端，对spring做深度融合
## 简单说
把远程数据赋给Spring的@Value的字段下

## 实现核心


- 启动时初始化配置：配置内容为spring PropertySource级别，支持XML、@Value注解、YML文件的占位写入
- 支持服务端“推”配置：客户端长轮讯服务端，得到返回即做本地赋值
- 配置自动更新：记录配置键与spring bean字段关系（弱引用），配置改动则反射对bean赋值
- 多层缓存：配置文件数据持久化