package com.cairiton.mega.pessoa;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaDtoConfig {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public PessoaDto toModel(final Pessoa pessoa) {
        return this.modelMapper.map(pessoa, PessoaDto.class);
    }
    
    public List<PessoaDto> toCollectionModel(final List<Pessoa> pessoas) {
        return pessoas.stream().map(this::toModel).collect(Collectors.toList());
    }
    
}
