package age

import org.junit.Test
import org.junit.Assert

class AgeSuite {
  val atila = new Guerrero()
  val unaMuralla = new Muralla()
  val unMisil = new Misil()

  @Test
  def unGuerreroAtacaAOtroGuerrero(): Unit = {
    val conan = new Guerrero()

    atila.atacarA(conan)

    Assert.assertEquals(80, conan.energia)
  }

  @Test
  def unGuerreroAtacaAUnaMuralla(): Unit = {
    atila.atacarA(unaMuralla)

    Assert.assertEquals(280, unaMuralla.energia)
  }

  @Test
  def unMisilAtacaAUnaMuralla(): Unit = {
    unMisil.atacarA(unaMuralla)

    Assert.assertEquals(0, unaMuralla.energia)
  }

  @Test
  def ataquesMultiplesAUnaMuralla(): Unit = {
    val atacantes = List(atila, unMisil)

    for (atacante <- atacantes) {
      atacante.atacarA(unaMuralla)
    }

    Assert.assertEquals(0, unaMuralla.energia)
  }

  @Test
  def guerreroDescansaComoAtacante(): Unit = {
    atila.descansar()
    Assert.assertEquals(60, atila.potencialOfensivo)
  }

  @Test
  def guerreroDescansaComoDefensor(): Unit = {
    atila.descansar()
    atila.m
    Assert.assertEquals(110, atila.energia)
  }

  @Test
  def murallaDescansaComoDefensor(): Unit = {
    unaMuralla.descansar
    Assert.assertEquals(310, unaMuralla.energia)
  }

  @Test
  def misilDescansaComoAtacante(): Unit = {
    unMisil.descansar()
    Assert.assertEquals(1990*2, unMisil.potencialOfensivo)
  }

}