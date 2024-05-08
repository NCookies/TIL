arr = [1, 3, 5, 2, 4]

def sum(list):
    if list == []:
        return 0
    else:
        return list[0] + sum(list[1:])
    
print(sum(arr))
