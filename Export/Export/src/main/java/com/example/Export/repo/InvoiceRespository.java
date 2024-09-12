package com.example.Export.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Export.Model.Invoice;

import java.util.List;

@Repository
public interface InvoiceRespository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByNameContainingIgnoreCase(String name);

}
