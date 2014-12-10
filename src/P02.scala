//Find the last but one element of a list.
/*
object P02 extends App {
	//penultimate(List(1, 1, 2, 3, 5, 8))
	def penultimate[A](ls: List[A]): A = ls match {
	  case h :: Nil      => throw new Error("Not enough elements")
	  case h :: g :: Nil => h
	  case _ :: tail     => penultimate(tail)
	  case _             => throw new NoSuchElementException 
	}
	
	println(penultimate(List(1, 1, 2, 3, 5, 8)))
	println(penultimate(List(1, 9)))
//	print(penultimate(List(8)))
	print(penultimate(List(Nil)))

}*/

object P02 extends App {
  // built-ins
  def penultimateBuiltin[A](ls: List[A]): A =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  // But pattern matching also makes it easy.
  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException
  }
  
  
  // Just for fun, let's look at making a generic lastNth function.

  // An obvious modification of the builtin solution works.
  def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n <= 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    ls.takeRight(n).head
  }

  //Count from right
  def lastNthRecursive[A](n: Int, ls: List[A]): A = {
    
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =  curList match {
        case Nil if count > 0 => throw new NoSuchElementException   //Exception case
        case Nil              => resultList.head                    //base case return value
        case _ :: tail        => lastNthR(count - 1,
                                          if (count > 0) resultList else resultList.tail,
                                          tail)
    }
    //entry point
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }
  
  /*def lastNthRecursive2[A](n: Int, ls: List[A]): A = {
    var i = 0;
    for( i <- 0 until ls.length){
      return ls();
    }
    
  }*/

  println(lastNthBuiltin(3, List(1,2,3,4,5)))
  println(lastNthRecursive(2, List(1,2,3,4,5)))
}