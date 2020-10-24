package category;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import entity.Category;
import validations.CategoryValidation;

public class CreateCategoryTest {

	Category newCategory = spy(Category.class);
	
	CategoryValidation categoryValidation = spy(CategoryValidation.class);
	
	@Test
	void createCategoryWithNameMinimumOf3Characters() {
		categoryValidation.validateNameCategory(newCategory, "P�es");
		verify(newCategory).setName("P�es");
		assertTrue("Categoria Deve Ter Um Nome Com No Min�mo 3 Caracteres",
				newCategory.getName().length() >= 3);
	}
	
	@Test
	void createCategoryWithNameMaximumOf40Characters() {
		categoryValidation.validateNameCategory(newCategory, "Pizzas");
		verify(newCategory).setName("Pizzas");
		assertTrue("Categoria Deve Ter Um Nome Com No Max�mo 40 Caracteres", 
				newCategory.getName().length() <= 40);
	}
}
