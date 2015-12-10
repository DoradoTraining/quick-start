package sample.chapter04;

import org.springframework.stereotype.Component;

import com.bstek.dorado.common.event.DefaultClientEvent;
import com.bstek.dorado.view.View;
import com.bstek.dorado.view.widget.base.Button;

@Component
public class DynaView3 {
	public void onViewInit(View view){
		view.setTitle("DynaView:测试标题");
		
		Button button1 = (Button) view.getComponent("button1"); 
		button1.setCaption("修改");
		
		Button button = new Button();
		button.setCaption("动态添加的按钮");
		button.setWidth("300");
		button.addClientEventListener("onClick", new DefaultClientEvent("dorado.MessageBox.alert('You clicked '+self.get('caption'))"));
		view.addChild(button);
	}
}
