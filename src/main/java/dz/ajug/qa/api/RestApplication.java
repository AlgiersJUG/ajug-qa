package dz.ajug.qa.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class RestApplication extends Application {

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public RestApplication() {
		classes.add(QuestionAPI.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
