package vk.bot.actors

import akka.actor.{Actor, ActorLogging, Props}
import vk.bot.actors.ParserSupervisor.Config
import vk.bot.utils.StringIterator

class ParserSupervisor(config: Config) extends Actor with ActorLogging {
  
  val stringBrute = StringIterator(config.minIdLen, config.maxIdLen, config.allowedChars)
  
  override def preStart(): Unit = {
    super.preStart()
    
  }
  
  override def receive: Receive = {
    case other => log.warning(s"Find unexpected command: $other")
  }
  
}

object ParserSupervisor {
  
  val defaultConfig = Config(5, 32, ('a' to 'z') ++ ('0' to '9') :+ '_', 5)
  
  def prop(): Props = Props(classOf[ParserSupervisor], defaultConfig)
  def prop(config: Config): Props = Props(classOf[ParserSupervisor], config)
  
  case class Config(
    minIdLen: Int,
    maxIdLen: Int,
    allowedChars: Seq[Char],
    children: Int
  )
  
}
