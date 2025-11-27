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
