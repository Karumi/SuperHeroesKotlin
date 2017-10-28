package com.karumi.domain.model

sealed class DomainError
class NotInternetDomainError() : DomainError()
data class UnknowDomainError(val errorMessage: String = "Unknow Error") : DomainError()
data class NotIndexFoundDomainError(val key: String) : DomainError()

