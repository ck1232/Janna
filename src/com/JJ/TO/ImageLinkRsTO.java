package com.JJ.TO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Where;
@Entity
@DynamicUpdate
@Table(name = "image_link_rs")
public class ImageLinkRsTO extends BaseTO {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "image_link_rs_id", nullable=false)
	private Long imageLinkRsId;
	
	@Column(name = "ref_type", nullable=false)
    private String refType;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "ref_id", nullable=false)
	@Where(clause="ref_type='product'")
	@ForeignKey( name = "none" )
    private ProductTO productTO;

	@Column(name = "sequence", nullable=false)
    private Integer sequence;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="image_link_id", nullable=true)
	@ForeignKey( name = "none" )
	private FileLinkTO fileLinkTO;

	public Long getImageLinkRsId() {
		return imageLinkRsId;
	}

	public void setImageLinkRsId(Long imageLinkRsId) {
		this.imageLinkRsId = imageLinkRsId;
	}

	public String getRefType() {
		return refType;
	}

	public void setRefType(String refType) {
		this.refType = refType;
	}

	public ProductTO getProductTO() {
		return productTO;
	}

	public void setProductTO(ProductTO productTO) {
		this.productTO = productTO;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public FileLinkTO getFileLinkTO() {
		return fileLinkTO;
	}

	public void setFileLinkTO(FileLinkTO fileLinkTO) {
		this.fileLinkTO = fileLinkTO;
	}
}
