package com.scrapkarocash.app.viewmodel

import com.scrapkarocash.app.engine.ScrapLogisticsEngine
import com.scrapkarocash.app.models.PickupRequest

class MainViewModel {

    private val logisticsEngine = ScrapLogisticsEngine()
    private val activeRequests = mutableListOf<PickupRequest>()

    fun loadDashboardData(): List<PickupRequest> {
        return activeRequests.toList()
    }

    fun submitNewPickup(
        id: String,
        segment: String,
        material: String,
        weight: Double,
        address: String
    ): Boolean {
        val request = PickupRequest(
            requestId = id,
            segment = segment,
            materialType = material,
            weightKg = weight,
            address = address,
            timestamp = System.currentTimeMillis(),
            status = "PENDING_DISPATCH"
        )
        val success = logisticsEngine.queuePickup(request)
        if (success) {
            activeRequests.add(request)
        }
        return success
    }

    fun fetchB2GComplianceReport(requestId: String): Map<String, Any> {
        return logisticsEngine.processB2GCompliance(requestId)
    }

    fun calculateTotalPendingPayouts(): Double {
        return logisticsEngine.calculateBatchPayout()
    }
}
