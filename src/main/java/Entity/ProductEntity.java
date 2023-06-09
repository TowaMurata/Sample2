package Entity;

import java.io.Serializable;

public class ProductEntity implements Serializable {
	private int id;
	private String name;
	private String category;
	private int stock;
	private int sales_price;
	private String target_gender_code;

	public ProductEntity(int id, String name, String category, int stock, int sales_price,
			int target_gender_code) {
	}

	public ProductEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSales_price() {
		return sales_price;
	}

	public void setSales_price(int sales_price) {
		this.sales_price = sales_price;
	}

	public String getTarget_gender_code() {
		return target_gender_code;
	}

	public void setTarget_gender_code(String target_gender_code) {
		this.target_gender_code = target_gender_code;
	}

}
