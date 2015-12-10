package sample.chapter04;

import org.springframework.stereotype.Component;

import com.bstek.dorado.view.View;
import com.bstek.dorado.view.widget.base.Button;

@Component
public class DynaView4 {
	
	public void onViewInit(View view,Button button1){
		view.setTitle("DynaView4:测试标题");
		button1.setCaption("修改");
	}
}
