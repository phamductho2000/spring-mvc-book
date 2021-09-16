package com.webbansach.dto;

import java.sql.Timestamp;

public class AbstractDTO<T> {
    private long id;
    private Timestamp createdDate;
    private Timestamp updated_date;
    private String created_by;
    private String modified_by;

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Long getId() {
            return id;
    }

    public Timestamp getCreated_date() {
        return createdDate;
    }

    public Timestamp getUpdated_date() { return updated_date; }

    public void setUpdated_date(Timestamp updated_date) { this.updated_date = updated_date; }

    public void setCreated_date(Timestamp created_date) {
        this.createdDate = created_date;
    }

    public void setId(Long id) {
            this.id = id;
    }


}
