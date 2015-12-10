package sample.chapter05;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.sample.dao.ProductDao;
import com.bstek.dorado.sample.entity.Product;

@Component
public class SimpleCRUD {

	@Autowired
	private ProductDao productDao;
	
	@DataProvider
	public Collection<Product> getAll(){
		return productDao.getAll();
	}
	
	@DataResolver
	@Transactional
	public void saveAll(Collection<Product> products){
		productDao.persistEntities(products);
	}
}
