package EC3.sandytejada.HospitalIdat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "Hospitales")
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "Hospitales_Especialidades",
			joinColumns = @JoinColumn(
					name = "id_hospital", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = 
			"foreign key (id_hospital) references Hospitales(id_hospital)")
			),
			inverseJoinColumns = @JoinColumn(
					name = "id_especialidades", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = 
			"foreign key (id_especialidades) references Especialidad(id_especialidades)")
			))
	private List<Especialidades> Especialidad =new ArrayList<>();		
			
			
	@ManyToMany	(mappedBy="doctor")
	private List<Doctor> doctor =new ArrayList<>();
	
	
	public Integer getIdHospital() {
		return idHospital;
	}
	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	
	

}
