package entity;

public class Foods {

	private int foodId;
	private String name;
	private String cuisine;

	public Foods(int foodId, String name, String cusine) {
		this.setFoodId(foodId);
		this.setFoodName(name);
		this.setCuisine(cusine);
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return name;
	}

	public void setFoodName(String foodName) {
		this.name = foodName;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
}
