package com.scrapkarocash.app.models

data class B2GManifest(
    val manifestId: String,
    val municipalZone: String,
    val totalWeightTons: Double,
    val wasteType: String,
    val environmentalApprovalCode: String,
    val isVerified: Boolean
)
