package cn.it.shop.service;

import java.util.Map;
import cn.it.shop.model.BackData;
import cn.it.shop.model.SendData;

public interface PayService {

	// 把加密后的信息存储到requestMap中
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.itcast.shop.service.impl.PayService#saveDataToRequest(java.util.Map,
	 * cn.itcast.shop.pojo.SendData)
	 */
	public abstract Map<String, Object> saveDataToRequest(
			Map<String, Object> request, SendData sendData);

	// 对返回来的数据进行加密,并且和传过来的密文进行比较,如果OK则说明数据没有被篡改
	public abstract boolean checkBackData(BackData backData);

}