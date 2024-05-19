package com.example.billing.controllers;

import com.example.billing.models.BillingModel;
import com.example.billing.repositories.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/billing-service")
public class BillingController {
    @Autowired
    BillingRepository billingRepository;
    //Metodos

    //crear facturas
    @PostMapping("/crear-factura")
    public ResponseEntity createBilling(@RequestBody BillingModel billingModel){
        billingRepository.save(billingModel);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //buscar todas las facturas
    @GetMapping("/findAll")
    public List<BillingModel> findAllBillings(){
        return billingRepository.findAll();
    }

    //buscar por id
    @GetMapping("findById/{billingId}")
    public ResponseEntity findBillingById(@PathVariable Long billingId){
        return new ResponseEntity(billingRepository.findById(billingId),HttpStatus.OK);
    }

    //borrar factura
    @DeleteMapping("/borrar{billingId}")
    public ResponseEntity deleteBilling(@PathVariable Long billingId){
        billingRepository.deleteById(billingId);
        return new ResponseEntity(HttpStatus.OK);
    }

    //Actualizar factura
    @PutMapping ("/update{billingId}")
    public ResponseEntity updateBilling(@PathVariable Long billingId, @RequestBody Integer nuevoNumeroCliente){
        Optional<BillingModel>optionalBilling = billingRepository.findById(billingId);
        if(optionalBilling.isPresent()){
            BillingModel billingModel = optionalBilling.get();
            billingModel.setNumeroCliente(nuevoNumeroCliente);
            billingRepository.save(billingModel);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
