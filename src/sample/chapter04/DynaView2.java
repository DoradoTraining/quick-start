package sample.chapter04;

import org.springframework.stereotype.Component;

import com.bstek.dorado.common.event.DefaultClientEvent;
import com.bstek.dorado.view.widget.base.Button;
import com.bstek.dorado.view.widget.base.Panel;

@Component
public class DynaView2 {
	
	public void onPanelInit(Panel panel){
		//创建Button对象
		Button button = new Button();
		//设定标题
		button.setCaption("新增(动态设置Button1的属性");
		//设定宽度
		button.setWidth("300");
		//设定点击事件
		button.addClientEventListener("onClick", new DefaultClientEvent("dorado.MessageBox.alert('You clicked '+self.get('caption'))"));
		panel.addButton(button);
	}
}
