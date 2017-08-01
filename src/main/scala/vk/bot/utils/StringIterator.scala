package vk.bot.utils

import scala.collection.immutable

class StringIterator(startValue: Array[Int], toLength: Int, chars: Seq[Char]) extends Iterable[String] {
  
  override def iterator: Iterator[String] = new Iterator[String] {
    
    /** Count of all variants */
    override val length: Long = math.pow(chars.length, toLength).toLong
    var position: Long = 0L
    
    val buf: Array[Int] = startValue
    
    def inc(arr: Array[Int], i: Int = 0): Unit =
      if (arr(i) == (chars.size - 1)) {
        arr(i) = 0
        inc(arr, i + 1)
      }
      else arr(i) += 1
    
    override def hasNext: Boolean = !buf.forall(_ == (chars.size - 1))
    
    override def next: String = {
      if (position % 1000000 == 0) logProgress()
      
      val str = buf.map(chars(_)).mkString
      
      inc(buf)
      position += 1L
      str
    }
    
    def logProgress(): Unit = {
      println("buffer is " + buf.mkString(" "))
      println("Str " + buf.map(chars(_)).mkString)
      val perCent = position / length * 100
      println(s"calculate $perCent %")
    }
    
  }
  
}

object StringIterator {
  
  val defaultChars: immutable.IndexedSeq[Char] = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9')
  val defaultStartValue: (Int) => Array[Int] = new Array[Int](_)
  
  def apply(startValue: Array[Int], toLength: Int, chars: Seq[Char]): StringIterator =
    new StringIterator(startValue, toLength, chars)
  
  def apply(startLen: Int, toLength: Int, chars: Seq[Char]): StringIterator =
    new StringIterator(defaultStartValue(startLen), toLength, chars)
  
  def apply(toLength: Int): StringIterator =
    new StringIterator(defaultStartValue(toLength), toLength, defaultChars)
  
  def apply(toLength: Int, chars: Seq[Char]): StringIterator =
    new StringIterator(defaultStartValue(toLength), toLength, chars)
  
}
