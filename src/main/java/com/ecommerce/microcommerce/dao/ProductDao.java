package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.web.model.Produit;

import java.util.List;

public interface ProductDao {

    public List<Produit>findAll();
    public Produit findById(int id);
    public Produit save(Produit product);

    public Produit delete(int id);

    public Produit update(int id, Produit product);
}
