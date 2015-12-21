package sample.chapter10;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.sample.dao.CategoryDao;
import com.bstek.dorado.sample.entity.Category;
import com.bstek.dorado.sample.entity.Product;

@Component
public class DataTree {
	
	@Autowired
	public CategoryDao categoryDao;
	
	@DataProvider
	public Collection<Category> getAll(){
		return categoryDao.getAll();
	}
	
	@DataProvider
	public Collection<Product> getProductsByCategoryId(String categotyId){
		String hql = "from Product where category.id="+categotyId;
		return categoryDao.find(hql);
	}
}
