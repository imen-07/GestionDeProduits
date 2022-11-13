package tn.enis.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.enis.produits.entities.Categorie;
import tn.enis.produits.entities.Produit;
import tn.enis.produits.repos.ProduitRepository;

@SpringBootTest
class GestionDeProduitsApplicationTests {

	//@Test
	//void contextLoads() {
	//}
	
	
		@Autowired
		private ProduitRepository produitRepository;
		
		@Test
		public void testCreateProduit() {
		Produit prod = new Produit("Clavier",30.0,new Date());
		produitRepository.save(prod);
		}
		
		@Test
		public void testFindProduit()
		{
		Produit p = produitRepository.findById(4L).get();
		System.out.println(p);
		}
		
		@Test
		public void testUpdateProduit()
		{
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(2000.500);
		produitRepository.save(p);
		}
		
		@Test
		public void testDeleteProduit()
		{
		produitRepository.deleteById(8L);;
		}

		@Test
		public void testListerTousProduits()
		{
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods)
		{
		System.out.println(p);
		}
		}
		
		@Test
		public void testFindByNomProduit()
		{
		List<Produit> prods = produitRepository.findByNomProduit("PC Acer");
		for (Produit p : prods)
			System.out.println(p);	
		}
		
		@Test
		public void testFindByNomProduitContains ()
		{
		List<Produit> prods=produitRepository.findByNomProduitContains("PC");
		for (Produit p : prods)
		{
		System.out.println(p);
		} }
		
		@Test
		public void testfindByNomPrix()
		{
		List<Produit> prods = produitRepository.findByNomPrix("PC Acer", 1000.0);
		for (Produit p : prods)
		{
		System.out.println(p);
		}
		}

		@Test
		public void testfindByCategorie()
		{
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods)
		{
		System.out.println(p);
		}
		}

		@Test
		public void findByCategorieIdCat()
		{
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		for (Produit p : prods)
		{
		System.out.println(p);
		}
		 }
		
		@Test
		public void testfindByOrderByNomProduitAsc()
		{
		List<Produit> prods =
		produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
		{
		System.out.println(p);
		}
		}
		
		@Test
		public void testTrierProduitsNomsPrix()
		{
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods)
		{
		System.out.println(p);
		}
		}

		
}


