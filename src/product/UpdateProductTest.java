package product;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import entity.Product;

public class UpdateProductTest {

	Product product = mock(Product.class);
	
	@Test
	void updateProductWithNullName() {
		when(product.getName()).thenReturn(null);
		assertFalse("Produto Deve Ter Um Nome Ao Ser Atualizado", product.getName() != null);
	}
	
	@Test
	void updateProductWithNullPrice() {
		when(product.getPrice()).thenReturn(null);
		assertFalse("Produto Deve Ter Um Preço Ao Ser Atualizado", product.getPrice() != null);
	}
	
}
