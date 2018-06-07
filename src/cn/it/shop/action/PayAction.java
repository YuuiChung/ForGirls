package cn.it.shop.action;

import java.util.Map;
import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.BackData;
import cn.it.shop.model.Forder;
import cn.it.shop.model.SendData;
import cn.it.shop.model.User;

/*
 * ParameterAware: 此接口可以获取请求的参数信息
 * 
 *  if (action instanceof ParameterAware) {
           ((ParameterAware) action).setParameters((Map)context.getParameters());
     }
    而且在执行Struts拦截器的时候是先执行: servletConfig---> modelDriven
 * */
@Controller
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware {

	private Map<String, String[]> parameter;

	@Override
	public Object getModel() {

		if (parameter.get("pd_FrpId") != null) {
			model = new SendData();
		} else {
			model = new BackData();
		}
		return model;
	}

	public String goBank() {
		SendData sendData = (SendData) model;
		Forder forder = (Forder) session.get("oldForder");
		User user = (User) session.get("user");
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail() + "," + user.getPhone());
		payService.saveDataToRequest(request, sendData);
		System.out.println("----success----");
		return "pay";
	}

	public void backBank() throws Exception {
		BackData backData = (BackData) model;
		System.out.println(model);
		boolean isOk = payService.checkBackData(backData);
		if (isOk) {
			forderService.updateStatusById(
					Integer.parseInt(backData.getR6_Order()), 2);
			String email = backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(email, backData.getR6_Order());
			String phone = backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(phone, backData.getR6_Order());
		} else {
			System.out.println("---fail---");
		}
	}

	@Override
	public void setParameters(Map<String, String[]> parameter) {
		this.parameter = parameter;
	}
}
