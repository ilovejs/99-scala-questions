object P05 extends App {
  //built-in
  def reverseB[A] (ls: List[A]): List[A] = ls.reverse
  
  // Simple recursive.  O(n^2)
  def reverse[A] (ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case x :: tail => reverse(tail) ::: List(x) 
  }
  
  // Tail recursive.
  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil       => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }

  // Pure functional
  def reverseFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) => h :: r }
}