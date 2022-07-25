package EC3.sandytejada.HospitalIdat.Service;

import java.util.ArrayList;
import java.util.List;
import EC3.sandytejada.HospitalIdat.dto.HospitalDTOResponse;
import EC3.sandytejada.HospitalIdat.dto.HospitalDTORequest;
import EC3.sandytejada.HospitalIdat.model.Hospital;
import EC3.sandytejada.HospitalIdat.Repository.HospitalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		
		Hospital p = new Hospital();
		p.setNombre(hospital.getNombre());
		p.setDescripcion(hospital.getDescripcion());
		p.setDistrito(hospital.getDistrito());
		repository.save(p);
	}

	@Override
	public void actualizarHospital(HospitalDTORequest  hospital) {
		// TODO Auto-generated method stub
		
		Hospital p = new Hospital();
		p.setIdHospital(hospital.getIdHospital());
		p.setNombre(hospital.getNombre());
		p.setDescripcion(hospital.getDescripcion());
		p.setDistrito(hospital.getDistrito());

		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarHospital(Integer idHospital) {
		// TODO Auto-generated method stub
		repository.deleteById(idHospital);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		
		List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> p = repository.findAll();
		
		for (Hospital hospital : p) {
			
			dto = new HospitalDTOResponse();
			dto.setIdHospital(hospital.getIdHospital());
			dto.setNombre(hospital.getNombre());
			dto.setDescripcion(hospital.getDescripcion());
			dto.setDistrito(hospital.getDistrito());
			
			listar.add(dto);
		}
		
		return listar;
	}
			
		
	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer idHospital) {
		// TODO Auto-generated method stub
		
		Hospital hospital = repository.findById(idHospital).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setIdHospital(hospital.getIdHospital());
		dto.setNombre(hospital.getNombre());
		dto.setDescripcion(hospital.getDescripcion());
		dto.setDistrito(hospital.getDistrito());
		
		return dto;
	}


}
