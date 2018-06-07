package cn.it.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.FileImage;
import cn.it.shop.model.PageModel;
import cn.it.shop.service.AccountService;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ForderService;
import cn.it.shop.service.PayService;
import cn.it.shop.service.PrivilegeService;
import cn.it.shop.service.ProductService;
import cn.it.shop.service.RoleService;
import cn.it.shop.service.SorderService;
import cn.it.shop.service.UrlService;
import cn.it.shop.service.UserService;
import cn.it.shop.util.EmailUtil;
import cn.it.shop.util.FileUpload;
import cn.it.shop.util.MessageUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("unchecked")
@Controller
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T> {

	protected T model;
	protected String ids;
	protected Class clazz;
	protected Integer page;
	protected Integer rows;
	protected FileImage fileImage;
	protected InputStream inputStream;
	protected List<T> jsonList = null;
	protected PageModel<T> pageModel = null;
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	@Resource
	protected FileUpload fileUpload;
	@Resource
	protected EmailUtil emailUtil;
	@Resource
	protected MessageUtil messageUtil;
	@Resource
	protected RoleService roleService;
	@Resource
	protected UrlService urlService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected PayService payService;
	@Resource
	protected UserService userService;
	@Resource
	protected SorderService sorderService;
	@Resource
	protected ForderService forderService;
	@Resource
	protected ProductService productService;
	@Resource
	protected AccountService accountService;
	@Resource
	protected CategoryService categoryService;

	@Override
	public T getModel() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return model;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public void setJsonList(List<T> jsonList) {
		this.jsonList = jsonList;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	

	public PageModel<T> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<T> pageModel) {
		this.pageModel = pageModel;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
