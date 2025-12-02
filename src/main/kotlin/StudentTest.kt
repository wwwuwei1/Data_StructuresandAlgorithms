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
//class Student(private var name: String,private var age:Int){
//    fun getName():String=name
//    fun setName(name:String){
//        if(name.contains("刚")){
//            println("名字不能含有刚")
//            return
//        }
//        this.name = name
//    }
//}
//open class Student(var name:String,var age:Int){
//    open fun hello()=println("我会打招呼")
//    //需要注意的事,函数也是需要添加open关键字才能被子类覆盖
//}
//class ArtStudent(name:String,age:Int):Student(name,age){
//    fun draw() = println("我会画画")
//    //在子类中编写一个同名函数,并添加override关键字,就可以在子类中进行覆盖了
//    override fun hello() = println("哦哈呦")
//}
//class SportStudent(name:String,age:Int):Student(name,age){
//    override fun hello(){
//        println("大家下午好")
//        super.hello()
//    }
//}
//open class Student{
//    var name:String = "小明"
//    open fun hello() = println("大家好")
//}
//class ArtStudent : Student(){
//    override fun hello() = println("哦哈呦")
//    fun test() = println("测试")
//}
//使用abstract表示这是一个抽象类
abstract class Student{
    abstract val name: String //抽象类中存在抽象成员属性
    abstract fun hello()  //抽象类中的抽象函数
    //抽象类是不能用private,不然子类就没法重写了
}

class ArtStudent(override var name:String = "小明"):Student(){
    override fun hello() = println("大家好,我叫$name")
}