package net.lrr.calculadora

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform