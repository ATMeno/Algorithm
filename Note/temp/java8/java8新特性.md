# java8新特性

## 一.Lambda

### 四大核心函数接口

- Consumer<T>   void accept(T t)
- Supplier<T>	T get()
- Function<T,R> R apply(T t)
- Predicate<T> bool test(T t)

### 引用

#### 方法引用

Lambda体中的方法已经有实现了，可以使用方法引用

对象::实例方法名  Consumer<String> con = System.out::printlin;

类::静态方法名  	Comparator<Integer> com = Integer::compare;

类::实例方法名		BiPredicate<String , String> bi = String::equals;	两个参数，第一个参数是实例方法的调用者， 第二参数是实例方法的参数

#### 构造器引用

Supplier<Object> sup = Object::new;

Function<Integer,Student> fun = Student::new;

#### 数组引用

Function<Interger,String[]> fun = String[]::new;

### Stream API



