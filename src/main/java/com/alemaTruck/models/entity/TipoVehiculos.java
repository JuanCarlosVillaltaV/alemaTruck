
  package com.alemaTruck.models.entity;
  
  import java.io.Serializable;
  
  import jakarta.persistence.Entity; import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType; import jakarta.persistence.Id;
  import jakarta.persistence.Table;
  
  @Entity
  
  @Table(name = "tipovehiculos")
  
  public class TipoVehiculos implements Serializable {
  
 /**
	* 
	*/
		  private static final long serialVersionUID = 1L;
		  
			@Id

			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int idtipovehiculo;
			private String nombretipo;
			private String descripcion;
			private int estadoregistro;

			public int getIdtipovehiculo() {
				return idtipovehiculo;
			}

			public void setIdtipovehiculo(int idtipovehiculo) {
				this.idtipovehiculo = idtipovehiculo;
			}

			public String getNombretipo() {
				return nombretipo;
			}

			public void setNombretipo(String nombretipo) {
				this.nombretipo = nombretipo;
			}

			public String getDescripcion() {
				return descripcion;
			}

			public void setDescripcion(String descripcion) {
				this.descripcion = descripcion;
			}

			public int getEstadoregistro() {
				return estadoregistro;
			}

			public void setEstadoregistro(int estadoregistro) {
				this.estadoregistro = estadoregistro;
			}
		  
		  @Override public String toString() { return "TipoVehiculos [idtipovehiculo="
		  + idtipovehiculo + ", nombretipo=" + nombretipo + ", descripcion=" +
		  descripcion + ", estadoregistro=" + estadoregistro + "]"; }
		  
		  
		  }
		 