package sample.chapter08;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.entity.EntityState;
import com.bstek.dorado.data.entity.EntityUtils;
import com.bstek.dorado.sample.dao.ProductDao;
import com.bstek.dorado.sample.entity.Product;

@Component
public class ProductInterceptor {
	
	@Autowired
	private ProductDao productDao;
	
	@DataResolver
	@Transactional
	public void saveAll(Collection<Product> products){
		System.out.println("调用方法....");
		
		for(Product product : products){
			if(EntityState.DELETED.equals(EntityUtils.getState(product))){
				System.out.println("删除产品:"+product.getProductName());
			}else if(EntityState.MODIFIED.equals(EntityUtils.getState(product))){
				System.out.println("修改产品："+product.getProductName());
				
				//getold不起作用  需要修改actionItem submitOldData 为true
				float oldValue = EntityUtils.getOldFloat(product, "unitPrice");
				System.out.println("修改前unitPrice=" + oldValue);
				System.out.println("修改后unitPrice=" + product.getUnitPrice());
			}else if(EntityState.NEW.equals(EntityUtils.getState(product))){
				System.out.println("新增产品："+product.getProductName());
			}
		}
		//productDao.persistEntities(products);
	}
}





