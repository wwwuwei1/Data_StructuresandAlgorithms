# Kotlin学习

## 一.Kotlin程序基本格式

1. 主程序

   ```kotlin
   fun main(){
       println("Hello World")
   }
   ```

   ```kotlin
   Hello world

## 二.变量的声明和使用

```kotlin
var x : Int//变量
val x : Short //固定值
```

1. 变量标识符可以由大小写字母，数字，下划线和美元符号$组成，但是不能以数字开头
2. 变量定义：var <标识符> ： <类型> = <初始化值>
3. 不可变量使用val，类似于Java中的final关键字

## 三.数字类型

Byte 8位 范围：-127~127

Short 16位 范围：-32768~32767

Int 32位 范围：-2^31^~2^31^-1

Long 64位

Float    Double（常用）

```kotlin
var a:Int = 1,000_000_000//可以这样表示多位数字
```

1. kotlin中还提供了无符号整数，比如说Unit：一个无符号的32位整数，范围是0~2^32^-1

```kotlin
val a:Unit = 10u//赋值后加上u
```

## 四.if条件分支

if判断依旧是

```kotlin
if(x){
    xxx
}
else{
    xxx
}
```

## 五.when条件分支

类似于swich case判断，但是实现起来更轻松简单

```kotlin
fun main(){
    val c = 'A'
    when(c){
        'A'->println("A")
        'B'->println("B")
        'C'->println("C")
        else->println("else")
    }
}
```

```kotlin
A
```

同样也可以把该分支判断赋值给一个变量，比如说

```kotlin
fun main(){
    val c:'C'
    val value = when(c){
        'A'->1
        'B'->2
        'C'->3
        else->0
    }
    printn(value)
}
```

```kotlin
3
```

并且在kotlin中也可以实现多个值符合同一种情况

```kotlin
fun main(){
    val c='C'
    when(c){
        'A'->println(1)
        'B','C'->println("2或者3")
        else->println("0")
    }
}
```

```kotlin
2或者3
```

## 六.in关键字

可以使用in来表示范围，例如：

```kotlin
fun main(){
    val score = 20
    val grade = when(score){
        in 0..10->"F"//0<=x<=10
        in 10..20->"D"
        in 20..30->"C"
        in 30..40->"B"
        in 40..50->"A"
        in 50..60->"S"
        else -> "Invalid Score"
    }
    println(grade)
}
```

```kotlin
D
```

## 七.for循环遍历和while循环遍历

```kotlin
fun main(){
    val range = 1..5
    for(i in range){
        println("Hello World")
    }
}
```

```kotlin
Hello World
Hello World
Hello World
Hello World
Hello World
```

可以使用step来决定间隔

两种使用方法

1. 

```kotlin
fun main(){
    val range = 1..5 step 2
    for(i in range){
        println(i)
    }
}
```

```kotlin
1
3
5
```

2. 

```kotlin
fun main(){
    val range = 1..5
    for(i in range step 2){
        println(i)
    }
}
```

```kotlin
1
3
5
```

3. 可以使用downTo来倒着进行循环,downTo也可以使用step来设置间隔

```kotlin
fun main(){
    for(i in 10 downTo 1){
        println(i)
    }
}
```

downTo属于和..相反作用1..10是从1到10,10 downTo 1是倒着来

4. xxx@.......@xxx的使用

```kotlin
fun main(){
    xxx@for(i in 1..3){
        for(i in 1..3){
            if(i==j)continue@xxx{
                println("i=$i,j=$j")
            }
        }
    }
}
```

如图所示,xxx@......continue@xxx的作用就是当满足条件时执行外层循环的下一次循环,如果不加会当条件满足时执行内层循环的下一次,这就是标识符的作用

5. while循环遍历基本同其他语言,无特殊语法

## 八.函数

### (一)函数的定义和使用

1. 函数的格式:fun 函数名()(参数名:参数类型):返回值类型{}

```kotlin
fun print(age:Int){
    println(age)
}
```

2. 函数的返回值

```kotlin
fun sum(a:Int,b:Int):Int{
    return a+b//有返回值就要有return
}
```

没有规定返回值就是Unit类型

3. 函数的默认值

```kotlin
fun message(message:String = "Hello World"){
    println(message)
}
```

规定默认值,如果调用函数的时候没有给出值,那么就会使用默认的初始值

4. 函数的使用

```kotlin
fun main(){
    print(10)
    println(sum(10,10))
    message()
}
```

```kotlin
10
20
Hello World
```

### (二)函数的重载

接受的值的类型不同可以使用同一个函数,叫做函数的重载,但是形参类型相同,返回值类型不同不可以使用函数的重载

```kotlin
//函数的默认值
fun hello1(massage:String){
    println(message)
}
//函数的重载
fun hello1(a:Int,b:Int){
    println(a+b)
}
```

### (三)函数类型变量

在kotlin中,可以使用函数来定义变量

```kotlin
fun mian(){
    var func:(String)->Int = ::test
    println(func(""))
}
fun test(str:String):Int{
    return 666
}
```

```kotlin
666
```

比如我使用func这个函数作为变量,接收的参数类型是String,返回值是Int,并且=::test,把test函数赋值给这个变量

```kotlin
var func1 :(String)->Int = fun(str:String) = 10
println(func1(""))
```

这段代码种的变量fun1为非直接引用函数赋值而是直接创建新的函数进行赋值

### (四)lambda表达式

在kotlin中,定义函数类型的变量时,将后面的创建函数的标准写法直接简写成一个花括号的形式,然后写函数主体,这就是lambda表达式,其中it在该表达式中代指输入的形参

```kotlin
fun main(){
    var func:(String)->Int={
        println(it)
        10
    }
    println(func("Hello World"))
}
```

```kotlin
Hello World
10
```

我称为:同时定义变量和函数,即函数类型变量

而如若是两个参数的情况,需要在第一个花括号后面紧接着为两个输入变量命名,不能再用it表示,比如

```kotlin
fun main(){
    var func:(String)->Int{a,b->
        println(a)
        println(b)
        10
    }
    println(func("Hello","World"))
}
```

```kotlin
Hello
World
10
```

## 九.类与对象

### (一)类的定义

通常使用构造函数来定义一个类,创建类会自动声明类的名称

```kotlin
class StudentTest constructor(name:String,age:Int){
    //比如学生有name和age属性,在constructor后编写,并用逗号分隔
    //如果没有注释或者可见性修饰符,可以省略constructor
    //可以定义类的属性,比如说var name:String,var age:Int
    //定义的属性写在括号里可以不赋初始值,也可以把属性定义写在类的内部,但是必须构造函数里赋初始值
}
```

### (二)定义类的对象

```kotlin
fun main(){
    var stu1 = StudentTest("xiaoming",18)
    var stu2 = StudentTest("xiaohua",17)
    var stu3 = stu1
    var stu4 = StudentTest("xiaoming",18)
    //调用对象的属性值
    println(stu1.name)
    println(stu1.age)
}
```

这里创建对象相当于定义一个指向类的指针而不是引用类,所以虽然stu1和stu4内完全一样,但是依旧是两个不同的对象

### (三)类的构造函数

主构造函数以及次要构造函数的声明,主构造函数只能声明一个,次要构造函数能声明多个

```kotlin
//主构造函数(定义在类名后面,用于定义创建和初始化对象)
class StudentTest(
    val name:String,// 主构造函数的参数，同时定义为属性
    val age:Int
){
    //主构造函数体
    // 成员函数
    fun printInfo() {
        println("姓名：$name, 年龄：$age")
    }
}
//次要构造函数的声明
constructor(name:String,age:Int,sex:String):this(name,age){
    println("学生的姓名是$name,学生的年龄是$age,学生的性别是$sex")
}
```

Kotlin 的类构造函数比作**一台功能强大的“对象生产机”**
**主构造函数**：定义了生产这台机器最基本的原料入口（哪些参数是必须的）。
**次构造函数**：是机器上不同的“投料口”，允许你以不同的方式投入原料，但最终生产的核心流程还是由主构造函数决定。

### (四)初始化语句

```kotlin
init{
    println("我是初始化代码块")
}
init{
    println("我是另一个初始化代码块")
}
```

之后只要在主程序中创建对象,就会自动执行代码块中的内容

**`init`块**：是机器内部的质检和组装流水线，对原料进行加工和检查,比如说规定创建对象时的初始逻辑,姓名不能超过10个字等

### (五)成员函数

想要调用定义在类里的函数,需要创建一个这个类的对象然后使用这个对象来调用函数,就像是定义一个角色,然后让角色做出一个行为

```kotlin
fun printInfo() {
    println("姓名：$name, 年龄：$age")
}
```

```kotlin
fun main(){
    var stu = StudentTest("小明",18)
    println("hello World")
    stu.hello()
}
```

再谈，如果定义类的时候定义了形参name：String,但是在定义成员函数的时候，也定义了形参name:String,那么我在都输入name这个参数的时候，会输出哪个name呢

输出了成员函数输入的形参，这个就是采用就近原则，如果就是想采用类定义的参数，可以把函数中的参数改名，当然如果实在不想改，可以使用this关键字

```kotlin
fun printInfo(){
    println("姓名：${this.name}, 年龄：${this.age}")
}
```

再谈,成员函数和主构造函数的区别

主构造函数相当规定了基本参数,成员函数是指这个对象的行为
主构造函数定义在类名后面,成员函数定义在类体内,使用fun关键字

### (六)再谈数据类型

在kotlin中,可以把定义的变量当成一个对象使用,比如说

```kotlin
fun main(){
    var a:Int = 10
    var b:Int = 5
    var c:Double = b/a.toDouble()
    println(c)
}
```

我们定义了Int类型的两个变量a和b，然后我们定义Double类型的c，让c=a/b，正常来说会返回0，因为整型变量会省去小数位，所以我们需要使其中一个变量变成Double类型的，在kotlin中，我们就可以直接使用a.todouble（）来实现,强制类型转换

### (七)运算符重载函数

我们想要实现类似于使用“+”，即Stu1+Stu2会把两个对象的属性拼接起来这种操作，就要对运算符进行重载，比如说“+”对应的是plus\

```kotlin
operator fun plus(another:StudentTest):StudentTest{
    return StudentTest(this.name+another.name,this.age+another.age)
}
```

```kotlin
var stu1 = StudentTest("小明",18)
var stu2 = StudentTest("小花",17)
var stu3 = stu1 + stu2
println(stu3.name)
println(stu3.age)
```

```kotlin
小明小花
35
```

a++,a--也可以进行重载，但是会直接返回重载函数中的值，对于调用时传入的形参会直接省略

kotlin运算符重载函数极其强大，甚至连小括号都可以重载，对于不同运算符的重载会有不同的使用

### (八)中缀函数

作用:提高代码的可读性，使代码看起来更像自然语言

使用：infix关键字

```kotlin
infix fun love(another:StudentTest){
    return println("$name 爱 {another.name}")
}
```

```kotlin
stu1 love stu2
```

就可以使用更简洁易懂的代码来使用这个函数，增强文章的可读性

### (九)空值和空类型

Kotlin中不允许把空值赋值给变量

```kotlin
var stu3 : StudentTest = null
```

如图会报错,但是如果想强制把值赋为空值可以

使用

```kotlin
var stu3 : StudentTest ?= null
```

这种方法来强制赋空值,但是如果此时获取类中的某个对象属性

```kotlin
stu3.name
```

就会报错,所以要先加上空值判断

```kotlin
if(stu3 != null){
    stu3.name
}
```

那么有没有办法就算是空值也不会报错，当然有我们可以使用这种方法

```kotlin
println(stu3?.name)
```

这就是安全运算符"?."

### (十)解构声明

有时候,我们可以调用对象的某个属性,比如说:

```kotlin
fun main(){
    val stu = Student("小明",18)
    println(stu.name)
    println(stu.age)
}
```

那么有没有办法可以直接获取一个对象的所有属性呢,当然是有的,**也就是解构**

要使一个类的属性支持解构,需要定义componentN函数并通过返回值的形式返回解构的结果

```kotlin
class Student(var name:String,var age:Int){
    operator fun component1() = name //表示解构出来的第一个参数
    operator fun component2() = age  //表示解构出来的第二个参数
    operator fun component3.....// 以此类推
}
```

```kotlin
val(a,b)=stu //解构出来的参数按顺序就是componentN的结果
```

如果想要第二个参数而第一个参数不需要,可以直接使用 _ 来忽略掉

```kotlin
val (_,b) = stu
println("年龄:$b")
```

解构也常和lambda表达式连用:

```kotlin
val func : (String) -> Unit = {(a,b) //
    println("姓名")
}
```

**简单来说，解构声明就像"拆快递"**：你收到一个包裹（对象），解构声明让你可以一次性拆开，直接拿到里面的各个物品（属性），而不需要先拆包装再一个个拿出来。

### (十一)包和导入

新建包:一般来说使倒着来的,比如说baidu.com的包就是com.baidu

在包下新建类,会自动导入该包,比如说在com.baidu下建一个teat.kt,会自动导入

```kotlin
package com.baidu
```

不同包里的类不能互通,所以如果想使用不同包中定义的类或者变量或函数,就要导入包

```kotlin
import com.test.User //使用import导入包,导入时 包名.类型/函数/变量名称 来完成
import com.test.*  //使用*一次性导入全部内容
```

### (十二)访问权限控制

public:默认就是public,也就是公开的,可以导入此类/函数/变量

private:为私有的,只有在本文件中才能访问,其他文件不能导入

internal:在项目中可以使用,但是别人想引用此项目不可以

## 十.封装,继承和多态

### (一)类的封装

属性的封装,比如说别人可以使用我的类,但是我并不想让别人随便动我的属性,就可以对属性进行封装,通过调用函数来获取属性值

```kotlin
class Student( private var name:String,private var age:Int){
    fun getName():String = name
    fun steName(name:String){
        if(name.contains("刚")){
            println("名字不能带有刚")
            return
        }
        this.name = name
    }
}
```

```kotlin
fun main(){
    var stu = Student("小明",18)
    println(stu.getName())
    stu.setName("小刚")
    stu.setName("小王")
    println(stu.getName())
}
```

```kotlin
小明
名字不能含有刚
小王
```

这样就可以来确保属性的值不会改变,就算允许改变设定了setName也可以对改变增加规则,这就是封装的作用

同样的对属性加上private之后,别人也无法根据我的属性来创建函数,只有我能从类内部创建函数,别人想使用这个功能,只能调用我的类中的函数

### (二)类的继承

类的继承就是子类继承父类,减少重复代码的定义

比如说学生这一父类,都会睡觉吃饭逃课
其下的子类有美术生,体育生,计算机生,分别有自己独特的技能

在kotlin,kotlin的类都是"终态"的(不能被任何类继承)要使类可继承,需要使用

**open**关键字标记需要被继承的类,说明设个类可以被继承

```kotlin
open class Student()
open class ArtStudent : Student()
class SuperArtStudent : ArtStudent()
```

父类使用open关键字可以被子类继承,子类也可以被子类的子类继承

子类继承时会把父类中定义的一切都继承过去,比如父类定义的变量,函数等,同样子类的子类也会继承父类和子类中的元素

```kotlin
open class Student(){
    var name : String = "小明"
    fun hello() = println("大家好,我叫$name")
}
open calss ArtStudent : Student(){
    fun test() = println("大家好,我叫$name,我是个美术生")
}
class SuperArtStudent : ArtStudent()
```

```kotlin
fun main(){
    var student = SuperArtStudent()
    student.hello()//虽然是父类定义的函数,子类的子类也可以调用
}
//除非在父类中把变量和函数加上private修饰符,这样就无法访问了
//当然如果使用protected修饰符,那么只是在本类外面无法访问,在本类里的子类和子类的子类都可以进行访问
```

一个子类只能继承一个父类,不能同时继承多个父类,但是一个父类可以被多个子类继承

初始化的注意点

```kotlin
open class Student(var name:String,var age:Int){
    init{
        println("我是父类")
    }
    fun hello() = println("大家好,我叫$name")
}
open calss ArtStudent(name:String,age:Int):Student(name,age){
    init{
        println("我是子类")
    }
    fun draw() = println("我会画画")
}
```

```kotlin
fun main(){
    var student = ArtStudent("小明",18)
    student.hello
    student.draw
}
```

```kotlin
我是父类
我是子类
大家好,我叫小明
我会画画
```

父类和子类都使用初始化语句之后,执行时会先执行父类和子类的初始化语句,再执行各自类的语句

子类初始化之前必须调用一次父类的构造函数,必须是父类先初始化,子类才能能使用

### (三)属性的覆盖

有时候我们希望子类继承父类的某些属性,但是希望修改这些属性的默认实现
就比如说美术生也会打招呼但是他们打招呼的方式和普通学生不太一样

我们就可以使用**override**这个关键字对这个属性进行重写(覆盖)

```kotlin
open class Student(var name:String,var age:Int){
    open fun hello()=println("大家好")
    //需要注意的事,函数也是需要添加open关键字才能被子类覆盖
}
class ArtStudent(name:String,age:Int):Student(name,age){
    fun draw() = println("我会画画")
    //在子类中编写一个同名函数,并添加override关键字,就可以在子类中进行覆盖了
    override fun hello() = println("哦哈呦")
}
```

```kotlin
fun main(){
    var student = Student("小明",18)
    student.hello
    var student1 = ArtStudent("小花",18)
    student.hello
}
```

```kotlin
大家好
哦哈呦
```

如果想要既覆盖又把原来父类中的也输出出来,就可以使用super关键字

```kotlin
class SportStudent(name:String,age:Int):Student(name,age){
    override fun hello(){
        println("大家下午好")
        super.hello()
    }
}
```

对变量也可以重写,实现形式差不多

```kotlin
class EStudent(override val name:String,val age:Int):Student(name,age){//在主构造函数中进行覆盖,会使用传入的变量进行覆盖
    override fun hello(){
        println("大家下午好")
        super.hello()
    }
}
```

子类可以当作父类来使用,比如说:

```kotlin
var student : Student = ArtStudent()
```

ArtStudent 是一个子类,但是也可以当作父类来使用,但是此时只能使用父类中的变量和函数,子类中特有的就不能再使用了,但是为什么说是特有的呢,比如说

```kotlin
open class Student{
    var name:String = "小明"
    open fun hello() = println("大家好")
}
class ArtStudent : Student(){
    override fun hello() = println("哦哈呦")
    fun test() = println("测试")
}
```

```kotlin
fun main(){
    var stu : Student = ArtStudent()
    stu.test()//会报错,因为父类中没有这个函数
    stu.hello//会输出"哦哈呦",因为父类中有这个函数,只不过终究定义的是一个ArtStudent类的变量,会输出美术生的
}
```

### (四)顶层Any类

顶层的Any类有如下三个函数,

首先第一个就是equals函数,相当于是"==",实现方法就是:

底层实现就是
```kotlin
class Student(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if(this === other) return true  //如果引用的是同一个对象，肯定是true不多逼逼
        if(other !is Student) return false //如果要判断的对象根本不是Student类型的，那也不用继续了
        if(name != other.name) return false  //判断名字是否相同
        if(age != other.age) return false  //判断年龄是否相同
        return true   //都没问题，那就是相等了
    }
}
```

第二个就是hashCode:后续会进行详细介绍

第三个是ToString
`toString`函数用于快速将对象转换为字符串

更多时候我们希望转换成员属性,更直观的看到对象的属性具有什么值:

```kotlin
class Student(val name:String,var age:Int){
    override fun toString():String //重写toString函数
        return "Student(name = '$name', age=$age )"
}
```

### (五)抽象类

有时候,我们定义的类仅仅是为了给其他了类继承,而其本身不需要创建实例对象,比如:

```kotlin
open class Student protected constructor(){
    open fun hello() = println("Hello World")
}

class ArtStudent: Student(){
    override fun hello() = println("Hello")
}

class SportStudent: Student(){
    override fun hello() = println("World")
}
```

在这个例子中,可以发现Student类中的hello函数在子类中都会被重写,所以说除非在子类中调用父类的默认实现,负责父类中的类永远不会被调用

这种父类不需要提供实现,完全由子类实现的类,可以使用**abstract**关键字来将一个类声明为抽象类:

```kotlin
//使用abstract表示这是一个抽象类
abstract class Student{
    abstract val name: String //抽象类中存在抽象成员属性
    abstract fun hello()  //抽象类中的抽象函数
    //抽象类是不能用private,不然子类就没法重写了
}
```

而当一个子类继承抽象类的时候,其中的方法必须要重写

```kotlin
class ArtStudent(override var name:String = "小明"):Student(){
    override fun hello() = println("大家好,我叫$name")
}
```

### (六)接口

接口必须是抽象的,一般情况下，他只代表某个确切的功能！也就是只能包含函数或属性的定义,接口一般只代表某些功能的抽象，接口包含了一系列内容的定义，类可以实现这个接口，表示类支持接口代表的功能。

比如说,学生具有以下接口:

+ 打游戏
+ 睡觉
+ 学习

我们要做的就是将这一个个功能拆分成一个个接口,然后让学生来实现这些接口

在kotlin中,要声明接口,我们可以使用**interface**关键字

```kotlin
interface A{
    val x:String //接口中所有属性默认都是abstract的(可省略关键字)
    fun sleep()
}
interface B{
    fun game()
}
class Student:A,B{
    override val x:String = "测试"
    override fun sleep() = println("我想睡觉")
    override fun game() = println("好想玩游戏")
}
```

相较于抽象类,接口更加的纯粹,一切内容都是抽象的,只能由子类来实现

那么接口和抽象类有什么区别呢

接口不能作为状态的保存,只能是定义属性,实现都是由类来调用接口来实现,而在抽象类中可以定义具体的属性

使用场景:

+ *当多个类有共同的"本质"时使用抽象类*,比如说美术生会打招呼,体育生会打招呼
+ *当类需要具备某种"能力"时使用接口* ,比如说学生会吃饭睡觉

接口也可以继承其他接口,并且可以是继承多个接口

```kotlin
interface C: A, B
class Student: C //直接获得三个接口的功能
```

当然接口也有缺陷,比如说接口A中定义了一个函数,接口B中也定义了一个函数
```kotlin
interface A{
    fun hello() = println("hello")
}
interface B{
    fun hello() = println("World")
}
class Student: A, B{
    override fun hello() = super<B>.hello() //如果A,B接口中同时定义了同一个名称的函数,那么如果想使用其中一个就要使用super<A/B>.hello()这样的格式
}
```

