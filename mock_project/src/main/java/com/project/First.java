package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class First {

    String name = "Pawan Bisht";
    
    private Second second;
    
//    public First(@Lazy Second second) {				// contructer injection
//        this.second = second;
//    }
    @Autowired
    @Lazy
    public void setSecond(Second second) {				// setter injection
		this.second = second;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public int printFirst() {
        return second.getAge();
    }
}
