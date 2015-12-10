package sample.chapter05;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.sample.dao.ProductDao;
import com.bstek.dorado.sample.entity.Product;

@Component
public class SimpleCRUD {
	private static Logger logger = LoggerFactory.getLogger(SimpleCRUD.class);

	@Autowired
	private ProductDao productDao;

	// 五分页
	// @DataProvider
	// public Collection<Product> getAll(){
	// return productDao.getAll();
	// }

	@DataProvider
	public void getAll(Page<Product> page) {

		// 每页加载的数据是多少
		// page.getPageSize();
		logger.info("size" + String.valueOf(page.getPageSize()));
		// 需要加载的是第几页
		// page.getPageNo();
		logger.info("no." + String.valueOf(page.getPageNo()));
		// Dao层的分页查询方法
		productDao.getAll(page);
	}

	//根据用户名条件查询
	@DataProvider
	public void query1(Page<Product> page, String productName) {
		if (null != productName) {
			productDao.find(page,
					"from Product where productName like '%"+productName+"%'");
		} else {
			productDao.getAll(page);
		}
	}

	//多个参数查询
	@DataProvider
	public void query2(Page<Product> page,Map<String, Object> params){
		if(!CollectionUtils.isEmpty(params)){
			String productName = (String) params.get("productName");
			String unitsInStock = (String) params.get("unitsInStock");
			
			String whereCase = "";
			if(!StringUtils.isEmpty(productName)){
				whereCase += " productName like '%"+productName+"%'";
			}
			if(!StringUtils.isEmpty(unitsInStock)){
				if(StringUtils.isNotEmpty(whereCase)){
					whereCase += " and";
				}
				whereCase += " unitsInStock>"+unitsInStock;
			}
			String hql = (StringUtils.isEmpty(whereCase))? "":" where "+whereCase;
			productDao.find(page, "from Product"+hql);
			
		}else{
			productDao.getAll(page);
		}
	}
	
	@DataResolver
	@Transactional
	public void saveAll(Collection<Product> products) {
		productDao.persistEntities(products);
	}
}
