package com.hackathon.ilac.dao.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.ilac.dao.file.properties.KomekJson;
import com.hackathon.ilac.dao.file.properties.PharmacyData;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class KomekDataDao {

    public KomekJson getKomeks(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            KomekJson km = mapper.readValue(new File("src/main/resources/komek.json"), KomekJson.class);
            return km;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
