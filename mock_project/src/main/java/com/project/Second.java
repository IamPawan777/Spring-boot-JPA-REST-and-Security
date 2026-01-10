package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Second {

    int age = 23;

    private First first;
    public Second(@Lazy First first) {       // constructor injection
        this.first = first;
    }
//    @Autowired
//    @Lazy
//    public void setFirst(First first) {				// setter injection
//    	this.first = first;
//    }
//    

    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public void printSecond() {
        System.out.println(first.getName());
    }
}
