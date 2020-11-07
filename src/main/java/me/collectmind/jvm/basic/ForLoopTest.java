package me.collectmind.jvm.basic;

/**
 * 循环控制的字节码测试
 *
 * Created by monica on 2020/10/18.
 */
public class ForLoopTest {
    private static int[] numbers = {1, 6, 8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.getAvg();
    }
}

/*
 javap -c -verbose me.collectmind.jvm.ForLoopTest
Classfile /xxx/src/main/java/me/collectmind/jvm/ForLoopTest.class
  Last modified Oct 18, 2020; size 627 bytes
  MD5 checksum 418c69677189032d17789282f6c53b71
  Compiled from "ForLoopTest.java"
public class me.collectmind.jvm.ForLoopTest
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #8.#24         // java/lang/Object."<init>":()V
   #2 = Class              #25            // me/collectmind/jvm/MovingAverage
   #3 = Methodref          #2.#24         // me/collectmind/jvm/MovingAverage."<init>":()V
   #4 = Fieldref           #7.#26         // me/collectmind/jvm/ForLoopTest.numbers:[I
   #5 = Methodref          #2.#27         // me/collectmind/jvm/MovingAverage.submit:(D)V
   #6 = Methodref          #2.#28         // me/collectmind/jvm/MovingAverage.getAvg:()D
   #7 = Class              #29            // me/collectmind/jvm/ForLoopTest
   #8 = Class              #30            // java/lang/Object
   #9 = Utf8               numbers
  #10 = Utf8               [I
  #11 = Utf8               <init>
  #12 = Utf8               ()V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               main
  #16 = Utf8               ([Ljava/lang/String;)V
  #17 = Utf8               StackMapTable
  #18 = Class              #31            // "[Ljava/lang/String;"
  #19 = Class              #25            // me/collectmind/jvm/MovingAverage
  #20 = Class              #10            // "[I"
  #21 = Utf8               <clinit>
  #22 = Utf8               SourceFile
  #23 = Utf8               ForLoopTest.java
  #24 = NameAndType        #11:#12        // "<init>":()V
  #25 = Utf8               me/collectmind/jvm/MovingAverage
  #26 = NameAndType        #9:#10         // numbers:[I
  #27 = NameAndType        #32:#33        // submit:(D)V
  #28 = NameAndType        #34:#35        // getAvg:()D
  #29 = Utf8               me/collectmind/jvm/ForLoopTest
  #30 = Utf8               java/lang/Object
  #31 = Utf8               [Ljava/lang/String;
  #32 = Utf8               submit
  #33 = Utf8               (D)V
  #34 = Utf8               getAvg
  #35 = Utf8               ()D
{
  public me.collectmind.jvm.ForLoopTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1   // ==> 方法栈深度，本地变量表槽位数，方法参数个数
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 8: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=6, args_size=1
         0: new           #2                  // class me/collectmind/jvm/MovingAverage
         3: dup
         4: invokespecial #3                  // Method me/collectmind/jvm/MovingAverage."<init>":()V
         7: astore_1
         8: getstatic     #4                  // Field numbers:[I
        11: astore_2
        12: aload_2
        13: arraylength
        14: istore_3
        15: iconst_0
        16: istore        4
        18: iload         4
        20: iload_3
        21: if_icmpge     43   // ==> 比较
        24: aload_2
        25: iload         4
        27: iaload
        28: istore        5
        30: aload_1
        31: iload         5
        33: i2d
        34: invokevirtual #5                  // Method me/collectmind/jvm/MovingAverage.submit:(D)V
        37: iinc          4, 1  // ==> int自增
        40: goto          18    // ==> 跳转
        43: aload_1
        44: invokevirtual #6                  // Method me/collectmind/jvm/MovingAverage.getAvg:()D
        47: dstore_2
        48: return
      LineNumberTable:
        line 12: 0
        line 13: 8
        line 14: 30
        line 13: 37
        line 16: 43
        line 17: 48
      StackMapTable: number_of_entries = 2
        frame_type = 255 // full_frame
          offset_delta = 18
                  locals = [ class "[Ljava/lang/String;", class me/collectmind/jvm/MovingAverage, class "[I", int, int ]
        stack = []
        frame_type = 248 // chop
        offset_delta = 24

static {};
        descriptor: ()V
        flags: ACC_STATIC
        Code:
        stack=4, locals=0, args_size=0
        0: iconst_3
        1: newarray       int
        3: dup
        4: iconst_0
        5: iconst_1
        6: iastore
        7: dup
        8: iconst_1
        9: bipush        6
        11: iastore
        12: dup
        13: iconst_2
        14: bipush        8
        16: iastore
        17: putstatic     #4                  // Field numbers:[I
        20: return
        LineNumberTable:
        line 9: 0
        }
        SourceFile: "ForLoopTest.java"
*/