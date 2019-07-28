package coreutils;

import interfaces.Hardware;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Systema {
    private Map<String,Hardware> hardwares;

    public Systema(Map<String,Hardware> hardwares) {
        this.hardwares = hardwares;
    }

    public Map<String, Hardware> getHardwares() {
        return hardwares;
    }
}
