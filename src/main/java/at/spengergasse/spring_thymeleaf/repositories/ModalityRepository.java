package at.spengergasse.spring_thymeleaf.repositories;

import at.spengergasse.spring_thymeleaf.entities.Modality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalityRepository extends JpaRepository<Modality, Integer> {
}
