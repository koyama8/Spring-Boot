package med.voll.api.domain.medico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MedicoRepository por estar herdando os do JPA, possui todos os metodo de salvar,incluir e mostrar
 */
public interface MedicoRepository extends JpaRepository<Medico,Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
