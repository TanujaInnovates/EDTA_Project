package com.example.Export.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Export.repo.InvoiceRespository;
import com.example.Export.Model.Invoice;
import java.util.List;

@Service
public class InvoiceService {
	
	 @Autowired
	    private InvoiceRespository invoiceRepository;

	    // Method to search products by name
	    public List<Invoice> searchProducts(String name) {
	        return invoiceRepository.findByNameContainingIgnoreCase(name);
	    }

}
