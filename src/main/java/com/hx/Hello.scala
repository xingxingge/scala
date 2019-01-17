package com.hx

object hello {
  def main(args: Array[String]): Unit = {
//    base
    testVariable()
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
  def testVariable():Unit={
    var myVar1 : String = "Foo"
    //不可修改变量
    val myVal1 : String = "Foo";

    val myVar2 = 10
    val myVal2 = "Hello, Scala!"
    val xmax, ymax = 100  // xmax, ymax都声明为100

    //元组
    val pa = (40,"Foo")
    println(pa)

  }

  /**
    * 方法与变量测试
    */

}
