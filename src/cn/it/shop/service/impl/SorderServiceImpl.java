package cn.it.shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.SorderService;

@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave = false;
		Sorder sorder = productToSorder(product);
		for (Sorder temp : forder.getSorderList()) {
			if ((sorder.getProduct().getId()).equals(temp.getProduct().getId())) {
				temp.setNumber(temp.getNumber() + 1);
				isHave = true;
				break;
			}
		}

		if (!isHave) {
			sorder.setForder(forder);
			forder.getSorderList().add(sorder);
		}
		return forder;
	}

	@Override
	public List<Object> querySale(int number) {
		return sorderDao.querySale(number);
	}

}
