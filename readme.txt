
���裺

1. ����������������
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


2. ����web.xml��������������

  <servlet>
        <servlet-name>jersey-serlvet</servlet-name>
        <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
        <init-param>
            <!--  ָ��ɨ��� ���������";"�� -->
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>com.github.herong.rest</param-value>
        </init-param>
         <init-param>
             <!-- ָ���Ƿ�ݹ�ɨ���Ŀ¼��Ĭ��true -->
            <param-name>jersey.config.server.provider.scanning.recursive</param-name>
            <param-value>true</param-value>
        </init-param>
         
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>jersey-serlvet</servlet-name>
       <url-pattern>/rest/*</url-pattern>
    </servlet-mapping>


3.��д��Դ�ṩ��

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

4. ���Է�����Դ
http://localhost:8080/RestFulTest/rest/myresource
����:herong
http://localhost:8080/RestFulTest/rest/myresource/getName2/herong2
����:herong2

�ο���Դ��
	https://jersey.java.net/documentation/latest/jaxrs-resources.html#d0e1291
	
	Best Practices for Designing a Pragmatic RESTful API
	http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api
	