package me.collectmind.java.camp.homework.basic;

/**
 * 四则运算的字节码例子
 *
 * Created by monica on 2020/10/18.
 */
public class LocalVariableTest {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        double avg = ma.getAvg();
    }
}

/*
➜  javap -c -verbose me.collectmind.jvm.LocalVariableTest
Classfile /xxx/src/main/java/me/collectmind/jvm/LocalVariableTest.class
  Last modified Oct 18, 2020; size 446 bytes
  MD5 checksum 7c92bc73935ce05835e5b22d7b1b55ba
  Compiled from "LocalVariableTest.java"
public class me.collectmind.jvm.LocalVariableTest
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #7.#16         // java/lang/Object."<init>":()V
   #2 = Class              #17            // me/collectmind/jvm/MovingAverage
   #3 = Methodref          #2.#16         // me/collectmind/jvm/MovingAverage."<init>":()V
   #4 = Methodref          #2.#18         // me/collectmind/jvm/MovingAverage.submit:(D)V
   #5 = Methodref          #2.#19         // me/collectmind/jvm/MovingAverage.getAvg:()D
   #6 = Class              #20            // me/collectmind/jvm/LocalVariableTest
   #7 = Class              #21            // java/lang/Object
   #8 = Utf8               <init>
   #9 = Utf8               ()V
  #10 = Utf8               Code
  #11 = Utf8               LineNumberTable
  #12 = Utf8               main
  #13 = Utf8               ([Ljava/lang/String;)V
  #14 = Utf8               SourceFile
  #15 = Utf8               LocalVariableTest.java
  #16 = NameAndType        #8:#9          // "<init>":()V
  #17 = Utf8               me/collectmind/jvm/MovingAverage
  #18 = NameAndType        #22:#23        // submit:(D)V
  #19 = NameAndType        #24:#25        // getAvg:()D
  #20 = Utf8               me/collectmind/jvm/LocalVariableTest
  #21 = Utf8               java/lang/Object
  #22 = Utf8               submit
  #23 = Utf8               (D)V
  #24 = Utf8               getAvg
  #25 = Utf8               ()D
{
  public me.collectmind.jvm.LocalVariableTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 6: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=6, args_size=1
         0: new           #2                  // class me/collectmind/jvm/MovingAverage
         3: dup
         4: invokespecial #3                  // Method me/collectmind/jvm/MovingAverage."<init>":()V
         7: astore_1    // ==> 后缀对应本地变量表的一个槽位 （slot）
         8: iconst_1
         9: istore_2
        10: iconst_2
        11: istore_3
        12: aload_1
        13: iload_2
        14: i2d
        15: invokevirtual #4                  // Method me/collectmind/jvm/MovingAverage.submit:(D)V
        18: aload_1
        19: iload_3
        20: i2d
        21: invokevirtual #4                  // Method me/collectmind/jvm/MovingAverage.submit:(D)V
        24: aload_1
        25: invokevirtual #5                  // Method me/collectmind/jvm/MovingAverage.getAvg:()D
        28: dstore        4
        30: return
      LineNumberTable:
        line 8: 0
        line 9: 8
        line 10: 10
        line 11: 12
        line 12: 18
        line 13: 24
        line 14: 30
}
SourceFile: "LocalVariableTest.java"
 */