package com.scrapkarocash.app.models

data class B2GManifest(
    val manifestId: String,
    val municipalZone: String,
    val grossWeightTons: Double,
    val wasteCategory: String,
    val complianceLicenseHash: String,
    val verifiedByInspector: Boolean
)
