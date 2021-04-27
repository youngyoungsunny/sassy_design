package org.techtown.graph;

import android.widget.Spinner;

public class AddEntry {
    String[] categories = {"카테고리 선택", "식비", "교통비", "문화생활" , "패션/미용", "생활용품", "교육", "수입"};

    String productName;
    String price;
    //Spinner category;

    public AddEntry(String productName, String price, String[] categories) {
        this.productName = productName;
        this.price = price;
        //this.category = category;
        this.categories = categories;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategory(String[] categories) {
        this.categories = categories;
    }
}
