package com.cairiton.mega.pessoa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
    
    Optional<Pessoa> findByCpf(String cpf);
    
}
