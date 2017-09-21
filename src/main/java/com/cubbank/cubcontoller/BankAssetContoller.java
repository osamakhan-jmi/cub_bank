package com.cubbank.cubcontoller;

import com.cubbank.cubentity.Bank;
import com.cubbank.cubentity.BankAsset;
import com.cubbank.service.BankAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import java.util.Date;


@Entity
@RequestMapping("/cubbank")
public class BankAssetContoller {

    private BankAssetService bankAssetService;

    @Autowired
    public BankAssetContoller(BankAssetService bankAssetService){
        this.bankAssetService = bankAssetService;
    }

    @RequestMapping(path = "/bank/asset", method = RequestMethod.POST)
    public @ResponseBody Iterable<BankAsset> getBankAsset(@RequestParam("fromdate") Date from,
                                                          @RequestParam("todate") Date to){
        Iterable<BankAsset> asset = bankAssetService.getBankAsset();
        for(BankAsset ba : asset){
            if((ba.getAssetTime().compareTo(from)>=0) && ba.getAssetTime().compareTo(to)<=0)
                continue;
            else{

            }
        }

        return asset;
    }
}
