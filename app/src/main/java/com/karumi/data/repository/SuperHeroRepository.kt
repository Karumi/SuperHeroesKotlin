package com.karumi.data.repository

import android.util.Log
import com.karumi.domain.model.SuperHero

class SuperHeroRepository(val datasources: List<SuperHeroDataSource>) {

  fun getAllSuperHeroes(): List<SuperHero> {
    waitABit()
    return superHeroes
  }

  fun getByName(name: String): SuperHero {
    waitABit()
    return superHeroes.first { it.name == name }
  }

}