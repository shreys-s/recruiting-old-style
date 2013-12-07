package it.f2informatica.services.domain.consultant;

import it.f2informatica.services.model.ConsultantModel;
import it.f2informatica.services.model.ExperienceModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConsultantService {

	Page<ConsultantModel> showAllConsultants(Pageable pageable);

	ConsultantModel registerConsultantMasterData(ConsultantModel consultantModel);

	ConsultantModel findConsultantById(String consultantId);

	String generateConsultantNumber();

	boolean saveConsultantExperience(ExperienceModel experienceModel, String consultantId);

	List<ExperienceModel> findExperiences(String consultantId);
}