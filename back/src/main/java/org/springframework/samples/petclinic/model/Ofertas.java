package org.springframework.samples.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ofertas")
public class Ofertas extends BaseEntity{

    
	@Column(name = "titulo")
	@NotEmpty
	private String vcTitulo;
	@Column(name = "descripcion")
	private String vcDescr;
	@Column(name = "descuento")
	private double vcDescu;
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
