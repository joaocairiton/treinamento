package com.cairiton.mega.bairro;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BairroDtoConfig {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public BairroDto toModel(final Bairro bairro) {
        return this.modelMapper.map(bairro, BairroDto.class);
    }
    
    public List<BairroDto> toCollectionModel(final List<Bairro> bairros) {
        return bairros.stream()
                .map(this::toModel)
                .collect(Collectors
                        .toList());
    }
}
