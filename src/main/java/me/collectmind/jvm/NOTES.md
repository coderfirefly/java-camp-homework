# P1(2020-10-15)
## JVM基础知识
+ 编程语言分类
  + 面向过程、面向对象、面向函数；
  + 静态类型、动态类型；
  + 编译执行、解释执行；
  + 有虚拟机、无虚拟机；
  + 有GC、无GC；
+ Java是一种面向对象、静态类型、编译执行，有VM/GC和运行时、跨平台的高级语言；
+ 编程语言跨平台
  + 源代码跨平台
  + 二进制跨平台
![P1.png](../../../../resources/images/jvm/p1.png)

##  Java字节码技术
+ 字节码：单字节指令，操作栈/程序流控制/对象操作/计算等指令；
![P2.png](../../../../resources/images/jvm/p2.png)

+ JVM是基于栈的操作，运行时将变量从本地变量表移动到栈上，计算完成后将变量保存回本地变量表；   
![P3.png](../../../../resources/images/jvm/p3.png)

+ 字节码到二进制的转换：
![P4.png](../../../../resources/images/jvm/p4.png)

+ 本地变量表：操作码的后缀数字表示槽位（slot），前缀表示变量的类型，如i是int，d是double，a是引用类型；
![P5.png](../../../../resources/images/jvm/p5.png)


+ 方法调用指令
![P6.png](../../../../resources/images/jvm/p6.png)


+ 一个方法执行过程的字节码动态示例
  + 把常量1入栈；
  + 取出栈顶元素存入本地变量表（局部变量区）第0个槽位；
  + 把常量2入栈；
  + 取出栈顶元素存入本地变量表第1个槽位；
  + 把第0个槽位的元素入栈；
  + 把第1个槽位的元素入栈；
  + 取出栈顶两个元素并求和后入栈；
  + 把常量5入栈；
  + 取出栈顶两个元素并相乘后入栈；
  + 取出栈顶元素存入本地变量表第2个槽位；
  + 方法结束返回；
![images](../../../../resources/images/jvm/p7.png)
![images](../../../../resources/images/jvm/p8.png)
![images](../../../../resources/images/jvm/p9.png)
![images](../../../../resources/images/jvm/p10.png)
![images](../../../../resources/images/jvm/p11.png)
![images](../../../../resources/images/jvm/p12.png)
![images](../../../../resources/images/jvm/p13.png)
![images](../../../../resources/images/jvm/p14.png)
![images](../../../../resources/images/jvm/p15.png)
![images](../../../../resources/images/jvm/p16.png)
![images](../../../../resources/images/jvm/p17.png)
![images](../../../../resources/images/jvm/p18.png)
![images](../../../../resources/images/jvm/p19.png)




----
##  JVM类加载器
+ 类的生命周期
![images](../../../../resources/images/jvm/p20.png)


+ 类的加载时机
![images](../../../../resources/images/jvm/p21.png)



+ 类不会被初始化的场景（可能会被加载）
![images](../../../../resources/images/jvm/p22.png)


+ 类加载器
![images](../../../../resources/images/jvm/p23.png)


+ 自定义类加载的例子
   + 定义Hello文件
   + 编译成class文件
   + BASE64编码 
   + 移除Hello文件
   + 运行自定义类加载器

+ 添加引用类的四种方式
![images](../../../../resources/images/jvm/p24.png)




##  JVM内存模型
+ JVM内存结构
  + 方法中使用的原生数据类型和对象引用地址在栈上存储；
  + 对象、对象成员与类定义、静态变量在堆上；
![images](../../../../resources/images/jvm/p25.png)
![images](../../../../resources/images/jvm/p26.png)
![images](../../../../resources/images/jvm/p27.png)

+ JVM内存整体结构
![images](../../../../resources/images/jvm/p28.png)

+ JVM栈内存结构
![images](../../../../resources/images/jvm/p29.png)

+ JVM堆内存结构
![images](../../../../resources/images/jvm/p30.png)


---
##  JVM启动参数
+ -server：运行模式参数
+ -D ：系统属性参数
+ -X：堆内存设置参数
+ -XX：GC设置参数、分析诊断参数



----
# P2





