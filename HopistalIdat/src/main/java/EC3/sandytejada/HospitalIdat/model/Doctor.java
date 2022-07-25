package EC3.sandytejada.HospitalIdat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "Doctores")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDoctor;
	private String doctor;
	private Integer numero;
	
	@ManyToMany( cascade= {CascadeType.PERSIST,CascadeType.MERGE} )
	@JoinTable(
			name ="doctor_hospital",
			joinColumns = @JoinColumn(
					name = "id_hopital", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = 
			"foreign key (id_hopital) references Hospitales(id_hopital)")
			),
					inverseJoinColumns = @JoinColumn(
							name = "id_doctor", 
							nullable = false, 
							unique = true, 
							foreignKey = @ForeignKey(foreignKeyDefinition = 
					"foreign key (id_doctor) references Doctores(id_doctor)")
					)
	
			)
	private List<Hospital> Hospital= new ArrayList<>();
	
	public Integer getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(Integer idDoctor) {
		this.idDoctor = idDoctor;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
