# 递推
n = int(input())
a, b = 0, 1
for i in range(n):
    print(a, end=" ")
    a, b = b, a + b


# 递推

n = int(input())
a = [0] * 46
a[1] = 1


def f(x):
    if x == 0:
        return 0
    elif x == 1:
        return 1
    else:
        a[x] = f(x - 1) + f(x - 2)
        return a[x]


f(n)
for i in range(n):
    print(a[i], end=" ")
