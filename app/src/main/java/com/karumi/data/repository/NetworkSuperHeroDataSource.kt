package com.karumi.data.repository

import com.karumi.domain.model.DomainError
import com.karumi.domain.model.SuperHero
import com.karumi.domain.model.UnknownDomainError
import org.funktionale.either.Either

class NetworkSuperHeroDataSource : SuperHeroDataSource {
    override fun get(key: String): Either<DomainError, SuperHero> =
        Either.left(UnknownDomainError())

    override fun isUpdated(): Boolean = true

    override fun getAll(): Either<DomainError, List<SuperHero>> =
        Either.left(UnknownDomainError())

}