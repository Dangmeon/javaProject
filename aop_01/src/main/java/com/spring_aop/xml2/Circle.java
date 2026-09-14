package com.spring_aop.xml2;

import org.springframework.stereotype.Component;

// 핵심기능 2
@Component
public class Circle {
	
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void showResult() {
        System.out.println("면적 : " + (Math.PI * radius * radius));
        System.out.println("둘레 : " + (2 * Math.PI * radius));
    }

}
