package com.karumi.domain.model

sealed class DomainError
class NotInternetDomainError : DomainError()
data class UnknownDomainError(val errorMessage: String = "Unknown Error") : DomainError()
data class NotIndexFoundDomainError(val key: String) : DomainError()
class AuthDomainError : DomainError()
