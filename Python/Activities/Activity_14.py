def fibonacci(number):
    if number <= 1:
        return number
    else:
        return(fibonacci(number-1) + fibonacci(number-2))

Num1 = int(input("Enter a number: "))

if Num1 <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence for entered number is: ")
    for i in range(Num1):
        print(fibonacci(i))