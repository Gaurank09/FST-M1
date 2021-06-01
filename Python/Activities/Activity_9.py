List1 = [1, 2, 3, 4, 5, 12]
List2 = [6, 7, 8, 9, 10, 11]

print("First List ", List1)
print("Second List ", List2)

CombinedList = []

# Iterate through first list to get odd elements
for num in List1:
    if (num % 2 > 0):
        CombinedList.append(num)
        
# Iterate through first list to get even elements
for num in List2:
    if (num % 2 == 0):
        CombinedList.append(num)

print("Final List: ")
print(CombinedList)