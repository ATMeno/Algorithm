# 递归

#### 以下为《算法》(第四版)第一章节递归习题

##### 1.1.16

给出exRl(6)的返回值:

```java
public static String exR1(int n)
{
    if (n <= 0) return ""; 
    return exR1(n-3) + n + exR1(n-2) + n;
}
```

##### 1.1.17

找出以下递归函数的问题：

```java
public static String exR2(int n)
{
    String s = exR2(n-3) + n + exR2(n-2) + n;
 	if (n <= 0) return "";
    return s;
}

```

答：这段代码中的基础情况永远不会被访问。调用exR2(3)会产生调用exR2(0)、exR2(-3) 和 exR2(-6) ，循环往复直到发生 StackOverflowError。

##### 1.1.18

请看以下递归函数：

```java
public static i n t mystery(int a, i n t b)
{
    if (b == 0) return 0; 
    if (b % 2 == 0) return mystery(a+a, b/2); 
    return mystery(a+a, b/2) + a;
}

```
mystery(2, 25)和 mystery(3, 11)的返回值是多少？给定正整数a 和 b，mystery(a,b) 计算的结果是什么？将代码中的+ 替换为* 并 将 return 0 改 为 return 1, 然后回答相同 的问题。

##### 1.1.19

在计算机上运行以下程序：

```java
public class Fibonacci
{
    public static long F(int N)
    {
        if (N == 0) return 0; 
        if (N == 1) return 1; 
        return F(N-l) + F(N- 2);
	} 
    public static void main(String[] args){
        for ( int N = 0; N < 100; N++) 
            StdOut.println(N + " " + F(N));
    }    
}
```
计算机用这段程序在一个小时之内能够得到F(N)结果的最大N值是多少？开发F(N) 的一个更好的实现，用数组保存已经计算过的值。 

##### 1.1.20

编写一个递归的静态方法计算ln(N!)的值。

##### 1.1.21

编写一段程序，从标准输人按行读取数据，其中每行都包含一个名字和两个整数。然后用 printf()打印一张表格，每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数的结果，精确到小数点后三位。可以用这种程序将棒球球手的击球命中率或者学生的考试分数制成表格。 

##### 1.1.22

使用1.1.6.4节中的rank()递归方法重新实现BinarySearch并跟踪该方法的调用。每当该方法被调用时，打印出它的参数lo和hi并按照递归的深度缩进。提示-为递归方法添加一个参数 来保存递归的深度。
