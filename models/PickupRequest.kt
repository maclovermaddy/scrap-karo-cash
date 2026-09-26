package com.scrapkarocash.app.models

data class PickupRequest(
    val requestId: String,
    val segment: String, // B2C, B2B, or B2G
    val materialType: String,
    val weightKg: Double,
    val address: String,
    val timestamp: Long,
    val status: String // Pending, Dispatched, Completed
)
