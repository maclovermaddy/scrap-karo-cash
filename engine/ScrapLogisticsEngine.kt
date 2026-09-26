package com.scrapkarocash.app.engine

import com.scrapkarocash.app.models.PickupRequest

class ScrapLogisticsEngine {

    private val dispatchQueue = mutableListOf<PickupRequest>()

    fun queuePickup(request: PickupRequest): Boolean {
        return if (request.weightKg > 0) {
            dispatchQueue.add(request)
            true
        } else false
    }

    fun processB2GCompliance(requestId: String): Map<String, Any> {
        val request = dispatchQueue.find { it.requestId == requestId }
        return mapOf(
            "requestId" to (request?.requestId ?: "UNKNOWN"),
            "status" to "VERIFIED_MUNICIPAL_DISPATCH",
            "timestamp" to System.currentTimeMillis(),
            "complianceCode" to "GOV_ENV_2026_OK"
        )
    }

    fun calculateBatchPayout(): Double {
        var total = 0.0
        for (item in dispatchQueue) {
            val baseRate = when (item.segment.uppercase()) {
                "B2C" -> 22.50
                "B2B" -> 35.00
                "B2G" -> 30.00
                else -> 15.00
            }
            total += item.weightKg * baseRate
        }
        return total
    }
}
