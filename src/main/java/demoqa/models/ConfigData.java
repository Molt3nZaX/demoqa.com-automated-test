package demoqa.models;

import lombok.Data;

import java.util.List;

@Data
public class ConfigData {
    private String baseUrl;
    private List<String> chromeOptionsList;
    private String browser;
    private int explicitlyWait;
    private List<String> firefoxOptions;
}