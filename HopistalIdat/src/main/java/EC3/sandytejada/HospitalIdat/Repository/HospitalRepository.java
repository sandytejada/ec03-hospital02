package EC3.sandytejada.HospitalIdat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC3.sandytejada.HospitalIdat.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital,Integer>{

}
