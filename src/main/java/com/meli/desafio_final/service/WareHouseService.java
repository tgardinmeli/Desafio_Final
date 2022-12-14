package com.meli.desafio_final.service;

import com.meli.desafio_final.exception.NotFoundException;
import com.meli.desafio_final.model.SellerAd;
import com.meli.desafio_final.model.Warehouse;
import com.meli.desafio_final.repository.IWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseService implements IWarehouseService{

    @Autowired
    private IWarehouseRepository warehouseRepository;

    /**
     * Show the total of ad's in a warehouse
     * @param sellerAdId can be search by de id's
     * @param wareHouseId the information about the warehouse
     * @return a quantity of ad's.
     */
    @Override
    public long getTotalQuantitySellerAdinWareHouse(SellerAd sellerAdId, Warehouse wareHouseId) {
        long quantityProducts = warehouseRepository.getAllProducts(sellerAdId.getSellerAdId(), wareHouseId.getWarehouseId());
        if (quantityProducts == 0){
            throw new NotFoundException("Produto não existe em nenhum depósito");
        }
        return quantityProducts;
    }
}
