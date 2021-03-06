/*
 * =============================================================================
 *
 *   Copyright (c) 2014, Fernando Aspiazu
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package it.f2informatica.core.model.builder;

import it.f2informatica.core.model.*;
import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ConsultantModelBuilder {

	private ConsultantModel consultant = new ConsultantModel();

	public static ConsultantModelBuilder consultantModel() {
		return new ConsultantModelBuilder();
	}

	public ConsultantModelBuilder withId(String id) {
		consultant.setId(id);
		return this;
	}

	public ConsultantModelBuilder withRegistrationDate(Date registrationDate) {
		consultant.setRegistrationDate(registrationDate);
		return this;
	}

	public ConsultantModelBuilder withConsultantNo(String consultantNo) {
		consultant.setConsultantNo(consultantNo);
		return this;
	}

	public ConsultantModelBuilder withFiscalCode(String fiscalCode) {
		consultant.setFiscalCode(fiscalCode);
		return this;
	}

	public ConsultantModelBuilder withEmail(String email) {
		consultant.setEmail(email);
		return this;
	}

	public ConsultantModelBuilder withFirstName(String firstName) {
		consultant.setFirstName(firstName);
		return this;
	}

	public ConsultantModelBuilder withLastName(String lastName) {
		consultant.setLastName(lastName);
		return this;
	}

	public ConsultantModelBuilder withGender(String gender) {
		consultant.setGender(gender);
		return this;
	}

	public ConsultantModelBuilder withPhoneNumber(String phoneNumber) {
		consultant.setPhoneNumber(phoneNumber);
		return this;
	}

	public ConsultantModelBuilder withMobileNo(String mobileNo) {
		consultant.setMobileNumber(mobileNo);
		return this;
	}

	public ConsultantModelBuilder withBirthDate(Date birthDate) {
		consultant.setBirthDate(birthDate);
		if (birthDate != null) {
			Period periodFromBirthdayToday = new Period(new DateTime(birthDate), new DateTime());
			consultant.setAge(periodFromBirthdayToday.getYears());
		}
		return this;
	}

	public ConsultantModelBuilder withBirthCountry(String birthCountry) {
		consultant.setBirthCountry(birthCountry);
		return this;
	}

	public ConsultantModelBuilder withBirthCity(String birthCity) {
		consultant.setBirthCity(birthCity);
		return this;
	}

	public ConsultantModelBuilder withNationality(String nationality) {
		consultant.setNationality(nationality);
		return this;
	}

	public ConsultantModelBuilder withIdentityCardNo(String identityCardNo) {
		consultant.setIdentityCardNo(identityCardNo);
		return this;
	}

	public ConsultantModelBuilder withPassportNo(String passportNo) {
		consultant.setPassportNo(passportNo);
		return this;
	}

	public ConsultantModelBuilder withExperienceIn(ExperienceModelBuilder experience) {
		return withExperienceIn(experience.build());
	}

	public ConsultantModelBuilder withExperienceIn(ExperienceModel experience) {
		consultant.getExperiences().add(experience);
		return this;
	}

	public ConsultantModelBuilder withExperiencesIn(List<ExperienceModel> experiences) {
		Collections.sort(experiences, Collections.reverseOrder());
		consultant.getExperiences().addAll(experiences);
		return this;
	}

	public ConsultantModelBuilder withEducationIn(EducationModelBuilder education) {
		return withEducationIn(education.build());
	}

	public ConsultantModelBuilder withEducationIn(EducationModel education) {
		consultant.getEducationList().add(education);
		return this;
	}

	public ConsultantModelBuilder withEducationIn(List<EducationModel> educations) {
//		Collections.sort(educations, Collections.reverseOrder());
		consultant.getEducationList().addAll(educations);
		return this;
	}

	public ConsultantModelBuilder withSkill(String skill) {
		consultant.getSkills().add(skill);
		return this;
	}

	public ConsultantModelBuilder withSkills(List<String> skills) {
		consultant.getSkills().addAll(skills);
		return this;
	}

	public ConsultantModelBuilder speaking(LanguageModelBuilder language) {
		return speaking(language.build());
	}

	public ConsultantModelBuilder speaking(LanguageModel language) {
		consultant.getLanguages().add(language);
		return this;
	}

	public ConsultantModelBuilder speakingLanguages(List<LanguageModel> languages) {
		consultant.getLanguages().addAll(languages);
		return this;
	}

	public ConsultantModelBuilder withInterestsIn(String interestsIn) {
		consultant.setInterests(interestsIn);
		return this;
	}

	public ConsultantModelBuilder withResidence(AddressModelBuilder residence) {
		return withResidence(residence.build());
	}

	public ConsultantModelBuilder withResidence(AddressModel residence) {
		consultant.setResidence(residence);
		return this;
	}

	public ConsultantModelBuilder withDomicile(AddressModelBuilder domicile) {
		return withDomicile(domicile.build());
	}

	public ConsultantModelBuilder withDomicile(AddressModel domicile) {
		consultant.setDomicile(domicile);
		return this;
	}

	public ConsultantModel build() {
		return consultant;
	}

}
