package com.cubbank.repository;

import com.cubbank.cubentity.BankAsset;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface IBankAssetRepository extends CrudRepository<BankAsset, Date> {
}
