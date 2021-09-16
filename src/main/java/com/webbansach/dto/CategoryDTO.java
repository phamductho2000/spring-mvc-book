package com.webbansach.dto;

public class CategoryDTO extends AbstractDTO<CategoryDTO>{
    private String name;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
