package org.covn.dto;

/**
 * Registration fields for all users (patients and health professionals)
 */


import java.util.Date;

/* UserDto has common fields for all users (both patients and health professionals)
 * Superclass for HealthProfessionalDto and PatientDto
 * Previously called RegisterDto
 * 
 */

public class UserDto {
	private String userId; // return to user after successful user creation 

	// ls name fields are in Latin English-26 character script
	// in Release1, only latin script names are supported
	private String lsTitle; // optional, eg. Mr, Ms, Miss, Mrs, Dr, Prof or regional variations. CHECK CONSTRAINT
	private String lsFirstName; // required
	private String lsMiddleName; // optional
	private String lsLastName; // required
	private String lsSuffix; // optional, e.g. I, II, III, Sr, Jr, etc. Not for academic degrees. 
	private String lsDegrees; // optional. Usually Masters and above degrees. But sometimes, undergraduate degrees are entered for some health professionals 
	private String lsMaidenName; // optional
	private String lsDisplayName; // optional. if blank, use (firstName + " " + lastName)
	private String lsAliasName1; // optional. If the user has an alias, fill it here
	private String lsAliasName2; // optional. If the user has another alias, fill it here

	// OPTIONAL: ns name fields are in native character script including extended Latin characters (e.g. European languages with accent marks)
	// Native script names will be supported in Release2
	private String nsTitle; 
	private String nsFirstName; 
	private String nsMiddleName; 
	private String nsLastName; 
	private String nsSuffix;  
	private String nsDegrees;
	private String nsMaidenName; 
	private String nsDisplayName;
	private String nsAliasName1; 
	private String nsAliasName2; 
	
	private String standardName; // autogenerated: standardized full name of the user in the 
	// machine readable passport official travel document line 3 format (even if the user 
	// does not have a passport) - Uppercase English letters and spaces only. Max length 
	// is 30 characters. Surname, followed by two spaces, followed by given names. If there 
	// are multiple given (first and middle) names or multiple surnames, they are separated 
	// by single spaces. If longer than 30 characters, then trim given names to fit.
	
	// either dob or ageInYrs must be present. (UI design note: dob is preferred)
	private Date dob; // date of birth
	private int ageInYrs; // approximate age in years, when date of birth is not known
	
	private String adminGender; // gender, required. also known as 'administrative gender'. What gender does the user identify 
		// as in a socio-cultureal context. CHECK CONSTRAINT
	private String biologicalSex; // Optional, the biological sex of an individual. May be different from their gender

	// id document fields go into the external_identifier table
	private String idDocType; // Identification document type, e.g. passport, driving license, etc. CHECK CONSTRAINT
	private String idDocNum; // Identification document number
	private String idDocIssuingAuthority; // e.g. Country for pasport, state for driving license. 
	// note: we are not capturing issue and expiration date of identification document for release1 though db fields are present
	
	// address fields go into the address table
	private String addressType; // Required - home, office. CHECK CONSTRAINT
	private String addressInCareOf; // optional
	private String addressCompanyName; // optional
	private String addressLine1; // required
	private String addressLine2; // optional 
	private String addressLine3; // optional
	private String addressCity; // required
	private String addressDistrict; // optional
	private String addressState; // required
	private String addressPostCode; // required
	private String addressCountry; // required
	
	// phone number fields go into the phone_number table
	private String phoneType; // required, CHECK CONSTRAINT
	private String phoneNumFormatted; // validate input format. Allowed characters: {"0-9", " ", "-", "+", "x", "(", ")", ","}
	private String phoneNumber;
	private String phoneNumberExtension; // typically used for office phones
	private boolean isPhonePrimaryUser; // is this user the primary user of the phone (false in some cases, e.g. when a child is added to a parent's phone number as a secondary user)
	private String phonePrimaryUserId; // optional, used for secondary users only.
	private boolean phoneHasInternet; // optional
	private boolean phoneHasSMS; // optional
	private boolean phoneHasWhatsApp; // optional
	private boolean phoneHasTelegram; // optional
	private boolean phoneHasLocationService; // optional
	
	// email fields go into the email_address table
	private String emailType; // optional for patients, required for health professionals, CHECK CONSTRAINT
	private String emailAddress; // validate input format. 
	private boolean isEmailPrimaryUser; // is this user the primary user of the email (false in some cases, e.g. when a child is added to a parent's or for office email address)
	private String emailPrimaryUserId; // optional, used for secondary users only
	
	// photo fields go into the user_photo table. the photo image file is saved on the file system and it's path is saved in the table
	// If photoPath is provided, then photoType must be provided.
	private String photoType; // CHECK CONSTRAINT
	private String photoPath;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLsTitle() {
		return lsTitle;
	}
	public void setLsTitle(String lsTitle) {
		this.lsTitle = lsTitle;
	}
	public String getLsFirstName() {
		return lsFirstName;
	}
	public void setLsFirstName(String lsFirstName) {
		this.lsFirstName = lsFirstName;
	}
	public String getLsMiddleName() {
		return lsMiddleName;
	}
	public void setLsMiddleName(String lsMiddleName) {
		this.lsMiddleName = lsMiddleName;
	}
	public String getLsLastName() {
		return lsLastName;
	}
	public void setLsLastName(String lsLastName) {
		this.lsLastName = lsLastName;
	}
	public String getLsSuffix() {
		return lsSuffix;
	}
	public void setLsSuffix(String lsSuffix) {
		this.lsSuffix = lsSuffix;
	}
	public String getLsDegrees() {
		return lsDegrees;
	}
	public void setLsDegrees(String lsDegrees) {
		this.lsDegrees = lsDegrees;
	}
	public String getLsMaidenName() {
		return lsMaidenName;
	}
	public void setLsMaidenName(String lsMaidenName) {
		this.lsMaidenName = lsMaidenName;
	}
	public String getLsDisplayName() {
		return lsDisplayName;
	}
	public void setLsDisplayName(String lsDisplayName) {
		this.lsDisplayName = lsDisplayName;
	}
	public String getLsAliasName1() {
		return lsAliasName1;
	}
	public void setLsAliasName1(String lsAliasName1) {
		this.lsAliasName1 = lsAliasName1;
	}
	public String getLsAliasName2() {
		return lsAliasName2;
	}
	public void setLsAliasName2(String lsAliasName2) {
		this.lsAliasName2 = lsAliasName2;
	}
	public String getNsTitle() {
		return nsTitle;
	}
	public void setNsTitle(String nsTitle) {
		this.nsTitle = nsTitle;
	}
	public String getNsFirstName() {
		return nsFirstName;
	}
	public void setNsFirstName(String nsFirstName) {
		this.nsFirstName = nsFirstName;
	}
	public String getNsMiddleName() {
		return nsMiddleName;
	}
	public void setNsMiddleName(String nsMiddleName) {
		this.nsMiddleName = nsMiddleName;
	}
	public String getNsLastName() {
		return nsLastName;
	}
	public void setNsLastName(String nsLastName) {
		this.nsLastName = nsLastName;
	}
	public String getNsSuffix() {
		return nsSuffix;
	}
	public void setNsSuffix(String nsSuffix) {
		this.nsSuffix = nsSuffix;
	}
	public String getNsDegrees() {
		return nsDegrees;
	}
	public void setNsDegrees(String nsDegrees) {
		this.nsDegrees = nsDegrees;
	}
	public String getNsMaidenName() {
		return nsMaidenName;
	}
	public void setNsMaidenName(String nsMaidenName) {
		this.nsMaidenName = nsMaidenName;
	}
	public String getNsDisplayName() {
		return nsDisplayName;
	}
	public void setNsDisplayName(String nsDisplayName) {
		this.nsDisplayName = nsDisplayName;
	}
	public String getNsAliasName1() {
		return nsAliasName1;
	}
	public void setNsAliasName1(String nsAliasName1) {
		this.nsAliasName1 = nsAliasName1;
	}
	public String getNsAliasName2() {
		return nsAliasName2;
	}
	public void setNsAliasName2(String nsAliasName2) {
		this.nsAliasName2 = nsAliasName2;
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAgeInYrs() {
		return ageInYrs;
	}
	public void setAgeInYrs(int ageInYrs) {
		this.ageInYrs = ageInYrs;
	}
	public String getAdminGender() {
		return adminGender;
	}
	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}
	public String getBiologicalSex() {
		return biologicalSex;
	}
	public void setBiologicalSex(String biologicalSex) {
		this.biologicalSex = biologicalSex;
	}
	public String getIdDocType() {
		return idDocType;
	}
	public void setIdDocType(String idDocType) {
		this.idDocType = idDocType;
	}
	public String getIdDocNum() {
		return idDocNum;
	}
	public void setIdDocNum(String idDocNum) {
		this.idDocNum = idDocNum;
	}
	public String getIdDocIssuingAuthority() {
		return idDocIssuingAuthority;
	}
	public void setIdDocIssuingAuthority(String idDocIssuingAuthority) {
		this.idDocIssuingAuthority = idDocIssuingAuthority;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddressInCareOf() {
		return addressInCareOf;
	}
	public void setAddressInCareOf(String addressInCareOf) {
		this.addressInCareOf = addressInCareOf;
	}
	public String getAddressCompanyName() {
		return addressCompanyName;
	}
	public void setAddressCompanyName(String addressCompanyName) {
		this.addressCompanyName = addressCompanyName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressDistrict() {
		return addressDistrict;
	}
	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getAddressPostCode() {
		return addressPostCode;
	}
	public void setAddressPostCode(String addressPostCode) {
		this.addressPostCode = addressPostCode;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumFormatted() {
		return phoneNumFormatted;
	}
	public void setPhoneNumFormatted(String phoneNumFormatted) {
		this.phoneNumFormatted = phoneNumFormatted;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumberExtension() {
		return phoneNumberExtension;
	}
	public void setPhoneNumberExtension(String phoneNumberExtension) {
		this.phoneNumberExtension = phoneNumberExtension;
	}
	public boolean isPhonePrimaryUser() {
		return isPhonePrimaryUser;
	}
	public void setPhonePrimaryUser(boolean isPhonePrimaryUser) {
		this.isPhonePrimaryUser = isPhonePrimaryUser;
	}
	public String getPhonePrimaryUserId() {
		return phonePrimaryUserId;
	}
	public void setPhonePrimaryUserId(String phonePrimaryUserId) {
		this.phonePrimaryUserId = phonePrimaryUserId;
	}
	public boolean isPhoneHasInternet() {
		return phoneHasInternet;
	}
	public void setPhoneHasInternet(boolean phoneHasInternet) {
		this.phoneHasInternet = phoneHasInternet;
	}
	public boolean isPhoneHasSMS() {
		return phoneHasSMS;
	}
	public void setPhoneHasSMS(boolean phoneHasSMS) {
		this.phoneHasSMS = phoneHasSMS;
	}
	public boolean isPhoneHasWhatsApp() {
		return phoneHasWhatsApp;
	}
	public void setPhoneHasWhatsApp(boolean phoneHasWhatsApp) {
		this.phoneHasWhatsApp = phoneHasWhatsApp;
	}
	public boolean isPhoneHasTelegram() {
		return phoneHasTelegram;
	}
	public void setPhoneHasTelegram(boolean phoneHasTelegram) {
		this.phoneHasTelegram = phoneHasTelegram;
	}
	public boolean isPhoneHasLocationService() {
		return phoneHasLocationService;
	}
	public void setPhoneHasLocationService(boolean phoneHasLocationService) {
		this.phoneHasLocationService = phoneHasLocationService;
	}
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isEmailPrimaryUser() {
		return isEmailPrimaryUser;
	}
	public void setEmailPrimaryUser(boolean isEmailPrimaryUser) {
		this.isEmailPrimaryUser = isEmailPrimaryUser;
	}
	public String getEmailPrimaryUserId() {
		return emailPrimaryUserId;
	}
	public void setEmailPrimaryUserId(String emailPrimaryUserId) {
		this.emailPrimaryUserId = emailPrimaryUserId;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
}
