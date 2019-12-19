package ariix.mybatix.learn.db.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerFlagsDomain {

	private Long custId;
	private Integer flagId;
	private Integer val;
	private Date createDate;

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public Integer getFlagId() {
		return flagId;
	}

	public void setFlagId(Integer flagId) {
		this.flagId = flagId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getCreateDateString() {
		if (createDate != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(createDate);
		} else {
			return null;
		}
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
