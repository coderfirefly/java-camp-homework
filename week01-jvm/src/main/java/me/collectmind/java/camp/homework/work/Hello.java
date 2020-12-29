package me.collectmind.java.camp.homework.work;

/**
 * 作业1.1 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后
 * 分析一下对应的字节码
 *
 * Created by monica on 2020/10/18.
 */
public class Hello {

    public static long factor(int n) {
        if (n <= 0) {
            return 0;
        }

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= n;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factor(10));
    }
}

// 生成的字节码：
//Classfile /xxx/java-camp-homework/src/main/java/me/collectmind/jvm/work/Hello.class
//  Last modified Oct 19, 2020; size 557 bytes
//  MD5 checksum 1ecc523401308b63ec8a24f8478e127e
//  Compiled from "Hello.java"
//public class me.collectmind.jvm.work.Hello
//  minor version: 0
//  major version: 52  // ==>jdk主版本号， jdk8
//  flags: ACC_PUBLIC, ACC_SUPER  // ==> 类的访问标志，类是public的，ACC_SUPER表示是否允许使用invokespecial指令
//Constant pool: // ==>常量池
//   #1 = Methodref          #6.#18         // java/lang/Object."<init>":()V    方法的符号引用，Hello类构造器，指向常量池的第6项和第18项，下同
//   #2 = Fieldref           #19.#20        // java/lang/System.out:Ljava/io/PrintStream; 字段的符号引用，System.out 静态常量的符号引用
//   #3 = Methodref          #5.#21         // me/collectmind/jvm/work/Hello.factor:(I)J 方法的符号引用，factor方法，I表示入参int基本类型，J表示出参long类型
//   #4 = Methodref          #22.#23        // java/io/PrintStream.println:(J)V 方法的符号引用，V表示返回值是void
//   #5 = Class              #24            // me/collectmind/jvm/work/Hello   Hello类的符号引用
//   #6 = Class              #25            // java/lang/Object  Object类的符号引用
//   #7 = Utf8               <init>         // 字面量，对应上面的引用
//   #8 = Utf8               ()V
//   #9 = Utf8               Code
//  #10 = Utf8               LineNumberTable
//  #11 = Utf8               factor
//  #12 = Utf8               (I)J
//  #13 = Utf8               StackMapTable
//  #14 = Utf8               main
//  #15 = Utf8               ([Ljava/lang/String;)V
//  #16 = Utf8               SourceFile
//  #17 = Utf8               Hello.java
//  #18 = NameAndType        #7:#8          // "<init>":()V  方法的部分符号引用，方法的名称，入参和返回值
//  #19 = Class              #26            // java/lang/System
//  #20 = NameAndType        #27:#28        // out:Ljava/io/PrintStream;
//  #21 = NameAndType        #11:#12        // factor:(I)J
//  #22 = Class              #29            // java/io/PrintStream
//  #23 = NameAndType        #30:#31        // println:(J)V
//  #24 = Utf8               me/collectmind/jvm/work/Hello
//  #25 = Utf8               java/lang/Object
//  #26 = Utf8               java/lang/System
//  #27 = Utf8               out
//  #28 = Utf8               Ljava/io/PrintStream;
//  #29 = Utf8               java/io/PrintStream
//  #30 = Utf8               println
//  #31 = Utf8               (J)V
//{
//  public me.collectmind.jvm.work.Hello();   // Hello构造器方法
//    descriptor: ()V
//    flags: ACC_PUBLIC
//    Code:
//      stack=1, locals=1, args_size=1
//         0: aload_0
//         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//         4: return
//      LineNumberTable:
//        line 9: 0
//
//  public static long factor(int);          // factor方法
//    descriptor: (I)J
//    flags: ACC_PUBLIC, ACC_STATIC
//    Code: // 4个槽位，0：入参，1-2：结果 （long占两个槽位） 3：迭代变量
//      stack=4, locals=4, args_size=1       // 方法栈的最大深度，局部变量表的大小，参数大小
//         0: iload_0                        // 将第0个槽位的元素入栈，即factor方法中的入参n
//         1: ifgt          6                // 如果栈顶元素大于0，跳转到偏移量6
//         4: lconst_0                           // 将long类型常量0入栈
//         5: lreturn                            // 出栈返回
//         6: lconst_1                      // 将常量1入栈
//         7: lstore_1                      // 取出常量1存入局部变量表的第1个槽位（对应表示方法的返回结果）
//         8: iconst_1                     // 将常量1入栈
//         9: istore_3                      // 出栈，存入局部变量表的第3个槽位
//        10: iload_3                       // 将第3个槽位入栈
//        11: iload_0                       // 将第0个槽位入栈(存的是入参)
//        12: if_icmpgt     26              // 取值栈顶两个元素比较，如果第3个槽位比第0个槽位大，跳转到26
//        15: lload_1                       // 将第1个槽位的元素入栈
//        16: iload_0                       // 将第0个槽位的元素入栈
//        17: i2l                           // 将栈顶元素转换成long类型
//        18: lmul                          // 栈顶两个元素出栈相乘，结果入栈
//        19: lstore_1                      // 出栈，存入局部变量表的第一个槽位 （存储当前的计算结果）
//        20: iinc          3, 1            // 将局部变量表的第3个槽位的元素加1
//        23: goto          10              // 跳转到偏移量10，继续执行
//        26: lload_1                       // 将第1个槽位值入栈
//        27: lreturn                       // 方法返回
//      LineNumberTable:
//        line 12: 0
//        line 13: 4
//        line 16: 6
//        line 17: 8
//        line 18: 15
//        line 17: 20
//        line 20: 26
//      StackMapTable: number_of_entries = 3
//        frame_type = 6   /* same */
//        frame_type = 253 * append */
//                offset_delta = 3
//                locals = [ long, int ]
//                frame_type = 250   /* chop */
//                offset_delta = 15
//
//public static void main(java.lang.String[]);
//        descriptor: ([Ljava/lang/String;)V
//        flags: ACC_PUBLIC, ACC_STATIC
//        Code:
//        stack=3, locals=1, args_size=1
//        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
//        3: bipush        10
//        5: invokestatic  #3                  // Method factor:(I)J
//        8: invokevirtual #4                  // Method java/io/PrintStream.println:(J)V
//        11: return
//        LineNumberTable:
//        line 24: 0
//        line 25: 11
//        }
//        SourceFile: "Hello.java"

