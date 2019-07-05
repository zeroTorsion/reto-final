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
public class Ofertas  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ofertas")
    protected Integer id;
	@Column(name = "titulo")
	@NotEmpty
	private String vc_titulo;
	@Column(name = "descripcion")
	private String vc_descr;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "descuento")
	private double vc_descu;
	@Column(name = "fExpiracion")
	private Date vc_fexp;
	public String getVc_titulo() {
		return vc_titulo;
	}
	public void setVc_titulo(String vc_titulo) {
		this.vc_titulo = vc_titulo;
	}
	public String getVc_descr() {
		return vc_descr;
	}
	public void setVc_descr(String vc_descr) {
		this.vc_descr = vc_descr;
	}
	public double getVc_descu() {
		return vc_descu;
	}
	public void setVc_descu(double vc_descu) {
		this.vc_descu = vc_descu;
	}
	public Date getVc_fexp() {
		return vc_fexp;
	}
	public void setVc_fexp(Date vc_fexp) {
		this.vc_fexp = vc_fexp;
	}
	public Ofertas(String vc_titulo, String vc_descr, double vc_descu, Date vc_fexp) {
		super();
		this.vc_titulo = vc_titulo;
		this.vc_descr = vc_descr;
		this.vc_descu = vc_descu;
		this.vc_fexp = vc_fexp;
	}

	public Ofertas() {
		super();
	}
	
	
}
