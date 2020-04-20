Spring

IOC容器

1.@Configration  @Bean

2.@ComponentScan

3.@Conditional

往IOC容器中添加组件的方式

1.@Configration + @Bean

2.@ComponentScan + @Controller + @Service + @Component+Repository

3.@Import  ImportSelector接口和ImportBeanDefinitionRegister接口

4.实现FactoryBean接口来注册，再通过方法1注入

Bean生命周期

创建	初始化	销毁

BeanPostProcessor接口 bean初始化前置后置处理器