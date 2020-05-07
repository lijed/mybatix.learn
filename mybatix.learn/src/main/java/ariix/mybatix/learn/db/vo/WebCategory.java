package ariix.mybatix.learn.db.vo;

import java.io.Serializable;
import java.util.Date;

public class WebCategory implements BaseVo {

	private static final long serialVersionUID = 1L;
	
	private String itemCode;
	private String categoryKey;
	private Integer displayOrder;
	private Integer disclaimer;
	private Date startDate;
	private Date endDate;
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getCategoryKey() {
		return categoryKey;
	}
	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}
	public Integer getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	public Integer getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(Integer disclaimer) {
		this.disclaimer = disclaimer;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startdate) {
		this.startDate = startdate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryKey == null) ? 0 : categoryKey.hashCode());
		result = prime * result
				+ ((itemCode == null) ? 0 : itemCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebCategory other = (WebCategory) obj;
		if (categoryKey == null) {
			if (other.categoryKey != null)
				return false;
		} else if (!categoryKey.equals(other.categoryKey))
			return false;
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		return true;
	}

}
