package com.hackathon.ilac.dao.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.ilac.dao.file.properties.PharmacyData;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class PharmacyDataDao {
    public PharmacyData data(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            PharmacyData properties = mapper.readValue(new File("src/main/resources/eczaneler.json"), PharmacyData.class);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
