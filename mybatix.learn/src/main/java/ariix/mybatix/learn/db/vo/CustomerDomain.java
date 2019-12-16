package ariix.mybatix.learn.db.vo;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class CustomerDomain {

	public static final String CUSTOMER_TABLE_NAME = "CUST";

	private Long custId;
	private Long sponsorId;
	private String countryCode;
	private String rFirstName;
	private String rMiddleName;
	private String rLastName;
	private String nFirstName;
	private String nMiddleName;
	private String nLastName;
	private String companyName;
	private String displayName;
	private String recognitionName;
	private String customerType;
	private Integer currentRank;
	private Date birthDate;
	private Date entryDate;
	private Date renewalDate;
	private Date terminationDate;
	private Date lastUpdate;
	private Date suspensionDate;
	private String customerStatus;
	private String language;

	private String kkFirst;
	private String kkLast;
	private Integer tlLevel;

	private String enteredBy;
	private String source;
	private Integer targetTlLevel;
	private long entryWeekId;
	private long weekId;
	private String gender;
	private String recognitionNativeName;

	// Below fileds only for France market
	private Integer subCustType;
	private String deptNumber;
	private String birthCity;
	private String birthCountry;
	private String countryNationality;
	private String courtesyTitle;
	private String countryOfResidence;

	private String updateFlag;

	private Long parentEmailHistoryId;
	private List<String> toEmailAddressList;
	private Long emailTypeId;

	private Integer resentFlag;
	private String emailEnterBy;

	// XO_PRO_THRU_WEEK
	private Long xoProThruWeek;

	private String recognitionCountry;
	private String nickName;

	private CustomerIdsDomain custGovernmentId;

	public String getEmailEnterBy() {
		return emailEnterBy;
	}

	public void setEmailEnterBy(String emailEnterBy) {
		this.emailEnterBy = emailEnterBy;
	}

	public Integer getResentFlag() {
		return resentFlag;
	}

	public void setResentFlag(Integer resentFlag) {
		this.resentFlag = resentFlag;
	}

	public String getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}

	public String getCountryOfResidence() {
		if (StringUtils.isNotBlank(countryOfResidence)) {
			countryOfResidence = countryOfResidence.toUpperCase();
		}
		return countryOfResidence;
	}

	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}

	public String getRecognitionNativeName() {
		return recognitionNativeName;
	}

	public void setRecognitionNativeName(String recognitionNativeName) {
		this.recognitionNativeName = recognitionNativeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getWeekId() {
		return weekId;
	}

	public void setWeekId(long weekId) {
		this.weekId = weekId;
	}

	public long getEntryWeekId() {
		return entryWeekId;
	}

	public void setEntryWeekId(long entryWeekId) {
		this.entryWeekId = entryWeekId;
	}

	public Integer getTargetTlLevel() {
		return targetTlLevel;
	}

	public void setTargetTlLevel(Integer targetTlLevel) {
		this.targetTlLevel = targetTlLevel;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Long getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(Long sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getrFirstName() {
		return rFirstName;
	}

	public void setrFirstName(String rFirstName) {
		this.rFirstName = rFirstName;
	}

	public String getrMiddleName() {
		return rMiddleName;
	}

	public void setrMiddleName(String rMiddleName) {
		this.rMiddleName = rMiddleName;
	}

	public String getrLastName() {
		return rLastName;
	}

	public void setrLastName(String rLastName) {
		this.rLastName = rLastName;
	}

	public String getnFirstName() {
		return nFirstName;
	}

	public void setnFirstName(String nFirstName) {
		this.nFirstName = nFirstName;
	}

	public String getnMiddleName() {
		return nMiddleName;
	}

	public void setnMiddleName(String nMiddleName) {
		this.nMiddleName = nMiddleName;
	}

	public String getnLastName() {
		return nLastName;
	}

	public void setnLastName(String nLastName) {
		this.nLastName = nLastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDisplayName() {
		if ("CHN".equals(countryCode) || "HKG".equals(countryCode)
				|| "TWN".equals(countryCode) || "KOR".equals(countryCode)
				|| "JPN".equals(countryCode)) {

			if (StringUtils.isNotBlank(getnLastName())
					|| StringUtils.isNotBlank(getnFirstName())) {
				displayName = (getnLastName() != null ? getnLastName() : "")
						+ " "
						+ (getnFirstName() != null ? getnFirstName() : "");
			} else {
				displayName = (getrLastName() != null ? getrLastName() : "")
						+ " "
						+ (getrFirstName() != null ? getrFirstName() : "");
			}
		} else {
			displayName = (getrFirstName() != null ? getrFirstName() : "")
					+ " " + (getrMiddleName() != null ? getrMiddleName() : "")
					+ " " + (getrLastName() != null ? getrLastName() : "");
		}
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getRecognitionName() {
		return recognitionName;
	}

	public void setRecognitionName(String recognitionName) {
		this.recognitionName = recognitionName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Integer getCurrentRank() {
		return currentRank;
	}

	public void setCurrentRank(Integer currentRank) {
		this.currentRank = currentRank;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getSuspensionDate() {
		return suspensionDate;
	}

	public void setSuspensionDate(Date suspensionDate) {
		this.suspensionDate = suspensionDate;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getKkFirst() {
		return kkFirst;
	}

	public void setKkFirst(String kkFirst) {
		this.kkFirst = kkFirst;
	}

	public String getKkLast() {
		return kkLast;
	}

	public void setKkLast(String kkLast) {
		this.kkLast = kkLast;
	}

	public Integer getTlLevel() {
		return tlLevel;
	}

	public void setTlLevel(Integer tlLevel) {
		this.tlLevel = tlLevel;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFullRommanName() {
		StringBuilder fullName = new StringBuilder(100);
		boolean isHasLastName = StringUtils.isNotBlank(getrLastName());
		boolean isHasMiddleName = StringUtils.isNotBlank(getrMiddleName());
		boolean isHasFirstName = StringUtils.isNotBlank(getrFirstName());
		if (isHasFirstName) {
			fullName.append(getrFirstName());
		}
		if (isHasMiddleName) {
			if (isHasLastName) {
				fullName.append(",");
			}
			fullName.append(getrMiddleName());
		}
		if (isHasLastName) {
			if (isHasMiddleName || isHasFirstName) {
				fullName.append(",");
			}
			fullName.append(getrLastName());
		}
		return fullName.toString();
	}

	public String getFullNativeName() {
		StringBuilder fullName = new StringBuilder(100);
		boolean isHasLastName = StringUtils.isNotBlank(getnFirstName());
		boolean isHasMiddleName = StringUtils.isNotBlank(getnMiddleName());
		boolean isHasFirstName = StringUtils.isNotBlank(getnFirstName());
		if (isHasLastName) {
			fullName.append(getrLastName());
		}
		if (isHasMiddleName) {
			if (isHasLastName) {
				fullName.append(",");
			}
			fullName.append(getrMiddleName());
		}
		if (isHasFirstName) {
			if (isHasMiddleName || isHasLastName) {
				fullName.append(",");
			}
			fullName.append(getrFirstName());
		}
		return fullName.toString();
	}

	public Integer getSubCustType() {
		return subCustType;
	}

	public void setSubCustType(Integer subCustType) {
		this.subCustType = subCustType;
	}

	public String getDeptNumber() {
		return deptNumber;
	}

	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}

	public String getBirthCity() {
		if (StringUtils.isNotBlank(birthCity)) {
			birthCity = birthCity.toUpperCase();
		}
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public String getBirthCountry() {
		if (StringUtils.isNotBlank(birthCountry)) {
			birthCountry = birthCountry.toUpperCase();
		}
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getCountryNationality() {
		if (StringUtils.isNotBlank(countryNationality)) {
			countryNationality = countryNationality.toUpperCase();
		}
		return countryNationality;
	}

	public void setCountryNationality(String countryNationality) {
		this.countryNationality = countryNationality;
	}

	public String getCourtesyTitle() {
		return courtesyTitle;
	}

	public void setCourtesyTitle(String courtesyTitle) {
		this.courtesyTitle = courtesyTitle;
	}

	public Long getParentEmailHistoryId() {
		return parentEmailHistoryId;
	}

	public void setParentEmailHistoryId(Long parentEmailHistoryId) {
		this.parentEmailHistoryId = parentEmailHistoryId;
	}

	public List<String> getToEmailAddressList() {
		return toEmailAddressList;
	}

	public void setToEmailAddressList(List<String> toEmailAddressList) {
		this.toEmailAddressList = toEmailAddressList;
	}

	public Long getEmailTypeId() {
		return emailTypeId;
	}

	public void setEmailTypeId(Long emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	public Long getXoProThruWeek() {
		return xoProThruWeek;
	}

	public void setXoProThruWeek(Long xoProThruWeek) {
		this.xoProThruWeek = xoProThruWeek;
	}

	public String getRecognitionCountry() {
		return recognitionCountry;
	}

	public void setRecognitionCountry(String recognitionCountry) {
		this.recognitionCountry = recognitionCountry;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public CustomerIdsDomain getCustGovernmentId() {
		return custGovernmentId;
	}

	public void setCustGovernmentId(CustomerIdsDomain custGovernmentId) {
		this.custGovernmentId = custGovernmentId;
	}
}
