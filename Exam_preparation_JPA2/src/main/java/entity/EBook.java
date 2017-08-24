/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Pravien
 */
@DiscriminatorValue("EBook")
@Entity
public class EBook extends Book
{
    private String downloadUrl;
    private double sizeMB;

    public EBook()
    {
    }

    public EBook(String downloadUrl, double sizeMB, Long Isbn, String title, String author, double price)
    {
        super(Isbn, title, author, price);
        this.downloadUrl = downloadUrl;
        this.sizeMB = sizeMB;
    }

    public String getDownloadUrl()
    {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl)
    {
        this.downloadUrl = downloadUrl;
    }

    public double getSizeMB()
    {
        return sizeMB;
    }

    public void setSizeMB(double sizeMB)
    {
        this.sizeMB = sizeMB;
    }
}
