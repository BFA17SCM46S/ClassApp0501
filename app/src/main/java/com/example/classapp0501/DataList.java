package com.example.classapp0501;

public class DataList {
    private String categoryId;
    private String categoryName;
    private String categoryImage;
    private String categoryDescription;


    public DataList(String categoryId, String categoryName, String categoryImage, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryDescription = categoryDescription;
    }

    public DataList(String id, String name, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
