package fr.springboot.test.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.springboot.test.model.AppModel;
import fr.springboot.test.repository.AppRepository;
import jakarta.transaction.Transactional;

@Service
public class AppService {

	@Autowired
	private AppRepository appRepository;

	public Iterable<AppModel> getEntities() {
		return appRepository.findAll();
	}
	
	public AppModel getEntity(int id) throws Exception {
		return appRepository.findById(id).get();		
	}

	public AppModel createEntity(AppModel appModel) throws Exception {
	    return appRepository.save(appModel);
	}

	@Transactional
	public AppModel updateEntity(int id, AppModel appModel) throws Exception {
		AppModel appModelToModify = appRepository.findById(id).orElseThrow();
		appModelToModify.setLabel(appModel.getLabel());
		appModelToModify.setLevel(appModel.getLevel());
		return appRepository.save(appModelToModify);
	}


}
