package validations;

import entity.Category;

public class CategoryValidation {

	public boolean validateNameCategory(Category newCategory, String nameCategory) {
		if (nameCategory.length() >= 3 && nameCategory.length() <= 40) {
			newCategory.setName(nameCategory);
			return true;
		}
		return false;
	}
}
