package com.dms.eo.yamlloader;

import com.dms.eo.yamlloader.component.*;
import com.dms.eo.yamlloader.iterator.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class YamlloaderApplicationTests {

	@Autowired
	private YamlFileLoader yamlFileLoader;

	@Autowired
	private MapIterator mapIterator;

	@Test
	void testDataContainsKey() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertNotNull(data);
		assertTrue(data.containsKey("name"));
		assertTrue(data.containsKey("orbitsItems"));
		assertTrue(data.containsKey("planningRules"));
		assertTrue(data.containsKey("sequencesItems"));
		assertTrue(data.containsKey("instrumentOperations"));
		assertTrue(data.containsKey("ppfEvents"));
		assertTrue(data.containsKey("visibilities"));
		assertTrue(data.containsKey("downlinksItems"));
		assertTrue(data.containsKey("unavailabilitiesItems"));
	}

	@Test
	void testDataIsNotEmpty() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertNotNull(data);
		assertFalse(data.isEmpty());
	}

	@Test
	void testNameValue() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertEquals("By default", data.get("name"));
	}

	@Test
	void testOrbitsItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertTrue(((List<?>) data.get("orbitsItems")).isEmpty());
	}

	@Test
	void testPlanningRulesContainsPlanningRuleItems() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> planningRules = (Map<String, Object>) data.get("planningRules");
		assertNotNull(planningRules);
		assertTrue(planningRules.containsKey("planningRuleItems"));
	}

	@Test
	void testPlanningRuleItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> planningRules = (Map<String, Object>) data.get("planningRules");
		List<Map<String, Object>> planningRuleItems = (List<Map<String, Object>>) planningRules.get("planningRuleItems");
		assertNotNull(planningRuleItems);
		assertTrue(planningRuleItems.isEmpty());
	}

	@Test
	void testSequencesItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertTrue(((List<?>) data.get("sequencesItems")).isEmpty());
	}

	@Test
	void testInstrumentOperationsContainsInstrumentOperationItems() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> instrumentOperations = (Map<String, Object>) data.get("instrumentOperations");
		assertNotNull(instrumentOperations);
		assertTrue(instrumentOperations.containsKey("instrumentOperationItems"));
	}

	@Test
	void testInstrumentOperationItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> instrumentOperations = (Map<String, Object>) data.get("instrumentOperations");
		List<Map<String, Object>> instrumentOperationItems = (List<Map<String, Object>>) instrumentOperations.get("instrumentOperationItems");
		assertNotNull(instrumentOperationItems);
		assertTrue(instrumentOperationItems.isEmpty());
	}

	@Test
	void testPpfEventsContainsPpfEventItems() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> ppfEvents = (Map<String, Object>) data.get("ppfEvents");
		assertNotNull(ppfEvents);
		assertTrue(ppfEvents.containsKey("ppfEventItems"));
	}

	@Test
	void testPpfEventItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> ppfEvents = (Map<String, Object>) data.get("ppfEvents");
		List<Map<String, Object>> ppfEventItems = (List<Map<String, Object>>) ppfEvents.get("ppfEventItems");
		assertNotNull(ppfEventItems);
		assertTrue(ppfEventItems.isEmpty());
	}

	@Test
	void testVisibilitiesContainsVisibilityItems() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> visibilities = (Map<String, Object>) data.get("visibilities");
		assertNotNull(visibilities);
		assertTrue(visibilities.containsKey("visibilityItems"));
	}

	@Test
	void testVisibilityItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		Map<String, Object> visibilities = (Map<String, Object>) data.get("visibilities");
		List<Map<String, Object>> visibilityItems = (List<Map<String, Object>>) visibilities.get("visibilityItems");
		assertNotNull(visibilityItems);
		assertTrue(visibilityItems.isEmpty());
	}

	@Test
	void testDownlinksItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertTrue(((List<?>) data.get("downlinksItems")).isEmpty());
	}

	@Test
	void testUnavailabilitiesItemsIsEmptyList() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		assertTrue(((List<?>) data.get("unavailabilitiesItems")).isEmpty());
	}

	@Test
	void testMapIterator() throws IOException {
		Map<String, Object> data = yamlFileLoader.loadConfig();
		mapIterator.printMapWithIndex(data);
	}
}
