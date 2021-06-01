ListNumbers = list(input("Enter comma separated numbers (without spaces): ").split(","))
Sum = 0

for number in ListNumbers:
  Sum += int(number)

print(Sum)