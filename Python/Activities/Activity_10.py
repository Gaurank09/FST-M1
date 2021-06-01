Tup1 = tuple(map(int, input("Enter comma separated numbers (without spaces): ").split(",")))

print("Given Tuple is ", Tup1)

print("Elements that are divisible by 5 in entered tuple are: ")
for num in Tup1:
    if (num % 5 == 0):
        print(num)