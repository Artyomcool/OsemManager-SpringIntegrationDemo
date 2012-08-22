package org.kwince.tmp;

import org.kwince.contribs.osem.annotations.Id;

public class College {

	@Id
    private String id;
    private String name;

    public College(){
    }
    
    public College(String name) {
    	this.name = name;
	}
    
    public void setId(String id){
    	this.id = id;
    }

	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}
}
