package com.dudessa.pageobject.model;

public class Product {
    private String fullNameOfProduct;
    private String priceOfProduct;
    private String linkToProductPage;

    public Product(String fullNameOfProduct, String priceOfProduct, String linkToProductPage) {
        this.fullNameOfProduct = fullNameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.linkToProductPage = linkToProductPage;
    }

    public String getFullNameOfProduct() {
        return fullNameOfProduct;
    }

    public void setFullNameOfProduct(String fullNameOfProduct) {
        this.fullNameOfProduct = fullNameOfProduct;
    }

    public String getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(String priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public String getLinkToProductPage() {
        return linkToProductPage;
    }

    public void setLinkToProductPage(String linkToProductPage) {
        this.linkToProductPage = linkToProductPage;
    }

    @Override
    public String toString() {
        return "Product{" +
                "fullNameOfProduct='" + fullNameOfProduct + '\'' +
                ", priceOfProduct='" + priceOfProduct + '\'' +
                ", linkToProductPage='" + linkToProductPage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getFullNameOfProduct() != null ? !getFullNameOfProduct().equals(product.getFullNameOfProduct()) : product.getFullNameOfProduct() != null)
            return false;
        if (getPriceOfProduct() != null ? !getPriceOfProduct().equals(product.getPriceOfProduct()) : product.getPriceOfProduct() != null)
            return false;
        return getLinkToProductPage() != null ? getLinkToProductPage().equals(product.getLinkToProductPage()) : product.getLinkToProductPage() == null;
    }

    @Override
    public int hashCode() {
        int result = getFullNameOfProduct() != null ? getFullNameOfProduct().hashCode() : 0;
        result = 31 * result + (getPriceOfProduct() != null ? getPriceOfProduct().hashCode() : 0);
        result = 31 * result + (getLinkToProductPage() != null ? getLinkToProductPage().hashCode() : 0);
        return result;
    }
}
