package com.flipcard.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipcard.rest.AdminController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<Configuration>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	@Override
	public void initialize(Bootstrap<Configuration> b) {
	}


	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(Configuration configuration, Environment e) throws Exception {
		// TODO Auto-generated method stub
		 LOGGER.info("Registering REST resources");
	        e.jersey().register(new AdminController());
	}
}
