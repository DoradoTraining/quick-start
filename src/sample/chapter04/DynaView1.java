package sample.chapter04;

import org.springframework.stereotype.Component;

import com.bstek.dorado.common.event.DefaultClientEvent;
import com.bstek.dorado.view.widget.base.Button;

@Component
public class DynaView1 {
	//对象监听器所使用的方法   初始化的时候起作用，也就是最终的结果
	public void onButton1Init(Button button){
		//设定标题
		button.setCaption("新增(动态设置Button1的属性)");
		//设定宽度
		button.setWidth("300");
		//设定点击事件
		button.addClientEventListener("onClick", new DefaultClientEvent("dorado.MessageBox.alert('You clicked'+self.get('caption'))"));
	}
	
	//对象监听器的使用方法 会被页面xml的配置覆盖
	public void beforeButton2Init(Button button){
		//设定标题
		button.setCaption("修改(动态设置Button2的属性)");
		//设置宽度
		button.setWidth("300");
		//设置点击事件
		button.addClientEventListener("onClick", new DefaultClientEvent("dorado.MessageBox.alert('You clicked' + self.get('caption'))"));
	}
}
