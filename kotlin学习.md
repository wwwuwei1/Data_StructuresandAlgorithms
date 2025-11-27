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

### (四.)lambda表达式

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

(八)中缀函数

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

(八)空值和空类型

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