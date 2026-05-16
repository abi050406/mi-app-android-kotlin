package com.example.curso

data class Device(
    val id: Long,
    val name: String,
    val data: Specs?
)

data class Specs(
    val color: String?,
    val capacity: String?
)