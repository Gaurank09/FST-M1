List1 = list(input("Enter comma separated numbers (without spaces): ").split(","))

print("Given list is ", List1)

firstElement = List1[0]
lastElement = List1[-1]

if (firstElement == lastElement):
    print(True)
else:
    print(False)