package EC3.sandytejada.HospitalIdat.model;



import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Recepcionistas")
public class Recepcionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecepcionista;
	private String nombre;
	private Integer celular;
	
	@ManyToOne
	@JoinColumn(
			name = "id_especialidades",
			nullable = false,
			unique = true,
			foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_especialidades) references Especialidad(id_especialidades)")
			)
	private Especialidades especialidades;
	
	
	public Integer getIdRecepcionista() {
		return idRecepcionista;
	}
	public void setIdRecepcionista(Integer idRecepcionista) {
		this.idRecepcionista = idRecepcionista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCelular() {
		return celular;
	}
	public void setCelular(Integer celular) {
		this.celular = celular;
	}
	
	
	
	

}
