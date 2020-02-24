# Servlet

- Servlet三大组件：Servlet,Listener,Filter

web启动流程：tomcat启动 ----》加载web应用 ----》 读web.xml的<context-param/>和 <listener/>标签 ----》 创建ServletContext对象  ----》创建

Listener、Filter、Servlet执行顺序

![Listener、Filter、Servlet执行顺序](G:\Ameno\Project\java\github\Base\Note\temp\web\servlet\pic\Listener、Filter、Servlet执行顺序.png)

## 一.Servlet

## 二.Listener  (六个三对监听器)

- 被监听的事件源：**ServletContext 、ServletRequest、HttpSession**

### 1.ServletContext

- **创建和销毁     ServletContextListener**

  *创建： 加载当前的web项目的时候*

  *销毁： 关闭服务器或者重新部署web项目*

  -  **属性增加，修改，删除**	**ServletContextAttirbuteListener**

  *增加:  setAttribute("name",Object)*

  *修改： setAttribute("name",Object)  //把同名的属性进行修改*

  *删除：removeAttribute("name")*

### 2.ServletRequest

**创建和销毁**	**ServletRequestListener**

*创建：用户每次发出请求的时候都会创建一个请求对象*

*销毁：完成整个请求之后请求对象销毁*

- **属性增加，修改，删除**	**ServletRequestAttributeListener**

  *增加： setAttribute("name",Object);*

  *修改： setAttribute("name",Object)  //把同名的属性进行修改*​                        

  *删除：removeAttribute("name")*

### 3.HttpSession

- **创建和销毁**	**HttpSessionListener**

  *创建：调用requset.getSession(true)方法*

  *销毁：*

  *​         1）默认情况下，等待30分钟，服务器自动回收session对象*

  *​         2）session.setMaxInactiveInterval（秒数) 设置服务器回收session的时间*

  ```xml
  <!-- 全局设置 -->
  <session-config>
  	<session-timeout>分钟数</session-timeout>
  <session-config>
  ```

  *​         3）session.invalidate() : 手动销毁session对象*

  - **属性增加，修改，删除**	**HttpSessionAttribtuteListener**

  ​	案例：统计当前网站的登录用户信息

  ​                            1）用户可以登录本网站，用户也退出本网站

  ​                            2）用户登录成功网站后，可以查询当前网站在线的登录用户信息。

  ​                            3）管理员可以踢出某个已经登录的用户。

## 三.Filter

### 1.生命周期：

构造方法： 创建过滤器对象的时候调用。在加载当前项目的时候加载过滤器，只调用1次。单                                                                    实例的多线程。

 init方法： 在创建完过滤器对象之后调用。只调用1次。

doFilter方法： 过滤任务方法。会调用n次。每次访问目标资源的时候，doFilter就会被调用。

destory方法：在销毁过滤器对象的时候调用。在web项目重新部署或tomcat服务器停止的时候销毁过滤器对象。

### 2.web.xml配置

```xml
<!-- 过滤器配置 -->  
  <filter> 
    <!-- 内部名称 -->  
    <filter-name>FirstFilter</filter-name>  
    <filter-class>gz.itcast.a_filter.FirstFilter</filter-class>  
    <!-- FilteConfig配置 -->  
    <init-param> 
      <param-name>AAA</param-name>  
      <param-value>AAA'value</param-value> 
    </init-param>  
    <init-param> 
      <param-name>BBB</param-name>  
      <param-value>BBB'value</param-value> 
    </init-param> 
  </filter>  
  <!-- 过滤器映射配置 -->  
  <filter-mapping> 
    <!-- 也是内部名称，但是和上面的名称保持一致！！！ -->  
    <filter-name>FirstFilter</filter-name>  
    <!--过滤器的url-pattern代表的是过滤的路径,而不是访问过滤器的路径  -->  
    <url-pattern>/target</url-pattern> 
  </filter-mapping>  
  <!-- 过滤类型：声明哪种请求才可以被拦截（过滤） -->  
  <dispatcher>REQUEST</dispatcher>
  <!-- 默认：来自于直接访问的请求才可以被拦截 -->  
  <dispatcher>FORWARD</dispatcher>
  <!-- 来自于转发的请求才可以被拦截 -->  
  <dispatcher>INCLUDE</dispatcher>
  <!-- 来自于包含的请求才可以被拦截 -->  
  <dispatcher>ERROR</dispatcher>
  <!-- 来自于错误的请求才可以被拦截 --> 
```

### 3.FilteConfig

​	

### 4.FilterChain

​	doFilter(ServletRequest request, ServletResponse response, FilterChain chain)

### 5.应用案例

- GET、POST中文乱码
- 网页压缩
- 登录、权限校验
