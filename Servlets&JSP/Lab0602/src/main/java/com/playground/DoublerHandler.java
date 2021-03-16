package com.playground;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;


public class DoublerHandler extends SimpleTagSupport {

    private double number;


    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
           
            
            out.println(" YOUR Outpput is : "+ number);
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in DoublerHandler tag", ex);
        }
    }

    public void setNumber(double number) {
        this.number = number;
    }
    
}
