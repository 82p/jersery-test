package jp.hani.jersey.api;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.moxy.internal.MoxyFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.grizzly.GrizzlyTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnimalApiTest extends JerseyTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		ResourceConfig config = new ResourceConfig(AnimalApi.class);//target of test
//		config.register(JacksonFeature.class);// NOT USE Jackson
		config.register(MoxyFilteringFeature.class);
		return config;
	}

	@Override
	protected TestContainerFactory getTestContainerFactory() {
		return new GrizzlyTestContainerFactory();
	}

	@Test
	public void testGet() {
		WebTarget target = target("animal");
		String actual = target.request().get(String.class);
		String expected = "[{\"name\":\"Puppy\",\"breed\":\"GOLDEN_RETRIEVER\"},{\"name\":\"Kitty\",\"breed\":\"ABYSSINIAN\"}]";
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPut(){
		//I don't know how to put test...
		WebTarget target = target("animal");
		Response res = target.request().put(Entity.json("{\"name\":\"Rocky\",\"breed\":\"GOLDEN_RETRIEVER\"}"));
		assertThat("200 OK?", res.getStatusInfo().getStatusCode(), is(200));
		assertThat("this is dog",res.readEntity(String.class),is("DOG"));
	}
}
