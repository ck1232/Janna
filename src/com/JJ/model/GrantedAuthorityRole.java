package com.JJ.model;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityRole implements GrantedAuthority{
    
    private String name;
     
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAuthority() {
        return this.name;
    }
}