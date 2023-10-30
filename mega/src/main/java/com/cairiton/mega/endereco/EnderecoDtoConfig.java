package com.cairiton.mega.endereco;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDtoConfig {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public EnderecoDto toModel(final Endereco endereco) {
        return this.modelMapper.map(endereco, EnderecoDto.class);
    }
    
    public List<EnderecoDto> toCollectionModel(final List<Endereco> enderecos) {
        return enderecos.stream().map(this::toModel).collect(Collectors.toList());
    }
    
}
