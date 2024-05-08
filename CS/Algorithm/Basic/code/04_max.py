arr = [1, 3, 5, 2, 4]

def max(list):
    if len(list) == 2:
        return list[0] if list[0] > list[1] else list[1]
    else:
        sub_max = max(list[1:])
        return list[0] if list[0] > sub_max else sub_max

print(max(arr))
