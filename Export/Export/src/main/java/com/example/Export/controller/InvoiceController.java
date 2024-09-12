package com.example.Export.controller;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Export.Model.Invoice;
import com.example.Export.Service.InvoiceService;
import com.example.Export.repo.InvoiceRespository;


@RestController
@RequestMapping("/invoices")
//@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
	
	@Autowired
	 private InvoiceRespository invoiceRepository;
	 
	 @PostMapping("/create")
	 public Invoice createInvoice(@RequestBody Invoice payload) {
		   System.out.println("ok");
	   return invoiceRepository.save(payload);
	
	 }

	 @GetMapping("/all")
	 public List<Invoice> getInvoices() {
		 System.out.println("data fetched");
	   return invoiceRepository.findAll();
	 }
	    @GetMapping("getinvoice/{id}")
	    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
	        Optional<Invoice> invoice = invoiceRepository.findById(id);
	        return invoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }


	 @PostMapping("/update/{id}")
	 public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoiceDetails) {
	     Invoice invoice = invoiceRepository.findById(id)
	    		 .orElseThrow();

	         // Update fields
	         invoice.setInvoiceNo(invoiceDetails.getInvoiceNo());
	         invoice.setInvoiceDate(invoiceDetails.getInvoiceDate());
	         invoice.setInvoiceDueDate(invoiceDetails.getInvoiceDueDate());
	         invoice.setOrderId(invoiceDetails.getOrderId());
	         invoice.setOrderDate(invoiceDetails.getOrderDate());
	         invoice.setOrderStatus(invoiceDetails.getOrderStatus());
	         invoice.setShipFrom(invoiceDetails.getShipFrom());
	         invoice.setShipTo(invoiceDetails.getShipTo());
	         invoice.setBillOfLading(invoiceDetails.getBillOfLading());
	         invoice.setShipDate(invoiceDetails.getShipDate());
	         invoice.setName(invoiceDetails.getName());
	         invoice.setAddress(invoiceDetails.getAddress());
	         invoice.setEmail(invoiceDetails.getEmail());
	         invoice.setPhoneNumber(invoiceDetails.getPhoneNumber());
	         invoice.setProductDes(invoiceDetails.getProductDes());
	         invoice.setQuantity(invoiceDetails.getQuantity());
	         invoice.setPrice(invoiceDetails.getPrice());
	         invoice.setTotal(invoiceDetails.getTotal());
	         invoice.setSubTotal(invoiceDetails.getSubTotal());
	         invoice.setTax(invoiceDetails.getTax());
	         invoice.setTotal1(invoiceDetails.getTotal1());
	         invoice.setNotes(invoiceDetails.getNotes());

	         // Save the updated invoice
	         Invoice updatedInvoice = invoiceRepository.save(invoice);
	         return ResponseEntity.ok(updatedInvoice);
	     } 
	 

	 @DeleteMapping("/delinvoice/{id}")
	 public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
	   invoiceRepository.deleteById(id);
	   return ResponseEntity.noContent().build();
	 }

	    
//	    @GetMapping("/invoice/search")
//	    public List<Invoice> searchInvoices(@RequestParam String name) {
//	        return InvoiceService.searchInvoices(name);
//	    }
	
}
