package com.dms.eo.yamlloader;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;
import org.yaml.snakeyaml.*;

import java.io.*;
import java.util.*;

@SpringBootApplication
@ComponentScan({"com.dms.eo.service.client.oauth", "com.dms.eo.flow.base.component", "com.dms.eo.fmpf",
		"com.dms.eo.flow.admin", "com.dms.eo.flow.job", "com.dms.eo.fmpf.startup", "com.dms.eo.fmpf.utils"})
public class YamlReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(YamlReaderApplication.class, args);
	}
}

@Component
class AppStartupRunner implements ApplicationRunner {

	@Value("classpath:data.yaml")
	private Resource yamlResource;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		processYaml();
	}

	public void processYaml() {
		try {
			Map<String, Object> data = loadConfig("data.yml");

			// Extract the 'name' field
			String name = (String) data.get("name");
			System.out.println("Name: " + name);

			// Extract and process 'orbitsItems'
			List<Object> orbitsItems = (List<Object>) data.get("orbitsItems");
			System.out.println("Orbits Items: " + orbitsItems);

			// Extract and process 'planningRules'
			Map<String, Object> planningRules = (Map<String, Object>) data.get("planningRules");
			if (planningRules != null && planningRules.containsKey("planningRuleItems")) {
				List<Map<String, Object>> planningRuleItems = (List<Map<String, Object>>) planningRules.get("planningRuleItems");

				if (planningRuleItems != null) {
					System.out.println("Planning Rules:");
					for (Map<String, Object> rule : planningRuleItems) {
						System.out.println("  " + rule);
					}
				}
			}

			// Extract and process 'sequencesItems'
			List<Object> sequencesItems = (List<Object>) data.get("sequencesItems");
			System.out.println("Sequences Items: " + sequencesItems);

			// Extract and process 'instrumentOperations'
			Map<String, Object> instrumentOperations = (Map<String, Object>) data.get("instrumentOperations");
			if (instrumentOperations != null && instrumentOperations.containsKey("instrumentOperationItems")) {
				List<Map<String, Object>> instrumentOperationItems = (List<Map<String, Object>>) instrumentOperations.get("instrumentOperationItems");

				if (instrumentOperationItems != null) {
					System.out.println("Instrument Operations:");
					for (Map<String, Object> operation : instrumentOperationItems) {
						System.out.println("  " + operation);
					}
				}
			}

			// Extract and process 'ppfEvents'
			Map<String, Object> ppfEvents = (Map<String, Object>) data.get("ppfEvents");
			if (ppfEvents != null && ppfEvents.containsKey("ppfEventItems")) {
				List<Map<String, Object>> ppfEventItems = (List<Map<String, Object>>) ppfEvents.get("ppfEventItems");

				if (ppfEventItems != null) {
					System.out.println("PPF Events:");
					for (Map<String, Object> event : ppfEventItems) {
						System.out.println("  " + event);
					}
				}
			}

			// Extract and process 'visibilities'
			Map<String, Object> visibilities = (Map<String, Object>) data.get("visibilities");
			if (visibilities != null && visibilities.containsKey("visibilityItems")) {
				List<Map<String, Object>> visibilityItems = (List<Map<String, Object>>) visibilities.get("visibilityItems");

				if (visibilityItems != null) {
					System.out.println("Visibilities:");
					for (Map<String, Object> visibility : visibilityItems) {
						System.out.println("  " + visibility);
					}
				}
			}

			// Extract and process 'downlinksItems'
			List<Object> downlinksItems = (List<Object>) data.get("downlinksItems");
			System.out.println("Downlinks Items: " + downlinksItems);

			// Extract and process 'unavailabilitiesItems'
			List<Object> unavailabilitiesItems = (List<Object>) data.get("unavailabilitiesItems");
			System.out.println("Unavailabilities Items: " + unavailabilitiesItems);

		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	/**
	 * Load the YAML file
	 * @param fileName File name
	 * @return Map with the data from the YAML file string object
	 * @throws IOException
	 */
	public Map<String, Object> loadConfig(String fileName) throws IOException {
		Yaml yaml = new Yaml();
		try (InputStream inputStream = yamlResource.getInputStream()) {
			return yaml.load(inputStream);
		}
	}
}
