package me.collectmind.week01jvm.basic;

/**
 * 字节码例子
 * Created by monica on 2020/10/18.
 */
public class HelloByteCode {
    public static void main(String[] args) {
        HelloByteCode obj = new HelloByteCode();
    }
}

/* *************************************************************************
➜  javap -c me.collectmind.jvm.basic.HelloByteCode
Compiled from "HelloByteCode.java"
public class me.collectmind.jvm.basic.HelloByteCode {
  public me.collectmind.jvm.basic.HelloByteCode();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class me/collectmind/jvm/HelloByteCode
       3: dup
       4: invokespecial #3                  // Method "<init>":()V
       7: astore_1
       8: return
}
 */


/* *************************************************************************
➜  javap -c -verbose me.collectmind.jvm.basic.HelloByteCode
Classfile /xxx/src/main/java/me/collectmind/jvm/HelloByteCode.class
  Last modified Oct 18, 2020; size 307 bytes
  MD5 checksum 372aa94e71f3bb3d6c73d8ff2e2035a2
  Compiled from "HelloByteCode.java"
public class me.collectmind.jvm.basic.HelloByteCode
  minor version: 0
  major version: 52 ==> Jdk8版本号
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool: ==> 常量池
   #1 = Methodref          #4.#13         // java/lang/Object."<init>":()V
   #2 = Class              #14            // me/collectmind/jvm/HelloByteCode
   #3 = Methodref          #2.#13         // me/collectmind/jvm/HelloByteCode."<init>":()V
   #4 = Class              #15            // java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               main
  #10 = Utf8               ([Ljava/lang/String;)V
  #11 = Utf8               SourceFile
  #12 = Utf8               HelloByteCode.java
  #13 = NameAndType        #5:#6          // "<init>":()V
  #14 = Utf8               me/collectmind/jvm/HelloByteCode
  #15 = Utf8               java/lang/Object
{
  public me.collectmind.jvm.basic.HelloByteCode();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 10: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class me/collectmind/jvm/HelloByteCode
         3: dup
         4: invokespecial #3                  // Method "<init>":()V
         7: astore_1
         8: return
      LineNumberTable:
        line 12: 0
        line 13: 8
}
SourceFile: "HelloByteCode.java"
 */
