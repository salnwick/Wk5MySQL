package Entity;

public class Models {

	private int model_id;
	private String model;
	
	public Models(int model_id, String model) {
		this.setModel_id(model_id);
		this.setModel(model);
	}

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
