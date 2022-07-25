package EC3.sandytejada.HospitalIdat.Service;

import java.util.List;
import EC3.sandytejada.HospitalIdat.dto.HospitalDTOResponse;
import EC3.sandytejada.HospitalIdat.dto.HospitalDTORequest;

public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHospital(Integer idHospital);
	List<HospitalDTOResponse> listarHospital();
	HospitalDTOResponse obtenerHospitalId(Integer idHospital);

}
