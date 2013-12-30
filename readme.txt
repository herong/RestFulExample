
步骤：

1. 导入以下依赖包：
asm-all-repackaged-2.2.0-b14.jar
cglib-2.2.0-b14.jar
guava-15.0.jar
hk2-api-2.2.0-b14.jar
hk2-locator-2.2.0-b14.jar
hk2-utils-2.2.0-b14.jar
javax.annotation-api-1.2.jar
javax.inject-2.2.0-b14.jar
javax.ws.rs-api-2.0.jar
jersey-client.jar
jersey-common.jar
jersey-container-servlet.jar
jersey-container-servlet-core.jar
jersey-server.jar
validation-api-1.1.0.Final.jar


2. 配置web.xml，增加以下配置

  <servlet>
        <servlet-name>jersey-serlvet</servlet-name>
        <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
        <init-param>
            <!--  指定扫描包 ，多个包用";"隔 -->
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>com.github.herong.rest</param-value>
        </init-param>
         <init-param>
             <!-- 指定是否递归扫描包目录，默认true -->
            <param-name>jersey.config.server.provider.scanning.recursive</param-name>
            <param-value>true</param-value>
        </init-param>
         
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>jersey-serlvet</servlet-name>
       <url-pattern>/rest/*</url-pattern>
    </servlet-mapping>


3.编写资源提供类

@Path("myresource")
public class RestFulProvider {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getName() {
		return "herong";
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("/getName2/{n}")
	public String getName(@PathParam("n") String name) {
		return name;
	}

}

4. 测试访问资源
http://localhost:8080/RestFulTest/rest/myresource
返回:herong
http://localhost:8080/RestFulTest/rest/myresource/getName2/herong2
返回:herong2

参考资源：
	https://jersey.java.net/documentation/latest/jaxrs-resources.html#d0e1291
	
	Best Practices for Designing a Pragmatic RESTful API
	http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api
	