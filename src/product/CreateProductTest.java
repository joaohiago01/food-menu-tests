package product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import entity.Category;
import entity.Product;
import validations.ProductValidation;

public class CreateProductTest {

	Product newProduct = spy(Product.class);
	
	Category category = spy(Category.class);
	
	ProductValidation productValidation = spy(ProductValidation.class);
	
	@Test
	void createProductWithoutCategory() {
		productValidation.validateCategoryAssociated(newProduct, category);
		assertTrue("Produto Deve Ter Uma Categoria",
				newProduct.getCategory() != null);
	}
	
	@Test
	void createProductWithNameMinimumOf3Characters() {
		productValidation.validateNameProduct(newProduct, "Pizza");
		verify(newProduct).setName("Pizza");
		assertTrue("Produto Deve Ter Um Nome Com No Minímo 3 Caracteres",
				newProduct.getName().length() >= 3);
	}
	
	@Test
	void createProductWithNameMaximumOf40Characters() {
		assertFalse("Produto Deve Ter Um Nome Com No Maxímo 40 Caracteres",
				productValidation
				.validateNameProduct(newProduct, "Pizza De Calabresa Com Mussarela E Catupiry Mais Bordas De Chocolate Com 2 Litros De Coca-Cola") == true);
	}

}
