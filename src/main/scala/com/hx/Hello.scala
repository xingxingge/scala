package com.hx

import java.lang.String
import java.util.Date

import org.junit.Test

//@Test
class hello {
  def main(args: Array[String]): Unit = {
    //    base
    //    testVariable();
    //    testMethodAndFunction();
    //    testbiBao();
    //
  }


  private def base = {
    var c: Object = new Object().getClass.getName;
    println(c)
    val a = "3"
    println(a)
    println(s"hello,scala world@")
    //字面量
    var b = 'x;
    println(b);
    //字符串
    var str =
      """xxx
        ff
        ff
      """;
    println(str)
  }

  /**
    * 变量测试
    */
  def testVariable(): Unit = {
    var myVar1: String = "Foo"
    //不可修改变量
    val myVal1: String = "Foo";

    val myVar2 = 10
    val myVal2 = "Hello, Scala!"
    val xmax, ymax = 100 // xmax, ymax都声明为100

    //元组
    val pa = (40, "Foo")
    println(pa)

  }

  /**
    * 方法与变量测试
    * Scala 有方法与函数，二者在语义上的区别很小。Scala 方法是类的一部分，
    * 而函数是一个对象可以赋值给一个变量。换句话来说在类中定义的函数即是方法。
    * *
    * Scala 中的方法跟 Java 的类似，方法是组成类的一部分。
    * *
    * Scala 中的函数则是一个完整的对象，Scala 中的函数其实就是继承了 Trait 的类的对象。
    * *
    * Scala 中使用 val 语句可以定义函数，def 语句定义方法
    */

  def testMethodAndFunction(): Unit = {
    def m(x: Int) = x + 3;
    val f = (x: Int) => x + 3;
    println(m(10));
    println(f(20));
    printMe()
    println(addInt(5, 10));

    def addInt(a: Int, b: Int): Int = {
      var sum: Int = 0
      sum = a + b

      return sum
    }

    def printMe(): Unit = {
      println("Hello, Scala!")
    }

    def time() = {
      println("获取时间，单位为纳秒")
      System.nanoTime
    }

    def delayed(t: => Long) = {
      println("在 delayed 方法内")
      println("参数： " + t)
      t
    }

    //传名调用
    delayed(time());

    /**
      * 可变参数
      */
    def printStrings(args: String*) = {
      var i: Int = 0;
      for (arg <- args) {
        println("Arg value[" + i + "] = " + arg);
        i = i + 1;
      }
    }

    printStrings("123", "456");

    /**
      * Scala 函数 - 默认参数值
      * Scala 函数 Scala 函数
      * *
      * Scala 可以为函数参数指定默认参数值，使用了默认参数，你在调用函数的过程中可以不需要传递参数，
      * 这时函数就会调用它的默认参数值，
      * 如果传递了参数，则传递值会取代默认值。实例如下：
      */
    def addInt2(a: Int = 5, b: Int = 7): Int = {
      var sum: Int = 0
      sum = a + b
      return sum
    }

    println(addInt2());
    println(addInt2(2));
    println(addInt2(2, 8));

    /**
      * Scala 偏应用函数
      */
    println("偏应用函数");
    def log(date: Date, message: String) = {
      println(date + "----" + message)
    }

    val date = new Date
    log(date, "message1")
    Thread.sleep(10)
    log(date, "message2")
    Thread.sleep(10)
    log(date, "message3")

    //偏应用优化
    val logWithDateBound = log(date, _: String)

    logWithDateBound("message1")
    Thread.sleep(10)
    logWithDateBound("message2")
    Thread.sleep(10)
    logWithDateBound("message3")

    /**
      * Scala 指定函数参数名
      */
    def printInt(a: Int, b: Int) = {
      println("Value of a : " + a);
      println("Value of b : " + b);
    }

    printInt(a = 1, b = 2);

    /**
      * 递归调用
      */
    def factarial(n: BigInt): BigInt = {
      if (n <= 1) return 1;
      else return n * factarial(n - 1);
    }

    println(factarial(10));
    println(factarial(5));

    /**
      * Scala 高阶函数
      */
    // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
    def apply(f: Int => String, v: Int) = f(v)

    def layout[A](x: A) = "[" + x.toString() + "]"

    println(apply(layout, 10))

    /**
      * Scala 匿名函数
      * Scala 中定义匿名函数的语法很简单，箭头左边是参数列表，右边是函数体。
      * 使用匿名函数后，我们的代码变得更简洁了。
      */
    var factor = 3
    val multiplier = (i: Int) => i * factor
    println("multiplier(1) value = " + multiplier(1))
    println("multiplier(2) value = " + multiplier(2))

    /**
      * Scala 函数柯里化(Currying)
      * 柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。
      * 新的函数返回一个以原有第二个参数为参数的函数。
      */
    def addxx(x: Int) = (y: Int) => x + y

    val result = addxx(1);
    val sum = result(2)
    println(sum)


    /**
      * 函数与方法的区别
      *
      */
    var array: Array[String] = Array.empty;
    new MethodAndFunctionDemo().main(array);
  }

  /**
    * 闭包测试
    * 这里我们引入一个自由变量 factor，这个变量定义在函数外面。
    * *
    * 这样定义的函数变量 multiplier 成为一个"闭包"，
    * 因为它引用到函数外面定义的变量，定义这个函数的过程是将这个自由变量捕获而构成
    * 一个封闭的函数。
    */

  @Test
  def testbiBao(): Unit = {

    var factor = 3
    val multiplier = (i: Int) => i * factor
    println("muliplier(1) value = " + multiplier(1))
    println("muliplier(2) value = " + multiplier(2))
  }

  /**
    * 数组测试
    */
  @Test
  def arrayTest(): Unit = {
    var z: Array[String] = new Array[String](3);
    z(0) = "Runoob";
    z(1) = "Baidu";
    z(4 / 2) = "Google";
    var k = Array("Runoob", "Baidu", "Google");

    var myList = Array(1.9, 2.9, 3.4, 3.5)

    // 输出所有数组元素
    for (x <- myList) {
      println(x)
    }

    // 计算数组所有元素的总和
    var total = 0.0;
    for (i <- 0 to (myList.length - 1)) {
      total += myList(i);
    }
    println("总和为 " + total);

    // 查找数组中的最大元素
    var max = myList(0);
    for (i <- 1 to (myList.length - 1)) {
      if (myList(i) > max) max = myList(i);
    }
    println("最大值为 " + max);

  }

  @Test
  def collectionTest(): Unit = {
    /**
      *
      * starxhong
      * *
      * 140***8135@qq.com
      * *
      * Scala 程序使用 Option 非常频繁，在 Java 中使用 null 来表示空值，
      * 代码中很多地方都要添加 null 关键字检测，
      * 不然很容易出现 NullPointException。因此 Java 程序需要关心那些变量可能是 null,
      * 而这些变量出现 null 的可能性很低，但一但出现，很难查出为什么出现
      * NullPointerException。
      * *
      * Scala 的 Option 类型可以避免这种情况，因此 Scala 应用推荐使用 Option
      * 类型来代表一些可选值。使用 Option 类型，读者一眼就可以看出这种类型的值可能为 None。
      */

    // 定义整型 List
    val a = List(1, 2, 3, 4)

    // 定义 Set
    val b = Set(1, 3, 5, 7)

    // 定义 Map
    val c = Map("one" -> 1, "two" -> 2, "three" -> 3)

    // 创建两个不同类型元素的元组
    val d = (10, "Runoob")

    // 定义 Option
    val e: Option[Any] = Some(5, "f", null);
    for (x <- e) {
      println(x)
    }
  }


  /**
    * 类和对象
    *
    */

  @Test
  def testClassAndObject() {
    class Point(xc: Int, yc: Int) {
      var x: Int = xc
      var y: Int = yc

      def move(dx: Int, dy: Int) {
        x = x + dx
        y = y + dy
        println("x 的坐标点: " + x);
        println("y 的坐标点: " + y);
      }
    }
    //    val v = new Point(1,2);
    //    v.move(3,4);
    //继承
    class Location(val xc: Int,
                   val yc: Int,
                   val zc: Int) extends Point(xc, yc) {
      var z: Int = zc

      def move(dx: Int, dy: Int, dz: Int) {
        x = x + dx
        y = y + dy
        z = z + dz
        println("x 的坐标点 : " + x);
        println("y 的坐标点 : " + y);
        println("z 的坐标点 : " + z);
      }
    }
    val l = new Location(1, 2, 3);
    println(l.move(1, 2));
    println(l.move(1, 2, 3))
  }

  /**
    * 模式匹配
    */
  @Test
  def schemaMatch(): Unit = {
//    def matchTest(x: Any): Any = x match {
//      case 1 => "one"
//      case "two" => 2
//      case y: Int => "scala.Int"
//      case _ => "many"
//    }
//
//    println(matchTest(1))
//    println(matchTest(2))
//    println(matchTest("two"))
//    println(matchTest("twof"))


    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) =>
          println("Age: " + age + " year, name: " + name + "?")
      }
    }
    // 样例类
    case class Person(name: String, age: Int);
  }



}
