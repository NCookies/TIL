arr = [1, 3, 5, 2, 4]

def sum(array):
    if array == []:
        return 0
    else:
        return array[0] + sum(array[1:])
    
print(sum(arr))
