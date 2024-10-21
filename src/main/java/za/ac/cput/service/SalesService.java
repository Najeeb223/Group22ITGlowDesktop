package za.ac.cput.service;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Sales;

import za.ac.cput.repository.SalesRepository;

import java.util.List;
@Service
public class SalesService implements ISalesService{

    private final SalesRepository repository;

    @Autowired
    SalesService(SalesRepository repository){
        this.repository= repository;
    }


    @Override
    public Sales create(Sales sales) {
        return this.repository.save(sales);
    }

    @Override
    public Sales read(String salesID) {
        return this.repository.findById(salesID).orElse(null);
    }

    @Override
    public Sales update(Sales sales) {
        if( this.repository.existsById(sales.getSalesID()))
            return this.repository.save(sales);
        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

   /* @Override
    public boolean delete(String salesID) {
        if (this.repository.existsById(salesID)){
            this.repository.deleteById(salesID);
            return true;
        }
        return false;
    }


    @Override
    public List<Sales> getAll() {
        return this.repository.findAll();
    }

}
 */