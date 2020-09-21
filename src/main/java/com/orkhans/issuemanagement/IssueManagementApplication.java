package com.orkhans.issuemanagement;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class IssueManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssueManagementApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		modelMapper.getConfiguration() .setMatchingStrategy(MatchingStrategies.STRICT);
		return new ModelMapper();
	}

//	@Bean
//	public Jackson2RepositoryPopulatorFactoryBean repositoryPopulatorFactoryBean(){
//		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
//		factory.setResources(new Resource[]{new ClassPathResource("projects.json")});
//		return factory;
//	}
}
