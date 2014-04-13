package it.f2informatica.core.gateway.mysql.converter;

import com.google.common.collect.Lists;
import it.f2informatica.core.gateway.EntityToModelConverter;
import it.f2informatica.core.model.*;
import it.f2informatica.mysql.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static it.f2informatica.core.model.builder.ConsultantModelBuilder.consultantModel;

@Component("mysqlConsultantToModelConverter")
public class MySQLConsultantToModelConverter extends EntityToModelConverter<Consultant, ConsultantModel> {

  @Autowired
  @Qualifier("mysqlSkillToStringConverter")
  private EntityToModelConverter<Skill, String> mysqlSkillToStringConverter;

  @Autowired
  @Qualifier("mysqlAddressToModelConverter")
  private EntityToModelConverter<Address, AddressModel> addressToModelConverter;

  @Autowired
  @Qualifier("mysqlLanguageToModelConverter")
  private EntityToModelConverter<Language, LanguageModel> languageToModelConverter;

  @Autowired
  @Qualifier("mysqlEducationToModelConverter")
  private EntityToModelConverter<Education, EducationModel> educationToModelConverter;

  @Autowired
  @Qualifier("mysqlExperienceToModelConverter")
  private EntityToModelConverter<Experience, ExperienceModel> experienceToModelConverter;

  @Override
  public ConsultantModel convert(Consultant consultant) {
    return (consultant == null) ? null :
      consultantModel()
        .withId(String.valueOf(consultant.getId()))
        .withConsultantNo(consultant.getConsultantNo())
        .withRegistrationDate(consultant.getRegistrationDate())
        .withFirstName(consultant.getFirstName())
        .withLastName(consultant.getLastName())
        .withGender(consultant.getGender())
        .withEmail(consultant.getEmail())
        .withFiscalCode(consultant.getFiscalCode())
        .withBirthDate(consultant.getBirthDate())
        .withBirthCity(consultant.getBirthCity())
        .withBirthCountry(consultant.getBirthCountry())
        .withPhoneNumber(consultant.getPhoneNumber())
        .withMobileNo(consultant.getMobileNumber())
        .withIdentityCardNo(consultant.getIdentityCard())
        .withResidence(addressToModelConverter.convert(consultant.getResidence()))
        .withDomicile(addressToModelConverter.convert(consultant.getDomicile()))
        .withExperiencesIn(experienceToModelConverter.convertList(consultant.getExperiences()))
        .withEducationIn(educationToModelConverter.convertList(consultant.getEducations()))
        .speakingLanguages(languageToModelConverter.convertList(Lists.newArrayList(consultant.getLanguages())))
        .withSkills(mysqlSkillToStringConverter.convertList(Lists.newArrayList(consultant.getSkills())))
        .withInterestsIn(consultant.getInterests())
        .build();
  }

}
