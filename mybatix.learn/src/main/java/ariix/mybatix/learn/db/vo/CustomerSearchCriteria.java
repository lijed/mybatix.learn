package ariix.mybatix.learn.db.vo;

import org.apache.commons.lang3.StringUtils;

public class CustomerSearchCriteria implements SearchCriteria {

	private String countryCode;
	private String firstName;
	private String stateCode;
	private String emailAddress;
	private String phoneNumber;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getFirstName() {
		if (StringUtils.isNotBlank(firstName)) {
			return firstName.toUpperCase();
		}
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
