def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum

# Define the list of numbers
ListNumbers = list(map(int, input("Enter comma separated numbers (without spaces): ").split(",")))
print("Given list is ", ListNumbers)

result = calculate_sum(ListNumbers)

print("The sum of all the elements is: " + str(result))