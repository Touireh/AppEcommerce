package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDaoI;
import com.ecommerce.microcommerce.web.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.microcommerce.web.model.Produit;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductDaoI produitDao;
    @RequestMapping(value="/Produits",method= RequestMethod.GET)
    public List<Produit>listeProduits(){
        return produitDao.findAll();
    }
//    public String listeProduits(){
//        return "Ceci est exemple de produit";
//    }
//    @RequestMapping(value="/Produits/{id}", method= RequestMethod.GET)
//
//    public String afficherUnProduit(@PathVariable int id)
//    {
//        return"Ceci est le produit avec l'id " +id;
//    }
    @GetMapping(value="/Produits/{id}")
    public Produit afficherUnProduit(@PathVariable int id){
        return produitDao.findById(id);
    }
//    public Produit afficherUnProduit(@PathVariable int id ){
//        Produit produit = new Produit();
//        produit.setId(id);
//        produit.setNom("Aspirateur");
//        produit.setPrix(100);
//
////        Produit produit = new Produit(id, new String("Aspirateur"), 100 );
//
//        return produit;
//    }
    @GetMapping(value = "Delete/{id}")
    public ResponseEntity<?> supprimerUnProduit(@PathVariable int id) {
        Produit produitSupprime = produitDao.delete(id);
        if (produitSupprime != null) {
            return ResponseEntity.ok("Produit supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping(value = "/Produits/{id}")
    public ResponseEntity<?> mettreAJourProduit(@PathVariable int id, @RequestBody Produit updatedProduct) {
        Produit produitMisAJour = produitDao.update(id, updatedProduct);

        if (produitMisAJour != null) {
            return ResponseEntity.ok("Produit mis à jour avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
