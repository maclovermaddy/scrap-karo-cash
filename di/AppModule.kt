package com.scrapkarocash.app.di

import com.scrapkarocash.app.engine.ScrapLogisticsEngine

object AppModule {
    val logisticsEngine: ScrapLogisticsEngine by lazy {
        ScrapLogisticsEngine()
    }
}
