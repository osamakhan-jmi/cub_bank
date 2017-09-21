package com.cubbank.service;

import com.cubbank.cubentity.BankAsset;
import com.cubbank.repository.IBankAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAssetService implements IBankAssetService {

    private IBankAssetRepository bankAssetRepository;

    @Autowired
    public BankAssetService(IBankAssetRepository bankAssetRepository){
        this.bankAssetRepository = bankAssetRepository;
    }

    @Override
    public Iterable<BankAsset> getBankAsset() {
        return bankAssetRepository.findAll();
    }
}
