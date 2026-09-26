package com.scrapkarocash.app.engine

import com.scrapkarocash.app.models.PickupRequest

class ScrapValuationEngine {
    
    fun calculatePayout(request: PickupRequest): Double {
        val baseRatePerKg = when (request.segment.uppercase()) {
            "B2C" -> 22.50
            "B2B" -> 35.00
            "B2G" -> 30.00
            else -> 18.00
        }
        
        val bulkMultiplier = if (request.weightKg > 500) 1.15 else 1.0
        return request.weightKg * baseRatePerKg * bulkMultiplier
    }

    fun generateAuditLog(request: PickupRequest): String {
        return "AUDIT_LOG | ID: ${request.requestId} | Segment: ${request.segment} | Status: ${request.status}"
    }
}
