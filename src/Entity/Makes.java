package Entity;

import java.util.List;

public class Makes {
	
	private int make_id;
	private String make;
	private List<Models> models;
	
	public Makes(int make_id, String make, List<Models> models) {
		this.setMake_id(make_id);
		this.setMake(make);
		this.setModels(models);
	}

	public int getMake_id() {
		return make_id;
	}

	public void setMake_id(int make_id) {
		this.make_id = make_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public List<Models> getModels() {
		return models;
	}

	public void setModels(List<Models> models) {
		this.models = models;
	}
	

}
