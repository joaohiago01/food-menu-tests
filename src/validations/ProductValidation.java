package validations;

import entity.Category;
import entity.Product;

public class ProductValidation {

	public boolean validateCategoryAssociated(Product newProduct, Category category) {
		if (category != null) {
			newProduct.setCategory(category);
			return true;
		}
		return false;
	}

	public boolean validateNameProduct(Product newProduct, String nameProduct) {
		if (nameProduct.length() >= 3 && nameProduct.length() <= 40) {
			newProduct.setName(nameProduct);
			return true;
		}
		return false;
	}

}
