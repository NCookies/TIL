arr = [1, 3, 5, 2, 4]

def max(array):
    if len(array) == 2:
        return array[0] if array[0] > array[1] else array[1]
    else:
        sub_max = max(array[1:])
        return array[0] if array[0] > sub_max else sub_max

print(max(arr))
