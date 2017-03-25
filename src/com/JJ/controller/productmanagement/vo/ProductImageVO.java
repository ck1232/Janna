package com.JJ.controller.productmanagement.vo;

import java.io.Serializable;

import com.JJ.model.ProductImageDbObject;

public class ProductImageVO extends ProductImageDbObject implements Serializable {
    private byte[] image;

    private byte[] thumbNailImage;

    private static final long serialVersionUID = 1L;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getThumbNailImage() {
        return thumbNailImage;
    }

    public void setThumbNailImage(byte[] thumbNailImage) {
        this.thumbNailImage = thumbNailImage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", image=").append(image);
        sb.append(", thumbNailImage=").append(thumbNailImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}