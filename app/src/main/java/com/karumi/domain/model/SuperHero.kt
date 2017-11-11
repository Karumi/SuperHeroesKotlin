package com.karumi.domain.model

data class SuperHero(
    val id: String,
    val name: String,
    val photo: String?,
    val isAvenger: Boolean,
    val description: String)