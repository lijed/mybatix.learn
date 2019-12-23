package ariix.mybatix.learn.db.vo;

import java.util.Set;

public class Province {
	
	private String province;
	private Set<City> citys;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Set<City> getCitys() {
		return citys;
	}
	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
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
		Province other = (Province) obj;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}
	
	
}
