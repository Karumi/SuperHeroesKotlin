package com.karumi.data.repository

import com.karumi.domain.model.DomainError
import com.karumi.domain.model.NotIndexFoundDomainError
import com.karumi.domain.model.SuperHero
import org.funktionale.either.Either


class MemorySuperHeroDataSource : SuperHeroDataSource {
  private val cache = LinkedHashMap<String, SuperHero>()

  override fun get(key: String): Either<DomainError, SuperHero> =
      cache[key]?.let { Either.right(it) }
          ?: Either.left(NotIndexFoundDomainError(key))


  override fun getAll(): Either<DomainError, List<SuperHero>> =
      Either.right(ArrayList(cache.values))

  override fun populate(superHeroes: List<SuperHero>) =
      cache.putAll(superHeroes.map { it.name to it })

}