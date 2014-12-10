object worksheet1 {

  def adder(m: Int, n:Int) = m + n                //> adder: (m: Int, n: Int)Int
  
  //partial application
  val add2 = adder(2, _:Int)                      //> add2  : Int => Int = <function1>
  
  //curried function
  def multiply(m: Int)(n: Int): Int = m * n       //> multiply: (m: Int)(n: Int)Int
  
  multiply(2)(3)                                  //> res0: Int = 6
  
  val timesTwo = multiply(2) _                    //> timesTwo  : Int => Int = <function1>
  
  timesTwo(3)                                     //> res1: Int = 6
  
  //You can take any function of multiple arguments and curry it.
  //Let's try with our earlier adder
  
  //currify
  val curriedAdd = (adder _).curried              //> curriedAdd  : Int => (Int => Int) = <function1>
  
  val addTwo = curriedAdd(2)                      //> addTwo  : Int => Int = <function1>
  
  addTwo(4)                                       //> res2: Int = 6
  
  
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = List(1, 2, 4)                          //> xs  : List[Int] = List(1, 2, 4)
  
  xs foreach println                              //> 1
                                                  //| 2
                                                  //| 4
	
// P07 (**) Flatten a nested list structure.
//     Example:
//     scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//     res0: List[Any] = List(1, 1, 2, 3, 5, 8)
	def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }                                               //> flatten: (ls: List[Any])List[Any]
  
  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res3: List[Any] = List(1, 1, 2, 3, 5, 8)
}