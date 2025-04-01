package com.dms.eo.yamlloader.component;

import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.*;
import org.yaml.snakeyaml.*;

import java.io.*;
import java.util.*;

@Component
public class YamlFileLoader {

    @Autowired
    private Resource yamlResource;

    public Map<String, Object> loadConfig() throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = yamlResource.getInputStream()) {
            return yaml.load(inputStream);
        }
    }
}
