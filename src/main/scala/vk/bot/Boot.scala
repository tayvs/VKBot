package vk.bot

import akka.actor.ActorSystem
import akka.util.Timeout
import scala.concurrent.duration._
import vk.bot.actors.ParserSupervisor

object Boot extends App {
  
  val timeout = Timeout(3 seconds)
  val system = ActorSystem("VKParser")
  
  val vkParsingSupervisor = system.actorOf(
    props = ParserSupervisor.prop(),
    name = "ParserSupervisor"
  )
  
  val minIdLength = 5
  val maxIdLength = 32
  val allowedCharacters = ('a' to 'z') ++ ('0' to '9') :+ '_'
  
}
