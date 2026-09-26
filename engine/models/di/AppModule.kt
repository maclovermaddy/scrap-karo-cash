package com.scrapkarocash.app.di

import com.scrapkarocash.app.engine.ScrapLogisticsService
import com.scrapkarocash.app.engine.ScrapValuationEngine

object AppModule {
    val valuationEngine: ScrapValuationEngine by lazy {
        ScrapValuationEngine()
    }

    val logisticsService: ScrapLogisticsService by lazy {
        ScrapLogisticsService()
    }
}
