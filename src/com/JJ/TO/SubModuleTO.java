package com.JJ.TO;

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

@Entity
@DynamicUpdate
@Table(name = "submodule")
public class SubModuleTO extends BaseTO  {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "submodule_id", nullable=false)
	private Long submoduleId;
    
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "icon", nullable=true)
	private String icon;
	
	@Column(name = "url", nullable=true)
	private String url;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id", nullable=false)
	@ForeignKey( name = "none" )
	private ModuleTO moduleTO;
	
	public Long getSubmoduleId() {
        return submoduleId;
    }

    public void setSubmoduleId(Long submoduleId) {
        this.submoduleId = submoduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
	
    public ModuleTO getModuleTO() {
		return moduleTO;
	}

	public void setModuleTO(ModuleTO moduleTO) {
		this.moduleTO = moduleTO;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", submoduleId=").append(submoduleId);
        sb.append(", name=").append(name);
        sb.append(", icon=").append(icon);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        sb.append(", from super class ");
        sb.append(super.toString());
        return sb.toString();
    }
}
