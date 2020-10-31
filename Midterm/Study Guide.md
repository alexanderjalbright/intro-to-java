### Module 1

**Statically typed language**: Types are known at compile time
**Using and representing binary numbers**:

```java
byte five = 0b101;
short three = 0b11;
int nine = 0B1001;
```

### Module 2

**Initializing an array**:

```java
int[] numbers = new int[5];
char[] letters = new char[]{'a','b','c'};
double[] grades = {1.0,2.0,3.0};
```

**How to format output in Java**:

```java
System.out.printf("String %s, double %d, float %.02f", word, number, );
System.out.format("%+,12.2d", n); //  -->  " +461,012.00"
// +/- right/left justified
// , show comma in number
// 12 number of characters
// .2 two decimal places
// d decimal integer
```

**How to get input values from standard input**:

```java
import java.utils.Scanner
...
Scanner sc = new Scanner(System.in);

while (!sc.hasNext()){
    String text = sc.next();
    int text = sc.nextInt();
}
```

### Module 3

**How to define and use methods**:

```java
public class Dog(){
    public String Bark(){
        return "Bark!";
    }
}
...
Dog dog = new Dog();
System.out.println(dog.Bark());
```

**\*Using pass-by-value and pass-by-reference mechanisms**:

always pass by value???

**Libraries and API**:
idk what this is asking

**Method’s signature**:

```java
// accessibility static outputType name(inputType inputName)
private static Boolean isEven(int number){
    return number % 2 == 0;
}

private static Boolean isEven(double number){
    return number % 2 == 0;
}
```

**Using iteration versus recursion to address a problem**

```

```
