package age

trait Defensor {
  def energiaInicial: Int

  var energia: Int = energiaInicial

  def perderEnergia(cantidad: Int): Unit = {
    energia = (energia - cantidad).max(0)
  }

  def potencialDefensivo: Int

  def descansar() = this.energia += 10
  
  def m: Unit = {
    println("DM")
  }
}

object Muralla {
  val ENERGIA_MAXIMA_MURALLA = 300
}

class Muralla(cantidadLadrillos: Int = 1000)
    extends Defensor {
  def energiaInicial = 300
  def energiaPerdida = Muralla.ENERGIA_MAXIMA_MURALLA - energia
  def potencialDefensivo: Int = (cantidadLadrillos - energiaPerdida) / 100
}

class Guerrero(
    val potencialOfensivoBase: Int = 30,
    val potencialDefensivo: Int = 10,
    val energiaInicial: Int = 100) extends Atacante with Defensor {
   
  override def descansar() = {
    super[Defensor].descansar()
    super[Atacante].descansar()
  }
  
  override def m() = {
    super[Atacante].m
    super[Defensor].m
  }
}

trait SuperAtacante {
  def m: Unit = {
    println("SAM")
  }
}

trait Atacante extends SuperAtacante {
  def potencialOfensivoBase: Int

  def potencialOfensivo = if (descansado) potencialOfensivoBase * 2 else potencialOfensivoBase

  var descansado = false

  def atacarA(defensor: Defensor): Unit = {
    if (this.potencialOfensivo >= defensor.potencialDefensivo) {
      defensor.perderEnergia(this.potencialOfensivo - defensor.potencialDefensivo)
    }
    descansado = false
  }

  def descansar() = {
    descansado = true
  }
}

class Misil(kgDeTNT: Int = 10) extends Atacante {
  def potencialOfensivoBase: Int = kgDeTNT * 199
}