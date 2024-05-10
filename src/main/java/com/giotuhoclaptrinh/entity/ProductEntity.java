package com.giotuhoclaptrinh.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{
	@Column(name = "code")
	private String code;
	
	@Column(name = "image")
	private String[] image;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "nameproduct")
	private String nameProduct;
	
	@Column(name = "oldprice")
	private Long oldPrice;
	
	@Column(name = "originalprice")
	private Long originalPrice;
	
	@Column(name = "quantity")	
	private Long quantity;
	
	@Column(name = "sale")
	private String sale;
	
	@Column(name = "size")
	private String[] size;
	
	@Column(name = "stastus")
	private String status;
	
	// quan hệ n - 1
	@ManyToOne
    @JoinColumn(name = "category_id") // sử dụng để chỉ định tên của cột ngoại khóa trong bảng hiện tại
    private CategoryEntity category;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String[] getImage() {
		return image;
	}

	public void setImage(String[] image) {
		this.image = image;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Long getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Long oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Long getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Long originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public String[] getSize() {
		return size;
	}

	public void setSize(String[] size) {
		this.size = size;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	
}
