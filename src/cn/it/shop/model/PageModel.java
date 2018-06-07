package cn.it.shop.model;

import java.util.List;

public class PageModel<T> {

	private Long total;
	
	private List<T> rows;
	
	@Override
	public String toString() {
		return "PageModel [total=" + total + ", rows=" + rows + "]";
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
