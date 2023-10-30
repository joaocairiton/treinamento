package com.cairiton.mega.compra;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraDtoConfig {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public CompraDto toModel(final Compra compra) {
        return this.modelMapper.map(compra, CompraDto.class);
    }
    
    public List<CompraDto> toCollectionModel(final List<Compra> compras) {
        return compras.stream().map(this::toModel).collect(Collectors.toList());
        
    }
    
}
