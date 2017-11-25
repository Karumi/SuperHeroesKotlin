package com.karumi.common

import org.funktionale.either.Either

fun <L, R> Either<L, R>.optionalRight() = this.component2()
fun <L, R> Either<L, R>.optionalLeft() = this.component1()