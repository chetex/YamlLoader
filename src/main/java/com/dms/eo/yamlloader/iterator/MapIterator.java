package com.dms.eo.yamlloader.iterator;

import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MapIterator {

    public void printMapWithIndex(Map<String, Object> data) {
        printMapWithIndex(data, 0, "");
    }

    private void printMapWithIndex(Map<String, Object> data, int index, String indent) {
        int localIndex = 0;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            System.out.println(indent + "[" + index + (localIndex == 0 ? "" : "." + localIndex) + "]" + entry.getKey() + ": " + entry.getValue());

            if (entry.getValue() instanceof Map) {
                printMapWithIndex((Map<String, Object>) entry.getValue(), index, indent + "  ");
                localIndex++;
            } else if (entry.getValue() instanceof List) {
                printListWithIndex((List<Object>) entry.getValue(), index, indent + "  ");
                localIndex++;
            }
        }
    }

    private void printListWithIndex(List<Object> list, int index, String indent) {
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            System.out.println(indent + "[" + index + "." + (i + 1) + "]" + " " + item);
            if (item instanceof Map) {
                printMapWithIndex((Map<String, Object>) item, index, indent + "  ");
            } else if (item instanceof List) {
                printListWithIndex((List<Object>) item, index, indent + "  ");
            }
        }
    }
}
