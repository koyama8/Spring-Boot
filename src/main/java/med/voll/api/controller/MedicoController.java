package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    /**
      - Valid seria as validações feitas pelo DadosCastro


     */
    @PostMapping
    @Transactional

    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

       repository.save(new Medico(dados));
    }

    //Converte pra uma lista de Medico para DadosListagemMedico
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
      return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional//Trecho de código sera rodeado na transação, na JPA ele mesmo faz a atualização
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
       var medico = repository.getReferenceById(dados.id());
       medico.atualizarInformacoes(dados);
    }

    /**

     - metodo que excluir diretamento do banco

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
         repository.deleteById(id);
   }
    */

     //Exclusão Lógica
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
         medico.excluir();
    }
}
