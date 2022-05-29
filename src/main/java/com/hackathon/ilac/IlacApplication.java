package com.hackathon.ilac;

import com.hackathon.ilac.dao.file.KomekDataDao;
import com.hackathon.ilac.dao.file.PharmacyDataDao;
import com.hackathon.ilac.dao.repository.KomekRepository;
import com.hackathon.ilac.dao.repository.PharmacyRepository;
import com.hackathon.ilac.dao.repository.RecycleMedicineRepository;
import com.hackathon.ilac.dao.rest.rest.DutyPharmacyDAO;
import com.hackathon.ilac.model.entity.Komek;
import com.hackathon.ilac.model.entity.Pharmacy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAsync
public class IlacApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IlacApplication.class, args);
	}

	@Autowired
	private PharmacyDataDao pharmacyDataDao;
	@Autowired
	private PharmacyRepository pharmacyRepository;
	@Autowired
	private DutyPharmacyDAO dutyPharmacyDAO;

	@Autowired
	private KomekDataDao komekDataDao;

	@Autowired
	private KomekRepository komekRepository;

	@Autowired
	private RecycleMedicineRepository recycleMedicineRepository;
	@Override
	public void run(String... args) throws Exception {


		/*List<Komek> komeks=new ArrayList<>();
		komekDataDao.getKomeks().getKomeks().forEach(komekProperties -> {
			Komek komek=new Komek();
			komek.setCity(komekProperties.getLoc());
			komek.setLang(komekProperties.getLang());
			komek.setLat(komekProperties.getLat());
			komek.setName(komekProperties.getName());
			komek.setPassword("12345");
			komeks.add(komek);
		});
		komekRepository.saveAll(komeks);
		pharmacyDataDao.data().getFeatures().forEach(pharmacyJson -> {
						Pharmacy pharmacy=new Pharmacy();
						pharmacy.setName(pharmacyJson.getProperties().getADI());
						pharmacy.setPassword("aaaaaa");
						pharmacy.setLang(pharmacyJson.getGeometry().getCoordinates()[0]);
						pharmacy.setLat(pharmacyJson.getGeometry().getCoordinates()[1]);
							pharmacyRepository.save(pharmacy);
					});*/
	}
}
