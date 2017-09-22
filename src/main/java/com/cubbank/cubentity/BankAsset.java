package com.cubbank.cubentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "bankasset")
public class BankAsset {

    @Id
    @Column(name = "cub_bank_asset_time")
    private Date assetTime;
    @Column(name = "cub_bank_asset")
    private double asset;

    public Date getAssetTime() {
        return assetTime;
    }

    public double getAsset() {
        return asset;
    }
}
