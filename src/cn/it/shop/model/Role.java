package cn.it.shop.model;

import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;



/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable,GrantedAuthority,ConfigAttribute {


    // Fields    

     private Integer id;
     private String name;
     private String detail;
     private Set<Privilege> privilegeSet;


     
    // Constructors

    public Set<Privilege> getPrivilegeSet() {
		return privilegeSet;
	}


	public void setPrivilegeSet(Set<Privilege> privilegeSet) {
		this.privilegeSet = privilegeSet;
	}


	/** default constructor 
	 * @param i */
	public Role() {
	}
	
    public Role(Integer id) {
    	this.id = id;
    }

    
    /** full constructor */
    public Role(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }


	@Override
	public String getAttribute() {
		// TODO Auto-generated method stub
		return name;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
   








}