
  package com.alemaTruck.models.entity;
  
  import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
  
  
  
  @Entity
  
  @Table(name="vehiculos") public class Vehiculos implements Serializable{
  
 /**
	* 
	*/
		  private static final long serialVersionUID = 1L;
		  
		  @Id
		  
		  @GeneratedValue(strategy = GenerationType.IDENTITY)
		  
			private int idvehiculo;
			private String marca;
			private String modelo;
			@Temporal(TemporalType.DATE)
			@DateTimeFormat(iso= ISO.DATE)
		    private Date fechaingreso;
			private String precio;
			private String cilindrada;
			private String potenciahp;
			private String torque;
			private String pesobruto;
			private String imagen;
			private int estadoregistro;

		  //Relacion
		  
		  @ManyToOne //Nombre del campo
		  
		  @JoinColumn(name="idtipovehiculo") private TipoVehiculos tipovehiculos;

		public int getIdvehiculo() {
			return idvehiculo;
		}

		public void setIdvehiculo(int idvehiculo) {
			this.idvehiculo = idvehiculo;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public Date getFechaingreso() {
			return fechaingreso;
		}

		public void setFechaingreso(Date fechaingreso) {
			this.fechaingreso = fechaingreso;
		}

		public String getPrecio() {
			return precio;
		}

		public void setPrecio(String precio) {
			this.precio = precio;
		}

		public String getCilindrada() {
			return cilindrada;
		}

		public void setCilindrada(String cilindrada) {
			this.cilindrada = cilindrada;
		}

		public String getPotenciahp() {
			return potenciahp;
		}

		public void setPotenciahp(String potenciahp) {
			this.potenciahp = potenciahp;
		}

		public String getTorque() {
			return torque;
		}

		public void setTorque(String torque) {
			this.torque = torque;
		}

		public String getPesobruto() {
			return pesobruto;
		}

		public void setPesobruto(String pesobruto) {
			this.pesobruto = pesobruto;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public int getEstadoregistro() {
			return estadoregistro;
		}

		public void setEstadoregistro(int estadoregistro) {
			this.estadoregistro = estadoregistro;
		}

		public TipoVehiculos getTipovehiculos() {
			return tipovehiculos;
		}

		public void setTipovehiculos(TipoVehiculos tipovehiculos) {
			this.tipovehiculos = tipovehiculos;
		}

		@Override
		public String toString() {
			return "Vehiculos [idvehiculo=" + idvehiculo + ", marca=" + marca + ", modelo=" + modelo + ", fechaingreso="
					+ fechaingreso + ", precio=" + precio + ", cilindrada=" + cilindrada + ", potenciahp=" + potenciahp
					+ ", torque=" + torque + ", pesobruto=" + pesobruto + ", imagen=" + imagen + ", estadoregistro="
					+ estadoregistro + ", tipovehiculos=" + tipovehiculos + "]";
		}
		  
		  
	      	  
		
		  
		  
		  
		  }
		 