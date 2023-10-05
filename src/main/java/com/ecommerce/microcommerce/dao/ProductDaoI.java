package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.web.model.Produit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoI implements ProductDao{
    public static List<Produit>produits=new ArrayList<>();
    static {
        produits.add(new Produit(1,new String("PC") , 8500));
        produits.add(new Produit(2,new String("Aspirateu") , 500));
        produits.add(new Produit(3,new String("Table") , 850));

    }


    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for( Produit produit : produits){
            if (produit.getId()== id)
            {
                return produit;
            }
        }
        return null;
    }

    @Override
    public Produit save(Produit produit) {
        produits.add(produit);
        return produit;
    }
    @Override
    public Produit delete(int id) {
        Produit produitToDelete = null;
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                produitToDelete = produit;
                break;
            }
        }
        if (produitToDelete != null) {
            produits.remove(produitToDelete);
        }
        return produitToDelete;
    }
    @Override
    public Produit update(int id, Produit product) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                produit.setNom(product.getNom());
                produit.setPrix(product.getPrix());
                return produit;
            }
        }
        return null;
    }


}
