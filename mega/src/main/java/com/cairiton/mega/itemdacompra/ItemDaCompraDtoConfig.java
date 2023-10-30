package com.cairiton.mega.itemdacompra;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemDaCompraDtoConfig {
    
    @Autowired
    private ModelMapper modelMapper;
    
    public ItemDaCompraDTO toModel(final ItemDaCompra itemDeCompra) {
        return this.modelMapper.map(itemDeCompra, ItemDaCompraDTO.class);
    }
    
    public List<ItemDaCompraDTO> toCollectionModel(final List<ItemDaCompra> itensDeCompras) {
        return itensDeCompras.stream().map(this::toModel).collect(Collectors.toList());
        
    }
    
}
