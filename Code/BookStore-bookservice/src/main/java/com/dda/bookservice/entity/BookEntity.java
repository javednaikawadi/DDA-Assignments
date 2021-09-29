package com.dda.bookservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="bookmaster")
public class BookEntity {
 
	@Id
    @GeneratedValue
    private Long bookId;
     
    @Column(name="bookname")
    private String bookName;
    
	@Column(name="bookdesc")
    private String bookDesc;
    
    @Column(name="bookauthor")
    private String bookAuthor;
    
	@Column(name="booktype")
    private String bookType;
	
	@Column(name="bookprice")
    private Long bookPrice;
	
	@Column(name="isbn")
    private String ISBN;
    
    @Column(name="delflag")
    private int delFlag;
     
    public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public Long getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
   
	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

    @Override
    public String toString() {
        return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + 
                ", bookDesc=" + bookDesc + ", bookAuthor=" + bookAuthor +
                ", bookType=" + bookType + ", bookPrice=" + bookPrice +
                ", ISBN=" + ISBN +", delFlag=" + delFlag +"]";
    }
}