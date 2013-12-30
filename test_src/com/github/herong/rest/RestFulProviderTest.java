package com.github.herong.rest;

import static org.junit.Assert.assertEquals;

import java.net.InetSocketAddress;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class RestFulProviderTest {

	
	  private HttpServer server;
	    private WebTarget target;
	 
	    @Before
	    public void setUp() throws Exception {
	    	
	        server = HttpServer.create(new InetSocketAddress(getBaseURI().getPort()), 0);
	       
	     // create a handler wrapping the JAX-RS application
	        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new JaxRsApplication(), HttpHandler.class);

	        // map JAX-RS handler to the server root
	        server.createContext(getBaseURI().getPath(), handler);
	        server.start();
	        Client c = ClientBuilder.newClient();
	        target =c.target("http://localhost:8080/RestFulTest/");
	       
	       
	    }
	 
	    @After
	    public void tearDown() throws Exception {
	        server.stop(0);
	    }
	 
	    /**
	     * Test to see that the message "Got it!" is sent in the response.
	     */
	    @Test
	    public void testGetName() {
	        String responseMsg = target.path("myresource").request().get(String.class);
	        assertEquals("herong", responseMsg);
	    }
	    
	    private static int getPort(int defaultPort) {
	        final String port = System.getProperty("jersey.config.test.container.port");
	        if (null != port) {
	            try {
	                return Integer.parseInt(port);
	            } catch (NumberFormatException e) {
	                System.out.println("Value of jersey.config.test.container.port property" +
	                        " is not a valid positive integer [" + port + "]." +
	                        " Reverting to default [" + defaultPort + "].");
	            }
	        }
	        return defaultPort;
	    }

	    /**
	     * Gets base {@link URI}.
	     *
	     * @return base {@link URI}.
	     */
	    public static URI getBaseURI() {
	        return UriBuilder.fromUri("http://localhost/").port(getPort(8080)).build();
	    }
}
