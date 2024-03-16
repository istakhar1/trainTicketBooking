package com.tricket.trainTicket.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReceiptService {
	  private List<ReceiptDTO> receiptList = new ArrayList<>();

	    public void addReceipt(ReceiptDTO receiptDTO) {
	        receiptList.add(receiptDTO);
	    }

	    public ReceiptDTO getReceiptDetails(Long userId) {
	        for (ReceiptDTO receipt : receiptList) {
	            if (receipt.getUser().equals(userId)) {
	                return receipt;
	            }
	        }
	        return null; // User not found
	    }
}
