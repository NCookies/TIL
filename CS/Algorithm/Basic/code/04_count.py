arr = [1, 3, 5, 2, 4]

def count(array):
    if array == []:
        return 0
    else:
        return 1 + count(array[1:])
    
print(count(arr))
