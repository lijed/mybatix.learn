package ariix.mybatix.learn.db.vo;

import java.util.Set;

public class City {
	
	private String city;
	
	private Set<String> distrcts;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public Set<String> getDistrcts() {
		return distrcts;
	}

	public void setDistrcts(Set<String> distrcts) {
		this.distrcts = distrcts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		City other = (City) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}
}
