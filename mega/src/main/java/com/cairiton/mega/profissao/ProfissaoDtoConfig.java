package com.cairiton.mega.profissao;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfissaoDtoConfig {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public ProfissaoDto toModel(final Profissao profissao) {
        return this.modelMapper.map(profissao, ProfissaoDto.class);
    }
    
    public List<ProfissaoDto> toCollectionModel(final List<Profissao> profissoes) {
        return profissoes.stream().map(this::toModel).collect(Collectors.toList());
    }
    
}
