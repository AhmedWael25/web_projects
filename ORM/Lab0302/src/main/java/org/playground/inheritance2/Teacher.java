package org.playground.inheritance2;

import java.sql.Date;

public class Teacher  extends Person {

    private Date hireDate;



    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

}
