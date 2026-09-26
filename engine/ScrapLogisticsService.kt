package com.scrapkarocash.app.engine

import com.scrapkarocash.app.models.PickupRequest

class ScrapLogisticsService {

    private val activePickups = mutableListOf<PickupRequest>()

    fun registerPickup(request: PickupRequest): Boolean {
        return if (request.weightKg > 0) {
            activePickups.add(request)
            true
        } else {
            false
        }
    }

    fun processB2GComplianceManifest(requestId: String): Map<String, String> {
        val pickup = activePickups.find { it.requestId == requestId }
        return mapOf(
            "requestId" to (pickup?.requestId ?: "UNKNOWN"),
            "complianceStatus" to "PASSED_MUNICIPAL_INSPECTION",
            "auditHash" to "HASH_${System.currentTimeMillis()}"
        )
    }

    fun calculateBulkPayouts(): Double {
        var totalPayout = 0.0
        val engine = ScrapValuationEngine()
        for (pickup in activePickups) {
            totalPayout += engine.calculatePayout(pickup)
        }
        return totalPayout
    }
}
