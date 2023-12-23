package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MedicoRepository por estar herdando os do JPA, possui todos os metodo de salvar,incluir e mostrar
 */
public interface MedicoRepository extends JpaRepository<Medico,Long> {

}
