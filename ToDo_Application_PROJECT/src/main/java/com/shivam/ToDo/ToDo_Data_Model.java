package com.shivam.ToDo;


/**
 * created by Shivam on 24-02-2019.
 */
public class ToDo_Data_Model {

    String detail;
    String category;
    String due_date;

    public ToDo_Data_Model(String detail, String category, String due_date) {
        this.detail = detail;
        this.category = category;
        this.due_date = due_date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo_Data_Model)) return false;
        ToDo_Data_Model that = (ToDo_Data_Model) o;
        return detail.equals(that.detail);
    }

}
