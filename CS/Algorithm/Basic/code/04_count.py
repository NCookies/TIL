arr = [1, 3, 5, 2, 4]

def count(list):
    if list == []:
        return 0
    else:
        return 1 + count(list[1:])
    
print(count(arr))
