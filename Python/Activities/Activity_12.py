def calculateSum(num):
  if num:
    # Recursive function call
    return num + calculateSum(num-1)
  else:
    return 0

inputvalue = int(input("Enter a number: "))

res = calculateSum(inputvalue)

print(res)