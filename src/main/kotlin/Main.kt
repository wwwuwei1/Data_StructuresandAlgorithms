package net.onest

import com.sun.tools.attach.AgentLoadException
import org.jetbrains.annotations.Nullable
import java.math.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

//fun main() {
//    val score = 20
//    val grade = when(score){
//        in 0..10->"F"
//        in 10..20->"D"
//        in 20..30->"C"
//        in 30..40->"B"
//        in 40..50->"A"
//        else -> "Invalid Score"
//    }
//    println(grade)
//}
//标准循环
//fun main() {
//    val range = 1..5
//    for (i in range) {
//        println("hello world$i")
//    }
//}
//}
//step的使用(1)
//fun main(){
//    val range = 1..5 step 2
//    for(i in range){
//        println(i)
//    }
//}

////step的使用(2)
//fun main(){
//    val range = 1..5
//    for(i in range step 2){
//        println(i)
//    }
//}

//downTo的使用
//fun main(){
//    for(i in 10 downTo 1 )
//        println(i)
//}

//xxx@的使用
//fun main(){
//    xxx@for(i in 1..3){
//        for(j in 1..3){
//            if (i==j) continue@xxx
//            println("i=$i,j=$j")
//        }
//    }
//}
//函数的使用
//fun main(){
//    print(10)
//    hello("WW")
//    println(sum(10,10))
//    hello1("xxx")
//    hello1(10, 10)
//}
////函数的格式为：fun 函数名(参数名:参数类型):返回值类型{}
//fun print(age : Int){
//    println(age)
//}
//fun hello(name:String){
//    println("hello $name")
//}
////函数的返回值
//fun sum(a:Int,b:Int):Int{
//    return a+b //有返回值就得有return
//}
////函数的默认值
//fun hello1(message : String = "Hello World"){
//    println(message)
//}
////函数的重载
//fun hello1(a: Int ,b: Int){
//    println(a+b)
//}
//fun main(){
//    var a = -2.0
//    var b = 9.0
//    //幂运算
//    println(a.pow(3))
//    //绝对值
//    println(abs(a))
//    //平方根
//    println(sqrt( b))
//
//}
//定义一个变量func,赋值为test
//fun main(){
//    var func : (String)->Int = ::test
//    println(func(""))
//    var func1 : (String)->Int = fun(str:String) = 10
//    println(func1(""))
//}
//fun test(str: String): Int{
//    return 666
//}
//lambda的使用
//fun main(){
//    var func : (String)-> Int = {
//        println(it)
//        10
//    }
//    println(func("Hello World"))
//}
//lambda双参数
//fun main(){
//    var func : (String, String)->Int = {a,b->
//        println(a)
//        println(b)
//        10
//    }
//    println(func("Hello","World"))
//}
//fun main(){
//    var stu1 = StudentTest("小明",18)
//    var stu2 = StudentTest("小花",17)
//    var stu3 = stu1
//    var stu4 = StudentTest("小明",18)
//    println(stu1.name)
//    println(stu1.age)
//    println(stu2.name)
//    println(stu2.age)
//    println(stu1===stu3)
//    println(stu1===stu4)
//}
//fun main() {
////    var stu = StudentTest("小明",18)
////    println("Hello World")
////    stu.hello("小红")
////    var a: Int = 10
////    var b: Int = 5
////    var c: Double = b/a.toDouble()
////    println(c)
//    var Stu1 = StudentTest("吴大玮", 20)
//    var Stu2 = StudentTest("郑大彤", 18)
////    var stu3 = Stu1-Stu2
////    println(stu3.name)
////    println(stu3.age)
//    Stu1 love Stu2
//    var stu3: StudentTest? = StudentTest("wuwei", 20)
//    if (stu3 != null) {
//        stu3.name
//    }
//    println(stu3?.name)
//}
fun main(){
    var stu = Student("小明",18)
    println(stu.getName())
    stu.setName("小刚")
    stu.setName("小王")
    println(stu.getName())
}