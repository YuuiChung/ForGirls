package cn.it.shop.service.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;
import cn.it.shop.service.ForderService;

@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements
		ForderService {

	@Override
	public BigDecimal culTotal(Forder forder) {
		BigDecimal total = new BigDecimal(0.00);
		for (Sorder temp : forder.getSorderList()) {
			total = total.add(new BigDecimal(temp.getNumber()).multiply(temp
					.getPrice()));
		}
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		forderDao.updateStatusById(id, sid);
	}

	public Forder updateSorder(Forder forder, Sorder sorder) {
		for (Sorder temp : forder.getSorderList()) {
			if ((temp.getProduct().getId()).equals(sorder.getProduct().getId())) {
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

}
