package com.scrapkarocash.app.test

import com.scrapkarocash.app.engine.ScrapValuationEngine
import com.scrapkarocash.app.models.PickupRequest

class ScrapValuationEngineTest {

    fun testB2CPayoutCalculation() {
        val engine = ScrapValuationEngine()
        val request = PickupRequest("REQ_001", "B2C", "Copper", 10.0, "Delhi", System.currentTimeMillis(), "PENDING")
        val payout = engine.calculatePayout(request)
        assert(payout > 0.0)
    }

    fun testB2GBulkPayoutCalculation() {
        val engine = ScrapValuationEngine()
        val request = PickupRequest("REQ_002", "B2G", "Municipal Iron", 600.0, "Zone 4", System.currentTimeMillis(), "PENDING")
        val payout = engine.calculatePayout(request)
        assert(payout > 15000.0)
    }
}
