package sample.chapter10;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.sample.dao.ExampleCategoryDao;
import com.bstek.dorado.sample.entity.ExampleCategory;

@Component
public class RecursiveTree {

	@Autowired
	private ExampleCategoryDao categoryDao;
	
	//返回顶层的数据
	@DataProvider
	public Collection<ExampleCategory> getCategories(){
		String hql = "from ExampleCategory where categoryId is null";
		return categoryDao.find(hql);
		
	}
}
