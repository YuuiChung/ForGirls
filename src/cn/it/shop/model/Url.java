package cn.it.shop.model;



/**
 * Url entity. @author MyEclipse Persistence Tools
 */

public class Url  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String url;
     private Privilege privilege;


    // Constructors

    /** default constructor */
    public Url() {
    }

    
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    

    public Privilege getPrivilege() {
		return privilege;
	}


	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

}