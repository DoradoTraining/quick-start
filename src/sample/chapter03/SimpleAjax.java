/**
 * ============================================================
 * File : SimpleAjax.java
 * Description : 
 * 
 * Package : sample.chapter03
 * Author : MXH
 * Last Edited By :
 * Version : 1.0
 * Created on : 2015年12月8日
 * History
 * Modified By : Initial Release
 * Classification : ZAVAN Confidential
 * Copyright (C) 2015 ZAVAN Company. All rights reserved
 *
 * ============================================================
 */

package sample.chapter03;

import java.util.Properties;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.core.DoradoAbout;

/*******************************************************************************
 *
 * @Author 		: MXH
 * @Version 	: 1.0
 * @Date Created: 2015年12月8日
 * @Date Modified : 
 * @Modified By : 
 * @Contact 	:
 * @Description : 
 * @History		:
 *
 ******************************************************************************/
@Component
public class SimpleAjax {
	
	@Expose
	public String toUpperCase(String str){
		return "input:\n"+str+"\n\n"+"output:\n"+str.toUpperCase();
	}

	@Expose
	public int multiply(int num1,int num2){
		return num1*num2;
	}
	
	@Expose
	public Properties getSystemInfo(){
		Properties info = new Properties();
		info.setProperty("product", DoradoAbout.getProductTitle());
		info.setProperty("vendor", DoradoAbout.getVendor());
		info.setProperty("version", DoradoAbout.getVersion());
		return info;
	}
}
