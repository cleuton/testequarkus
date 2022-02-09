package guru.desenvolvedor.wbindex.model;

public class Country {
	
	private String id;
	
	private String iso2Code;
	
	private String name;
	
	public Country() {
		super();
	}
	
	public Country(String id, String iso2Code, String name) {
		super();
		this.id = id;
		this.iso2Code = iso2Code;
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIso2Code() {
		return iso2Code;
	}
	public void setIso2Code(String iso2Code) {
		this.iso2Code = iso2Code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((iso2Code == null) ? 0 : iso2Code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Country other = (Country) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iso2Code == null) {
			if (other.iso2Code != null)
				return false;
		} else if (!iso2Code.equals(other.iso2Code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
}
