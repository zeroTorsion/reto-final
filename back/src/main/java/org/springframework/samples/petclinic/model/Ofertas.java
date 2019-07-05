package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ofertas")
public class Ofertas extends BaseEntity {

	@Column(name = "titulo")
	@NotEmpty
	private String vcTitulo;
	@Column(name = "descripcion")
	private String vcDescr;
	@Column(name = "descuento")
	private double vcDescu;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "f_expiracion")
	private Date vcFexp;

	public Ofertas() {
		super();
	}

	public String getVcTitulo() {
		return vcTitulo;
	}

	public void setVcTitulo(String vcTitulo) {
		this.vcTitulo = vcTitulo;
	}

	public String getVcDescr() {
		return vcDescr;
	}

	public void setVcDescr(String vcDescr) {
		this.vcDescr = vcDescr;
	}

	public double getVcDescu() {
		return vcDescu;
	}

	public void setVcDescu(double vcDescu) {
		this.vcDescu = vcDescu;
	}

	public Date getVcFexp() {
		return vcFexp;
	}

	public void setVcFexp(Date vcFexp) {
		this.vcFexp = vcFexp;
	}

}
