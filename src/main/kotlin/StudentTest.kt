package net.onest

//class StudentTest constructor(var name: String, var age: Int) {
    //比如学生有name和age属性，在constructor后编写，并用逗号分隔
    //如果没有任何注释或者可见性修饰符，可以省略掉constructor
    //可以定义类的属性，比如说var name: String, var age: Int
    //定义的属性写在括号里可以不赋初始值，也可以把属性定义在类内部，但是必须在构造函数里赋初始值
//    //主构造函数的声明
//    constructor(name: String,age: Int,sex: String):this(name,age)
//    //次构造函数的声明
//    constructor(name: String,age: Int,sex: String,phone: String):this(name,age,sex)
//    //对象的初始化
////    init{
//        println("我是初始化块")
//    }
//    init{
//        println("我是另一个初始化块")
//    }
//    fun hello(name: String){
//        println("我是主函数")
//        println("大家好，我是${this.name},今年${this.age}岁了")
//    }
//    operator fun plus(another: StudentTest): StudentTest=StudentTest(this.name+another.name,this.age+another.age)
//    operator fun minus(another: StudentTest): StudentTest =StudentTest(this.name,this.age-another.age)
//
//    infix fun love(another: StudentTest){
//        return println("$name 爱 ${another.name}")
//    }
//}
//属性的封装
class Student(private var name: String,private var age:Int){
    fun getName():String=name
    fun setName(name:String){
        if(name.contains("刚")){
            println("名字不能含有刚")
            return
        }
        this.name = name
    }
}